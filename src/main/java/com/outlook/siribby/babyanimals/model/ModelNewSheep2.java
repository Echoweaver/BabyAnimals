package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.entity.Entity;

public class ModelNewSheep2 extends ModelSheep2 {
    public final ModelRenderer lambHead;
    public final ModelRenderer lambBody;
    public final ModelRenderer lambLeg1;
    public final ModelRenderer lambLeg2;
    public final ModelRenderer lambLeg3;
    public final ModelRenderer lambLeg4;

    public ModelNewSheep2() {
        lambHead = new ModelRenderer(this, 0, 0);
        lambHead.addBox(-3F, -2.5F, -3F, 6, 5, 4, 0.0F);
        lambHead.setRotationPoint(0.0F, 13F, -4F);
        lambBody = new ModelRenderer(this, 15, 4);
        lambBody.addBox(-3F, -4.5F, -2.5F, 6, 9, 5, 0.0F);
        lambBody.setRotationPoint(0.0F, 15.5F, 0.0F);
        lambLeg1 = new ModelRenderer(this, 0, 9);
        lambLeg1.addBox(-1F, 0.0F, -1F, 2, 6, 2, 0.0F);
        lambLeg1.setRotationPoint(-2F, 18F, 4F);
        lambLeg2 = new ModelRenderer(this, 0, 9);
        lambLeg2.addBox(-1F, 0.0F, -1F, 2, 6, 2, 0.0F);
        lambLeg2.setRotationPoint(2.0F, 18F, 4F);
        lambLeg3 = new ModelRenderer(this, 0, 9);
        lambLeg3.addBox(-1F, 0.0F, -1F, 2, 6, 2, 0.0F);
        lambLeg3.setRotationPoint(-2F, 18F, -3F);
        lambLeg4 = new ModelRenderer(this, 0, 9);
        lambLeg4.addBox(-1F, 0.0F, -1F, 2, 6, 2, 0.0F);
        lambLeg4.setRotationPoint(2.0F, 18F, -3F);
    }

    @Override
    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (isChild) {
            setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

            lambHead.render(par7);
            lambBody.render(par7);
            lambLeg1.render(par7);
            lambLeg2.render(par7);
            lambLeg3.render(par7);
            lambLeg4.render(par7);
        } else {
            super.render(entity, par2, par3, par4, par5, par6, par7);
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        lambHead.rotateAngleX = head.rotateAngleX;
        lambHead.rotateAngleY = head.rotateAngleY;
        lambBody.rotateAngleX = body.rotateAngleX;
        lambLeg1.rotateAngleX = leg1.rotateAngleX;
        lambLeg2.rotateAngleX = leg2.rotateAngleX;
        lambLeg3.rotateAngleX = leg3.rotateAngleX;
        lambLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
