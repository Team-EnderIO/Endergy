package com.enderio.endergy.common.recipes;

import com.enderio.base.common.init.EIOItems;
import com.enderio.base.common.tag.EIOTags;
import com.enderio.conduits.common.init.EIOConduitTypes;
import com.enderio.core.data.recipes.EnderRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.datapack_registries.ConduitsBootstrap;
import com.enderio.endergy.common.init.EndergyItems;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class ConduitRecipeProvider extends EnderRecipeProvider {

    public ConduitRecipeProvider(PackOutput output) {
        super(output);
    }

    private static Consumer<FinishedRecipe> noAdv(Consumer<FinishedRecipe> consumer) {
        return recipe -> consumer.accept(new FinishedRecipe() {
            @Override public void serializeRecipeData(JsonObject json) { recipe.serializeRecipeData(json); }
            @Override public ResourceLocation getId() { return recipe.getId(); }
            @Override public RecipeSerializer<?> getType() { return recipe.getType(); }
            @Override public JsonObject serializeAdvancement() { return null; }
            @Override public ResourceLocation getAdvancementId() { return null; }
        });
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        Consumer<FinishedRecipe> c = noAdv(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.CRUDE_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("III").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.CRUDE_STEEL_INGOT.get())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("crude_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.COPPER_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("IGI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('G', EIOTags.Items.DUSTS_GRAINS_OF_INFINITY)
            .define('I', Tags.Items.INGOTS_COPPER)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("copper_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.IRON_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("IGI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('G', EIOTags.Items.DUSTS_GRAINS_OF_INFINITY)
            .define('I', Tags.Items.INGOTS_IRON)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("iron_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.GOLD_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("IGI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('G', EIOTags.Items.DUSTS_GRAINS_OF_INFINITY)
            .define('I', Tags.Items.INGOTS_GOLD)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("gold_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.CRYSTALLINE_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("III").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.CRYSTALLINE_ALLOY_INGOT.get())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("crystalline_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.CRYSTALLINE_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("ICI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.CRYSTALLINE_ALLOY_INGOT.get())
            .define('C', EIOConduitTypes.ENERGY.get().getConduitItem())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("crystalline_energy_conduit_upgrade"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.MELODIC_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("III").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.MELODIC_ALLOY_INGOT.get())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("melodic_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.MELODIC_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("ICI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.MELODIC_ALLOY_INGOT.get())
            .define('C', ConduitsBootstrap.CRYSTALLINE_ENERGY.get().getConduitItem())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("melodic_energy_conduit_upgrade"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.STELLAR_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("III").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.STELLAR_ALLOY_INGOT.get())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("stellar_energy_conduit"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                ConduitsBootstrap.STELLAR_ENERGY.get().getConduitItem(), 8)
            .pattern("BBB").pattern("ICI").pattern("BBB")
            .define('B', EIOItems.CONDUIT_BINDER.get())
            .define('I', EndergyItems.STELLAR_ALLOY_INGOT.get())
            .define('C', ConduitsBootstrap.MELODIC_ENERGY.get().getConduitItem())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.CONDUIT_BINDER.get()))
            .save(c, EnderIOEndergy.rl("stellar_energy_conduit_upgrade"));
    }
}