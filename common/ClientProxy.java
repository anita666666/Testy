package Testy.common;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	public static String blockTex = "/Testy/Tex/Blocks.png";
	public static String itemTex = "/Testy/Tex/Items.png";
	
	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture(blockTex);
		MinecraftForgeClient.preloadTexture(itemTex);
	}
	
	public static String getBlocksTexture()
	{
		return blockTex;
	}
	
	public static String getItemsTexture()
	{
		return itemTex;
	}
}
