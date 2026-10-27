package de.artemis.baobabtree.common.registry;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.worldgen.feature.BaobabTreeFeature;
import de.artemis.baobabtree.common.worldgen.feature.BaobabTreeGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;

public final class ModTreeConfiguredFeatures {
    public static final ResourceKey<Feature> YOUNG_BAOBAB_KEY = registerKey("young_baobab");
    public static final ResourceKey<Feature> MATURE_BAOBAB_KEY = registerKey("mature_baobab");
    public static final ResourceKey<Feature> ANCIENT_BAOBAB_KEY = registerKey("ancient_baobab");
    public static final ResourceKey<Feature> FALLEN_BAOBAB_KEY = registerKey("fallen_baobab");

    private ModTreeConfiguredFeatures() {
    }

    public static void bootstrap(BootstrapContext<Feature> context) {
        context.register(YOUNG_BAOBAB_KEY, new BaobabTreeFeature(BaobabTreeGenerator.Variant.YOUNG));
        context.register(MATURE_BAOBAB_KEY, new BaobabTreeFeature(BaobabTreeGenerator.Variant.MATURE));
        context.register(ANCIENT_BAOBAB_KEY, new BaobabTreeFeature(BaobabTreeGenerator.Variant.ANCIENT));
        context.register(FALLEN_BAOBAB_KEY, new BaobabTreeFeature(BaobabTreeGenerator.Variant.FALLEN));
    }

    private static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(BaobabTree.MOD_ID, name));
    }

}
