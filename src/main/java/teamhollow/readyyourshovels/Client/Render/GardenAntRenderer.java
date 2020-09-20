package teamhollow.readyyourshovels.Client.Render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import teamhollow.readyyourshovels.Client.Model.GardenAntModel;
import teamhollow.readyyourshovels.Objects.Entities.GardenAntEntity;
import teamhollow.readyyourshovels.ReadyYourShovels;

public class GardenAntRenderer extends MobRenderer<GardenAntEntity, GardenAntModel<GardenAntEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(ReadyYourShovels.MODID,"textures/entity/garden_ant.png");

    public GardenAntRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new GardenAntModel<>(), 0.25F);
    }

    @Override
    public ResourceLocation getEntityTexture(GardenAntEntity entity) {
        return TEXTURE;
    }
}
