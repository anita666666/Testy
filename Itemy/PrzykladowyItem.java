package Testy.Itemy;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;

public class PrzykladowyItem extends ItemFood {

	public PrzykladowyItem(int id)
	{
		super(id, 10, true);
		this.setIconIndex(24);
		
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
