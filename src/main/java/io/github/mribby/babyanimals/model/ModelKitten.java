package io.github.mribby.babyanimals.model;

import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;

import static org.lwjgl.opengl.GL11.*;

public class ModelKitten extends ModelOcelot {
    public final ModelRenderer kittenBackLeftLeg;
    public final ModelRenderer kittenBackRightLeg;
    public final ModelRenderer kittenFrontLeftLeg;
    public final ModelRenderer kittenFrontRightLeg;
    public final ModelRenderer kittenTail;
    public final ModelRenderer kittenTail2;
    public final ModelRenderer kittenHead;
    public final ModelRenderer kittenBody;

    public ModelKitten() {
        setTextureOffset("head.main", 0, 0);
        setTextureOffset("head.nose", 0, 17);
        setTextureOffset("head.ear1", 0, 8);
        setTextureOffset("head.ear2", 6, 8);
        kittenHead = new ModelRenderer(this, "head");
        kittenHead.addBox("main", -2.5F, -2.0F, -2.0F, 5, 4, 4);
        kittenHead.addBox("nose", -1.5F, 0.0F, -3.0F, 3, 2, 1);
        kittenHead.addBox("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2);
        kittenHead.addBox("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2);
        kittenHead.setRotationPoint(0.0F, 18.0F, -6.0F);
        kittenBody = new ModelRenderer(this, 18, 0);
        kittenBody.addBox(-2.0F, 3.0F, -6.0F, 4, 10, 4, 0.0F);
        kittenBody.setRotationPoint(0.0F, 15.0F, -7.0F);
        kittenTail = new ModelRenderer(this, 0, 13);
        kittenTail.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        kittenTail.rotateAngleX = 0.9F;
        kittenTail.setRotationPoint(0.0F, 18.0F, 5.25F);
        kittenTail2 = new ModelRenderer(this, 4, 13);
        kittenTail2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        kittenTail2.setRotationPoint(0.0F, 19.9F, 7.5F);
        kittenBackLeftLeg = new ModelRenderer(this, 8, 11);
        kittenBackLeftLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 4, 2, 0.0F);
        kittenBackLeftLeg.setRotationPoint(1.1F, 20.0F, 2.9F);
        kittenBackRightLeg = new ModelRenderer(this, 8, 11);
        kittenBackRightLeg.addBox(-1.0F, 0.0F, 1.0F, 2, 4, 2, 0.0F);
        kittenBackRightLeg.setRotationPoint(-1.1F, 20.0F, 2.9F);
        kittenFrontLeftLeg = new ModelRenderer(this, 34, 0);
        kittenFrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        kittenFrontLeftLeg.setRotationPoint(1.2F, 16.8F, -3.0F);
        kittenFrontRightLeg = new ModelRenderer(this, 34, 0);
        kittenFrontRightLeg.addBox(-1.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
        kittenFrontRightLeg.setRotationPoint(-1.2F, 16.8F, -3.0F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        glPushMatrix();
        glScalef(0.9F, 0.9F, 0.9F);
        glTranslatef(0.0F, 3.0F * scale, 0.0F);
        kittenBackRightLeg.render(scale);
        kittenHead.render(scale);
        kittenTail2.render(scale);
        kittenBackLeftLeg.render(scale);
        kittenTail.render(scale);
        kittenFrontLeftLeg.render(scale);
        kittenBody.render(scale);
        kittenFrontRightLeg.render(scale);
        glPopMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        kittenHead.rotateAngleX = ocelotHead.rotateAngleX;
        kittenHead.rotateAngleY = ocelotHead.rotateAngleY;
        if (field_78163_i != 3) {
            kittenBody.rotateAngleX = ocelotBody.rotateAngleX;
            kittenBackLeftLeg.rotateAngleX = ocelotBackLeftLeg.rotateAngleX;
            kittenBackRightLeg.rotateAngleX = ocelotBackRightLeg.rotateAngleX;
            kittenFrontLeftLeg.rotateAngleX = ocelotFrontLeftLeg.rotateAngleX;
            kittenFrontRightLeg.rotateAngleX = ocelotFrontRightLeg.rotateAngleX;
            kittenTail2.rotateAngleX = ocelotTail2.rotateAngleX;
        }
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float limbSwing, float limbSwingAmount, float partialTickTime) {
        super.setLivingAnimations(entityLivingBase, limbSwing, limbSwingAmount, partialTickTime);

        kittenBody.rotationPointY = 15.0F;
        kittenBody.rotationPointZ = -7.0F;
        kittenHead.rotationPointY = 18.0F;
        kittenHead.rotationPointZ = -6.0F;
        kittenTail.rotationPointY = 18.0F;
        kittenTail.rotationPointZ = 5.25F;
        kittenTail2.rotationPointY = 19.9F;
        kittenTail2.rotationPointZ = 7.5F;
        kittenFrontLeftLeg.rotationPointY = kittenFrontRightLeg.rotationPointY = 16.8F;
        kittenFrontLeftLeg.rotationPointZ = kittenFrontRightLeg.rotationPointZ = -3.0F;
        kittenBackLeftLeg.rotationPointY = kittenBackRightLeg.rotationPointY = 20.0F;
        kittenBackLeftLeg.rotationPointZ = kittenBackRightLeg.rotationPointZ = 2.9F;
        kittenTail.rotateAngleX = ocelotTail.rotateAngleX;

        EntityOcelot kittenEntity = (EntityOcelot) entityLivingBase;
        if (kittenEntity.isSneaking()) {
            kittenBody.rotationPointY += 0.5F;
            kittenHead.rotationPointY += 1.25F;
            kittenTail.rotationPointY += 0.5F;
            kittenTail2.rotationPointY = kittenTail.rotationPointY;
            kittenTail2.rotationPointZ += 0.75F;
            kittenTail.rotateAngleX = ocelotTail.rotateAngleX;
            kittenTail2.rotateAngleX = ocelotTail2.rotateAngleX;
        } else if (kittenEntity.isSprinting()) {
            kittenTail2.rotationPointY = kittenTail.rotationPointY;
            kittenTail2.rotationPointZ += 0.75F;
            kittenTail.rotateAngleX = ocelotTail.rotateAngleX;
            kittenTail2.rotateAngleX = ocelotTail2.rotateAngleX;
        } else if (kittenEntity.isSitting()) {
            kittenBody.rotateAngleX = ocelotBody.rotateAngleX;
            kittenBody.rotationPointY += -2.5F;
            kittenBody.rotationPointZ += 4.0F;
            kittenHead.rotationPointY += -2.0F;
            kittenHead.rotationPointZ += 0.5F;
            kittenTail.rotationPointY += 5.25F;
            kittenTail.rotationPointZ += -1.0F;
            kittenTail2.rotationPointY += 2.75F;
            kittenTail2.rotationPointZ += -0.75F;
            kittenTail.rotateAngleX = ocelotTail.rotateAngleX;
            kittenTail2.rotateAngleX = ocelotTail2.rotateAngleX;
            kittenFrontLeftLeg.rotateAngleX = kittenFrontRightLeg.rotateAngleX = ocelotFrontLeftLeg.rotateAngleX;
            kittenFrontLeftLeg.rotationPointY = kittenFrontRightLeg.rotationPointY = 16.8F + 2.0F;
            kittenFrontLeftLeg.rotationPointZ = kittenFrontRightLeg.rotationPointZ = -3.0F - 1.5F;
            kittenBackLeftLeg.rotateAngleX = kittenBackRightLeg.rotateAngleX = ocelotBackLeftLeg.rotateAngleX;
            kittenBackLeftLeg.rotationPointY = kittenBackRightLeg.rotationPointY = 20.0F + 1.0F;
            kittenBackLeftLeg.rotationPointZ = kittenBackRightLeg.rotationPointZ = 2.9F - 1.75F;
        }
    }
}
