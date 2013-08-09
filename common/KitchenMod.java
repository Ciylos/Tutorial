package kitchenmod;


import java.io.File;

import kitchenmod.blocks.Blocks;
import kitchenmod.config.ConfigurationHander;
import kitchenmod.core.handler.GuiHandler;
import kitchenmod.core.handler.LocalizationHandler;
import kitchenmod.items.Items;
import kitchenmod.lib.References;
import kitchenmod.misc.CreativeTabKitchen;
import kitchenmod.misc.RecipeRemover;
import kitchenmod.proxy.ClientProxy;
import kitchenmod.recipe.Crafting;
import kitchenmod.tileentity.TileEntityStove;
import net.minecraft.creativetab.CreativeTabs;
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



 @Mod(modid = References.MOD_ID , name = References.MOD_NAME  ,version = References.VERSION )
 @NetworkMod(clientSideRequired = true, serverSideRequired = false)
 
 
public class KitchenMod{
     
  
	 @SidedProxy(clientSide = References.CLIENT_PROXY_LOCATION, serverSide = References.SERVER_PROXY_LOCATION)
	 public static ClientProxy proxy;
     
     //creative tab
     public static CreativeTabs KitchenMod = new CreativeTabKitchen(CreativeTabs.getNextID(),"Kitchen Mod");
     
     //gui
     @Instance(References.MOD_ID)
     public static KitchenMod instance = new KitchenMod();;
    
     @PreInit
     public void preInit(FMLPreInitializationEvent event) {
     
    	 
    	 
    	 
    	 //Classes
    	 RecipeRemover.remover();
    	 ConfigurationHander.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + References.CHANNEL_NAME + File.separator + References.MOD_ID + ".cfg"));
    	 LocalizationHandler.loadLanguages();
    	 Blocks.blocksInit();
    	 Items.itemsInit();
    	 Crafting.craft();
     }
    @Init
    public void init(FMLInitializationEvent event){
    	 proxy.registerRenders();
    	 NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
    	 GameRegistry.registerTileEntity(TileEntityStove.class, "containerStove");
    }
    
   @PostInit
   public void postInit(FMLPostInitializationEvent event){
       
   }
    

 }    

 
  
       
       

        


  

