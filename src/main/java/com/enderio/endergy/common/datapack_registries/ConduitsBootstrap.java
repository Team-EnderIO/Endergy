package com.enderio.endergy.common.datapack_registries;

import com.enderio.api.conduit.ConduitItemFactory;
import com.enderio.api.conduit.ConduitType;
import com.enderio.api.registry.EnderIORegistries;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.conduit.EndergyEnergyConduitTicker;
import com.enderio.endergy.common.conduit.EndergyEnergyConduitType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ConduitsBootstrap {
    public static final DeferredRegister<ConduitType<?>> CONDUIT_TYPES =
        DeferredRegister.create(EnderIORegistries.Keys.CONDUIT_TYPES, EnderIOEndergy.MOD_ID);

    public static final DeferredRegister<Item> CONDUIT_ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, EnderIOEndergy.MOD_ID);

    // Tiers
    public static final RegistryObject<EndergyEnergyConduitType> CRUDE_ENERGY =
        CONDUIT_TYPES.register("crude_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.crude_energy", EndergyEnergyConduitTicker.CRUDE));

    public static final RegistryObject<EndergyEnergyConduitType> IRON_ENERGY =
        CONDUIT_TYPES.register("iron_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.iron_energy", EndergyEnergyConduitTicker.IRON));

    public static final RegistryObject<EndergyEnergyConduitType> GOLD_ENERGY =
        CONDUIT_TYPES.register("gold_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.gold_energy", EndergyEnergyConduitTicker.GOLD));

    public static final RegistryObject<EndergyEnergyConduitType> COPPER_ENERGY =
        CONDUIT_TYPES.register("copper_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.copper_energy", EndergyEnergyConduitTicker.COPPER));

    public static final RegistryObject<EndergyEnergyConduitType> CRYSTALLINE_ENERGY =
        CONDUIT_TYPES.register("crystalline_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.crystalline_energy", EndergyEnergyConduitTicker.CRYSTALLINE));

    public static final RegistryObject<EndergyEnergyConduitType> MELODIC_ENERGY =
        CONDUIT_TYPES.register("melodic_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.melodic_energy", EndergyEnergyConduitTicker.MELODIC));

    public static final RegistryObject<EndergyEnergyConduitType> STELLAR_ENERGY =
        CONDUIT_TYPES.register("stellar_energy", () -> new EndergyEnergyConduitType("conduit.enderio_endergy.stellar_energy", EndergyEnergyConduitTicker.STELLAR));

    // Items
    public static final RegistryObject<Item> CRUDE_ENERGY_ITEM =
        CONDUIT_ITEMS.register("crude_energy", () -> ConduitItemFactory.build(CRUDE_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> IRON_ENERGY_ITEM =
        CONDUIT_ITEMS.register("iron_energy", () -> ConduitItemFactory.build(IRON_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_ENERGY_ITEM =
        CONDUIT_ITEMS.register("gold_energy", () -> ConduitItemFactory.build(GOLD_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> COPPER_ENERGY_ITEM =
        CONDUIT_ITEMS.register("copper_energy", () -> ConduitItemFactory.build(COPPER_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> CRYSTALLINE_ENERGY_ITEM =
        CONDUIT_ITEMS.register("crystalline_energy", () -> ConduitItemFactory.build(CRYSTALLINE_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> MELODIC_ENERGY_ITEM =
        CONDUIT_ITEMS.register("melodic_energy", () -> ConduitItemFactory.build(MELODIC_ENERGY, new Item.Properties()));

    public static final RegistryObject<Item> STELLAR_ENERGY_ITEM =
        CONDUIT_ITEMS.register("stellar_energy", () -> ConduitItemFactory.build(STELLAR_ENERGY, new Item.Properties()));

    public static void register(IEventBus bus) {
        CONDUIT_TYPES.register(bus);
        CONDUIT_ITEMS.register(bus);
    }
}