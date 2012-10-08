package Testy.Bloki;

import net.minecraft.src.TileEntity;

public class TileEntityPrzykladowy extends TileEntity {
	
	public TileEntityPrzykladowy()
	{
		
	}
	
	public void updateEntity()
	{
		this.worldObj.setBlock(this.xCoord, this.yCoord,  this.zCoord+1, 1000);
	}
}
