package net.arman.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;


public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
    .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();
    public static final FoodComponent PANCAKE = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f)
    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60), 0.25f).build();
    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(2).saturationModifier(0.25f).build();
    public static final FoodComponent COOKED_CORN = new FoodComponent.Builder().nutrition(5).saturationModifier(0.25f).build();
    public static final FoodComponent GRAPE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent MANGO = new FoodComponent.Builder().nutrition(6).saturationModifier(0.25f).build();
    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.25f).build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f).build();
    public static final FoodComponent FLOUR = new FoodComponent.Builder().nutrition(1).saturationModifier(0f).build();
    public static final FoodComponent TOMATO_SOUP = new FoodComponent.Builder().nutrition(6).saturationModifier(0.25f).build();
    public static final FoodComponent TOMATO_SAUCE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.25f).build();
    public static final FoodComponent SPAGHETTI_TOMATO = new FoodComponent.Builder().nutrition(8).saturationModifier(0.25f).build();
    public static final FoodComponent FRUIT_SALAD = new FoodComponent.Builder().nutrition(7).saturationModifier(0.25f).build();
    public static final FoodComponent SUCCOTASH = new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).build();

}
