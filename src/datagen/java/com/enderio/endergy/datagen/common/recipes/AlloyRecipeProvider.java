package com.enderio.endergy.datagen.common.recipes;

import com.enderio.core.data.recipe.SubRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyItems;
import com.enderio.enderio.content.machines.alloy.AlloySmeltingRecipe;
import com.enderio.enderio.foundation.tag.EIOTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.SizedIngredient;

import java.util.List;

public class AlloyRecipeProvider extends SubRecipeProvider {

    private HolderLookup.RegistryLookup<Item> items;

    protected SizedIngredient sizedFromTag(TagKey<Item> tag, int count) {
        return new SizedIngredient(Ingredient.of(this.items.getOrThrow(tag)), count);
    }

    @Override
    public void buildRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        this.items = provider.lookupOrThrow(Registries.ITEM);

        // TODO: Review all recipes and alloy compositions
        // TODO: Experience values need set properly, i just used a filler value off the
        // top of my head

        // region Metal Alloys

        build(new ItemStackTemplate(EndergyItems.CRUDE_STEEL_INGOT.get()),
                List.of(sizedFromTag(Tags.Items.GRAVELS, 1),
                    SizedIngredient.of(Items.CLAY_BALL, 1),
                        sizedFromTag(Tags.Items.COBBLESTONES_NORMAL, 1)),
                5000, 0.3f, recipeOutput);

        build(new ItemStackTemplate(EndergyItems.VIVID_ALLOY_INGOT.get()),
                List.of(sizedFromTag(EIOTags.Items.DUSTS_LAPIS, 1),
                        sizedFromTag(Tags.Items.INGOTS_GOLD, 1),
                        sizedFromTag(EIOTags.Items.DUSTS_GRAINS_OF_VIBRANCY, 1)),
                5000, 0.3f, recipeOutput);

        build(new ItemStackTemplate(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get()),
                List.of(sizedFromTag(EIOTags.Items.DUSTS_GRAINS_OF_PIZEALLITY, 1),
                        sizedFromTag(Tags.Items.INGOTS_GOLD, 1),
                        sizedFromTag(Tags.Items.GEMS_PRISMARINE, 1)),
                10000, 0.3f, recipeOutput);

        build(new ItemStackTemplate(EndergyItems.MELODIC_ALLOY_INGOT.get()),
                List.of(SizedIngredient.of(Items.POPPED_CHORUS_FRUIT, 1),
                        sizedFromTag(EIOTags.Items.INGOTS_END_STEEL, 1),
                        sizedFromTag(Tags.Items.GEMS_AMETHYST, 1)),
                20000, 0.3f, recipeOutput);

        build(new ItemStackTemplate(EndergyItems.STELLAR_ALLOY_INGOT.get(), 2),
                List.of(SizedIngredient.of(Items.NETHER_STAR, 1),
                    SizedIngredient.of(EndergyItems.MELODIC_ALLOY_INGOT, 1),
                        sizedFromTag(EIOTags.Items.DUSTS_GRAINS_OF_THE_END, 1)),
                20000, 0.3f, recipeOutput);
        // endregion
    }

    protected void build(ItemStackTemplate output, List<SizedIngredient> inputs, int energy, float experience,
            RecipeOutput recipeOutput) {
        build(EnderIOEndergy.id("alloy_smelting/" + output.item().getKey().identifier().getPath()), inputs,
                output, energy, experience, recipeOutput);
    }

    protected void build(ItemStackTemplate output, String suffix, List<SizedIngredient> inputs, int energy, float experience,
            RecipeOutput recipeOutput) {
        build(EnderIOEndergy
                .id("alloy_smelting/" + output.item().getKey().identifier().getPath() + "_" + suffix),
                inputs, output, energy, experience, recipeOutput);
    }

    protected void build(Identifier id, List<SizedIngredient> inputs, ItemStackTemplate output, int energy,
                         float experience, RecipeOutput recipeOutput) {
        recipeOutput.accept(ResourceKey.create(Registries.RECIPE, id), new AlloySmeltingRecipe(inputs, output, energy, experience), null);
    }

}
