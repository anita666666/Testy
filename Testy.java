package Testy;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import Testy.Bloki.Przykladowy;
import Testy.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name="Testy", modid="Ilddor_Testy", version="0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Testy {
	@Instance
	public static Testy instance;
	
	//Bloki
	public static Block blokPrzykladowy;
	
	 @SidedProxy(clientSide = "Testy.common.ClientProxy", serverSide = "Testy.common.CommonProxy")
	 public static CommonProxy proxy;
	
	private void zaladujDane(){
		//Ladowanie blokow
		GameRegistry.registerBlock(blokPrzykladowy);
		LanguageRegistry.addName(blokPrzykladowy, "Nasz bloczek");
		
		//Ladowanie receptur
		GameRegistry.addShapelessRecipe(new ItemStack(blokPrzykladowy), new Object[] {
			new ItemStack(Block.dirt)
		});
	}
	
	@Init
	public void init(FMLInitializationEvent evt) {
		blokPrzykladowy = new Przykladowy(1000, 0).setBlockName("Przykladowy").setHardness(1.f).setResistance(10.f).setStepSound(Block.soundWoodFootstep);
		zaladujDane();
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent evt) {
		proxy.registerRenderThings();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent evt) {
		
	}
}
