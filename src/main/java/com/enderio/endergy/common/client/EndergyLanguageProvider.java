package com.enderio.endergy.datagen.client;

import com.enderio.api.conduit.ConduitType;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.EndergyConduits;
import com.enderio.endergy.common.init.EndergyBlocks;
import com.enderio.endergy.common.init.EndergyItems;
import com.enderio.endergy.common.lang.EndergyCommonComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.LanguageProvider;

public class EndergyLanguageProvider {

    // -------------------------------------------------------------------------
    // English
    // -------------------------------------------------------------------------
    public static class En extends LanguageProvider {
        public En(PackOutput output) {
            super(output, EnderIOEndergy.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            addConduitDescriptions();
            addItems();
            addBlocks();
            addCommonLang();
            addTooltips();
        }

        private void addConduitDescriptions() {
            add("item.enderio_endergy.crude_energy",       "Crude Energy Conduit");
            add("item.enderio_endergy.copper_energy",      "Copper Energy Conduit");
            add("item.enderio_endergy.iron_energy",        "Iron Energy Conduit");
            add("item.enderio_endergy.gold_energy",        "Gold Energy Conduit");
            add("item.enderio_endergy.crystalline_energy", "Crystalline Energy Conduit");
            add("item.enderio_endergy.melodic_energy",     "Melodic Energy Conduit");
            add("item.enderio_endergy.stellar_energy",     "Stellar Energy Conduit");

            addConduit(EndergyConduits.CRUDE_ENERGY,       "Crude Energy Conduit");
            addConduit(EndergyConduits.COPPER_ENERGY,      "Copper Energy Conduit");
            addConduit(EndergyConduits.IRON_ENERGY,        "Iron Energy Conduit");
            addConduit(EndergyConduits.GOLD_ENERGY,        "Gold Energy Conduit");
            addConduit(EndergyConduits.CRYSTALLINE_ENERGY, "Crystalline Energy Conduit");
            addConduit(EndergyConduits.MELODIC_ENERGY,     "Melodic Energy Conduit");
            addConduit(EndergyConduits.STELLAR_ENERGY,     "Stellar Energy Conduit");
        }

        private void addTooltips() {
            add("tooltip.enderio_endergy.transfer_rate", "Transfer Rate: %s");
            add("conduit.enderio_endergy.crude_energy.description",       "A basic energy conduit made from crude steel.");
            add("conduit.enderio_endergy.copper_energy.description",      "A copper energy conduit with improved throughput.");
            add("conduit.enderio_endergy.iron_energy.description",        "An iron energy conduit with solid throughput.");
            add("conduit.enderio_endergy.gold_energy.description",        "A gold energy conduit for high-speed transfer.");
            add("conduit.enderio_endergy.crystalline_energy.description", "A crystalline alloy conduit for advanced energy transfer.");
            add("conduit.enderio_endergy.melodic_energy.description",     "A melodic alloy conduit for massive energy transfer.");
            add("conduit.enderio_endergy.stellar_energy.description",     "A stellar alloy conduit capable of extreme energy transfer.");
        }

        private void addItems() {
            add(EndergyItems.CRUDE_STEEL_INGOT.get(),        "Crude Steel Ingot");
            add(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get(),  "Crystalline Alloy Ingot");
            add(EndergyItems.MELODIC_ALLOY_INGOT.get(),      "Melodic Alloy Ingot");
            add(EndergyItems.STELLAR_ALLOY_INGOT.get(),      "Stellar Alloy Ingot");
            add(EndergyItems.VIVID_ALLOY_INGOT.get(),        "Vivid Alloy Ingot");

            add(EndergyItems.CRUDE_STEEL_NUGGET.get(),       "Crude Steel Nugget");
            add(EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get(), "Crystalline Alloy Nugget");
            add(EndergyItems.MELODIC_ALLOY_NUGGET.get(),     "Melodic Alloy Nugget");
            add(EndergyItems.STELLAR_ALLOY_NUGGET.get(),     "Stellar Alloy Nugget");
            add(EndergyItems.VIVID_ALLOY_NUGGET.get(),       "Vivid Alloy Nugget");

            add(EndergyItems.CRUDE_STEEL_BALL.get(),         "Crude Steel Grinding Ball");
            add(EndergyItems.CRYSTALLINE_ALLOY_BALL.get(),   "Crystalline Alloy Grinding Ball");
            add(EndergyItems.MELODIC_ALLOY_BALL.get(),       "Melodic Alloy Grinding Ball");
            add(EndergyItems.STELLAR_ALLOY_BALL.get(),       "Stellar Alloy Grinding Ball");
            add(EndergyItems.VIVID_ALLOY_BALL.get(),         "Vivid Alloy Grinding Ball");

            add(EndergyItems.GRAINY_CAPACITOR.get(),         "Grainy Capacitor");
            add(EndergyItems.VIVID_CAPACITOR.get(),          "Vivid Capacitor");
            add(EndergyItems.CRYSTALLINE_CAPACITOR.get(),    "Crystalline Capacitor");
            add(EndergyItems.MELODIC_CAPACITOR.get(),        "Melodic Capacitor");
            add(EndergyItems.STELLAR_CAPACITOR.get(),        "Stellar Capacitor");
            add(EndergyItems.TOTEMIC_CAPACITOR.get(),        "Totemic Capacitor");
        }

        private void addBlocks() {
            add(EndergyBlocks.CRUDE_STEEL_BLOCK.get(),       "Crude Steel Block");
            add(EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get(), "Crystalline Alloy Block");
            add(EndergyBlocks.MELODIC_ALLOY_BLOCK.get(),     "Melodic Alloy Block");
            add(EndergyBlocks.STELLAR_ALLOY_BLOCK.get(),     "Stellar Alloy Block");
            add(EndergyBlocks.VIVID_ALLOY_BLOCK.get(),       "Vivid Alloy Block");
        }

        private void addCommonLang() {
            add(EndergyCommonComponents.CREATIVE_TAB_TITLE, "Enderio Endergy");
            add(EndergyCommonComponents.TOTEMIC_CAPACITOR_TOOLTIP, "Can be enchanted with Efficiency to increase the modifier.");
        }

        private void addConduit(ResourceKey<ConduitType<?>> key, String translation) {
            add("conduit." + key.location().getNamespace() + "." + key.location().getPath(), translation);
        }

        private void add(Component component, String translation) {
            if (component.getContents() instanceof TranslatableContents tc) {
                add(tc.getKey(), translation);
            } else {
                throw new IllegalArgumentException("Component " + component + " is not translatable");
            }
        }
    }

    // -------------------------------------------------------------------------
    // Español España
    // -------------------------------------------------------------------------
    public static class EsEs extends LanguageProvider {
        public EsEs(PackOutput output) {
            super(output, EnderIOEndergy.MOD_ID, "es_es");
        }

        @Override
        protected void addTranslations() {
            addConduitDescriptions();
            addItems();
            addBlocks();
            addCommonLang();
            addTooltips();
        }

        private void addConduitDescriptions() {
            add("item.enderio_endergy.crude_energy",       "Conducto de Energía Tosca");
            add("item.enderio_endergy.copper_energy",      "Conducto de Energía de Cobre");
            add("item.enderio_endergy.iron_energy",        "Conducto de Energía de Hierro");
            add("item.enderio_endergy.gold_energy",        "Conducto de Energía de Oro");
            add("item.enderio_endergy.crystalline_energy", "Conducto de Energía Cristalina");
            add("item.enderio_endergy.melodic_energy",     "Conducto de Energía Melódica");
            add("item.enderio_endergy.stellar_energy",     "Conducto de Energía Estelar");

            addConduit(EndergyConduits.CRUDE_ENERGY,       "Conducto de Energía Tosca");
            addConduit(EndergyConduits.COPPER_ENERGY,      "Conducto de Energía de Cobre");
            addConduit(EndergyConduits.IRON_ENERGY,        "Conducto de Energía de Hierro");
            addConduit(EndergyConduits.GOLD_ENERGY,        "Conducto de Energía de Oro");
            addConduit(EndergyConduits.CRYSTALLINE_ENERGY, "Conducto de Energía Cristalina");
            addConduit(EndergyConduits.MELODIC_ENERGY,     "Conducto de Energía Melódica");
            addConduit(EndergyConduits.STELLAR_ENERGY,     "Conducto de Energía Estelar");
        }

        private void addTooltips() {
            add("tooltip.enderio_endergy.transfer_rate", "Tasa de Transferencia: %s");
            add("conduit.enderio_endergy.crude_energy.description",       "Un conducto básico de energía fabricado con acero tosco.");
            add("conduit.enderio_endergy.copper_energy.description",      "Un conducto de energía de cobre con mayor rendimiento.");
            add("conduit.enderio_endergy.iron_energy.description",        "Un conducto de energía de hierro con buen rendimiento.");
            add("conduit.enderio_endergy.gold_energy.description",        "Un conducto de energía de oro para transferencias rápidas.");
            add("conduit.enderio_endergy.crystalline_energy.description", "Un conducto de aleación cristalina para transferencias avanzadas.");
            add("conduit.enderio_endergy.melodic_energy.description",     "Un conducto de aleación melódica para transferencias masivas.");
            add("conduit.enderio_endergy.stellar_energy.description",     "Un conducto de aleación estelar capaz de transferencias extremas.");
        }

        private void addItems() {
            add(EndergyItems.CRUDE_STEEL_INGOT.get(),        "Lingote de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get(),  "Lingote de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_INGOT.get(),      "Lingote de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_INGOT.get(),      "Lingote de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_INGOT.get(),        "Lingote de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_NUGGET.get(),       "Pepita de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get(), "Pepita de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_NUGGET.get(),     "Pepita de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_NUGGET.get(),     "Pepita de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_NUGGET.get(),       "Pepita de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_BALL.get(),         "Bola de Molienda de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_BALL.get(),   "Bola de Molienda de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_BALL.get(),         "Bola de Molienda de Aleación Vívida");

            add(EndergyItems.GRAINY_CAPACITOR.get(),         "Condensador Granuloso");
            add(EndergyItems.VIVID_CAPACITOR.get(),          "Condensador Vívido");
            add(EndergyItems.CRYSTALLINE_CAPACITOR.get(),    "Condensador Cristalino");
            add(EndergyItems.MELODIC_CAPACITOR.get(),        "Condensador Melódico");
            add(EndergyItems.STELLAR_CAPACITOR.get(),        "Condensador Estelar");
            add(EndergyItems.TOTEMIC_CAPACITOR.get(),        "Condensador Totémico");
        }

        private void addBlocks() {
            add(EndergyBlocks.CRUDE_STEEL_BLOCK.get(),       "Bloque de Acero Tosco");
            add(EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get(), "Bloque de Aleación Cristalina");
            add(EndergyBlocks.MELODIC_ALLOY_BLOCK.get(),     "Bloque de Aleación Melódica");
            add(EndergyBlocks.STELLAR_ALLOY_BLOCK.get(),     "Bloque de Aleación Estelar");
            add(EndergyBlocks.VIVID_ALLOY_BLOCK.get(),       "Bloque de Aleación Vívida");
        }

        private void addCommonLang() {
            add(EndergyCommonComponents.CREATIVE_TAB_TITLE, "Enderio Endergy");
            add(EndergyCommonComponents.TOTEMIC_CAPACITOR_TOOLTIP, "Puede encantarse con Eficiencia para aumentar el modificador.");
        }

        private void addConduit(ResourceKey<ConduitType<?>> key, String translation) {
            add("conduit." + key.location().getNamespace() + "." + key.location().getPath(), translation);
        }

        private void add(Component component, String translation) {
            if (component.getContents() instanceof TranslatableContents tc) {
                add(tc.getKey(), translation);
            } else {
                throw new IllegalArgumentException("Component " + component + " is not translatable");
            }
        }
    }

    // -------------------------------------------------------------------------
    // Español Argentina
    // -------------------------------------------------------------------------
    public static class EsAr extends LanguageProvider {
        public EsAr(PackOutput output) {
            super(output, EnderIOEndergy.MOD_ID, "es_ar");
        }

        @Override
        protected void addTranslations() {
            addConduitDescriptions();
            addItems();
            addBlocks();
            addCommonLang();
            addTooltips();
        }

        private void addConduitDescriptions() {
            add("item.enderio_endergy.crude_energy",       "Conducto de Energía Tosca");
            add("item.enderio_endergy.copper_energy",      "Conducto de Energía de Cobre");
            add("item.enderio_endergy.iron_energy",        "Conducto de Energía de Hierro");
            add("item.enderio_endergy.gold_energy",        "Conducto de Energía de Oro");
            add("item.enderio_endergy.crystalline_energy", "Conducto de Energía Cristalina");
            add("item.enderio_endergy.melodic_energy",     "Conducto de Energía Melódica");
            add("item.enderio_endergy.stellar_energy",     "Conducto de Energía Estelar");

            addConduit(EndergyConduits.CRUDE_ENERGY,       "Conducto de Energía Tosca");
            addConduit(EndergyConduits.COPPER_ENERGY,      "Conducto de Energía de Cobre");
            addConduit(EndergyConduits.IRON_ENERGY,        "Conducto de Energía de Hierro");
            addConduit(EndergyConduits.GOLD_ENERGY,        "Conducto de Energía de Oro");
            addConduit(EndergyConduits.CRYSTALLINE_ENERGY, "Conducto de Energía Cristalina");
            addConduit(EndergyConduits.MELODIC_ENERGY,     "Conducto de Energía Melódica");
            addConduit(EndergyConduits.STELLAR_ENERGY,     "Conducto de Energía Estelar");
        }

        private void addTooltips() {
            add("tooltip.enderio_endergy.transfer_rate", "Tasa de Transferencia: %s");
            add("conduit.enderio_endergy.crude_energy.description",       "Un conducto básico de energía hecho con acero tosco.");
            add("conduit.enderio_endergy.copper_energy.description",      "Un conducto de energía de cobre con mayor rendimiento.");
            add("conduit.enderio_endergy.iron_energy.description",        "Un conducto de energía de hierro con buen rendimiento.");
            add("conduit.enderio_endergy.gold_energy.description",        "Un conducto de energía de oro para transferencias rápidas.");
            add("conduit.enderio_endergy.crystalline_energy.description", "Un conducto de aleación cristalina para transferencias avanzadas.");
            add("conduit.enderio_endergy.melodic_energy.description",     "Un conducto de aleación melódica para transferencias masivas.");
            add("conduit.enderio_endergy.stellar_energy.description",     "Un conducto de aleación estelar capaz de transferencias extremas.");
        }

        private void addItems() {
            add(EndergyItems.CRUDE_STEEL_INGOT.get(),        "Lingote de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get(),  "Lingote de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_INGOT.get(),      "Lingote de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_INGOT.get(),      "Lingote de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_INGOT.get(),        "Lingote de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_NUGGET.get(),       "Pepita de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get(), "Pepita de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_NUGGET.get(),     "Pepita de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_NUGGET.get(),     "Pepita de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_NUGGET.get(),       "Pepita de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_BALL.get(),         "Bola de Molienda de Acero Tosco");
            add(EndergyItems.CRYSTALLINE_ALLOY_BALL.get(),   "Bola de Molienda de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_BALL.get(),         "Bola de Molienda de Aleación Vívida");

            add(EndergyItems.GRAINY_CAPACITOR.get(),         "Capacitor Granuloso");
            add(EndergyItems.VIVID_CAPACITOR.get(),          "Capacitor Vívido");
            add(EndergyItems.CRYSTALLINE_CAPACITOR.get(),    "Capacitor Cristalino");
            add(EndergyItems.MELODIC_CAPACITOR.get(),        "Capacitor Melódico");
            add(EndergyItems.STELLAR_CAPACITOR.get(),        "Capacitor Estelar");
            add(EndergyItems.TOTEMIC_CAPACITOR.get(),        "Capacitor Totémico");
        }

        private void addBlocks() {
            add(EndergyBlocks.CRUDE_STEEL_BLOCK.get(),       "Bloque de Acero Tosco");
            add(EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get(), "Bloque de Aleación Cristalina");
            add(EndergyBlocks.MELODIC_ALLOY_BLOCK.get(),     "Bloque de Aleación Melódica");
            add(EndergyBlocks.STELLAR_ALLOY_BLOCK.get(),     "Bloque de Aleación Estelar");
            add(EndergyBlocks.VIVID_ALLOY_BLOCK.get(),       "Bloque de Aleación Vívida");
        }

        private void addCommonLang() {
            add(EndergyCommonComponents.CREATIVE_TAB_TITLE, "Enderio Endergy");
            add(EndergyCommonComponents.TOTEMIC_CAPACITOR_TOOLTIP, "Se puede encantar con Eficiencia para aumentar el modificador.");
        }

        private void addConduit(ResourceKey<ConduitType<?>> key, String translation) {
            add("conduit." + key.location().getNamespace() + "." + key.location().getPath(), translation);
        }

        private void add(Component component, String translation) {
            if (component.getContents() instanceof TranslatableContents tc) {
                add(tc.getKey(), translation);
            } else {
                throw new IllegalArgumentException("Component " + component + " is not translatable");
            }
        }
    }

    // -------------------------------------------------------------------------
    // Español México
    // -------------------------------------------------------------------------
    public static class EsMx extends LanguageProvider {
        public EsMx(PackOutput output) {
            super(output, EnderIOEndergy.MOD_ID, "es_mx");
        }

        @Override
        protected void addTranslations() {
            addConduitDescriptions();
            addItems();
            addBlocks();
            addCommonLang();
            addTooltips();
        }

        private void addConduitDescriptions() {
            add("item.enderio_endergy.crude_energy",       "Conducto de Energía Cruda");
            add("item.enderio_endergy.copper_energy",      "Conducto de Energía de Cobre");
            add("item.enderio_endergy.iron_energy",        "Conducto de Energía de Hierro");
            add("item.enderio_endergy.gold_energy",        "Conducto de Energía de Oro");
            add("item.enderio_endergy.crystalline_energy", "Conducto de Energía Cristalina");
            add("item.enderio_endergy.melodic_energy",     "Conducto de Energía Melódica");
            add("item.enderio_endergy.stellar_energy",     "Conducto de Energía Estelar");

            addConduit(EndergyConduits.CRUDE_ENERGY,       "Conducto de Energía Cruda");
            addConduit(EndergyConduits.COPPER_ENERGY,      "Conducto de Energía de Cobre");
            addConduit(EndergyConduits.IRON_ENERGY,        "Conducto de Energía de Hierro");
            addConduit(EndergyConduits.GOLD_ENERGY,        "Conducto de Energía de Oro");
            addConduit(EndergyConduits.CRYSTALLINE_ENERGY, "Conducto de Energía Cristalina");
            addConduit(EndergyConduits.MELODIC_ENERGY,     "Conducto de Energía Melódica");
            addConduit(EndergyConduits.STELLAR_ENERGY,     "Conducto de Energía Estelar");
        }

        private void addTooltips() {
            add("tooltip.enderio_endergy.transfer_rate", "Tasa de Transferencia: %s");
            add("conduit.enderio_endergy.crude_energy.description",       "Un conducto básico de energía fabricado con acero crudo.");
            add("conduit.enderio_endergy.copper_energy.description",      "Un conducto de energía de cobre con mayor rendimiento.");
            add("conduit.enderio_endergy.iron_energy.description",        "Un conducto de energía de hierro con buen rendimiento.");
            add("conduit.enderio_endergy.gold_energy.description",        "Un conducto de energía de oro para transferencias rápidas.");
            add("conduit.enderio_endergy.crystalline_energy.description", "Un conducto de aleación cristalina para transferencias avanzadas.");
            add("conduit.enderio_endergy.melodic_energy.description",     "Un conducto de aleación melódica para transferencias masivas.");
            add("conduit.enderio_endergy.stellar_energy.description",     "Un conducto de aleación estelar capaz de transferencias extremas.");
        }

        private void addItems() {
            add(EndergyItems.CRUDE_STEEL_INGOT.get(),        "Lingote de Acero Crudo");
            add(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get(),  "Lingote de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_INGOT.get(),      "Lingote de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_INGOT.get(),      "Lingote de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_INGOT.get(),        "Lingote de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_NUGGET.get(),       "Pepita de Acero Crudo");
            add(EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get(), "Pepita de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_NUGGET.get(),     "Pepita de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_NUGGET.get(),     "Pepita de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_NUGGET.get(),       "Pepita de Aleación Vívida");

            add(EndergyItems.CRUDE_STEEL_BALL.get(),         "Bola de Molienda de Acero Crudo");
            add(EndergyItems.CRYSTALLINE_ALLOY_BALL.get(),   "Bola de Molienda de Aleación Cristalina");
            add(EndergyItems.MELODIC_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Melódica");
            add(EndergyItems.STELLAR_ALLOY_BALL.get(),       "Bola de Molienda de Aleación Estelar");
            add(EndergyItems.VIVID_ALLOY_BALL.get(),         "Bola de Molienda de Aleación Vívida");

            add(EndergyItems.GRAINY_CAPACITOR.get(),         "Capacitor Granuloso");
            add(EndergyItems.VIVID_CAPACITOR.get(),          "Capacitor Vívido");
            add(EndergyItems.CRYSTALLINE_CAPACITOR.get(),    "Capacitor Cristalino");
            add(EndergyItems.MELODIC_CAPACITOR.get(),        "Capacitor Melódico");
            add(EndergyItems.STELLAR_CAPACITOR.get(),        "Capacitor Estelar");
            add(EndergyItems.TOTEMIC_CAPACITOR.get(),        "Capacitor Totémico");
        }

        private void addBlocks() {
            add(EndergyBlocks.CRUDE_STEEL_BLOCK.get(),       "Bloque de Acero Crudo");
            add(EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get(), "Bloque de Aleación Cristalina");
            add(EndergyBlocks.MELODIC_ALLOY_BLOCK.get(),     "Bloque de Aleación Melódica");
            add(EndergyBlocks.STELLAR_ALLOY_BLOCK.get(),     "Bloque de Aleación Estelar");
            add(EndergyBlocks.VIVID_ALLOY_BLOCK.get(),       "Bloque de Aleación Vívida");
        }

        private void addCommonLang() {
            add(EndergyCommonComponents.CREATIVE_TAB_TITLE, "Enderio Endergy");
            add(EndergyCommonComponents.TOTEMIC_CAPACITOR_TOOLTIP, "Se puede encantar con Eficiencia para aumentar el modificador.");
        }

        private void addConduit(ResourceKey<ConduitType<?>> key, String translation) {
            add("conduit." + key.location().getNamespace() + "." + key.location().getPath(), translation);
        }

        private void add(Component component, String translation) {
            if (component.getContents() instanceof TranslatableContents tc) {
                add(tc.getKey(), translation);
            } else {
                throw new IllegalArgumentException("Component " + component + " is not translatable");
            }
        }
    }
}