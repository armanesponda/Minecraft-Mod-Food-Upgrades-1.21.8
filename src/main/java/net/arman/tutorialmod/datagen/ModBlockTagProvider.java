package net.arman.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;

import net.arman.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
        
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.END_EMERALD_BLOCK)
            .add(ModBlocks.END_EMERALD_ORE)
            .add(ModBlocks.RUBY_BLOCK);

    getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
            .add(ModBlocks.MANGO_LOG);
    

    getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
            
    

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
            
    

    getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.END_EMERALD_BLOCK)
            .add(ModBlocks.END_EMERALD_ORE)
            .add(ModBlocks.RUBY_BLOCK);
    }

    
}
