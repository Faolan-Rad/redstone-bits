package com.shnupbups.redstonebits.datagen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import com.shnupbups.redstonebits.RedstoneBits;
import com.shnupbups.redstonebits.init.ModTags;

public class RBItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public RBItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries) {
		RedstoneBits.LOGGER.info("Generating item tags...");

		copy(ModTags.Blocks.UNWAXED_COPPER_BUTTONS, ModTags.Items.UNWAXED_COPPER_BUTTONS);
		copy(ModTags.Blocks.WAXED_COPPER_BUTTONS, ModTags.Items.WAXED_COPPER_BUTTONS);
		copy(ModTags.Blocks.COPPER_BUTTONS, ModTags.Items.COPPER_BUTTONS);

		copy(ModTags.Blocks.UNWAXED_COPPER_PRESSURE_PLATES, ModTags.Items.UNWAXED_COPPER_PRESSURE_PLATES);
		copy(ModTags.Blocks.WAXED_COPPER_PRESSURE_PLATES, ModTags.Items.WAXED_COPPER_PRESSURE_PLATES);
		copy(ModTags.Blocks.COPPER_PRESSURE_PLATES, ModTags.Items.COPPER_PRESSURE_PLATES);

		getOrCreateTagBuilder(ModTags.Items.BREAKER_TOOL_BLACKLIST);
		getOrCreateTagBuilder(ModTags.Items.PLACER_BLACKLIST);

		getOrCreateTagBuilder(ItemTags.BUTTONS).addTag(ModTags.Items.COPPER_BUTTONS);

		RedstoneBits.LOGGER.info("Finished generating item tags!");
	}
}
