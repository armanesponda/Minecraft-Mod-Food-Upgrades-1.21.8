package net.arman.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class FoodSeedItem extends AliasedBlockItem {
    public FoodSeedItem(Block crop, Item.Settings settings) {
        super(crop, settings);
    }
}