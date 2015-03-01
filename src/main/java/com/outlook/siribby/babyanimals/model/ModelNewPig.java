package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNewPig extends ModelPig {
    public final ModelRenderer pigletHead;
    public final ModelRenderer pigletBody;
    public final ModelRenderer pigletLeg1;
    public final ModelRenderer pigletLeg2;
    public final ModelRenderer pigletLeg3;
    public final ModelRenderer pigletLeg4;

    public ModelNewPig() {
        this(0.0F);
    }

    public ModelNewPig(float par1) {
        super(par1);

        pigletHead = new ModelRenderer(this, 0, 0);
        pigletHead.addBox(-2.5F, -2F, -3F, 5, 4, 4, 0.0F);
        pigletHead.setRotationPoint(0.0F, 17F, -3F);
        pigletBody = new ModelRenderer(this, 14, 4);
        pigletBody.addBox(-3F, -4F, -2F, 6, 8, 4, 0.0F);
        pigletBody.setRotationPoint(0.0F, 19F, 0.0F);
        pigletLeg1 = new ModelRenderer(this, 0, 8);
        pigletLeg1.addBox(-1F, 0.0F, -1F, 2, 3, 2, 0.0F);
        pigletLeg1.setRotationPoint(-2F, 21F, 4F);
        pigletLeg2 = new ModelRenderer(this, 0, 8);
        pigletLeg2.addBox(-1F, 0.0F, -1F, 2, 3, 2, 0.0F);
        pigletLeg2.setRotationPoint(2.0F, 21F, 4F);
        pigletLeg3 = new ModelRenderer(this, 0, 8);
        pigletLeg3.addBox(-1F, 0.0F, -1F, 2, 3, 2, 0.0F);
        pigletLeg3.setRotationPoint(-2F, 21F, -2F);
        pigletLeg4 = new ModelRenderer(this, 0, 8);
        pigletLeg4.addBox(-1F, 0.0F, -1F, 2, 3, 2, 0.0F);
        pigletLeg4.setRotationPoint(2.0F, 21F, -2F);
    }

    @Override
    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (isChild) {
            setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

            pigletHead.render(par7);
            pigletBody.render(par7);
            pigletLeg1.render(par7);
            pigletLeg2.render(par7);
            pigletLeg3.render(par7);
            pigletLeg4.render(par7);
        } else {
            super.render(entity, par2, par3, par4, par5, par6, par7);
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        pigletHead.rotateAngleX = head.rotateAngleX;
        pigletHead.rotateAngleY = head.rotateAngleY;
        pigletBody.rotateAngleX = body.rotateAngleX;
        pigletLeg1.rotateAngleX = leg1.rotateAngleX;
        pigletLeg2.rotateAngleX = leg2.rotateAngleX;
        pigletLeg3.rotateAngleX = leg3.rotateAngleX;
        pigletLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
