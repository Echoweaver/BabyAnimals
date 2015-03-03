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
        super.setLivingAnimations(entityLivingBase, par2, par3, par4);

        EntityWolf entityWolf = (EntityWolf) entityLivingBase;
        puppyTail.rotateAngleY = wolfTail.rotateAngleY;

        if (entityWolf.isSitting()) {
            puppyRuff.setRotationPoint(0.0F, 18.5F, -0F);
            puppyRuff.rotateAngleX = wolfMane.rotateAngleX;
            puppyBody.setRotationPoint(0.0F, 20F, 0.0F);
            puppyBody.rotateAngleX = wolfBody.rotateAngleX;
            puppyTail.setRotationPoint(0.0F, 22.0F, 3.0F);
            puppyLeg1.setRotationPoint(-1.5F, 22F, 1.0F);
            puppyLeg1.rotateAngleX = wolfLeg1.rotateAngleX;
            puppyLeg2.setRotationPoint(1.5F, 22F, 1.0F);
            puppyLeg2.rotateAngleX = wolfLeg2.rotateAngleX;
            puppyLeg3.rotateAngleX = wolfLeg3.rotateAngleX;
            puppyLeg3.setRotationPoint(-1.5F, 19F, -3F);
            puppyLeg4.rotateAngleX = wolfLeg4.rotateAngleX;
            puppyLeg4.setRotationPoint(1.51F, 19F, -3F);
        } else {
            puppyBody.setRotationPoint(0.0F, 17F, 0.0F);
            puppyBody.rotateAngleX = wolfBody.rotateAngleX;
            puppyRuff.setRotationPoint(0.0F, 17F, 0.0F);
            puppyRuff.rotateAngleX = wolfMane.rotateAngleX;
            puppyTail.setRotationPoint(0.0F, 15.5F, 4F);
            puppyLeg1.setRotationPoint(-1.5F, 19F, 3F);
            puppyLeg2.setRotationPoint(1.5F, 19F, 3F);
            puppyLeg3.setRotationPoint(-1.5F, 19F, -3F);
            puppyLeg4.setRotationPoint(1.5F, 19F, -3F);
            puppyLeg1.rotateAngleX = wolfLeg1.rotateAngleX;
            puppyLeg2.rotateAngleX = wolfLeg2.rotateAngleX;
            puppyLeg3.rotateAngleX = wolfLeg3.rotateAngleX;
            puppyLeg4.rotateAngleX = wolfLeg4.rotateAngleX;
        }

        puppyHead.rotateAngleZ = wolfHeadMain.rotateAngleZ;
        puppyRuff.rotateAngleZ = wolfMane.rotateAngleZ;
        puppyBody.rotateAngleZ = wolfBody.rotateAngleZ;
        puppyTail.rotateAngleZ = wolfTail.rotateAngleZ;
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        puppyHead.rotateAngleX = wolfHeadMain.rotateAngleX;
        puppyHead.rotateAngleY = wolfHeadMain.rotateAngleY;
        puppyTail.rotateAngleX = wolfTail.rotateAngleX;
    }
}
