package com.uraneptus.sullysmod.core.data.server;

import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.data.SMDatagenUtil;
import com.uraneptus.sullysmod.core.data.server.builder.GrindstonePolishingRecipeBuilder;
import com.uraneptus.sullysmod.core.registry.SMBlocks;
import com.uraneptus.sullysmod.core.registry.SMItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.ConditionalRecipe;

import static com.uraneptus.sullysmod.core.data.SMDatagenUtil.*;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SMRecipeProvider extends RecipeProvider {

    public SMRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        //Cooking, Smelting etc.
        cookingRecipes(SMItems.RAW_LANTERNFISH, SMItems.COOKED_LANTERNFISH, 0.35F, consumer);

        basicSmeltingRecipes(SMBlocks.ROUGH_JADE_BLOCK, SMBlocks.SMOOTHED_ROUGH_JADE, 1.0F, consumer);

        oreCookingRecipes(SMBlocks.JADE_ORE, SMItems.ROUGH_JADE, 0.7F, consumer);
        oreCookingRecipes(SMBlocks.DEEPSLATE_JADE_ORE, SMItems.ROUGH_JADE, 0.7F, consumer);

        //Crafting
        packableBlockRecipes(SMItems.ROUGH_JADE, SMBlocks.ROUGH_JADE_BLOCK, consumer);
        packableBlockRecipes(SMItems.POLISHED_JADE, SMBlocks.POLISHED_JADE_BLOCK, consumer);

        tilingBlockRecipes(SMBlocks.ROUGH_JADE_BLOCK, SMBlocks.ROUGH_JADE_BRICKS, consumer);
        tilingBlockRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_TILES, consumer);
        tilingBlockRecipes(SMBlocks.POLISHED_JADE_BLOCK, SMBlocks.POLISHED_JADE_BRICKS, consumer);
        tilingBlockRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_TILES, consumer);
        tilingBlockRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_SMALL_JADE_BRICKS, consumer);
        tilingBlockRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_JADE_SHINGLES, consumer);

        stairRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_BRICK_STAIRS, consumer);
        stairRecipes(SMBlocks.ROUGH_JADE_TILES, SMBlocks.ROUGH_JADE_TILE_STAIRS, consumer);
        stairRecipes(SMBlocks.SMOOTHED_ROUGH_JADE, SMBlocks.SMOOTHED_ROUGH_JADE_STAIRS, consumer);
        stairRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_BRICK_STAIRS, consumer);
        stairRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_JADE_TILE_STAIRS, consumer);
        stairRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_SMALL_JADE_BRICK_STAIRS, consumer);
        stairRecipes(SMBlocks.POLISHED_JADE_SHINGLES, SMBlocks.POLISHED_JADE_SHINGLE_STAIRS, consumer);

        slabRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_BRICK_SLAB, consumer);
        slabRecipes(SMBlocks.ROUGH_JADE_TILES, SMBlocks.ROUGH_JADE_TILE_SLAB, consumer);
        slabRecipes(SMBlocks.SMOOTHED_ROUGH_JADE, SMBlocks.SMOOTHED_ROUGH_JADE_SLAB, consumer);
        slabRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_BRICK_SLAB, consumer);
        slabRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_JADE_TILE_SLAB, consumer);
        slabRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_SMALL_JADE_BRICK_SLAB, consumer);
        slabRecipes(SMBlocks.POLISHED_JADE_SHINGLES, SMBlocks.POLISHED_JADE_SHINGLE_SLAB, consumer);

        verticalSlabRecipes(SMBlocks.ROUGH_JADE_BRICK_SLAB, SMBlocks.ROUGH_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.ROUGH_JADE_TILE_SLAB, SMBlocks.ROUGH_JADE_TILE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.SMOOTHED_ROUGH_JADE_SLAB, SMBlocks.SMOOTHED_ROUGH_JADE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_BRICK_SLAB, SMBlocks.POLISHED_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_TILE_SLAB, SMBlocks.POLISHED_JADE_TILE_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICK_SLAB, SMBlocks.SMALL_POLISHED_JADE_BRICK_VERTICAL_SLAB, consumer);
        verticalSlabRecipes(SMBlocks.POLISHED_JADE_SHINGLE_SLAB, SMBlocks.POLISHED_JADE_SHINGLE_VERTICAL_SLAB, consumer);

        pillarRecipes(SMBlocks.POLISHED_JADE_BLOCK, SMBlocks.POLISHED_JADE_PILLAR, consumer);

        chiseledRecipes(SMBlocks.POLISHED_JADE_BRICK_SLAB, SMBlocks.POLISHED_CHISELED_JADE, consumer);

        buttonRecipes(Blocks.CUT_COPPER, SMBlocks.COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.EXPOSED_CUT_COPPER, SMBlocks.EXPOSED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.WEATHERED_CUT_COPPER, SMBlocks.WEATHERED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.OXIDIZED_CUT_COPPER, SMBlocks.OXIDIZED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.WAXED_CUT_COPPER, SMBlocks.WAXED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.WAXED_EXPOSED_CUT_COPPER, SMBlocks.WAXED_EXPOSED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.WAXED_WEATHERED_CUT_COPPER, SMBlocks.WAXED_WEATHERED_COPPER_BUTTON, consumer);
        buttonRecipes(Blocks.WAXED_OXIDIZED_CUT_COPPER, SMBlocks.WAXED_OXIDIZED_COPPER_BUTTON, consumer);

        waxButtonRecipes(SMBlocks.COPPER_BUTTON, SMBlocks.WAXED_COPPER_BUTTON, consumer);
        waxButtonRecipes(SMBlocks.EXPOSED_COPPER_BUTTON, SMBlocks.WAXED_EXPOSED_COPPER_BUTTON, consumer);
        waxButtonRecipes(SMBlocks.WEATHERED_COPPER_BUTTON, SMBlocks.WAXED_WEATHERED_COPPER_BUTTON, consumer);
        waxButtonRecipes(SMBlocks.OXIDIZED_COPPER_BUTTON, SMBlocks.WAXED_OXIDIZED_COPPER_BUTTON, consumer);

        //Stonecutting
        stonecutterRecipes(SMBlocks.ROUGH_JADE_BLOCK, SMBlocks.ROUGH_JADE_BRICKS, 1, consumer);
        stonecutterRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_TILES, 1, consumer);
        stonecutterRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_BRICK_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.ROUGH_JADE_BRICKS, SMBlocks.ROUGH_JADE_BRICK_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.ROUGH_JADE_TILES, SMBlocks.ROUGH_JADE_TILE_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.ROUGH_JADE_TILES, SMBlocks.ROUGH_JADE_TILE_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.SMOOTHED_ROUGH_JADE, SMBlocks.SMOOTHED_ROUGH_JADE_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.SMOOTHED_ROUGH_JADE, SMBlocks.SMOOTHED_ROUGH_JADE_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BLOCK, SMBlocks.POLISHED_JADE_BRICKS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BLOCK, SMBlocks.POLISHED_JADE_PILLAR, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_TILES, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_BRICK_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_JADE_BRICK_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_BRICKS, SMBlocks.POLISHED_CHISELED_JADE, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_SMALL_JADE_BRICKS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_JADE_TILE_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_TILES, SMBlocks.POLISHED_JADE_TILE_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_JADE_SHINGLES, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_SMALL_JADE_BRICK_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_SMALL_JADE_BRICKS, SMBlocks.POLISHED_SMALL_JADE_BRICK_STAIRS, 1, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_SHINGLES, SMBlocks.POLISHED_JADE_SHINGLE_SLAB, 2, consumer);
        stonecutterRecipes(SMBlocks.POLISHED_JADE_SHINGLES, SMBlocks.POLISHED_JADE_SHINGLE_STAIRS, 1, consumer);

        //Grindstone Polishing
        grindstonePolishingRecipes(SMItems.ROUGH_JADE, SMItems.POLISHED_JADE, 1, 1, consumer);

        //Custom
        ShapedRecipeBuilder.shaped(SMBlocks.JADE_TOTEM.get()).define('#', SMBlocks.POLISHED_JADE_SHINGLES.get()).pattern("###").pattern("# #").pattern("###").unlockedBy(getHasName(SMBlocks.POLISHED_JADE_SHINGLES.get()), has(SMBlocks.POLISHED_JADE_SHINGLES.get())).save(consumer, craftingPath(getItemName(SMBlocks.JADE_TOTEM.get())));
        ShapedRecipeBuilder.shaped(SMBlocks.JADE_FLINGER_TOTEM.get()).define('#', SMBlocks.POLISHED_JADE_SHINGLES.get()).define('-', Items.TRIPWIRE_HOOK).pattern("###").pattern("#-#").pattern("###").unlockedBy(getHasName(Items.TRIPWIRE_HOOK), has(Items.TRIPWIRE_HOOK)).unlockedBy(getHasName(SMBlocks.POLISHED_JADE_SHINGLES.get()), has(SMBlocks.POLISHED_JADE_SHINGLES.get())).save(consumer, craftingPath(getItemName(SMBlocks.JADE_FLINGER_TOTEM.get())));

        SullysMod.LOGGER.info("RECIPE GENERATION COMPLETE");
    }

    private static void packableBlockRecipes(Supplier<? extends ItemLike> unpacked, Supplier<? extends ItemLike> packed, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(packed.get()).define('#', unpacked.get()).pattern("###").pattern("###").pattern("###")
                .unlockedBy(getHasName(unpacked.get()), has(unpacked.get())).save(consumer, craftingPath(getItemName(packed.get())));
        ShapelessRecipeBuilder.shapeless(unpacked.get(), 9).requires(packed.get())
                .unlockedBy(getHasName(packed.get()), has(packed.get())).save(consumer, craftingPath(getItemName(unpacked.get())));
    }

    private static void tilingBlockRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result.get(), 4).define('#', ingredient.get()).pattern("##").pattern("##")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void basicSmeltingRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, float experience, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        String ingredientName = getItemName(ingredient.get());
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, 200)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, smeltingPath(resultName + "_from_smelting" + "_" + ingredientName));
    }

    private static void oreCookingRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, float experience, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());
        String ingredientName = getItemName(ingredient.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, 200)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, smeltingPath(resultName + "_from_smelting" + "_" + ingredientName));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient.get()), result.get(), experience, 100)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, blastingPath(resultName + "_from_blasting" + "_" + ingredientName));
    }

    private static void cookingRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, float experience, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, 200)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                .save(consumer, smeltingPath(resultName));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient.get()), result.get(), experience, 600)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                .save(consumer, campfire_cookingPath(resultName + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient.get()), result.get(), experience, 100)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get()))
                .save(consumer, smokingPath(resultName + "_from_smoking"));
    }

    private static void stairRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result.get(), 4).define('#', ingredient.get()).pattern("#  ").pattern("## ").pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void slabRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result.get(), 6).define('#', ingredient.get()).pattern("###")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void pillarRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
      ShapedRecipeBuilder.shaped(result.get(), 2).define('#', ingredient.get()).pattern("#").pattern("#")
              .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void chiseledRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result.get(), 1).define('#', ingredient.get()).pattern("#").pattern("#")
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void buttonRecipes(ItemLike ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result.get()).requires(ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, craftingPath(getItemName(result.get())));
    }

    private static void waxButtonRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, Consumer<FinishedRecipe> consumer) {
        String resultName = getItemName(result.get());

        ShapelessRecipeBuilder.shapeless(result.get()).requires(ingredient.get()).requires(Items.HONEYCOMB)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, craftingPath(resultName + "_from_honeycomb"));
    }

    private static void stonecutterRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, int resultCount, Consumer<FinishedRecipe> consumer) {
        String prefix = getItemName(result.get()) + "_from_" + getItemName(ingredient.get());
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient.get()), result.get(), resultCount)
                .unlockedBy(getHasName(ingredient.get()), has(ingredient.get())).save(consumer, stonecuttingPath(prefix + "_stonecutting"));
    }

    private static void grindstonePolishingRecipes(Supplier<? extends ItemLike> ingredient, Supplier<? extends ItemLike> result, int resultCount, int experience, Consumer<FinishedRecipe> consumer) {
        GrindstonePolishingRecipeBuilder.grindstonePolishing(ingredient.get(), result.get(), resultCount, experience).save(consumer);
    }

    private static void verticalSlabRecipes(Supplier<? extends ItemLike> slab, Supplier<? extends ItemLike> verticalSlab, Consumer<FinishedRecipe> consumer) {
        ConditionalRecipe.builder()
                .addCondition(new QuarkFlagRecipeCondition(SMDatagenUtil.QUARK_FLAG, "vertical_slabs"))
                .addRecipe(consumer1 -> ShapedRecipeBuilder.shaped(verticalSlab.get(), 3).define('#', slab.get()).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(slab.get()), has(slab.get())).save(consumer1, SullysMod.modPrefix(getItemName(verticalSlab.get()))))
                .build(consumer, craftingPath(getItemName(verticalSlab.get())));

        ConditionalRecipe.builder()
                .addCondition(new QuarkFlagRecipeCondition(SMDatagenUtil.QUARK_FLAG, "vertical_slabs"))
                .addRecipe(consumer1 -> ShapelessRecipeBuilder.shapeless(slab.get()).requires(verticalSlab.get()).unlockedBy(getHasName(verticalSlab.get()), has(verticalSlab.get())).save(consumer1, SullysMod.modPrefix(getItemName(verticalSlab.get()) + "_revert")))
                .build(consumer, craftingPath(getItemName(verticalSlab.get()) + "_revert"));
    }
}
