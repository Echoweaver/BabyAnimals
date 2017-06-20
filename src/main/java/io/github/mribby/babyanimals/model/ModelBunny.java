package io.github.mribby.babyanimals.model;

import cpw.mods.fml.common.Optional;
import ganymedes01.etfuturum.client.model.ModelRabbit;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBunny {
    @Optional.Method(modid = "etfuturum")
    public static ModelBase create() {
        return new ModelRabbit() {
            private final ModelRenderer bunnyLeftFoot;
            private final ModelRenderer bunnyRightFoot;
            private final ModelRenderer bunnyLeftThigh;
            private final ModelRenderer bunnyRightThigh;
            private final ModelRenderer bunnyBody;
            private final ModelRenderer bunnyLeftArm;
            private final ModelRenderer bunnyRightArm;
            private final ModelRenderer bunnyHead;
            private final ModelRenderer bunnyRightEar;
            private final ModelRenderer bunnyLeftEar;
            private final ModelRenderer bunnyTail;

            {
                textureWidth = 32;
                bunnyLeftFoot = new ModelRenderer(this, 0, 6);
                bunnyLeftFoot.addBox(-0.5F, 2.3F, -1.9F, 1, 1, 3, 0.0F);
                bunnyLeftFoot.setRotationPoint(1.5F, 20.7F, 0.4F);
                bunnyLeftFoot.mirror = true;
                setRotationOffset(bunnyLeftFoot, 0.0F, 0.0F, 0.0F);
                bunnyRightFoot = new ModelRenderer(this, 0, 10);
                bunnyRightFoot.addBox(-0.5F, 2.3F, -1.9F, 1, 1, 3, 0.0F);
                bunnyRightFoot.setRotationPoint(-1.5F, 20.7F, 0.4F);
                bunnyRightFoot.mirror = true;
                setRotationOffset(bunnyRightFoot, 0.0F, 0.0F, 0.0F);
                bunnyLeftThigh = new ModelRenderer(this, 6, 14);
                bunnyLeftThigh.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
                bunnyLeftThigh.setRotationPoint(1.5F, 20.7F, 0.4F);
                bunnyLeftThigh.mirror = true;
                setRotationOffset(bunnyLeftThigh, -0.34906584F, 0.0F, 0.0F);
                bunnyRightThigh = new ModelRenderer(this, 0, 14);
                bunnyRightThigh.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
                bunnyRightThigh.setRotationPoint(-1.5F, 20.7F, 0.4F);
                bunnyRightThigh.mirror = true;
                setRotationOffset(bunnyRightThigh, -0.34906584F, 0.0F, 0.0F);
                bunnyBody = new ModelRenderer(this, 8, 6);
                bunnyBody.addBox(-1.5F, -1.2F, -5.0F, 3, 3, 5, 0.0F);
                bunnyBody.setRotationPoint(0.0F, 21.4F, 2.0F);
                bunnyBody.mirror = true;
                setRotationOffset(bunnyBody, -0.34906584F, 0.0F, 0.0F);
                bunnyLeftArm = new ModelRenderer(this, 0, 2);
                bunnyLeftArm.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
                bunnyLeftArm.setRotationPoint(1.5F, 21.0F, -2.7F);
                bunnyLeftArm.mirror = true;
                setRotationOffset(bunnyLeftArm, -0.17453292F, 0.0F, 0.0F);
                bunnyRightArm = new ModelRenderer(this, 4, 2);
                bunnyRightArm.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
                bunnyRightArm.setRotationPoint(-1.5F, 21.0F, -2.7F);
                bunnyRightArm.mirror = true;
                setRotationOffset(bunnyRightArm, -0.17453292F, 0.0F, 0.0F);
                bunnyHead = new ModelRenderer(this, 12, 0);
                bunnyHead.addBox(-1.5F, -3.0F, -3.0F, 3, 3, 3, -0.1F);
                bunnyHead.setRotationPoint(0.0F, 20.5F, -2.5F);
                bunnyHead.mirror = true;
                setRotationOffset(bunnyHead, 0.0F, 0.0F, 0.0F);
                bunnyRightEar = new ModelRenderer(this, 24, 0);
                bunnyRightEar.addBox(-1.5F, -4.75F, -1.5F, 1, 3, 1, 0.0F);
                bunnyRightEar.setRotationPoint(0.0F, 20.5F, -2.5F);
                bunnyRightEar.mirror = true;
                setRotationOffset(bunnyRightEar, 0.0F, -0.2617994F, 0.0F);
                bunnyLeftEar = new ModelRenderer(this, 28, 0);
                bunnyLeftEar.addBox(0.5F, -4.75F, -1.5F, 1, 3, 1, 0.0F);
                bunnyLeftEar.setRotationPoint(0.0F, 20.5F, -2.5F);
                bunnyLeftEar.mirror = true;
                setRotationOffset(bunnyLeftEar, 0.0F, 0.2617994F, 0.0F);
                bunnyTail = new ModelRenderer(this, 24, 4);
                bunnyTail.addBox(-0.5F, -0.7F, 0.0F, 1, 1, 1, 0.2F);
                bunnyTail.setRotationPoint(0.0F, 22.0F, 1.5F);
                bunnyTail.mirror = true;
                setRotationOffset(bunnyTail, -0.3490659F, 0.0F, 0.0F);
            }

            @Override
            public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
                setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
                bunnyHead.render(scale);
                bunnyBody.render(scale);
                bunnyLeftThigh.render(scale);
                bunnyRightThigh.render(scale);
                bunnyRightArm.render(scale);
                bunnyLeftArm.render(scale);
                bunnyLeftFoot.render(scale);
                bunnyRightFoot.render(scale);
                bunnyTail.render(scale);
                bunnyRightEar.render(scale);
                bunnyLeftEar.render(scale);
            }

            @Override
            public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
                super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
                bunnyHead.rotateAngleX = rabbitHead.rotateAngleX;
                bunnyHead.rotateAngleY = rabbitHead.rotateAngleY;
                bunnyRightEar.rotateAngleX = rabbitRightEar.rotateAngleX;
                bunnyRightEar.rotateAngleY = rabbitRightEar.rotateAngleY;
                bunnyLeftEar.rotateAngleX = rabbitLeftEar.rotateAngleX;
                bunnyLeftEar.rotateAngleY = rabbitLeftEar.rotateAngleY;
                bunnyLeftThigh.rotateAngleX = rabbitLeftThigh.rotateAngleX;
                bunnyRightThigh.rotateAngleX = rabbitRightThigh.rotateAngleX;
                bunnyLeftFoot.rotateAngleX = rabbitLeftFoot.rotateAngleX;
                bunnyRightFoot.rotateAngleX = rabbitRightFoot.rotateAngleX;
                bunnyLeftArm.rotateAngleX = rabbitLeftArm.rotateAngleX;
                bunnyRightArm.rotateAngleX = rabbitRightArm.rotateAngleX;
            }

            private void setRotationOffset(ModelRenderer renderer, float x, float y, float z) {
                renderer.rotateAngleX = x;
                renderer.rotateAngleY = y;
                renderer.rotateAngleZ = z;
            }
        };
    }
}
