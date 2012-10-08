package Testy.Itemy;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class PrzykladowyItem extends Item {

	public PrzykladowyItem(int id)
	{
		super(id);
		this.setIconIndex(24);
		
		maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
}
