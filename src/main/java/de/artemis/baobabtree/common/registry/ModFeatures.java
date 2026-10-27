package de.artemis.baobabtree.common.registry;

import com.mojang.serialization.MapCodec;
import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.worldgen.feature.BaobabTreeFeature;
import de.artemis.baobabtree.common.worldgen.feature.BaobabTreeGenerator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class ModFeatures {
    public static final DeferredRegister<MapCodec<? extends Feature>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE_TYPE, BaobabTree.MOD_ID);

    public static final Supplier<MapCodec<BaobabTreeFeature>> YOUNG_BAOBAB_FEATURE =
            FEATURES.register("young_baobab_feature", () -> MapCodec.unit(() -> new BaobabTreeFeature(BaobabTreeGenerator.Variant.YOUNG)));
    public static final Supplier<MapCodec<BaobabTreeFeature>> MATURE_BAOBAB_FEATURE =
            FEATURES.register("mature_baobab_feature", () -> MapCodec.unit(() -> new BaobabTreeFeature(BaobabTreeGenerator.Variant.MATURE)));
    public static final Supplier<MapCodec<BaobabTreeFeature>> ANCIENT_BAOBAB_FEATURE =
            FEATURES.register("ancient_baobab_feature", () -> MapCodec.unit(() -> new BaobabTreeFeature(BaobabTreeGenerator.Variant.ANCIENT)));
    public static final Supplier<MapCodec<BaobabTreeFeature>> FALLEN_BAOBAB_FEATURE =
            FEATURES.register("fallen_baobab_feature", () -> MapCodec.unit(() -> new BaobabTreeFeature(BaobabTreeGenerator.Variant.FALLEN)));

    public static MapCodec<BaobabTreeFeature> codec(BaobabTreeGenerator.Variant variant) {
        return switch (variant) {
            case YOUNG -> YOUNG_BAOBAB_FEATURE.get();
            case MATURE -> MATURE_BAOBAB_FEATURE.get();
            case ANCIENT -> ANCIENT_BAOBAB_FEATURE.get();
            case FALLEN -> FALLEN_BAOBAB_FEATURE.get();
        };
    }

    private ModFeatures() {
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
