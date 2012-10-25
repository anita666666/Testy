package Testy.Bloki;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityPrzykladowy extends TileEntity implements IInventory {
	
	private ItemStack[] inv;
	
	public TileEntityPrzykladowy()
	{
		inv = new ItemStack[72];
	}
	
	public void updateEntity()
	{
		//this.worldObj.setBlock(this.xCoord, this.yCoord,  this.zCoord+1, 1000);
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inv[var1];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                if (stack.stackSize <= amount) {
                        setInventorySlotContents(slot, null);
                } else {
                        stack = stack.splitStack(amount);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(slot, null);
                        }
                }
        }
        return stack;
	}

	@Override
    public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                    setInventorySlotContents(slot, null);
            }
            return stack;
    }

	@Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
            inv[slot] = stack;
            if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                    stack.stackSize = getInventoryStackLimit();
            }               
    }

	@Override
	public String getInvName() {
		return "Testora skrzynka";
	}

	@Override
    public int getInventoryStackLimit() {
            return 64;
    }

	@Override
    public boolean isUseableByPlayer(EntityPlayer player) {
            return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
            player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

	@Override
	public void openChest() 
	{
	}

	@Override
	public void closeChest()
	{
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList lista = new NBTTagList();
		for(int it = 0; it < this.inv.length; it++)
		{
			if (this.inv[it] != null)
            {
				NBTTagCompound przedmiot = new NBTTagCompound();
				przedmiot.setByte("Slot", (byte)it);
				this.inv[it].writeToNBT(przedmiot);
				lista.appendTag(przedmiot);
            }
		}
		
		par1NBTTagCompound.setTag("Items", lista);
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
        NBTTagList lista = par1NBTTagCompound.getTagList("Items");
        this.inv = new ItemStack[this.getSizeInventory()];

        for (int it = 0; it < lista.tagCount(); ++it)
        {
            NBTTagCompound przedmiot = (NBTTagCompound)lista.tagAt(it);
            int slot = przedmiot.getByte("Slot") & 255;

            if (slot >= 0 && slot < this.inv.length)
            {
                this.inv[slot] = ItemStack.loadItemStackFromNBT(przedmiot);
            }
        }
	}
}
