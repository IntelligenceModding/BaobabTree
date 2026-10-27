package de.artemis.baobabtree.common.registry;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.item.BaobabBoatItem;
import de.artemis.baobabtree.common.item.BaobabFruitItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BaobabTree.MOD_ID);

    public static final DeferredItem<Item> BAOBAB_SIGN = ITEMS.registerItem("baobab_sign",
            properties -> new StandingAndWallBlockItem(ModBlocks.BAOBAB_SIGN.get(), ModBlocks.BAOBAB_WALL_SIGN.get(), Direction.DOWN, properties),
            properties -> properties.stacksTo(16).signText().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE));

    public static final DeferredItem<Item> BAOBAB_HANGING_SIGN = ITEMS.registerItem("baobab_hanging_sign",
            properties -> new HangingSignItem(ModBlocks.BAOBAB_HANGING_SIGN.get(), ModBlocks.BAOBAB_WALL_HANGING_SIGN.get(), properties),
            properties -> properties.stacksTo(16).signText().cookingFuel(ContextIntProviders.COOKING_TIME_HANGING_SIGNS));

    public static final DeferredItem<Item> BAOBAB_BOAT = ITEMS.registerItem("baobab_boat",
            properties -> new BaobabBoatItem(false, properties),
            properties -> properties.stacksTo(1).cookingFuel(ContextIntProviders.COOKING_TIME_BOATS));

    public static final DeferredItem<Item> BAOBAB_CHEST_BOAT = ITEMS.registerItem("baobab_chest_boat",
            properties -> new BaobabBoatItem(true, properties),
            properties -> properties.stacksTo(1).cookingFuel(ContextIntProviders.COOKING_TIME_BOATS));

    public static final DeferredItem<Item> BAOBAB_FRUIT = ITEMS.registerItem("baobab_fruit",
            properties -> new BaobabFruitItem(properties.food(ModFoods.BAOBAB_FRUIT).compostable(ContextIntProviders.COMPOSTABLE_MEDIUM)));

    public static Item.Properties blockItemProperties(String name, Item.Properties properties) {
        switch (name) {
            case "baobab_leaves", "baobab_sapling", "baobab_litter" -> properties.compostable(ContextIntProviders.COMPOSTABLE_LOW);
            case "baobab_fruit_pod", "small_baobab_fruit_pod", "medium_baobab_fruit_pod", "large_baobab_fruit_pod" -> properties.compostable(ContextIntProviders.COMPOSTABLE_LOW_MEDIUM);
        }
        return switch (name) {
            case "baobab_log", "baobab_wood", "stripped_baobab_log", "stripped_baobab_wood", "baobab_planks", "baobab_stairs", "baobab_fence", "baobab_fence_gate", "baobab_trapdoor", "baobab_shelf", "baobab_pressure_plate", "tree_root" -> properties.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS);
            case "baobab_slab" -> properties.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_SLABS);
            case "baobab_door" -> properties.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_LARGE);
            case "baobab_button", "baobab_litter" -> properties.cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_ITEMS_EXTRA_SMALL);
            default -> properties;
        };
    }

    private ModItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
