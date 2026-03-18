package com.enderio.endergy.common.datagen;

import com.enderio.base.data.EIODataProvider;
import com.enderio.endergy.common.recipes.AlloyRecipeProvider;
import com.enderio.endergy.common.recipes.ConduitRecipeProvider;
import com.enderio.endergy.common.recipes.MaterialRecipeProvider;
import com.enderio.endergy.common.recipes.SlicingRecipeProvider;
import com.enderio.endergy.datagen.client.EndergyBlockStateProvider;
import com.enderio.endergy.datagen.client.EndergyItemModelProvider;
import com.enderio.endergy.datagen.client.EndergyLanguageProvider;
import com.enderio.endergy.datagen.common.data_maps.GrindingBallDataMapProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;

public class EndergyDataGen {

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();

        EIODataProvider provider = new EIODataProvider("endergy");

        // Server
        provider.addSubProvider(event.includeServer(), new AlloyRecipeProvider(output));
        provider.addSubProvider(event.includeServer(), new ConduitRecipeProvider(output));
        provider.addSubProvider(event.includeServer(), new MaterialRecipeProvider(output));
        provider.addSubProvider(event.includeServer(), new SlicingRecipeProvider(output));
        provider.addSubProvider(event.includeServer(), new GrindingBallDataMapProvider(output));

        // Client
        provider.addSubProvider(event.includeClient(), new EndergyLanguageProvider.En(output));
        provider.addSubProvider(event.includeClient(), new EndergyLanguageProvider.EsEs(output));
        provider.addSubProvider(event.includeClient(), new EndergyLanguageProvider.EsAr(output));
        provider.addSubProvider(event.includeClient(), new EndergyLanguageProvider.EsMx(output));
        provider.addSubProvider(event.includeClient(), new EndergyBlockStateProvider(output, event.getExistingFileHelper()));
        provider.addSubProvider(event.includeClient(), new EndergyItemModelProvider(output, event.getExistingFileHelper()));

        generator.addProvider(true, provider);
    }
}