package net.arman.tutorialmod.item;

import net.arman.tutorialmod.FoodAndStart;
import net.arman.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;


public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(FoodAndStart.MOD_ID, "ruby"),
    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
        entries.add(ModItems.RUBY);
        entries.add(ModItems.RAW_RUBY);
        entries.add(ModItems.RUBY_BOOTS);
        entries.add(ModItems.ROCKET_BOOTS_V1);
        entries.add(ModItems.ROCKET_BOOTS_V2);
        entries.add(Items.DIAMOND);

        entries.add(ModBlocks.RUBY_BLOCK);

    }).build());

    public static final ItemGroup FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(FoodAndStart.MOD_ID, "food"),
    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.food"))
    .icon(() -> new ItemStack(ModItems.STRAWBERRY)).entries((displayContext, entries) -> {
        entries.add(ModItems.TOMATO);
        entries.add(ModItems.CORN);
        entries.add(ModItems.BLUEBERRY);
        entries.add(ModItems.MANGO);
        entries.add(ModItems.COOKED_CORN);
        entries.add(ModItems.STRAWBERRY);
        entries.add(ModItems.GRAPE);
        entries.add(ModItems.PANCAKE);
        entries.add(ModItems.FRUIT_SALAD);
        entries.add(ModItems.TOMATO_SOUP);
        entries.add(ModItems.TOMATO_SAUCE);
        entries.add(ModItems.SPAGHETTI_TOMATO);
        
        entries.add(ModItems.FLOUR);
        entries.add(ModItems.DOUGH);
        entries.add(ModItems.SUCCOTASH);

        entries.add(ModItems.GRAPE_VINE);

        entries.add(ModItems.TOMATO_SEEDS);
        entries.add(ModItems.CORN_SEEDS);

    }).build());

    public static final ItemGroup END_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(FoodAndStart.MOD_ID, "end_emerald"),
    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.end"))
    .icon(() -> new ItemStack(ModItems.END_EMERALD)).entries((displayContext, entries) -> {
        entries.add(ModItems.END_EMERALD);
        entries.add(ModItems.END_CLAY_BALL);
        entries.add(ModItems.END_FLOWER_POT);
        entries.add(ModItems.END_BRICK);

        entries.add(ModItems.END_EMERALD_PICKAXE);
        entries.add(ModItems.END_EMERALD_AXE);
        entries.add(ModItems.END_EMERALD_SHOVEL);
        entries.add(ModItems.END_EMERALD_SWORD);
        entries.add(ModItems.END_EMERALD_HOE);

        entries.add(ModItems.END_EMERALD_HELMET);
        entries.add(ModItems.END_EMERALD_CHESTPLATE);
        entries.add(ModItems.END_EMERALD_LEGGINGS);
        entries.add(ModItems.END_EMERALD_BOOTS);

        entries.add(ModBlocks.END_EMERALD_BLOCK);
        entries.add(ModBlocks.END_EMERALD_ORE);
        entries.add(ModBlocks.END_SANDSTONE);
        entries.add(ModBlocks.END_SAND);
        entries.add(ModBlocks.END_MOSSY_BOULDER);
        entries.add(ModBlocks.END_BRICKS);
        entries.add(ModBlocks.END_CLAY);
        entries.add(ModBlocks.END_BOULDER);
        entries.add(ModBlocks.END_GRASS);
        entries.add(ModBlocks.END_OBSIDIAN);
        entries.add(ModBlocks.END_WOOD_PLANKS);
        entries.add(ModBlocks.MANGO_LOG);

    }).build());

    public static void registerItemGroups() {
        FoodAndStart.LOGGER.info("Registering Item Groups for " + FoodAndStart.MOD_ID);
    }
}
