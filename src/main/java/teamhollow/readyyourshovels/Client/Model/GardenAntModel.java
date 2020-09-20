package teamhollow.readyyourshovels.Client.Model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import teamhollow.readyyourshovels.Objects.Entities.GardenAntEntity;

public class GardenAntModel<T extends GardenAntEntity> extends EntityModel<T> {

        private final ModelRenderer Thorax;
        private final ModelRenderer Head;
        private final ModelRenderer Antenna;
        private final ModelRenderer Rear;
        private final ModelRenderer left_mid_leg;
        private final ModelRenderer right_mid_leg;
        private final ModelRenderer left_fore_leg;
        private final ModelRenderer right_fore_leg;
        private final ModelRenderer left_hind_leg;
        private final ModelRenderer right_hind_leg;

        public GardenAntModel() {
            textureWidth = 32;
            textureHeight = 32;

            Thorax = new ModelRenderer(this);
            Thorax.setRotationPoint(0.0F, 24.0F, 0.0F);
            Thorax.setTextureOffset(0, 8).addBox(-1.5F, -4.0F, -1.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

            Head = new ModelRenderer(this);
            Head.setRotationPoint(0.0F, 19.0F, -2.0F);
            Head.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

            Antenna = new ModelRenderer(this);
            Antenna.setRotationPoint(0.0F, -2.0F, -1.0F);
            Head.addChild(Antenna);
            setRotationAngle(Antenna, 0.2618F, 0.0F, 0.0F);
            Antenna.setTextureOffset(16, 13).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

            Rear = new ModelRenderer(this);
            Rear.setRotationPoint(0.0F, 20.5F, 1.5F);
            setRotationAngle(Rear, -0.1745F, 0.0F, 0.0F);
            Rear.setTextureOffset(18, 0).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

            left_mid_leg = new ModelRenderer(this);
            left_mid_leg.setRotationPoint(1.0F, 21.5F, 0.5F);
            setRotationAngle(left_mid_leg, 0.0F, 0.0F, 0.6981F);
            left_mid_leg.setTextureOffset(20, 8).addBox(0.0F, -0.25F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

            right_mid_leg = new ModelRenderer(this);
            right_mid_leg.setRotationPoint(-1.0F, 21.5F, 0.5F);
            setRotationAngle(right_mid_leg, 0.0F, 0.0F, -0.6981F);
            right_mid_leg.setTextureOffset(20, 8).addBox(-4.0F, -0.25F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

            left_fore_leg = new ModelRenderer(this);
            left_fore_leg.setRotationPoint(0.8F, 21.5F, -0.5F);
            setRotationAngle(left_fore_leg, 0.0F, 0.4363F, 0.6981F);
            left_fore_leg.setTextureOffset(20, 8).addBox(0.0F, -0.25F, -0.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);

            right_fore_leg = new ModelRenderer(this);
            right_fore_leg.setRotationPoint(-0.8F, 21.5F, -0.5F);
            setRotationAngle(right_fore_leg, 0.0F, -0.4363F, -0.6981F);
            right_fore_leg.setTextureOffset(20, 8).addBox(-4.0F, -0.25F, -0.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);

            left_hind_leg = new ModelRenderer(this);
            left_hind_leg.setRotationPoint(0.8F, 21.5F, 1.5F);
            setRotationAngle(left_hind_leg, 0.0F, -0.3491F, 0.6981F);
            left_hind_leg.setTextureOffset(20, 8).addBox(0.0F, -0.25F, -0.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);

            right_hind_leg = new ModelRenderer(this);
            right_hind_leg.setRotationPoint(-0.8F, 21.5F, 1.5F);
            setRotationAngle(right_hind_leg, 0.0F, 0.3491F, -0.6981F);
            right_hind_leg.setTextureOffset(20, 8).addBox(-4.0F, -0.25F, -0.75F, 4.0F, 1.0F, 1.0F, 0.0F, false);
        }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        float f = ((float)Math.PI / 4F);
        this.right_fore_leg.rotateAngleZ = -0.6981F;
        this.left_fore_leg.rotateAngleZ = 0.6981F;
        this.right_mid_leg.rotateAngleZ = -0.58119464F;
        this.left_mid_leg.rotateAngleZ = 0.58119464F;
        this.right_hind_leg.rotateAngleZ = -0.6981F;
        this.left_hind_leg.rotateAngleZ = 0.6981F;

        this.right_fore_leg.rotateAngleY = -0.4363F;
        this.left_fore_leg.rotateAngleY = 0.4363F;
        this.right_mid_leg.rotateAngleY = 0.0F;
        this.left_mid_leg.rotateAngleY = 0.0F;
        this.right_hind_leg.rotateAngleY = 0.3491F;
        this.left_hind_leg.rotateAngleY = -0.3491F;
        float f3 = -(MathHelper.cos(limbSwing * 1.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 1.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 1.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 1.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = 2*(MathHelper.sin(limbSwing * 1.6662F * (1.0F)) * 0.4F) * limbSwingAmount;
        float f8 = 2*(MathHelper.sin(limbSwing * 1.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f9 = 2*(MathHelper.sin(limbSwing * 1.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f10 = 2*(MathHelper.sin(limbSwing * 1.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        this.right_fore_leg.rotateAngleY += f3;
        this.left_fore_leg.rotateAngleY += -f3;
        this.right_mid_leg.rotateAngleY += f4;
        this.left_mid_leg.rotateAngleY += -f5;
        this.right_hind_leg.rotateAngleY += f6;
        this.left_hind_leg.rotateAngleY += -f6;
        this.right_fore_leg.rotateAngleZ += f7;
        this.left_fore_leg.rotateAngleZ += f7;
        this.right_mid_leg.rotateAngleZ += -f8;
        this.left_mid_leg.rotateAngleZ += -f9;
        this.right_hind_leg.rotateAngleZ += f10;
        this.left_hind_leg.rotateAngleZ += f10;
    }


    @Override
        public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
            Thorax.render(matrixStack, buffer, packedLight, packedOverlay);
            Head.render(matrixStack, buffer, packedLight, packedOverlay);
            Rear.render(matrixStack, buffer, packedLight, packedOverlay);
            left_mid_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            right_mid_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            left_fore_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            right_fore_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            left_hind_leg.render(matrixStack, buffer, packedLight, packedOverlay);
            right_hind_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        }

        public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
            modelRenderer.rotateAngleX = x;
            modelRenderer.rotateAngleY = y;
            modelRenderer.rotateAngleZ = z;
        }
    }

