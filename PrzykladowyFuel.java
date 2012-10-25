package Testy;

import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class PrzykladowyFuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		// TODO Auto-generated method stub
		switch(fuel.itemID)
		{
			case 1000 : return 1000;
		}
		return 0;
	}

	
}
