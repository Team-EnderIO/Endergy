package com.enderio.endergy.common.recipes;

import com.enderio.base.common.tag.EIOTags;
import com.enderio.core.data.recipes.EnderRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyItems;
import com.enderio.machines.common.init.MachineRecipes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class SlicingRecipeProvider extends EnderRecipeProvider {

    public SlicingRecipeProvider(PackOutput output) {
    super(output);
}

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        build(EndergyItems.TOTEMIC_CAPACITOR.get(),
            List.of(
                Ingredient.of(EIOTags.Items.INGOTS_SOULARIUM),
                Ingredient.of(Items.TOTEM_OF_UNDYING),
                Ingredient.of(EIOTags.Items.INGOTS_SOULARIUM),
                Ingredient.of(EIOTags.Items.DUSTS_GRAINS_OF_INFINITY),
                Ingredient.of(EndergyItems.CRYSTALLINE_CAPACITOR.get()),
                Ingredient.of(EIOTags.Items.DUSTS_GRAINS_OF_INFINITY)
            ), 20000, consumer);
    }

    protected void build(Item output, List<Ingredient> inputs, int energy,
            Consumer<FinishedRecipe> consumer) {
        ResourceLocation id = EnderIOEndergy.rl(
            "slicing/" + ForgeRegistries.ITEMS.getKey(output).getPath());
        consumer.accept(new FinishedSlicingRecipe(id, new ItemStack(output), inputs, energy));
    }

    protected static class FinishedSlicingRecipe implements FinishedRecipe {

        private final ResourceLocation id;
        private final ItemStack output;
        private final List<Ingredient> inputs;
        private final int energy;

        public FinishedSlicingRecipe(ResourceLocation id, ItemStack output,
                List<Ingredient> inputs, int energy) {
            this.id = id;
            this.output = output;
            this.inputs = inputs;
            this.energy = energy;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonObject outputJson = new JsonObject();
            outputJson.addProperty("item", ForgeRegistries.ITEMS.getKey(output.getItem()).toString());
            if (output.getCount() > 1) {
                outputJson.addProperty("count", output.getCount());
            }
            json.add("output", outputJson);

            JsonArray inputsArray = new JsonArray();
            for (Ingredient input : inputs) {
                inputsArray.add(input.toJson());
            }
            json.add("inputs", inputsArray);

            json.addProperty("energy", energy);

            Set<String> modDeps = getModDependencies();
            List<ICondition> conditions = new ArrayList<>();
            for (String mod : modDeps) {
                if (!StringUtils.equalsAny(mod, "minecraft", "forge", "enderio", id.getNamespace())) {
                    conditions.add(new ModLoadedCondition(mod));
                }
            }
            if (!conditions.isEmpty()) {
                JsonArray jsonConditions = new JsonArray();
                for (ICondition condition : conditions) {
                    jsonConditions.add(CraftingHelper.serialize(condition));
                }
                json.add("conditions", jsonConditions);
            }
        }

        protected Set<String> getModDependencies() {
            return Set.of(ForgeRegistries.ITEMS.getKey(output.getItem()).getNamespace());
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return MachineRecipes.SLICING.serializer().get();
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}