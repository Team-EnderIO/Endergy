package com.enderio.endergy.datagen.common.datapack_registries;

import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.EndergyConduits;
import com.enderio.endergy.common.init.EndergyCreativeTabs;
import com.enderio.enderio.EnderIO;
import com.enderio.enderio.api.EnderIORegistries;
import com.enderio.enderio.api.conduits.Conduit;
import com.enderio.enderio.content.conduits.type.energy.EnergyConduit;
import com.enderio.enderio.content.conduits.type.fluid.FluidConduit;
import com.enderio.enderio.content.conduits.type.item.ItemConduit;
import com.enderio.enderio.init.EIOConduits;
import net.minecraft.Util;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;

import java.util.Optional;
import java.util.function.Function;

public class ConduitsBootstrap {
    public static void bootstrap(BootstrapContext<Conduit<?, ?>> context) {
        // TODO: Need to adapt rates to new balance, just getting them in
        register(context, EndergyConduits.CRUDE_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/crude_energy"), desc, 20));
        register(context, EndergyConduits.COPPER_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/copper_energy"), desc, 40));
        register(context, EndergyConduits.IRON_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/iron_energy"), desc, 80));
        register(context, EndergyConduits.GOLD_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/gold_energy"), desc, 160));
        register(context, EndergyConduits.CRYSTALLINE_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/crystalline_energy"), desc, 384_000));
        register(context, EndergyConduits.MELODIC_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/melodic_energy"), desc, 768_000));
        register(context, EndergyConduits.STELLAR_ENERGY, (desc) -> new EnergyConduit(EnderIOEndergy.rl("block/conduit/stellar_energy"), desc, Integer.MAX_VALUE));

//        register(context, EndergyConduits.CRYSTALLINE_FLUID, (desc) -> new FluidConduit(EnderIO.rl("block/conduit/ender_fluid"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), 128_000, true, true));
//        register(context, EndergyConduits.MELODIC_FLUID, (desc) -> new FluidConduit(EnderIO.rl("block/conduit/ender_fluid"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), 512_000, true, true));
//        register(context, EndergyConduits.STELLAR_FLUID, (desc) -> new FluidConduit(EnderIO.rl("block/conduit/ender_fluid"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), Integer.MAX_VALUE, true, true));
//
//        register(context, EndergyConduits.CRYSTALLINE_ITEM, (desc) -> new ItemConduit(EnderIO.rl("block/conduit/item"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), 128, 10));
//        register(context, EndergyConduits.MELODIC_ITEM, (desc) -> new ItemConduit(EnderIO.rl("block/conduit/item"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), 256, 5));
//        register(context, EndergyConduits.STELLAR_ITEM, (desc) -> new ItemConduit(EnderIO.rl("block/conduit/item"), desc,
//                Optional.of(EndergyCreativeTabs.MAIN), 512, 1));
    }

    private static void register(BootstrapContext<Conduit<?, ?>> context, ResourceKey<Conduit<?, ?>> key, Function<Component, Conduit<?, ?>> factory) {
        context.register(key,
            factory.apply(Component.translatable(Util.makeDescriptionId(EnderIORegistries.Keys.CONDUIT.location().getPath(), key.location()))));
    }
}
