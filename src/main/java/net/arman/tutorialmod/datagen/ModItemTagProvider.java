package net.arman.tutorialmod.datagen;

import java.util.concurrent.CompletableFuture;

import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
        
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg){
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
        .add(ModItems.END_EMERALD_HELMET, ModItems.END_EMERALD_CHESTPLATE, ModItems.END_EMERALD_LEGGINGS, ModItems.END_EMERALD_BOOTS);
    }
    
    
}
