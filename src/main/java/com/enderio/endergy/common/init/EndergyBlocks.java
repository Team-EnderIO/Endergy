package com.enderio.endergy.common.init;

import com.enderio.endergy.common.EnderIOEndergy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndergyBlocks {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, EnderIOEndergy.MOD_ID);
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, EnderIOEndergy.MOD_ID);

    // region Alloy Blocks

    public static final RegistryObject<Block> CRUDE_STEEL_BLOCK        = registerMetalBlock("crude_steel_block");
    public static final RegistryObject<Block> CRYSTALLINE_ALLOY_BLOCK  = registerMetalBlock("crystalline_alloy_block");
    public static final RegistryObject<Block> MELODIC_ALLOY_BLOCK      = registerMetalBlock("melodic_alloy_block");
    public static final RegistryObject<Block> STELLAR_ALLOY_BLOCK      = registerMetalBlock("stellar_alloy_block");
    public static final RegistryObject<Block> VIVID_ALLOY_BLOCK        = registerMetalBlock("vivid_alloy_block");

    private static RegistryObject<Block> registerMetalBlock(String name) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of()
            .sound(SoundType.METAL)
            .mapColor(MapColor.METAL)
            .strength(5, 6)
            .requiresCorrectToolForDrops();

        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(props));
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    // endregion

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }
}