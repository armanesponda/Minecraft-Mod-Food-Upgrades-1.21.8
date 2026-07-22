package net.arman.tutorialmod;

import net.arman.tutorialmod.datagen.ModBlockTagProvider;
import net.arman.tutorialmod.datagen.ModItemTagProvider;
import net.arman.tutorialmod.datagen.ModLootTableProvider;
import net.arman.tutorialmod.datagen.ModModelProvider;
import net.arman.tutorialmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FoodAndStartDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
