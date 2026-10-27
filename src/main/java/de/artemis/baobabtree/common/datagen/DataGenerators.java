package de.artemis.baobabtree.common.datagen;

import de.artemis.baobabtree.common.registry.ModBiomeModifiers;
import de.artemis.baobabtree.common.registry.ModPlacedFeatures;
import de.artemis.baobabtree.common.registry.ModTreeConfiguredFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.concurrent.CompletableFuture;

public final class DataGenerators {
    private DataGenerators() {
    }

    public static void gatherRegistries(GatherDataRegistryEntriesEvent event) {
        // Keep datapack entries in the server output; client generation only supplies assets.
        if (FMLEnvironment.getDist().isClient()) {
            return;
        }
        event.add(Registries.FEATURE, ModTreeConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
                .lootTable(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK))
                .recipe(ModRecipeProvider::new);
    }

    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        event.addProvider(new ModModelProvider(packOutput));
        event.addProvider(new ModLanguageProvider(packOutput, "en_us"));
    }

    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getWorldLookupProvider();

        event.addProvider(new ModBlockTagProvider(packOutput, lookupProvider));
        event.addProvider(new ModItemTagProvider(packOutput, lookupProvider));
        event.addProvider(new ModDataMapProvider(packOutput, lookupProvider));
    }
}
