package net.arman.tutorialmod.block.custom;

import net.arman.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class GrapeVineBlock extends VineBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;
    public static final BooleanProperty HAS_GRAPES = BooleanProperty.of("has_grapes");
    
    // Growth chance - lower number = faster growth
    private static final int GROWTH_CHANCE = 5;
    // Minimum vine length to produce grapes
    private static final int MIN_LENGTH_FOR_GRAPES = 2;

    public GrapeVineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
            .with(AGE, 0)
            .with(HAS_GRAPES, false)
            .with(UP, false)
            .with(NORTH, false)
            .with(EAST, false)
            .with(SOUTH, false)
            .with(WEST, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // Always place as ceiling-hanging vine with no directional attachments
        return this.getDefaultState()
            .with(AGE, 0)
            .with(HAS_GRAPES, false)
            .with(UP, false)
            .with(NORTH, false)
            .with(EAST, false)
            .with(SOUTH, false)
            .with(WEST, false);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int currentAge = state.get(AGE);
            
            // Try to grow the vine downward
            if (currentAge < MAX_AGE && random.nextInt(GROWTH_CHANCE) == 0) {
                BlockPos belowPos = pos.down();
                if (world.getBlockState(belowPos).isAir()) {
                    // Create new vine segment below
                    BlockState newVineState = this.getDefaultState().with(AGE, 0);
                    world.setBlockState(belowPos, newVineState, 2);
                    
                    // Age up the current segment
                    world.setBlockState(pos, state.with(AGE, currentAge + 1), 2);
                }
            }
            
            // Check if this segment should have grapes
            updateGrapeState(world, pos, state);
        }
        
        // DON'T call super.randomTick - it handles wall spreading which we don't want
    }

    private void updateGrapeState(World world, BlockPos pos, BlockState state) {
    int vineLength = calculateVineLengthBelow(world, pos);
    boolean shouldHaveGrapes = vineLength >= MIN_LENGTH_FOR_GRAPES && state.get(AGE) >= 1;

    // Set HAS_GRAPES on this block
    if (shouldHaveGrapes != state.get(HAS_GRAPES)) {
        world.setBlockState(pos, state.with(HAS_GRAPES, shouldHaveGrapes), 2);
    }

    // Optional: set HAS_GRAPES on the block below too, so both blocks can drop grapes
    BlockPos belowPos = pos.down();
    BlockState belowState = world.getBlockState(belowPos);
    if (belowState.getBlock() == this && shouldHaveGrapes != belowState.get(HAS_GRAPES)) {
        world.setBlockState(belowPos, belowState.with(HAS_GRAPES, shouldHaveGrapes), 2);
    }
}

    private int calculateVineLengthBelow(World world, BlockPos startPos) {
        int length = 1; // Count this block
        BlockPos currentPos = startPos.down();
        
        // Count connected vine blocks below
        while (world.getBlockState(currentPos).getBlock() == this) {
            length++;
            currentPos = currentPos.down();
        }
        
        return length;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, 
                            Hand hand, BlockHitResult hit) {
        if (state.get(HAS_GRAPES)) {
            if (!world.isClient) {
                // Drop grapes
                Block.dropStack(world, pos, new ItemStack(ModItems.GRAPE, 1 + world.random.nextInt(2)));
                world.playSound(null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, 
                               SoundCategory.BLOCKS, 1.0f, 0.8f + world.random.nextFloat() * 0.4f);
                
                // Remove grapes from this block
                world.setBlockState(pos, state.with(HAS_GRAPES, false), 2);
            }
            return ActionResult.SUCCESS;
        }
        
        return ActionResult.PASS;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        // Just call super - let it drop the vine block naturally
        // Don't drop grapes here since they should only drop when harvested
        super.onBroken(world, pos, state);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        // Can place if hanging from ceiling or from another grape vine above
        BlockPos abovePos = pos.up();
        BlockState aboveState = world.getBlockState(abovePos);
        return aboveState.isSideSolidFullSquare(world, abovePos, Direction.DOWN) || 
               aboveState.getBlock() == this;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, 
                                               BlockState neighborState, WorldAccess world, 
                                               BlockPos pos, BlockPos neighborPos) {
        // Override to prevent VineBlock's wall-attachment breaking behavior
        if (direction == Direction.UP) {
            // Check if we should break (no support above)
            if (!this.canPlaceAt(state, world, pos)) {
                return net.minecraft.block.Blocks.AIR.getDefaultState();
            }
        }
        
        // Update grape state when neighbors change
        if (!world.isClient() && state.getBlock() == this) {
            updateGrapeState((World)world, pos, state);
        }
        
        return state; // Return current state, don't call super
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE, HAS_GRAPES);
    }
}