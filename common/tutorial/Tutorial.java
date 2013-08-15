package tutorial;

import tutorial.lib.References;
import tutorial.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;



@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class Tutorial {

	@SidedProxy(clientSide = References.CLIENT_PROXY_LOCATION, serverSide = References.COMMON_PROXY_LOCATION)
	public static CommonProxy proxy;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		
	}
	
	@Init
	public void init(FMLInitializationEvent event){
		
	}
	
	@PostInit
	public void postInit(FMLInitializationEvent event){
		
	}
	
	
}
