package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNewCow extends ModelCow {
    public final ModelRenderer calfHead;
    public final ModelRenderer calfBody;
    public final ModelRenderer calfLeg1;
    public final ModelRenderer calfLeg2;
    public final ModelRenderer calfLeg3;
    public final ModelRenderer calfLeg4;

    public ModelNewCow() {
        calfHead = new ModelRenderer(this, 0, 0);
        calfHead.addBox(-3F, -3F, -3F, 6, 6, 4, -0.1F);
        calfHead.setRotationPoint(0.0F, 10F, -4F);
        calfHead.setTextureOffset(17, 0).addBox(-3.5F, -4F, -2F, 1, 2, 1, 0.0F);
        calfHead.setTextureOffset(17, 0).addBox(2.5F, -4F, -2F, 1, 2, 1, 0.0F);
        calfBody = new ModelRenderer(this, 15, 5);
        calfBody.addBox(-3F, -4.5F, -2.5F, 6, 9, 5, 0.0F);
        calfBody.setRotationPoint(0.0F, 12.5F, 0.0F);
        calfLeg1 = new ModelRenderer(this, 0, 10);
        calfLeg1.addBox(-1F, 0.0F, -1F, 2, 9, 2, 0.0F);
        calfLeg1.setRotationPoint(-2F, 15F, 4F);
        calfLeg2 = new ModelRenderer(this, 0, 10);
        calfLeg2.addBox(-1F, 0.0F, -1F, 2, 9, 2, 0.0F);
        calfLeg2.setRotationPoint(2.0F, 15F, 4F);
        calfLeg3 = new ModelRenderer(this, 0, 10);
        calfLeg3.addBox(-1F, 0.0F, -1F, 2, 9, 2, 0.0F);
        calfLeg3.setRotationPoint(-2F, 15F, -3F);
        calfLeg4 = new ModelRenderer(this, 0, 10);
        calfLeg4.addBox(-1F, 0.0F, -1F, 2, 9, 2, 0.0F);
        calfLeg4.setRotationPoint(2.0F, 15F, -3F);
    }

    @Override
    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (isChild) {
            setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

            calfHead.render(par7);
            calfBody.render(par7);
            calfLeg1.render(par7);
            calfLeg2.render(par7);
            calfLeg3.render(par7);
            calfLeg4.render(par7);
        } else {
            super.render(entity, par2, par3, par4, par5, par6, par7);
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        calfHead.rotateAngleX = head.rotateAngleX;
        calfHead.rotateAngleY = head.rotateAngleY;
        calfBody.rotateAngleX = body.rotateAngleX;
        calfLeg1.rotateAngleX = leg1.rotateAngleX;
        calfLeg2.rotateAngleX = leg2.rotateAngleX;
        calfLeg3.rotateAngleX = leg3.rotateAngleX;
        calfLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
