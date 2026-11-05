package de.artemis.baobabtree.common.datagen;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.registry.ModBlocks;
import de.artemis.baobabtree.common.registry.ModItems;
import de.artemis.baobabtree.common.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BaobabTree.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ItemTags.SAPLINGS)
                .add(ModBlocks.BAOBAB_SAPLING.get().asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BAOBAB_LOG.get().asItem())
                .add(ModBlocks.BAOBAB_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_WOOD.get().asItem());

        tag(ModTags.Items.BAOBAB_LOGS)
                .add(ModBlocks.BAOBAB_LOG.get().asItem())
                .add(ModBlocks.BAOBAB_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BAOBAB_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.BAOBAB_PLANKS.get().asItem());

        tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.BAOBAB_STAIRS.get().asItem());

        tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.BAOBAB_SLAB.get().asItem());

        tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.BAOBAB_FENCE.get().asItem());

        tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.BAOBAB_FENCE_GATE.get().asItem());

        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.BAOBAB_BUTTON.get().asItem());

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.BAOBAB_PRESSURE_PLATE.get().asItem());

        tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.BAOBAB_DOOR.get().asItem());

        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.BAOBAB_TRAPDOOR.get().asItem());

        tag(ItemTags.LEAVES)
                .add(ModBlocks.BAOBAB_LEAVES.get().asItem());

        tag(ItemTags.BOATS)
                .add(ModItems.BAOBAB_BOAT.get());

        tag(ItemTags.CHEST_BOATS)
                .add(ModItems.BAOBAB_CHEST_BOAT.get());

        tag(ItemTags.SIGNS)
                .add(ModItems.BAOBAB_SIGN.get());

        tag(ItemTags.HANGING_SIGNS)
                .add(ModItems.BAOBAB_HANGING_SIGN.get());

        tag(Tags.Items.FENCE_GATES_WOODEN)
                .add(ModBlocks.BAOBAB_FENCE_GATE.get().asItem());

        tag(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.ITEM, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("c", "stripped_logs")))
                .add(ModBlocks.STRIPPED_BAOBAB_LOG.get().asItem());

        tag(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.ITEM, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("c", "stripped_woods")))
                .add(ModBlocks.STRIPPED_BAOBAB_WOOD.get().asItem());

        tag(net.minecraft.tags.TagKey.create(net.minecraft.core.registries.Registries.ITEM, net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("c", "foods/fruit")))
                .add(ModItems.BAOBAB_FRUIT.get());
    }
}
