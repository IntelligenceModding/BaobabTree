package de.artemis.baobabtree.common.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BaobabStrippableLogBlock extends RotatedPillarBlock {

    private final Supplier<Block> strippedBlock;

    public BaobabStrippableLogBlock(BlockBehaviour.Properties properties, Supplier<Block> strippedBlock) {
        super(properties);
        this.strippedBlock = strippedBlock;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction itemAbility, boolean simulate) {
        if (itemAbility == ToolActions.AXE_STRIP) {
            return strippedBlock.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
