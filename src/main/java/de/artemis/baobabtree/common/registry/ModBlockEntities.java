package de.artemis.baobabtree.common.registry;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.block.entity.BaobabLitterBlockEntity;
import de.artemis.baobabtree.common.block.entity.BaobabHangingSignBlockEntity;
import de.artemis.baobabtree.common.block.entity.BaobabSignBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public final class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE, BaobabTree.MOD_ID);

    public static final RegistryObject<BlockEntityType<BaobabSignBlockEntity>> BAOBAB_SIGN =
            BLOCK_ENTITIES.register("baobab_sign",
                    () -> BlockEntityType.Builder.of(
                            BaobabSignBlockEntity::new,
                            ModBlocks.BAOBAB_SIGN.get(),
                            ModBlocks.BAOBAB_WALL_SIGN.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<BaobabHangingSignBlockEntity>> BAOBAB_HANGING_SIGN =
            BLOCK_ENTITIES.register("baobab_hanging_sign",
                    () -> BlockEntityType.Builder.of(
                            BaobabHangingSignBlockEntity::new,
                            ModBlocks.BAOBAB_HANGING_SIGN.get(),
                            ModBlocks.BAOBAB_WALL_HANGING_SIGN.get()
                    ).build(null));

    public static final RegistryObject<BlockEntityType<BaobabLitterBlockEntity>> BAOBAB_LITTER =
            BLOCK_ENTITIES.register("baobab_litter",
                    () -> BlockEntityType.Builder.of(
                            BaobabLitterBlockEntity::new,
                            ModBlocks.BAOBAB_LITTER.get()
                    ).build(null));

    private ModBlockEntities() {
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
