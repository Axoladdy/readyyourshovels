package teamhollow.readyyourshovels.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teamhollow.readyyourshovels.Objects.Entities.GardenAntEntity;
import teamhollow.readyyourshovels.ReadyYourShovels;

public class RYSEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ReadyYourShovels.MODID);
    public static final RegistryObject<EntityType<GardenAntEntity>> GARDEN_ANT = ENTITY_TYPES.register("garden_ant",
            () -> EntityType.Builder.create(GardenAntEntity::new, EntityClassification.CREATURE)
            .size(0.5F, 0.5F)
            .build(new ResourceLocation(ReadyYourShovels.MODID,"garden_ant").toString()));

}
