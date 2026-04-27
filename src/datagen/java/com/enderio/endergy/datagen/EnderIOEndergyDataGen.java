package com.enderio.endergy.datagen;

import com.enderio.endergy.datagen.client.EndergyLanguageProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.datagen.client.EndergyModelProvider;
import com.enderio.endergy.datagen.common.data_maps.GrindingBallDataMapProvider;
import com.enderio.endergy.datagen.common.recipes.EndergyRecipeProvider;
import com.enderio.endergy.datagen.common.datapack_registries.ConduitsBootstrap;
import com.enderio.enderio.api.EnderIORegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod(EnderIOEndergy.MOD_ID)
public class EnderIOEndergyDataGen {
    public EnderIOEndergyDataGen(IEventBus eventBus) {
        eventBus.addListener(EventPriority.LOWEST, this::onGatherData);
    }

    public void onGatherData(GatherDataEvent.Client event) {
        // Create datapack registry objects
        event.createDatapackRegistryObjects(createDatapackEntriesBuilder(), Set.of(EnderIOEndergy.MOD_ID));

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.createProvider(EndergyRecipeProvider.Runner::new);

        generator.addProvider(true, new GrindingBallDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(true, new EndergyLanguageProvider(packOutput));
        generator.addProvider(true, new EndergyModelProvider(packOutput));

    }

    private static RegistrySetBuilder createDatapackEntriesBuilder() {
        return new RegistrySetBuilder()
            .add(EnderIORegistries.Keys.CONDUIT, context -> {
                ConduitsBootstrap.bootstrap(context);
                // Need to bootstrap main mod conduits to reference them for recipes.
                // TODO: Better way of exposing this without shipping the datagen source set fully.
                com.enderio.enderio.datagen.common.datapack_registries.ConduitsBootstrap.bootstrap(context);
            });
    }
}
