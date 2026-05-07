package com.enderio.endergy.common;

import com.enderio.enderio.api.EnderIORegistries;
import com.enderio.enderio.api.conduits.Conduit;
import net.minecraft.resources.ResourceKey;

public class EndergyConduits {
    public static final ResourceKey<Conduit<?, ?>> CRUDE_ENERGY = create("crude_energy");
    public static final ResourceKey<Conduit<?, ?>> COPPER_ENERGY = create("copper_energy");
    public static final ResourceKey<Conduit<?, ?>> IRON_ENERGY = create("iron_energy");
    public static final ResourceKey<Conduit<?, ?>> GOLD_ENERGY = create("gold_energy");
    public static final ResourceKey<Conduit<?, ?>> CRYSTALLINE_ENERGY = create("crystalline_energy");
    public static final ResourceKey<Conduit<?, ?>> MELODIC_ENERGY = create("melodic_energy");
    public static final ResourceKey<Conduit<?, ?>> STELLAR_ENERGY = create("stellar_energy");

    public static final ResourceKey<Conduit<?, ?>> CRYSTALLINE_ITEM = create("crystalline_item");
    public static final ResourceKey<Conduit<?, ?>> MELODIC_ITEM = create("melodic_item");
    public static final ResourceKey<Conduit<?, ?>> STELLAR_ITEM = create("stellar_item");

    public static final ResourceKey<Conduit<?, ?>> CRYSTALLINE_FLUID = create("crystalline_fluid");
    public static final ResourceKey<Conduit<?, ?>> MELODIC_FLUID = create("melodic_fluid");
    public static final ResourceKey<Conduit<?, ?>> STELLAR_FLUID = create("stellar_fluid");

    private static ResourceKey<Conduit<?, ?>> create(String name) {
        return ResourceKey.create(EnderIORegistries.Keys.CONDUIT, EnderIOEndergy.rl(name));
    }
}
