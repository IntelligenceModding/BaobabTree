package de.artemis.baobabtree;

import de.artemis.baobabtree.common.command.BaobabTreeCommands;
import de.artemis.baobabtree.common.datagen.DataGenerators;
import de.artemis.baobabtree.common.event.ModItemBehavior;
import de.artemis.baobabtree.common.event.ModVillagerTradeHandler;
import de.artemis.baobabtree.common.event.TreeRootClimbHandler;
import de.artemis.baobabtree.common.registry.ModBlockEntities;
import de.artemis.baobabtree.common.registry.ModBlocks;
import de.artemis.baobabtree.common.registry.ModCreativeModeTabs;
import de.artemis.baobabtree.common.registry.ModEntityTypes;
import de.artemis.baobabtree.common.registry.ModFeatures;
import de.artemis.baobabtree.common.registry.ModItems;
import de.artemis.baobabtree.common.registry.ModParticles;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;

@Mod(BaobabTree.MOD_ID)
public class BaobabTree {
    public static final String MOD_ID = "baobabtree";

    public BaobabTree(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(ModItemBehavior::setup);
        MinecraftForge.EVENT_BUS.addListener(ModItemBehavior::fuel);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ModFeatures.register(modEventBus);
        ModParticles.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        modEventBus.addListener(DataGenerators::gatherData);
        MinecraftForge.EVENT_BUS.addListener(BaobabTreeCommands::register);
        MinecraftForge.EVENT_BUS.addListener(TreeRootClimbHandler::onPlayerTick);
        MinecraftForge.EVENT_BUS.addListener(ModVillagerTradeHandler::onWandererTrades);
        MinecraftForge.EVENT_BUS.addListener(ModVillagerTradeHandler::onVillagerTrades);
    }
}
