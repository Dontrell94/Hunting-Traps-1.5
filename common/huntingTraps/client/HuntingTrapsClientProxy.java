package huntingTraps.client;

import net.minecraftforge.client.MinecraftForgeClient;

public class HuntingTrapsClientProxy extends huntingTraps.common.HuntingtrapsCommonProxy
{
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/Hunting_Traps/ht_resources/huntingTraps/textures/hnttrp.png");
		// RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
		// registerBlockHandler
	}
}
