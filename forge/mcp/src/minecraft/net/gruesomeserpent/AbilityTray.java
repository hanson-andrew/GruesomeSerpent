package net.gruesomeserpent;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class AbilityTray extends Gui {
	
	private Minecraft mc;	
	
	public AbilityTray(Minecraft mc)
	{
		this.mc = mc;
	}

	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void renderTray(RenderGameOverlayEvent event)
	{
		ScaledResolution scaledresolution = event.resolution;
        int screenWidth = scaledresolution.getScaledWidth();
        int screenHeight = scaledresolution.getScaledHeight();
        int textureTop = 0;
        int textureLeft = 0;
        int buttonWidth = 20;
        int buttonHeight = 20;
        int buttonCount = 3;
        int drawTop = screenHeight - (buttonHeight * buttonCount) - 2;
        int drawLeft = (screenWidth/2) - ((buttonWidth*10)/2) - 1 - (buttonWidth/2) - 2;
        this.mc.renderEngine.bindTexture(new ResourceLocation("gruesomeserpent:textures/gui/AbilityTray.png"));
        this.drawTexturedModalRect(drawLeft, drawTop, textureLeft, textureTop, buttonWidth+2, (buttonHeight * buttonCount)+2);
        
        int activeSlot = 3;
        
        this.drawTexturedModalRect(drawLeft-1, (drawTop-1) + ((activeSlot-1)*buttonHeight), textureLeft, 62, 23, 23);
        
        ItemStack is = new ItemStack(MagicMissileScroll.instance);
        Icon object = is.getIconIndex();
        ResourceLocation resourcelocation = this.mc.getTextureManager().getResourceLocation(is.getItemSpriteNumber());
        this.mc.getTextureManager().bindTexture(resourcelocation);
        
        this.drawTexturedModelRectFromIcon(drawLeft+2, drawTop+2, object, object.getIconWidth(), object.getIconHeight());
	}
	
}
