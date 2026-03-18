package com.enderio.endergy.common;

import com.enderio.endergy.common.datapack_registries.ConduitsBootstrap;
import com.enderio.endergy.common.datagen.EndergyDataGen;
import com.enderio.endergy.common.init.EndergyBlocks;
import com.enderio.endergy.common.init.EndergyCreativeTabs;
import com.enderio.endergy.common.init.EndergyItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EnderIOEndergy.MOD_ID)
public class EnderIOEndergy {
    public static final String MOD_ID = "enderio_endergy";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public EnderIOEndergy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EndergyItems.register(modEventBus);
        EndergyBlocks.register(modEventBus);
        EndergyCreativeTabs.register(modEventBus);
        ConduitsBootstrap.register(modEventBus);

        modEventBus.addListener(EndergyDataGen::gatherData);
    }
}