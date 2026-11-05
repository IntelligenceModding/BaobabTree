package de.artemis.baobabtree.common.registry;

import de.artemis.baobabtree.BaobabTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BaobabTree.MOD_ID);

    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> BAOBAB_TREE = CREATIVE_MODE_TABS.register(
            "baobab_tree",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.BAOBAB_SAPLING.get()))
                    .title(Component.translatable("itemGroup.baobabtree"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BAOBAB_LOG.get());
                        output.accept(ModBlocks.BAOBAB_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_BAOBAB_LOG.get());
                        output.accept(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
                        output.accept(ModBlocks.BAOBAB_PLANKS.get());
                        output.accept(ModBlocks.BAOBAB_STAIRS.get());
                        output.accept(ModBlocks.BAOBAB_SLAB.get());
                        output.accept(ModBlocks.BAOBAB_FENCE.get());
                        output.accept(ModBlocks.BAOBAB_FENCE_GATE.get());
                        output.accept(ModBlocks.BAOBAB_DOOR.get());
                        output.accept(ModBlocks.BAOBAB_TRAPDOOR.get());
                        output.accept(ModBlocks.BAOBAB_BUTTON.get());
                        output.accept(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
                        output.accept(ModItems.BAOBAB_SIGN.get());
                        output.accept(ModItems.BAOBAB_HANGING_SIGN.get());
                        output.accept(ModBlocks.BAOBAB_LEAVES.get());
                        output.accept(ModBlocks.BAOBAB_SAPLING.get());
                        output.accept(ModBlocks.BAOBAB_LITTER.get());
                        output.accept(ModBlocks.TREE_ROOT.get());
                        output.accept(ModBlocks.SMALL_BAOBAB_FRUIT_POD.get());
                        output.accept(ModBlocks.MEDIUM_BAOBAB_FRUIT_POD.get());
                        output.accept(ModBlocks.LARGE_BAOBAB_FRUIT_POD.get());
                        output.accept(ModItems.BAOBAB_FRUIT.get());
                        output.accept(ModItems.BAOBAB_BOAT.get());
                        output.accept(ModItems.BAOBAB_CHEST_BOAT.get());
                    })
                    .build()
    );

    private ModCreativeModeTabs() {
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
