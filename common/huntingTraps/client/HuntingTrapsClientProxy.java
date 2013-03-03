package huntingTraps.client;

import net.minecraftforge.client.MinecraftForgeClient;

public class HuntingTrapsClientProxy extends huntingTraps.common.HuntingtrapsCommonProxy
{
	@Override
	public void registerRendering()
	{
		MinecraftForgeClient.preloadTexture("/textures/hnttrp.png");
		// RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
		// registerBlockHandler
	}
}
