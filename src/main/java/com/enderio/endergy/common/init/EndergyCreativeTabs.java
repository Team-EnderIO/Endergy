package com.enderio.endergy.common.init;

import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.datapack_registries.ConduitsBootstrap;
import com.enderio.endergy.common.lang.EndergyCommonComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EndergyCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnderIOEndergy.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("endergy", () ->
        CreativeModeTab.builder()
            .title(Component.translatable(EndergyCommonComponents.CREATIVE_TAB_TITLE))
            .icon(() -> new ItemStack(EndergyItems.TOTEMIC_CAPACITOR.get()))
            .displayItems((params, output) -> {
                for (var entry : EndergyBlocks.ITEMS.getEntries()) {
                    output.accept(entry.get());
                }
                for (var entry : EndergyItems.ITEMS.getEntries()) {
                    output.accept(entry.get());
                }
                for (var entry : ConduitsBootstrap.CONDUIT_ITEMS.getEntries()) {
                    output.accept(entry.get());
                }
            })
            .build()
    );

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
        bus.addListener(EndergyCreativeTabs::addToExistingTabs);
    }

    private static void addToExistingTabs(BuildCreativeModeTabContentsEvent event) {
    }
}