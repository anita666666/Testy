package Testy.common;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class CommonProxy {
	
	private Configuration config;
	
	public void registerRenderThings()
	{
		
	}
	
	public void loadConfig(File file)
	{
		config = new Configuration(file);
		config.load();
	}
	
	public void saveConfig()
	{
		config.save();
	}
	
	public Configuration getConfig()
	{
		return config;
	}
}
