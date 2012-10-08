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
	
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		world.setBlockTileEntity(x, y, z, new TileEntityPrzykladowy());
	}
	
	public void breakBlock(World world, int x, int y, int z, int par5, int par6)
	{
		super.breakBlock(world, x, y, z, par5, par6);
		world.removeBlockTileEntity(x, y, z);
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
}
