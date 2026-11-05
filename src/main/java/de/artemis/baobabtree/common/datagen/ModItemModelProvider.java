package de.artemis.baobabtree.common.datagen;

import de.artemis.baobabtree.BaobabTree;
import de.artemis.baobabtree.common.registry.ModBlocks;
import de.artemis.baobabtree.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BaobabTree.MOD_ID, existingFileHelper);
    }

    @Override
    public void registerModels() {
        modTextureItem(ModItems.BAOBAB_SIGN.get(), "baobab_sign");
        modTextureItem(ModItems.BAOBAB_HANGING_SIGN.get(), "baobab_hanging_sign");
        modTextureItem(ModItems.BAOBAB_BOAT.get(), "baobab_boat");
        modTextureItem(ModItems.BAOBAB_CHEST_BOAT.get(), "baobab_chest_boat");
        modTextureItem(ModItems.BAOBAB_FRUIT.get(), "baobab_fruit");
        modTextureBlockItem(ModBlocks.BAOBAB_SAPLING.get().asItem(), "baobab_sapling");

        modTextureBlockItem(ModBlocks.BAOBAB_LITTER.get().asItem(), "baobab_litter");
    }


    private void modTextureItem(Item item, String textureName) {
        String name = net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(item).getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + textureName));
    }

    private void modTextureBlockItem(Item item, String textureName) {
        String name = net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(item).getPath();
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + textureName));
    }
}
