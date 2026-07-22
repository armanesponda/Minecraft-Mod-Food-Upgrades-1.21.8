package net.arman.tutorialmod.datagen;

import net.arman.tutorialmod.block.ModBlocks;
import net.arman.tutorialmod.block.custom.CornCropBlock;
import net.arman.tutorialmod.block.custom.GrapeVineBlock;
import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookupFuture) {
        super(dataOutput, registryLookupFuture);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.END_EMERALD_BLOCK);
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.MANGO_LOG);

        LootCondition.Builder hasGrapes = BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_VINE)
        .properties(StatePredicate.Builder.create().exactMatch(GrapeVineBlock.HAS_GRAPES, true));

    // Drop grapes when vine has grapes
    LootPool.Builder grapePool = LootPool.builder()
        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.GRAPE_VINE)
            .properties(StatePredicate.Builder.create().exactMatch(GrapeVineBlock.HAS_GRAPES, true)))
        .with(ItemEntry.builder(ModItems.GRAPE)
            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))));

    // Vine block itself only if broken with shears
    LootPool.Builder vinePool = LootPool.builder()
        .conditionally(MatchToolLootCondition.builder(
            ItemPredicate.Builder.create().items(Items.SHEARS)))
        .with(ItemEntry.builder(ModBlocks.GRAPE_VINE));

    addDrop(ModBlocks.GRAPE_VINE, LootTable.builder()
        .pool(grapePool)
        .pool(vinePool));


        addDrop(ModBlocks.END_EMERALD_ORE, oreDrops(ModBlocks.END_EMERALD_ORE, ModItems.END_EMERALD));

        LootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP)
            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 5));
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder));

        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP)
            .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 5));
        addDrop(ModBlocks.STRAWBERRY_CROP, cropDrops(ModBlocks.STRAWBERRY_CROP, ModItems.STRAWBERRY, ModItems.STRAWBERRY, builder2));

        AnyOfLootCondition.Builder builder3 = 
            BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 7))
            .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 8)));

        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder3));
    }
}