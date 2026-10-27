package de.artemis.baobabtree.common.block;

import de.artemis.baobabtree.common.block.entity.BaobabSignBlockEntity;
import de.artemis.baobabtree.common.registry.ModWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BaobabStandingSignBlock extends StandingSignBlock {

    public BaobabStandingSignBlock(BlockBehaviour.Properties properties) {
        super(ModWoodTypes.BAOBAB_WOOD_TYPE, properties);
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new BaobabSignBlockEntity(pos, state);
    }
}
