package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.MathHelper;

public class ModelNewWolf extends ModelWolf {
    public final ModelRenderer puppyHead;
    public final ModelRenderer puppyBody;
    public final ModelRenderer puppyRuff;
    public final ModelRenderer puppyLeg1;
    public final ModelRenderer puppyLeg2;
    public final ModelRenderer puppyLeg3;
    public final ModelRenderer puppyLeg4;
    public final ModelRenderer puppyTail;

    public ModelNewWolf() {
        puppyHead = new ModelRenderer(this, 0, 0);
        puppyHead.addBox(-2.5F, -2F, -4F, 5, 4, 4, 0.0F);
        puppyHead.setRotationPoint(0.0F, 17F, -4F);
        puppyBody = new ModelRenderer(this, 8, 8);
        puppyBody.addBox(-2.5F, -4F, -2F, 5, 8, 4, 0.0F);
        puppyBody.setRotationPoint(0.0F, 17F, 0.0F);
        puppyRuff = new ModelRenderer(this, 26, 0);
        puppyRuff.addBox(-3.5F, -5F, -3F, 7, 4, 6, -0.5F);
        puppyRuff.setRotationPoint(0.0F, 17F, 0.0F);
        puppyLeg1 = new ModelRenderer(this, 0, 8);
        puppyLeg1.addBox(-1F, 0.0F, -1F, 2, 5, 2, 0.0F);
        puppyLeg1.setRotationPoint(-1.5F, 19F, 3F);
        puppyLeg2 = new ModelRenderer(this, 0, 8);
        puppyLeg2.addBox(-1F, 0.0F, -1F, 2, 5, 2, 0.0F);
        puppyLeg2.setRotationPoint(1.5F, 19F, 3F);
        puppyLeg3 = new ModelRenderer(this, 0, 8);
        puppyLeg3.addBox(-1F, 0.0F, -1F, 2, 5, 2, 0.0F);
        puppyLeg3.setRotationPoint(-1.5F, 19F, -3F);
        puppyLeg4 = new ModelRenderer(this, 0, 8);
        puppyLeg4.addBox(-1F, 0.0F, -1F, 2, 5, 2, 0.0F);
        puppyLeg4.setRotationPoint(1.5F, 19F, -3F);
        puppyTail = new ModelRenderer(this, 26, 10);
        puppyTail.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
        puppyTail.setRotationPoint(0.0F, 15.5F, 4F);
        puppyHead.setTextureOffset(14, 0).addBox(-2.5F, -4F, -2F, 2, 2, 1, 0.0F);
        puppyHead.setTextureOffset(14, 0).addBox(0.5F, -4F, -2F, 2, 2, 1, 0.0F);
        puppyHead.setTextureOffset(18, 3).addBox(-1.5F, 0.0F, -5F, 3, 2, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (isChild) {
            setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

            puppyHead.renderWithRotation(par7);
            puppyBody.render(par7);
            puppyLeg1.render(par7);
            puppyLeg2.render(par7);
            puppyLeg3.render(par7);
            puppyLeg4.render(par7);
            puppyTail.renderWithRotation(par7);
            puppyRuff.render(par7);
        } else {
            super.render(entity, par2, par3, par4, par5, par6, par7);
        }
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entityLivingBase, float par2, float par3, float par4) {
        EntityWolf entityWolf = (EntityWolf) entityLivingBase;

        if (entityWolf.isAngry()) {
            wolfTail.rotateAngleY = puppyTail.rotateAngleY = 0.0F;
        } else {
            wolfTail.rotateAngleY = puppyTail.rotateAngleY = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        }

        if (entityWolf.isSitting()) {
            wolfMane.setRotationPoint(-1.0F, 16.0F, -3.0F);
            puppyRuff.setRotationPoint(0.0F, 18.5F, -0F);
            wolfMane.rotateAngleX = ((float) Math.PI * 2F / 5F);
            wolfMane.rotateAngleY = 0.0F;
            wolfBody.setRotationPoint(0.0F, 18.0F, 0.0F);
            puppyBody.setRotationPoint(0.0F, 20F, 0.0F);
            wolfBody.rotateAngleX = puppyBody.rotateAngleX = ((float) Math.PI / 4F);
            wolfTail.setRotationPoint(-1.0F, 21.0F, 6.0F);
            puppyTail.setRotationPoint(0.0F, 22.0F, 3.0F);
            wolfLeg1.setRotationPoint(-2.5F, 22.0F, 2.0F);
            puppyLeg1.setRotationPoint(-1.5F, 22F, 1.0F);
            wolfLeg1.rotateAngleX = puppyLeg1.rotateAngleX = ((float) Math.PI * 3F / 2F);
            wolfLeg2.setRotationPoint(0.5F, 22.0F, 2.0F);
            puppyLeg2.setRotationPoint(1.5F, 22F, 1.0F);
            wolfLeg2.rotateAngleX = puppyLeg2.rotateAngleX = ((float) Math.PI * 3F / 2F);
            wolfLeg3.rotateAngleX = puppyLeg3.rotateAngleX = 5.811947F;
            wolfLeg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
            puppyLeg3.setRotationPoint(-1.5F, 19F, -3F);
            wolfLeg4.rotateAngleX = puppyLeg4.rotateAngleX = 5.811947F;
            wolfLeg4.setRotationPoint(0.51F, 17.0F, -4.0F);
            puppyLeg4.setRotationPoint(1.51F, 19F, -3F);
        } else {
            wolfBody.setRotationPoint(0.0F, 14.0F, 2.0F);
            puppyBody.setRotationPoint(0.0F, 17F, 0.0F);
            wolfBody.rotateAngleX = puppyBody.rotateAngleX = ((float) Math.PI / 2F);
            wolfMane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            puppyRuff.setRotationPoint(0.0F, 17F, 0.0F);
            wolfMane.rotateAngleX = puppyRuff.rotateAngleX = wolfBody.rotateAngleX;
            wolfTail.setRotationPoint(-1.0F, 12.0F, 8.0F);
            wolfLeg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
            wolfLeg2.setRotationPoint(0.5F, 16.0F, 7.0F);
            wolfLeg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
            wolfLeg4.setRotationPoint(0.5F, 16.0F, -4.0F);
            puppyTail.setRotationPoint(0.0F, 15.5F, 4F);
            puppyLeg1.setRotationPoint(-1.5F, 19F, 3F);
            puppyLeg2.setRotationPoint(1.5F, 19F, 3F);
            puppyLeg3.setRotationPoint(-1.5F, 19F, -3F);
            puppyLeg4.setRotationPoint(1.5F, 19F, -3F);
            wolfLeg1.rotateAngleX = puppyLeg1.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
            wolfLeg2.rotateAngleX = puppyLeg2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;
            wolfLeg3.rotateAngleX = puppyLeg3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;
            wolfLeg4.rotateAngleX = puppyLeg4.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        }

        wolfHeadMain.rotateAngleZ = puppyHead.rotateAngleZ = entityWolf.getInterestedAngle(par4) + entityWolf.getShakeAngle(par4, 0.0F);
        wolfMane.rotateAngleZ = puppyRuff.rotateAngleZ = entityWolf.getShakeAngle(par4, -0.08F);
        wolfBody.rotateAngleZ = puppyBody.rotateAngleZ = entityWolf.getShakeAngle(par4, -0.16F);
        wolfTail.rotateAngleZ = puppyTail.rotateAngleZ = entityWolf.getShakeAngle(par4, -0.2F);
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        puppyHead.rotateAngleX = wolfHeadMain.rotateAngleX;
        puppyHead.rotateAngleY = wolfHeadMain.rotateAngleY;
        puppyTail.rotateAngleX = wolfTail.rotateAngleX;
    }
}
