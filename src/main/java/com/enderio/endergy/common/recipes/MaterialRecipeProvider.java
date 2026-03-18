package com.enderio.endergy.common.recipes;

import com.enderio.base.common.init.EIOItems;
import com.enderio.base.common.tag.EIOTags;
import com.enderio.core.data.recipes.EnderRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyBlocks;
import com.enderio.endergy.common.init.EndergyItems;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

public class MaterialRecipeProvider extends EnderRecipeProvider {

    public MaterialRecipeProvider(PackOutput output) {
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
        addAlloys(c);
        addCapacitors(c);
        addGrindingBalls(c);
    }

    private void addAlloys(Consumer<FinishedRecipe> consumer) {
        makeMaterialRecipes(consumer, EndergyItems.CRUDE_STEEL_INGOT.get(),
            EndergyItems.CRUDE_STEEL_NUGGET.get(), EndergyBlocks.CRUDE_STEEL_BLOCK.get());
        makeMaterialRecipes(consumer, EndergyItems.CRYSTALLINE_ALLOY_INGOT.get(),
            EndergyItems.CRYSTALLINE_ALLOY_NUGGET.get(), EndergyBlocks.CRYSTALLINE_ALLOY_BLOCK.get());
        makeMaterialRecipes(consumer, EndergyItems.MELODIC_ALLOY_INGOT.get(),
            EndergyItems.MELODIC_ALLOY_NUGGET.get(), EndergyBlocks.MELODIC_ALLOY_BLOCK.get());
        makeMaterialRecipes(consumer, EndergyItems.STELLAR_ALLOY_INGOT.get(),
            EndergyItems.STELLAR_ALLOY_NUGGET.get(), EndergyBlocks.STELLAR_ALLOY_BLOCK.get());
        makeMaterialRecipes(consumer, EndergyItems.VIVID_ALLOY_INGOT.get(),
            EndergyItems.VIVID_ALLOY_NUGGET.get(), EndergyBlocks.VIVID_ALLOY_BLOCK.get());
    }

    private void addCapacitors(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EndergyItems.GRAINY_CAPACITOR.get())
            .pattern("G").pattern("N").pattern("N")
            .define('G', EIOTags.Items.DUSTS_GRAINS_OF_INFINITY)
            .define('N', Tags.Items.NUGGETS_IRON)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EIOItems.GRAINS_OF_INFINITY.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EndergyItems.VIVID_CAPACITOR.get())
            .pattern(" I ").pattern("CGC").pattern(" I ")
            .define('I', EndergyItems.VIVID_ALLOY_INGOT.get())
            .define('C', EIOItems.DOUBLE_LAYER_CAPACITOR.get())
            .define('G', Items.GLOWSTONE)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EndergyItems.VIVID_ALLOY_INGOT.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EndergyItems.CRYSTALLINE_CAPACITOR.get())
            .pattern(" I ").pattern("CPC").pattern(" I ")
            .define('I', EndergyItems.CRYSTALLINE_ALLOY_INGOT.get())
            .define('C', Ingredient.of(EndergyItems.VIVID_CAPACITOR.get()))
            .define('P', Tags.Items.GEMS_PRISMARINE)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EndergyItems.MELODIC_CAPACITOR.get())
            .pattern(" I ").pattern("CEC").pattern(" I ")
            .define('I', EndergyItems.MELODIC_ALLOY_INGOT.get())
            .define('C', Ingredient.of(EndergyItems.CRYSTALLINE_CAPACITOR.get()))
            .define('E', EIOTags.Items.INGOTS_END_STEEL)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EndergyItems.MELODIC_ALLOY_INGOT.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, EndergyItems.STELLAR_CAPACITOR.get())
            .pattern(" I ").pattern("CSC").pattern(" I ")
            .define('I', EndergyItems.STELLAR_ALLOY_INGOT.get())
            .define('C', Ingredient.of(EndergyItems.MELODIC_CAPACITOR.get()))
            .define('S', Items.SHULKER_SHELL)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(EndergyItems.STELLAR_ALLOY_INGOT.get()))
            .save(consumer);
    }

    private void addGrindingBalls(Consumer<FinishedRecipe> consumer) {
        grindingBall(consumer, EndergyItems.CRUDE_STEEL_BALL.get(),       EndergyItems.CRUDE_STEEL_INGOT.get());
        grindingBall(consumer, EndergyItems.CRYSTALLINE_ALLOY_BALL.get(), EndergyItems.CRYSTALLINE_ALLOY_INGOT.get());
        grindingBall(consumer, EndergyItems.MELODIC_ALLOY_BALL.get(),     EndergyItems.MELODIC_ALLOY_INGOT.get());
        grindingBall(consumer, EndergyItems.STELLAR_ALLOY_BALL.get(),     EndergyItems.STELLAR_ALLOY_INGOT.get());
        grindingBall(consumer, EndergyItems.VIVID_ALLOY_BALL.get(),       EndergyItems.VIVID_ALLOY_INGOT.get());
    }

    private void makeMaterialRecipes(Consumer<FinishedRecipe> consumer, Item ingot, Item nugget, Block block) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9)
            .requires(block.asItem())
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(block.asItem()))
            .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
            .requires(ingot)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingot))
            .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
            .pattern("III").pattern("III").pattern("III")
            .define('I', ingot)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(block.asItem()))
            .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
            .pattern("NNN").pattern("NNN").pattern("NNN")
            .define('N', nugget)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingot))
            .save(consumer, EnderIOEndergy.rl(ForgeRegistries.ITEMS.getKey(nugget).getPath() + "_to_ingot"));
    }

    private void grindingBall(Consumer<FinishedRecipe> consumer, Item result, ItemLike input) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 24)
            .pattern(" I ").pattern("III").pattern(" I ")
            .define('I', input)
            .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(input))
            .save(consumer);
    }
}