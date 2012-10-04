package Testy.Bloki;

import java.util.Random;

import Testy.common.ClientProxy;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class Przykladowy extends Block {
	
	public Przykladowy(int id, int icona){
		super(id, icona, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getTextureFile()
	{
		return ClientProxy.getBlocksTexture();
	}
	
	public int getBlockTextureFromSide(int side)
	{
		return side;
	}
}
