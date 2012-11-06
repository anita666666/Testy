package Testy.Bloki;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.ModelBase;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import Testy.Cokolwiek;

public class PrzykladowyRenderer extends TileEntitySpecialRenderer
{
	private static Cokolwiek model;
	
	static
	{
		model = new Cokolwiek();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8)
	{
		this.bindTextureByName("/Testy/Tex/Cokolwiek.png");
		GL11.glPushMatrix();
		GL11.glTranslated(var2 + 0.5F, var4 - 0.5F, var6 + 0.5F);
		GL11.glRotatef(((TileEntityPrzykladowy)var1).angle, 0.F, 1.F, 0.F);
		//System.out.println("Cos tam sie dzieje");
		model.renderAll();
		GL11.glPopMatrix();
	}
}
