package io.github.mribby.babyanimals.model;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChick extends ModelChicken {
    public final ModelRenderer chickHead;
    public final ModelRenderer chickBill;
    public final ModelRenderer chickBody;
    public final ModelRenderer chickRightLeg;
    public final ModelRenderer chickLeftLeg;

    public ModelChick() {
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
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        chickHead.render(scale);
        chickBill.render(scale);
        chickBody.render(scale);
        chickRightLeg.render(scale);
        chickLeftLeg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        chickHead.rotateAngleX = head.rotateAngleX;
        chickHead.rotateAngleY = head.rotateAngleY;
        chickBill.rotateAngleX = bill.rotateAngleX;
        chickBill.rotateAngleY = bill.rotateAngleY;
        chickBody.rotateAngleX = body.rotateAngleX;
        chickRightLeg.rotateAngleX = rightLeg.rotateAngleX;
        chickLeftLeg.rotateAngleX = leftLeg.rotateAngleX;
    }
}
