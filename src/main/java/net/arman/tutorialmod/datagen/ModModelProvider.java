package net.arman.tutorialmod.datagen;

import net.arman.tutorialmod.block.ModBlocks;
import net.arman.tutorialmod.block.custom.CornCropBlock;
import net.arman.tutorialmod.block.custom.StrawberryCropBlock;
import net.arman.tutorialmod.block.custom.TomatoCropBlock;
import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
        
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_EMERALD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_CLAY);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_BOULDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_GRASS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_MOSSY_BOULDER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_SANDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_WOOD_PLANKS);

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);

        // Custom grape vine generation
        generateGrapeVineBlockState(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerLog(ModBlocks.MANGO_LOG).log(ModBlocks.MANGO_LOG);
    }

    private void generateGrapeVineBlockState(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerTintableCross(ModBlocks.GRAPE_VINE, BlockStateModelGenerator.TintType.NOT_TINTED);
}

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
       itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
       itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
       itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
       itemModelGenerator.register(ModItems.COOKED_CORN, Models.GENERATED);
       itemModelGenerator.register(ModItems.GRAPE, Models.GENERATED);
       itemModelGenerator.register(ModItems.MANGO, Models.GENERATED);
       itemModelGenerator.register(ModItems.BLUEBERRY, Models.GENERATED);
       itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);
       itemModelGenerator.register(ModItems.TOMATO_SOUP, Models.GENERATED);
       itemModelGenerator.register(ModItems.PANCAKE, Models.GENERATED);
       itemModelGenerator.register(ModItems.SPAGHETTI_TOMATO, Models.GENERATED);
       itemModelGenerator.register(ModItems.DOUGH, Models.GENERATED);
       itemModelGenerator.register(ModItems.TOMATO_SAUCE, Models.GENERATED);
       itemModelGenerator.register(ModItems.FRUIT_SALAD, Models.GENERATED);
       itemModelGenerator.register(ModItems.SUCCOTASH, Models.GENERATED);

       itemModelGenerator.register(ModItems.END_BRICK, Models.GENERATED);
       itemModelGenerator.register(ModItems.END_CLAY_BALL, Models.GENERATED);
       itemModelGenerator.register(ModItems.END_FLOWER_POT, Models.GENERATED);
       itemModelGenerator.register(ModItems.END_EMERALD, Models.GENERATED);


       itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED); 
       itemModelGenerator.register(ModItems.RUBY_BOOTS, Models.GENERATED);
       itemModelGenerator.register(ModItems.ROCKET_BOOTS_V1, Models.GENERATED);
       itemModelGenerator.register(ModItems.ROCKET_BOOTS_V2, Models.GENERATED);

       itemModelGenerator.register(ModItems.END_EMERALD_SWORD, Models.HANDHELD);
       itemModelGenerator.register(ModItems.END_EMERALD_AXE, Models.HANDHELD);
       itemModelGenerator.register(ModItems.END_EMERALD_PICKAXE, Models.HANDHELD);
       itemModelGenerator.register(ModItems.END_EMERALD_SHOVEL, Models.HANDHELD);
       itemModelGenerator.register(ModItems.END_EMERALD_HOE, Models.HANDHELD);

       itemModelGenerator.registerArmor(((ArmorItem) ModItems.END_EMERALD_HELMET));
       itemModelGenerator.registerArmor(((ArmorItem) ModItems.END_EMERALD_LEGGINGS));
       itemModelGenerator.registerArmor(((ArmorItem) ModItems.END_EMERALD_CHESTPLATE));
       itemModelGenerator.registerArmor(((ArmorItem) ModItems.END_EMERALD_BOOTS));



    }
    
}
