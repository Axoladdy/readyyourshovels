package teamhollow.readyyourshovels.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import teamhollow.readyyourshovels.Client.Render.GardenAntRenderer;
import teamhollow.readyyourshovels.ReadyYourShovels;
import teamhollow.readyyourshovels.registry.RYSEntities;

@Mod.EventBusSubscriber(modid = ReadyYourShovels.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT )
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(RYSEntities.GARDEN_ANT.get(), GardenAntRenderer::new);
    }
}
