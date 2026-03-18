package com.enderio.endergy.common.init;

import com.enderio.base.common.item.capacitors.FixedCapacitorItem;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.capacitor.EndergyCapacitorData;
import com.enderio.endergy.common.item.TotemicCapacitorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndergyItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, EnderIOEndergy.MOD_ID);

    // region Alloys

    public static final RegistryObject<Item> CRUDE_STEEL_INGOT        = basic("crude_steel_ingot");
    public static final RegistryObject<Item> CRYSTALLINE_ALLOY_INGOT  = basic("crystalline_alloy_ingot");
    public static final RegistryObject<Item> MELODIC_ALLOY_INGOT      = basic("melodic_alloy_ingot");
    public static final RegistryObject<Item> STELLAR_ALLOY_INGOT      = basic("stellar_alloy_ingot");
    public static final RegistryObject<Item> VIVID_ALLOY_INGOT        = basic("vivid_alloy_ingot");

    public static final RegistryObject<Item> CRUDE_STEEL_NUGGET       = basic("crude_steel_nugget");
    public static final RegistryObject<Item> CRYSTALLINE_ALLOY_NUGGET = basic("crystalline_alloy_nugget");
    public static final RegistryObject<Item> MELODIC_ALLOY_NUGGET     = basic("melodic_alloy_nugget");
    public static final RegistryObject<Item> STELLAR_ALLOY_NUGGET     = basic("stellar_alloy_nugget");
    public static final RegistryObject<Item> VIVID_ALLOY_NUGGET       = basic("vivid_alloy_nugget");

    // endregion

    // region Grinding Balls

    public static final RegistryObject<Item> CRUDE_STEEL_BALL        = basic("crude_steel_grinding_ball");
    public static final RegistryObject<Item> CRYSTALLINE_ALLOY_BALL  = basic("crystalline_alloy_grinding_ball");
    public static final RegistryObject<Item> MELODIC_ALLOY_BALL      = basic("melodic_alloy_grinding_ball");
    public static final RegistryObject<Item> STELLAR_ALLOY_BALL      = basic("stellar_alloy_grinding_ball");
    public static final RegistryObject<Item> VIVID_ALLOY_BALL        = basic("vivid_alloy_grinding_ball");

    // endregion

    // region Capacitors

    public static final RegistryObject<FixedCapacitorItem> GRAINY_CAPACITOR =
        ITEMS.register("grainy_capacitor",
            () -> new FixedCapacitorItem(EndergyCapacitorData.GRAINY, new Item.Properties()));

    public static final RegistryObject<FixedCapacitorItem> VIVID_CAPACITOR =
        ITEMS.register("vivid_capacitor",
            () -> new FixedCapacitorItem(EndergyCapacitorData.VIVID, new Item.Properties()));

    public static final RegistryObject<FixedCapacitorItem> CRYSTALLINE_CAPACITOR =
        ITEMS.register("crystalline_capacitor",
            () -> new FixedCapacitorItem(EndergyCapacitorData.CRYSTALLINE, new Item.Properties()));

    public static final RegistryObject<FixedCapacitorItem> MELODIC_CAPACITOR =
        ITEMS.register("melodic_capacitor",
            () -> new FixedCapacitorItem(EndergyCapacitorData.MELODIC, new Item.Properties()));

    public static final RegistryObject<FixedCapacitorItem> STELLAR_CAPACITOR =
        ITEMS.register("stellar_capacitor",
            () -> new FixedCapacitorItem(EndergyCapacitorData.STELLAR, new Item.Properties()));

    public static final RegistryObject<TotemicCapacitorItem> TOTEMIC_CAPACITOR =
        ITEMS.register("totemic_capacitor",
            () -> new TotemicCapacitorItem(new Item.Properties()));

    // endregion

    private static RegistryObject<Item> basic(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}