package net.gruesomeserpent;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicMissileScroll extends Item {

	public static final MagicMissileScroll instance = new MagicMissileScroll(5001);
	
	private MagicMissileScroll(int id)
	{
		super(id);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabCombat);
		setUnlocalizedName("magicMissileScroll");
		this.setTextureName("gruesomeserpent:magicMissileScroll");
	}
	
	public static void registerItem()
	{
		LanguageRegistry.addName(MagicMissileScroll.instance, "Magic Missile");
	}
}
