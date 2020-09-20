package teamhollow.readyyourshovels.Objects.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GardenAntEntity extends CreatureEntity {

    private int lifetime;
    public GardenAntEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static Ingredient ANTSUGARCRAVING = Ingredient.fromItems(Items.SUGAR, Items.COOKIE, Items.CAKE, Items.HONEY_BLOCK, Items.HONEYCOMB, Items.HONEY_BOTTLE, Items.HONEY_BLOCK, Items.PUMPKIN_PIE, Items.SWEET_BERRIES);

    public static AttributeModifierMap.MutableAttribute GardenAntAttribute() {
            return MobEntity.registerAttributes()
                    .createMutableAttribute(Attributes.MAX_HEALTH,6.0D)
                    .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.20D)
                    .createMutableAttribute(Attributes.FOLLOW_RANGE, 7.0D);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1));
        this.goalSelector.addGoal(2, new TemptGoal(this,1.1D,ANTSUGARCRAVING,false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this,2.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, BeeEntity.class, 6));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.lifetime = compound.getInt("Lifetime");
    }

    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            for (int i = 0; i < 2; ++i) {
                ++this.lifetime;

                if (this.lifetime >= 4800) {
                    this.remove();
                }
            }
        }
    }

    protected int getExperiencePoints(PlayerEntity player){
        return 0;
    }

    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.BLOCK_GRASS_HIT;
    }

    @Override
    protected SoundEvent getDeathSound(){
        return SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn){
        return SoundEvents.ENTITY_ENDERMAN_TELEPORT;
    }
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn){
        super.playStepSound(pos, blockIn);

        this.playSound(SoundEvents.ENTITY_WOLF_AMBIENT, 0.15F, 1);
    }

}
