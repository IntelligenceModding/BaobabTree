package de.artemis.baobabtree.common.registry;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.entity.BaobabBoatEntity;
import de.artemis.baobabtree.common.entity.BaobabChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public final class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.ENTITY_TYPE, BaobabTree.MOD_ID);

    public static final RegistryObject<EntityType<BaobabBoatEntity>> BAOBAB_BOAT =
            ENTITY_TYPES.register("baobab_boat",
                    () -> EntityType.Builder.<BaobabBoatEntity>of(BaobabBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .clientTrackingRange(10)
                            .updateInterval(1)
                            .build("baobab_boat"));

    public static final RegistryObject<EntityType<BaobabChestBoatEntity>> BAOBAB_CHEST_BOAT =
            ENTITY_TYPES.register("baobab_chest_boat",
                    () -> EntityType.Builder.<BaobabChestBoatEntity>of(BaobabChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .clientTrackingRange(10)
                            .updateInterval(1)
                            .build("baobab_chest_boat"));

    private ModEntityTypes() {
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
