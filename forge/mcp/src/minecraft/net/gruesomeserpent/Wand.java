package net.gruesomeserpent;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class Wand extends Item {

  public static final Wand instance = new Wand(5000);

  private Wand(int id) {
    super(id);
    setMaxStackSize(1);
    setCreativeTab(CreativeTabs.tabCombat);
    setUnlocalizedName("wand");
  }

  public static void registerItem() {
    GameRegistry.addRecipe(new ItemStack(Wand.instance), "x", "y", 'x', new ItemStack(Item.diamond), 'y', new ItemStack(Item.stick));
    LanguageRegistry.addName(Wand.instance, "Wand");
  }

  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
    if (entityPlayer.capabilities.isCreativeMode||entityPlayer.inventory.consumeInventoryItem(MagicMissileScroll.instance.itemID)) {
      world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
      if (!world.isRemote)
      {
        world.spawnEntityInWorld(new MagicMissileEntity(world, entityPlayer));
      }

    }
    return itemStack;
  }

}