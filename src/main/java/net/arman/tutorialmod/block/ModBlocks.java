package net.arman.tutorialmod.block;

import net.arman.tutorialmod.FoodAndStart;
import net.arman.tutorialmod.block.custom.CornCropBlock;
import net.arman.tutorialmod.block.custom.GrapeVineBlock;
import net.arman.tutorialmod.block.custom.StrawberryCropBlock;
import net.arman.tutorialmod.block.custom.TomatoCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
        new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block END_EMERALD_BLOCK = registerBlock("end_emerald_block",
        new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block END_EMERALD_ORE = registerBlock("end_emerald_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(4, 8), AbstractBlock.Settings.copy(Blocks.STONE).strength(3f)));

    public static final Block END_SAND = registerBlock("end_sand",
        new ExperienceDroppingBlock(UniformIntProvider.create(1, 2), AbstractBlock.Settings.copy(Blocks.SAND).strength(1f)));

    public static final Block END_CLAY = registerBlock("end_clay",
        new Block(AbstractBlock.Settings.copy(Blocks.CLAY)));

    public static final Block END_OBSIDIAN = registerBlock("end_obsidian",
        new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN)));

    public static final Block END_WOOD_PLANKS = registerBlock("end_wood_planks",
        new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block END_BRICKS = registerBlock("end_bricks",
        new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)));
        
    public static final Block END_GRASS = registerBlock("end_grass",
        new Block(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).strength(3f)));

    public static final Block END_BOULDER = registerBlock("end_boulder",
        new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block END_MOSSY_BOULDER = registerBlock("end_mossy_boulder",
        new Block(AbstractBlock.Settings.copy(Blocks.STONE)));

    public static final Block END_SANDSTONE = registerBlock("end_sandstone",
        new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE)));

    public static final Block MANGO_LOG = registerBlock("mango_log",
        new Block(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, 
    Identifier.of(FoodAndStart.MOD_ID, "tomato_crop"),
    new TomatoCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block STRAWBERRY_CROP = Registry.register(Registries.BLOCK, 
    Identifier.of(FoodAndStart.MOD_ID, "strawberry_crop"),
    new StrawberryCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, 
    Identifier.of(FoodAndStart.MOD_ID, "corn_crop"),
    new CornCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block GRAPE_VINE = registerBlock("grape_vine",
    new GrapeVineBlock(AbstractBlock.Settings.copy(Blocks.VINE).ticksRandomly()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FoodAndStart.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(FoodAndStart.MOD_ID, name),
        new BlockItem(block, new Item.Settings()));
    }
    
    public static void registerModBlocks() {
        FoodAndStart.LOGGER.info("Registering for " + FoodAndStart.MOD_ID);
    }
}
