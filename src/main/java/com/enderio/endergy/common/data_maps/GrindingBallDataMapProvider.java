package com.enderio.endergy.datagen.common.data_maps;

import com.enderio.base.common.init.EIORecipes;
import com.enderio.base.data.recipe.GrindingBallRecipeProvider;
import com.enderio.endergy.common.EnderIOEndergy;
import com.enderio.endergy.common.init.EndergyItems;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class GrindingBallDataMapProvider extends GrindingBallRecipeProvider {

    public GrindingBallDataMapProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        build(EndergyItems.CRUDE_STEEL_BALL.get(),       1.2F,  1.25F, 0.85F, 24000,  consumer);
        build(EndergyItems.CRYSTALLINE_ALLOY_BALL.get(), 1.8F,  1.4F,  1.45F, 80000,  consumer);
        build(EndergyItems.MELODIC_ALLOY_BALL.get(),     2.00F, 1.45F, 1.55F, 80000,  consumer);
        build(EndergyItems.STELLAR_ALLOY_BALL.get(),     2.30F, 2.25F, 2.2F,  160000, consumer);
        build(EndergyItems.VIVID_ALLOY_BALL.get(),       1.75F, 1.35F, 1.35F, 80000,  consumer);
    }

    @Override
    protected void build(Item item, float grinding, float chance, float power, int durability,
            Consumer<FinishedRecipe> recipeConsumer) {
        recipeConsumer.accept(new EndergyFinishedGrindingBall(
            new ResourceLocation(EnderIOEndergy.MOD_ID,
                "grindingball/" + ForgeRegistries.ITEMS.getKey(item).getPath()),
            item, grinding, chance, power, durability
        ));
    }

    protected static class EndergyFinishedGrindingBall implements FinishedRecipe {

        private final ResourceLocation id;
        private final Item item;
        private final float grinding;
        private final float chance;
        private final float power;
        private final int durability;

        public EndergyFinishedGrindingBall(ResourceLocation id, Item item, float grinding, float chance, float power, int durability) {
            this.id = id;
            this.item = item;
            this.grinding = grinding;
            this.chance = chance;
            this.power = power;
            this.durability = durability;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("item", ForgeRegistries.ITEMS.getKey(item).toString());
            json.addProperty("grinding", grinding);
            json.addProperty("chance", chance);
            json.addProperty("power", power);
            json.addProperty("durability", durability);
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return EIORecipes.GRINDING_BALL.serializer().get();
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