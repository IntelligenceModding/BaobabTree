package de.artemis.baobabtree.common.event;

import de.artemis.baobabtree.common.registry.ModBlocks;
import de.artemis.baobabtree.common.registry.ModItems;

public final class ModItemBehavior {
    public static void setup(net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.BAOBAB_LEAVES.get().asItem(), 0.3F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.BAOBAB_SAPLING.get().asItem(), 0.3F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.BAOBAB_LITTER.get().asItem(), 0.3F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.BAOBAB_FRUIT_POD.get().asItem(), 0.5F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.SMALL_BAOBAB_FRUIT_POD.get().asItem(), 0.5F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.MEDIUM_BAOBAB_FRUIT_POD.get().asItem(), 0.5F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.LARGE_BAOBAB_FRUIT_POD.get().asItem(), 0.5F);
            net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModItems.BAOBAB_FRUIT.get().asItem(), 0.65F);
            net.minecraft.world.level.block.FireBlock fire = (net.minecraft.world.level.block.FireBlock) net.minecraft.world.level.block.Blocks.FIRE;
            for (var block : java.util.List.of(ModBlocks.BAOBAB_LOG, ModBlocks.BAOBAB_WOOD, ModBlocks.STRIPPED_BAOBAB_LOG, ModBlocks.STRIPPED_BAOBAB_WOOD))
                fire.setFlammable(block.get(), 5, 5);
            for (var block : java.util.List.of(ModBlocks.BAOBAB_PLANKS, ModBlocks.BAOBAB_STAIRS, ModBlocks.BAOBAB_SLAB, ModBlocks.BAOBAB_FENCE, ModBlocks.BAOBAB_FENCE_GATE, ModBlocks.TREE_ROOT))
                fire.setFlammable(block.get(), 5, 20);
            fire.setFlammable(ModBlocks.BAOBAB_LEAVES.get(), 30, 60);
            fire.setFlammable(ModBlocks.BAOBAB_LITTER.get(), 60, 100);
            ((net.minecraft.world.level.block.FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT).addPlant(ModBlocks.BAOBAB_SAPLING.getId(), ModBlocks.POTTED_BAOBAB_SAPLING);
        });
    }

    public static void fuel(net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent event) {
        if (event.getItemStack().is(ModItems.BAOBAB_BOAT.get().asItem())) event.setBurnTime(1200);
        if (event.getItemStack().is(ModItems.BAOBAB_CHEST_BOAT.get().asItem())) event.setBurnTime(1200);
        if (event.getItemStack().is(ModItems.BAOBAB_SIGN.get().asItem())) event.setBurnTime(200);
        if (event.getItemStack().is(ModItems.BAOBAB_HANGING_SIGN.get().asItem())) event.setBurnTime(800);
        if (event.getItemStack().is(ModBlocks.BAOBAB_LOG.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_WOOD.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.STRIPPED_BAOBAB_LOG.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.STRIPPED_BAOBAB_WOOD.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_PLANKS.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_STAIRS.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_SLAB.get().asItem())) event.setBurnTime(150);
        if (event.getItemStack().is(ModBlocks.BAOBAB_FENCE.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_FENCE_GATE.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_DOOR.get().asItem())) event.setBurnTime(200);
        if (event.getItemStack().is(ModBlocks.BAOBAB_TRAPDOOR.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_BUTTON.get().asItem())) event.setBurnTime(100);
        if (event.getItemStack().is(ModBlocks.BAOBAB_PRESSURE_PLATE.get().asItem())) event.setBurnTime(300);
        if (event.getItemStack().is(ModBlocks.BAOBAB_LITTER.get().asItem())) event.setBurnTime(100);
        if (event.getItemStack().is(ModBlocks.TREE_ROOT.get().asItem())) event.setBurnTime(300);
    }
}
