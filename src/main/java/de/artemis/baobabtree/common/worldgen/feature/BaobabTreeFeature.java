package de.artemis.baobabtree.common.worldgen.feature;

import com.mojang.serialization.MapCodec;
import de.artemis.baobabtree.common.registry.ModFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.WorldGenLevel;

public record BaobabTreeFeature(BaobabTreeGenerator.Variant variant) implements Feature {
    @Override
    public MapCodec<BaobabTreeFeature> codec() {
        return ModFeatures.codec(variant);
    }

    @Override
    public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
        return BaobabTreeGenerator.generate(level, origin, random, variant);
    }
}
