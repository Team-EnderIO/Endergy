package com.enderio.endergy.common;

import com.enderio.api.conduit.ConduitType;
import com.enderio.api.registry.EnderIORegistries;
import net.minecraft.resources.ResourceKey;

public class EndergyConduits {
    public static final ResourceKey<ConduitType<?>> CRUDE_ENERGY        = create("crude_energy");
    public static final ResourceKey<ConduitType<?>> COPPER_ENERGY       = create("copper_energy");
    public static final ResourceKey<ConduitType<?>> IRON_ENERGY         = create("iron_energy");
    public static final ResourceKey<ConduitType<?>> GOLD_ENERGY         = create("gold_energy");
    public static final ResourceKey<ConduitType<?>> CRYSTALLINE_ENERGY  = create("crystalline_energy");
    public static final ResourceKey<ConduitType<?>> MELODIC_ENERGY      = create("melodic_energy");
    public static final ResourceKey<ConduitType<?>> STELLAR_ENERGY      = create("stellar_energy");

    private static ResourceKey<ConduitType<?>> create(String name) {
        return ResourceKey.create(EnderIORegistries.Keys.CONDUIT_TYPES, EnderIOEndergy.rl(name));
    }
}