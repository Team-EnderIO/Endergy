package com.enderio.endergy.common.client;

import com.enderio.endergy.common.EnderIOEndergy;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD, modid = EnderIOEndergy.MOD_ID)
public class EndergyClientSetup {

    @SubscribeEvent
    public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/crude_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/iron_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/gold_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/copper_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/crystalline_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/melodic_energy"));
        event.register(new ResourceLocation(EnderIOEndergy.MOD_ID, "item/stellar_energy"));
    }
}