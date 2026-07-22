package net.arman.tutorialmod;

import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.arman.tutorialmod.block.ModBlocks;
import net.arman.tutorialmod.item.ModItemGroups;
import net.arman.tutorialmod.util.ModCustomTrades;
import net.arman.tutorialmod.util.ModLootTableModifiers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoodAndStart implements ModInitializer {
	public static final String MOD_ID = "foodandstart";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
	}
}