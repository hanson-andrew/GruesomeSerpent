package net.gruesomeserpent;

import net.gruesomeserpent.MagicMissileEntity;
import net.gruesomeserpent.MagicMissileScroll;
import net.gruesomeserpent.RenderMagicMissileBolt;
import net.gruesomeserpent.Wand;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "GruesomeSerpentModID", name = "Generic", version = "0.0.0")
@NetworkMod(clientSideRequired = true)
public class GrueseomSerpent {

  // The instance of your mod that Forge uses.
  @Instance(value = "GruesomeSerpentModID")
  public static GrueseomSerpent instance;

  // Says where the client and server 'proxy' code is loaded.
  @SidedProxy(clientSide = "net.gruesomeserpent.ClientProxy", serverSide = "net.gruesomeserpent.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  // used in 1.6.2
  // @PreInit // used in 1.5.2
  public void preInit(FMLPreInitializationEvent event) {
    // Stub Method
  }

  @EventHandler
  // used in 1.6.2
  // @Init // used in 1.5.2
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();
    ResourceLocation r = new ResourceLocation("grueseomserpent", "textures/items/MagicMisileScroll.png");
    Wand.registerItem();
    MagicMissileScroll.registerItem();
    EntityRegistry.registerModEntity(MagicMissileEntity.class, "MagicMissile", 5002, this, 120, 3, true);
    RenderingRegistry.registerEntityRenderingHandler(MagicMissileEntity.class, new RenderMagicMissileBolt());
    MinecraftForge.EVENT_BUS.register(new AbilityTray(Minecraft.getMinecraft()));
  }

  @EventHandler
  // used in 1.6.2
  // @PostInit // used in 1.5.2
  public void postInit(FMLPostInitializationEvent event) {
    // Stub Method
  }

}
