package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNewChicken extends ModelChicken {
    public final ModelRenderer chickHead;
    public final ModelRenderer chickBill;
    public final ModelRenderer chickBody;
    public final ModelRenderer chickRightLeg;
    public final ModelRenderer chickLeftLeg;

    public ModelNewChicken() {
        chickHead = new ModelRenderer(this, 0, 0);
        chickHead.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        chickHead.setRotationPoint(0.0F, 18F, -2.5F);
        chickBill = new ModelRenderer(this, 12, 3);
        chickBill.addBox(-0.5F, 0.5F, -2.5F, 1, 1, 1, 0.0F);
        chickBill.setRotationPoint(0.0F, 18F, -2.5F);
        chickBody = new ModelRenderer(this, 0, 6);
        chickBody.addBox(-2F, -2.5F, -2F, 4, 5, 4, 0.0F);
        chickBody.setRotationPoint(0.0F, 20F, 0.0F);
        chickRightLeg = new ModelRenderer(this, 12, 0);
        chickRightLeg.addBox(-0.5F, 0.0F, -1F, 1, 2, 1, 0.0F);
        chickRightLeg.setRotationPoint(-1F, 22F, 0.5F);
        chickLeftLeg = new ModelRenderer(this, 12, 0);
        chickLeftLeg.addBox(-0.5F, 0.0F, -1F, 1, 2, 1, 0.0F);
        chickLeftLeg.setRotationPoint(1.0F, 22F, 0.5F);
    }

    @Override
    public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        if (isChild) {
            setRotationAngles(par2, par3, par4, par5, par6, par7, entity);

            chickHead.render(par7);
            chickBill.render(par7);
            chickBody.render(par7);
            chickRightLeg.render(par7);
            chickLeftLeg.render(par7);
        } else {
            super.render(entity, par2, par3, par4, par5, par6, par7);
        }
    }

    @Override
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        chickHead.rotateAngleX = head.rotateAngleX;
        chickHead.rotateAngleY = head.rotateAngleY;
        chickBill.rotateAngleX = bill.rotateAngleX;
        chickBill.rotateAngleY = bill.rotateAngleY;
        chickBody.rotateAngleX = body.rotateAngleX;
        chickRightLeg.rotateAngleX = rightLeg.rotateAngleX;
        chickLeftLeg.rotateAngleX = leftLeg.rotateAngleX;
    }
}
