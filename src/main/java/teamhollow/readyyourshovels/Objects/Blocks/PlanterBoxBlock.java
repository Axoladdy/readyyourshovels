package teamhollow.readyyourshovels.Objects.Blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.tags.ITag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class PlanterBoxBlock extends FarmlandBlock {


    public static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }



    public PlanterBoxBlock(Properties properties){
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(MOISTURE, Integer.valueOf(7)));

    }

    public boolean isTransparent(BlockState state) {
        return true;
    }



    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        }

    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }
    public boolean isFertile(BlockState state, IBlockReader world, BlockPos pos)
    {
        return true;
    }


}
