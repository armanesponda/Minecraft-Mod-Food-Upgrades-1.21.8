package net.arman.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;

import net.arman.tutorialmod.block.ModBlocks;
import net.arman.tutorialmod.item.ModFoodComponents;
import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider{

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.END_EMERALD, RecipeCategory.DECORATIONS, ModBlocks.END_EMERALD_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PANCAKE, 1)
            .input(Items.EGG)
            .input(Items.SUGAR)
            .input(Items.MILK_BUCKET)
            .input(ModItems.FLOUR)
            .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
            .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
            .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
            .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
            .offerTo(exporter, Identifier.of("foodandstart", "pancake_from_ingredients"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.FRUIT_SALAD, 1)
            .input(Items.BOWL)
            .input(Items.APPLE)
            .input(ModItems.STRAWBERRY)
            .input(ModItems.GRAPE)
            .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
            .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
            .criterion(hasItem(ModItems.STRAWBERRY), conditionsFromItem(ModItems.STRAWBERRY))
            .criterion(hasItem(ModItems.GRAPE), conditionsFromItem(ModItems.GRAPE))
            .offerTo(exporter, Identifier.of("foodandstart", "fruit_salad_from_ingredients"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SAUCE, 1)
            .input(Items.GLASS_BOTTLE)
            .input(ModItems.TOMATO)
            .input(ModItems.TOMATO)
            .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
            .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
            .offerTo(exporter, Identifier.of("foodandstart", "tomato_sauce_from_ingredients"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOMATO_SOUP, 1)
            .pattern("   ")
            .pattern("FBM")
            .pattern("TTT")
            .input('T', ModItems.TOMATO)
            .input('F', ModItems.FLOUR)
            .input('B', Items.BOWL)
            .input('M', Items.MILK_BUCKET)
            .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
            .criterion(hasItem(ModItems.FLOUR), conditionsFromItem(ModItems.FLOUR))
            .criterion(hasItem(Items.BOWL), conditionsFromItem(Items.BOWL))
            .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
            .offerTo(exporter, Identifier.of("foodandstart", "tomato_soup_maker"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.END_EMERALD, 1)
            .pattern("SSS")
            .pattern("SRS")
            .pattern("SSS")
            .input('S', Items.STONE)
            .input('R', ModItems.END_EMERALD)
            .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
            .criterion(hasItem(ModItems.END_EMERALD), conditionsFromItem(ModItems.END_EMERALD))
            .offerTo(exporter, Identifier.of(getRecipeName(Items.ENDER_PEARL)));

        //Tutorial #12 ShapedRecipeJsonBuilder
    }
}
