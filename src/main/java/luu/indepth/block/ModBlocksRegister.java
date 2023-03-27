package luu.indepth.block;

import luu.indepth.Indepth;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocksRegister {

	/** Block-Register without Item */
	public static Block registerBlock(String name, Block block) {
		return Registry.register(Registries.BLOCK, new Identifier(Indepth.MOD_ID, name), block);
	}

	/** Block-Register with Item */
	public static Block registerBlock(String name, Block block, ItemGroup group) {
		registerBlockItem(name, block, group);
		return Registry.register(Registries.BLOCK, new Identifier(Indepth.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block, ItemGroup group){
		Item item = Registry.register(Registries.ITEM, new Identifier(Indepth.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	/** BlockRegister with tooltip */
	public static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
		registerBlockItem(name, block, group, tooltipKey);
		return Registry.register(Registries.BLOCK, new Identifier(Indepth.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey){
		Item item = Registry.register(Registries.ITEM, new Identifier(Indepth.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()) {
					@Override
					public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
						tooltip.add(Text.translatable(tooltipKey));
					}
				});
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	/** BlockRegister with tooltip Shift & Ctrl */
	public static Block registerBlock(String name, Block block, ItemGroup group, String tooltipShift, String tooltipCtrl) {
		registerBlockItem(name, block, group, tooltipShift, tooltipCtrl);
		return Registry.register(Registries.BLOCK, new Identifier(Indepth.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block, ItemGroup group, String tooltipShift, String tooltipCtrl) {
		Item item = Registry.register(Registries.ITEM, new Identifier(Indepth.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()) {
					@Override
					public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

						if (!Screen.hasShiftDown()) { tooltip.add(Text.translatable("tooltip_hold_shift"));

						} else { tooltip.add(Text.translatable(tooltipShift)); }

						if (!Screen.hasControlDown()) { tooltip.add(Text.translatable("tooltip_hold_ctrl"));

						} else { tooltip.add(Text.translatable(tooltipCtrl)); }
					}
				});
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}

	/** BlockRegister with tooltip Shift , Ctrl & Alt */
	public static Block registerBlock(String name, Block block, ItemGroup group, String tooltipShift, String tooltipCtrl, String tooltipAlt) {
		registerBlockItem(name, block, group, tooltipShift, tooltipCtrl, tooltipAlt);
		return Registry.register(Registries.BLOCK, new Identifier(Indepth.MOD_ID, name), block);
	}

	private static void registerBlockItem(String name, Block block, ItemGroup group, String tooltipShift, String tooltipCtrl, String tooltipAlt) {
		Item item = Registry.register(Registries.ITEM, new Identifier(Indepth.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()) {
					@Override
					public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

						if (!Screen.hasShiftDown()) { tooltip.add(Text.translatable("tooltip_hold_shift"));

						} else { tooltip.add(Text.translatable(tooltipShift)); }

						if (!Screen.hasControlDown()) { tooltip.add(Text.translatable("tooltip_hold_ctrl"));

						} else { tooltip.add(Text.translatable(tooltipCtrl)); }

						if (!Screen.hasControlDown()) { tooltip.add(Text.translatable("tooltip_hold_alt"));

						} else { tooltip.add(Text.translatable(tooltipAlt)); }
					}
				});
		ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
	}
}
