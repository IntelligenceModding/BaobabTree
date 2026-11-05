package de.artemis.baobabtree.common.event;

import de.artemis.baobabtree.common.registry.ModBlocks;
import de.artemis.baobabtree.common.registry.ModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;

public final class ModVillagerTradeHandler {
    private static final float PRICE_MULTIPLIER = 0.05F;

    private ModVillagerTradeHandler() {
    }

    public static void onWandererTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new BasicItemListing(5, new ItemStack(ModBlocks.BAOBAB_SAPLING.get()), 8, 1, PRICE_MULTIPLIER));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.BAOBAB_FRUIT.get(), 2), 12, 1, PRICE_MULTIPLIER));
        event.getRareTrades().add(new BasicItemListing(1, new ItemStack(ModBlocks.BAOBAB_LOG.get(), 8), 4, 1, PRICE_MULTIPLIER));
    }

    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            event.getTrades().get(2).add(new BasicItemListing(
                    new ItemStack(ModItems.BAOBAB_FRUIT.get(), 8),
                    new ItemStack(Items.EMERALD),
                    12,
                    10,
                    PRICE_MULTIPLIER
            ));
        }
    }

    private record BasicItemListing(ItemStack cost, ItemStack result, int uses, int xp,
                                    float multiplier) implements net.minecraft.world.entity.npc.VillagerTrades.ItemListing {
        BasicItemListing(int emeralds, ItemStack result, int uses, int xp, float multiplier) {
            this(new ItemStack(Items.EMERALD, emeralds), result, uses, xp, multiplier);
        }

        @Override
        public net.minecraft.world.item.trading.MerchantOffer getOffer(net.minecraft.world.entity.Entity trader, net.minecraft.util.RandomSource random) {
            return new net.minecraft.world.item.trading.MerchantOffer(cost.copy(), result.copy(), uses, xp, multiplier);
        }
    }
}
