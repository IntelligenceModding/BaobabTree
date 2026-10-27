package de.artemis.baobabtree.common.registry;

import net.minecraft.world.level.block.grower.TreeGrower;

import net.minecraft.util.random.WeightedList;

public final class ModTreeGrowers {
    public static final TreeGrower BAOBAB = new TreeGrower(
            "baobabtree:baobab",
            WeightedList.of(),
            WeightedList.of(ModTreeConfiguredFeatures.YOUNG_BAOBAB_KEY),
            WeightedList.of(),
            null
    );

    private ModTreeGrowers() {
    }
}
