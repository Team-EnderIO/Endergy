package com.enderio.endergy.datagen.common.data_maps;

import com.enderio.endergy.common.init.EndergyItems;
import com.enderio.enderio.api.components.GrindingBallData;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class GrindingBallDataMapProvider extends DataMapProvider {

    public GrindingBallDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(GrindingBallData.DATA_MAP_TYPE)
            .add(EndergyItems.CRUDE_STEEL_BALL, new GrindingBallData(1.2F, 1.25F, 0.85F, 24000), false)
            .add(EndergyItems.CRYSTALLINE_ALLOY_BALL, new GrindingBallData(1.8F, 1.4F, 1.45F, 80000), false)
            .add(EndergyItems.MELODIC_ALLOY_BALL, new GrindingBallData(2.00F, 1.45F, 1.55F, 80000), false)
            .add(EndergyItems.STELLAR_ALLOY_BALL, new GrindingBallData(2.30F, 2.25F, 2.2F, 160000), false)
            .add(EndergyItems.VIVID_ALLOY_BALL, new GrindingBallData(1.75F, 1.35F, 1.35F, 80000), false);
    }

    @Override
    public String getName() {
        return "Grinding Ball Datamaps";
    }
}
