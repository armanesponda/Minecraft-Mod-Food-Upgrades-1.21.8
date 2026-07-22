package net.arman.tutorialmod.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.arman.tutorialmod.FoodAndStart;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> END_EMERALD = register("end_emerald", 
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 13);
            map.put(ArmorItem.Type.LEGGINGS, 15);
            map.put(ArmorItem.Type.CHESTPLATE, 16);
            map.put(ArmorItem.Type.HELMET, 11);
            map.put(ArmorItem.Type.BODY, 11);
        }), 19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 2.0F, 0.1F, () -> Ingredient.ofItems(ModItems.END_EMERALD));

    private static RegistryEntry<ArmorMaterial> register(
        String id, 
        EnumMap<ArmorItem.Type, Integer> defense, 
        int enchantability,
        RegistryEntry<SoundEvent> equipSound, 
        float toughness, 
        float knockbackResistance,
        Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(FoodAndStart.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
        String id, 
        EnumMap<ArmorItem.Type, Integer> defense, 
        int enchantability,
        RegistryEntry<SoundEvent> equipSound, 
        float toughness, 
        float knockbackResistance,
        Supplier<Ingredient> repairIngredient,
        List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap<>(ArmorItem.Type.class);
        
        for(ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, defense.get(type));
        }
        
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(FoodAndStart.MOD_ID, id), 
            new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}