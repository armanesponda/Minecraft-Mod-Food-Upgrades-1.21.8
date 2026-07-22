package net.arman.tutorialmod.util;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.arman.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
            factories -> {
                factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(ModItems.TOMATO, 4),
                    6, 4, 0.05F));

                    factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(ModItems.GRAPE, 6),
                    6, 6, 0.05F));

                    factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY, 5),
                    6, 5, 0.05F));

                    factories.add((entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 2),
                    new ItemStack(ModItems.CORN, 6),
                    6, 6, 0.05F));
            });
    }
}
