package Testy;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.EnumHelper;
import Testy.Bloki.Przykladowy;
import Testy.Bloki.PrzykladowyRenderer;
import Testy.Bloki.TileEntityPrzykladowy;
import Testy.GUI.GuiHandler;
import Testy.Itemy.Miecz;
import Testy.Itemy.PrzykladowyItem;
import Testy.common.CommonProxy;
import cpw.mods.fml.client.registry.ClientRegistry;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(name="Testy", modid="Ilddor_Testy", version="0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Testy {
	@Instance
	public static Testy instance;
	
	//Bloki
	public static Block blokPrzykladowy;
	
	//Itemy
	public static Item itemPrzyklad;
	public static Item miecz;
	
	@SidedProxy(clientSide = "Testy.common.ClientProxy", serverSide = "Testy.common.CommonProxy")
	public static CommonProxy proxy;
	
	static EnumToolMaterial naszmaterial = EnumHelper.addToolMaterial("material", 3, 500, 10F, 10, 14);
	
	private void zaladujDane(){
		//Ladowanie blokow
		GameRegistry.registerBlock(blokPrzykladowy);
		LanguageRegistry.addName(blokPrzykladowy, "Nasz bloczek");
		
		//Ladowanie itemow
		LanguageRegistry.addName(itemPrzyklad, "Nasz Itemek");
		LanguageRegistry.addName(miecz, "Nasz mieczyk");
		
		//Ladowanie receptur
		GameRegistry.addShapelessRecipe(new ItemStack(blokPrzykladowy), new Object[] {
										new ItemStack(Block.dirt)
										});
		GameRegistry.addRecipe(new ItemStack(miecz), new Object[] {
								"M", "M", "P", 'M', itemPrzyklad, 'P', Item.stick
								});
		
		//Przetapianie
		GameRegistry.addSmelting(blokPrzykladowy.blockID, new ItemStack(Block.cactus), 2F);
		
		//Ladowanie tileEntities
		GameRegistry.registerTileEntity(TileEntityPrzykladowy.class, "Przykladowy");
		
		GameRegistry.registerFuelHandler(new PrzykladowyFuel());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPrzykladowy.class, new PrzykladowyRenderer());
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		//bloki
		blokPrzykladowy = new Przykladowy(proxy.getConfig().get(Configuration.CATEGORY_BLOCK, "PrzykladowyBlok", 1000).getInt(), 0).setBlockName("Przykladowy").setHardness(1.f).setResistance(10.f).setStepSound(Block.soundWoodFootstep);
		
		//itemy
		itemPrzyklad = new PrzykladowyItem(proxy.getConfig().get(Configuration.CATEGORY_ITEM,  "PrzykladowyItem", 1001).getInt()).setItemName("itemek");
		miecz = new Miecz(1002, naszmaterial).setIconIndex(67).setItemName("miecz");
		
		proxy.getConfig().get(Configuration.CATEGORY_BLOCK, "cos", 2000).comment = "Nasz komentarz";
		
		zaladujDane();
		
		DungeonHooks.addDungeonLoot(new ItemStack(blokPrzykladowy), 10, 2, 7);
		
		DungeonHooks.setDungeonLootTries(15);
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRenderThings();
		proxy.loadConfig(event.getSuggestedConfigurationFile());
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		proxy.saveConfig();
	}
}
