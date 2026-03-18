package com.enderio.endergy.datagen.client;

import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyBlocks;
import com.enderio.endergy.common.init.EndergyItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class EndergyItemModelProvider extends ItemModelProvider {
    public EndergyItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, EnderIOEndergy.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Alloys
        basicItem(EndergyItems.CRUDE_STEEL_INGOT.get());
        basicItem(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get());
        basicItem(EndergyItems.MELODIC_ALLOY_INGOT.get());
        basicItem(EndergyItems.STELLAR_ALLOY_INGOT.get());
        basicItem(EndergyItems.VIVID_ALLOY_INGOT.get());

        basicItem(EndergyItems.CRUDE_STEEL_NUGGET.get());
        basicItem(EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get());
        basicItem(EndergyItems.MELODIC_ALLOY_NUGGET.get());
        basicItem(EndergyItems.STELLAR_ALLOY_NUGGET.get());
        basicItem(EndergyItems.VIVID_ALLOY_NUGGET.get());

        // Grinding Balls
        basicItem(EndergyItems.CRUDE_STEEL_BALL.get());
        basicItem(EndergyItems.CRYSTALLINE_ALLOY_BALL.get());
        basicItem(EndergyItems.MELODIC_ALLOY_BALL.get());
        basicItem(EndergyItems.STELLAR_ALLOY_BALL.get());
        basicItem(EndergyItems.VIVID_ALLOY_BALL.get());

        // Capacitors
        basicItem(EndergyItems.GRAINY_CAPACITOR.get());
        basicItem(EndergyItems.VIVID_CAPACITOR.get());
        basicItem(EndergyItems.CRYSTALLINE_CAPACITOR.get());
        basicItem(EndergyItems.MELODIC_CAPACITOR.get());
        basicItem(EndergyItems.STELLAR_CAPACITOR.get());
        basicItem(EndergyItems.TOTEMIC_CAPACITOR.get());

        // Blocks
        blockItem(EndergyBlocks.CRUDE_STEEL_BLOCK.get());
        blockItem(EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get());
        blockItem(EndergyBlocks.MELODIC_ALLOY_BLOCK.get());
        blockItem(EndergyBlocks.STELLAR_ALLOY_BLOCK.get());
        blockItem(EndergyBlocks.VIVID_ALLOY_BLOCK.get());

    }

    private void blockItem(Block block) {
        ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(block);
        withExistingParent(
            blockId.getPath(),
            new ResourceLocation(blockId.getNamespace(), "block/" + blockId.getPath())
        );
    }

    private void conduitItem(String name) {
        getBuilder(name)
            .parent(new ModelFile.UncheckedModelFile(
                new ResourceLocation(EnderIOEndergy.MOD_ID, "item/" + name)
            ));
    }

    public ItemModelBuilder flatBlockItem(ResourceLocation block) {
        return this.getBuilder(block.toString())
            .parent(new ModelFile.UncheckedModelFile("item/generated"))
            .texture("layer0", new ResourceLocation(block.getNamespace(), "block/" + block.getPath()));
    }

    public ItemModelBuilder bucketItem(BucketItem item) {
        return withExistingParent(
            ForgeRegistries.ITEMS.getKey(item).toString(),
            new ResourceLocation("forge", "item/bucket")
        )
        .texture("base",  new ResourceLocation("forge", "item/bucket"))
        .texture("fluid", new ResourceLocation("forge", "item/bucket_fluid"))
        .texture("cover", new ResourceLocation("forge", "item/bucket_cover"));
    }
}