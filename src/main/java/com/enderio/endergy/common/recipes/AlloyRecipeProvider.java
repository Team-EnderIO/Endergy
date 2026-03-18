package com.enderio.endergy.common.recipes;

import com.enderio.base.common.tag.EIOTags;
import com.enderio.core.common.recipes.CountedIngredient;
import com.enderio.core.data.recipes.EnderRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyItems;
import com.enderio.machines.common.init.MachineRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class AlloyRecipeProvider extends EnderRecipeProvider {

    public AlloyRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        build(new ItemStack(EndergyItems.CRUDE_STEEL_INGOT.get()),
            List.of(
                CountedIngredient.of(1, Tags.Items.GRAVEL),
                CountedIngredient.of(1, Items.CLAY_BALL),
                CountedIngredient.of(1, Tags.Items.COBBLESTONE)
            ), 5000, 0.3f, consumer);

        build(new ItemStack(EndergyItems.CRYSTALLINE_ALLOY_INGOT.get()),
            List.of(
                CountedIngredient.of(1, EIOTags.Items.DUSTS_GRAINS_OF_INFINITY),
                CountedIngredient.of(1, Tags.Items.INGOTS_GOLD)
            ), 10000, 0.3f, consumer);

        build(new ItemStack(EndergyItems.MELODIC_ALLOY_INGOT.get()),
            List.of(
                CountedIngredient.of(1, Items.POPPED_CHORUS_FRUIT),
                CountedIngredient.of(1, EIOTags.Items.INGOTS_END_STEEL)
            ), 20000, 0.3f, consumer);

        build(new ItemStack(EndergyItems.STELLAR_ALLOY_INGOT.get(), 2),
            List.of(
                CountedIngredient.of(1, Items.NETHER_STAR),
                CountedIngredient.of(1, EndergyItems.MELODIC_ALLOY_INGOT.get()),
                CountedIngredient.of(4, Items.CLAY_BALL)
            ), 20000, 0.3f, consumer);
    }

    protected void build(ItemStack output, List<CountedIngredient> inputs, int energy,
            float experience, Consumer<FinishedRecipe> consumer) {
        ResourceLocation id = EnderIOEndergy.rl(
            "alloy_smelting/" + ForgeRegistries.ITEMS.getKey(output.getItem()).getPath());
        consumer.accept(new FinishedAlloySmeltingRecipe(id, inputs, output, energy, experience));
    }

    protected static class FinishedAlloySmeltingRecipe implements FinishedRecipe {

        private final ResourceLocation id;
        private final List<CountedIngredient> inputs;
        private final ItemStack output;
        private final int energy;
        private final float experience;

        public FinishedAlloySmeltingRecipe(ResourceLocation id, List<CountedIngredient> inputs,
                ItemStack output, int energy, float experience) {
            this.id = id;
            this.inputs = inputs;
            this.output = output;
            this.energy = energy;
            this.experience = experience;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray inputsArray = new JsonArray();
            for (CountedIngredient input : inputs) {
                inputsArray.add(input.toJson());
            }
            json.add("inputs", inputsArray);

            JsonObject result = new JsonObject();
            result.addProperty("item", ForgeRegistries.ITEMS.getKey(output.getItem()).toString());
            if (output.getCount() > 1) {
                result.addProperty("count", output.getCount());
            }
            json.add("result", result);

            json.addProperty("energy", energy);
            json.addProperty("experience", experience);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return MachineRecipes.ALLOY_SMELTING.serializer().get();
        }

        @Override
        @Nullable
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        @Nullable
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}