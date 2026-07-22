package net.arman.tutorialmod.item;

import net.arman.tutorialmod.FoodAndStart;
import net.arman.tutorialmod.block.ModBlocks;
import net.arman.tutorialmod.item.custom.FoodSeedItem;
import net.arman.tutorialmod.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item END_EMERALD = registerItem("end_emerald", new Item(new Item.Settings()));
    public static final Item END_CLAY_BALL = registerItem("end_clay_ball", new Item(new Item.Settings()));
    public static final Item END_FLOWER_POT = registerItem("end_flower_pot", new Item(new Item.Settings()));
    public static final Item END_BRICK = registerItem("end_brick", new Item(new Item.Settings()));

    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots", new Item(new Item.Settings()));
    public static final Item ROCKET_BOOTS_V1 = registerItem("rocket_boots_v1", new Item(new Item.Settings()));
    public static final Item ROCKET_BOOTS_V2 = registerItem("rocket_boots_v2", new Item(new Item.Settings()));

    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));
    public static final Item CORN = registerItem("corn", new Item(new Item.Settings().food(ModFoodComponents.CORN)));
    public static final Item COOKED_CORN = registerItem("cooked_corn", new Item(new Item.Settings().food(ModFoodComponents.COOKED_CORN)));
    public static final Item GRAPE = registerItem("grape", new Item(new Item.Settings().food(ModFoodComponents.GRAPE)));
    public static final Item MANGO = registerItem("mango", new Item(new Item.Settings().food(ModFoodComponents.MANGO)));
    public static final Item BLUEBERRY = registerItem("blueberry", new Item(new Item.Settings().food(ModFoodComponents.BLUEBERRY)));
    public static final Item FLOUR = registerItem("flour", new Item(new Item.Settings().food(ModFoodComponents.FLOUR)));
    public static final Item PANCAKE = registerItem("pancake", new Item(new Item.Settings().food(ModFoodComponents.PANCAKE)));
    public static final Item FRUIT_SALAD = registerItem("fruit_salad", new Item(new Item.Settings().food(ModFoodComponents.FRUIT_SALAD)));
    public static final Item TOMATO_SAUCE = registerItem("tomato_sauce", new Item(new Item.Settings().food(ModFoodComponents.TOMATO_SAUCE)));
    public static final Item TOMATO_SOUP = registerItem("tomato_soup", new Item(new Item.Settings().food(ModFoodComponents.TOMATO_SOUP)));
    public static final Item SPAGHETTI_TOMATO = registerItem("spaghetti_tomato", new Item(new Item.Settings().food(ModFoodComponents.SPAGHETTI_TOMATO)));
    public static final Item DOUGH = registerItem("dough", new Item(new Item.Settings()));
    public static final Item SUCCOTASH = registerItem("succotash", new Item(new Item.Settings().food(ModFoodComponents.SUCCOTASH)));
    
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
        new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Settings()));
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
        new AliasedBlockItem(ModBlocks.CORN_CROP, new Settings()));
    public static final Item STRAWBERRY = registerItem("strawberry",
        new FoodSeedItem(
            ModBlocks.STRAWBERRY_CROP,
            new Item.Settings().food(ModFoodComponents.STRAWBERRY)
    )
);
    
    public static final Item GRAPE_VINE = registerItem("grape_vine",
    new AliasedBlockItem(ModBlocks.GRAPE_VINE, new Settings()));

    public static final Item END_EMERALD_PICKAXE = registerItem("end_emerald_pickaxe",
        new PickaxeItem(ModToolMaterial.END_EMERALD, new Item.Settings()));
    public static final Item END_EMERALD_AXE = registerItem("end_emerald_axe",
        new AxeItem(ModToolMaterial.END_EMERALD, new Item.Settings()));
    public static final Item END_EMERALD_SWORD = registerItem("end_emerald_sword",
        new SwordItem(ModToolMaterial.END_EMERALD, new Item.Settings()));
    public static final Item END_EMERALD_SHOVEL = registerItem("end_emerald_shovel",
        new ShovelItem(ModToolMaterial.END_EMERALD, new Item.Settings()));
    public static final Item END_EMERALD_HOE = registerItem("end_emerald_hoe",
        new HoeItem(ModToolMaterial.END_EMERALD, new Item.Settings()));

    public static final Item END_EMERALD_HELMET = registerItem("end_emerald_helmet",
        new ModArmorItem(ModArmorMaterials.END_EMERALD, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item END_EMERALD_CHESTPLATE = registerItem("end_emerald_chestplate",
        new ArmorItem(ModArmorMaterials.END_EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item END_EMERALD_LEGGINGS = registerItem("end_emerald_leggings",
        new ArmorItem(ModArmorMaterials.END_EMERALD, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item END_EMERALD_BOOTS = registerItem("end_emerald_boots",
        new ArmorItem(ModArmorMaterials.END_EMERALD, ArmorItem.Type.BOOTS, new Item.Settings()));
    

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(END_EMERALD);
        entries.add(RAW_RUBY);
        entries.add(RUBY_BOOTS);
        entries.add(TOMATO);
        entries.add(CORN);
        entries.add(STRAWBERRY);
        entries.add(GRAPE);
        entries.add(FLOUR);
        entries.add(ROCKET_BOOTS_V1);
        entries.add(ROCKET_BOOTS_V2);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FoodAndStart.MOD_ID, name), item);
    }
    
    public static void registerModItems() {
        FoodAndStart.LOGGER.info("Registering Mod Items for " + FoodAndStart.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
