package de.artemis.baobabtree.common.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public final class ModTreeGrowers {
    public static final AbstractTreeGrower BAOBAB = new AbstractTreeGrower() {
        @Override
        protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
            return ModTreeConfiguredFeatures.YOUNG_BAOBAB_KEY;
        }
    };

    private ModTreeGrowers() {
    }
}
