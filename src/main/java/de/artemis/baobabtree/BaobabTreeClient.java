package de.artemis.baobabtree;

import de.artemis.baobabtree.client.ClientModEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BaobabTree.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BaobabTreeClient {
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerEntityRenderers(net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event) { ClientModEvents.registerEntityRenderers(event); }
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerParticleProviders(net.minecraftforge.client.event.RegisterParticleProvidersEvent event) { ClientModEvents.registerParticleProviders(event); }
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void onClientSetup(net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent event) { ClientModEvents.onClientSetup(event); }
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerBlockEntityRenderers(net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event) { ClientModEvents.registerBlockEntityRenderers(event); }
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerItemColors(net.minecraftforge.client.event.RegisterColorHandlersEvent.Item event) { ClientModEvents.registerItemColors(event); }
    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void registerBlockColors(net.minecraftforge.client.event.RegisterColorHandlersEvent.Block event) { ClientModEvents.registerBlockColors(event); }
}
