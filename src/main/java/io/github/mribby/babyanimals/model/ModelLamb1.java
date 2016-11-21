package io.github.mribby.babyanimals.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.entity.Entity;

public class ModelLamb1 extends ModelSheep1 {
    public final ModelRenderer lambHead;
    public final ModelRenderer lambBody;
    public final ModelRenderer lambLeg1;
    public final ModelRenderer lambLeg2;
    public final ModelRenderer lambLeg3;
    public final ModelRenderer lambLeg4;

    public ModelLamb1() {
        lambHead = new ModelRenderer(this, 0, 0);
        lambHead.addBox(-3F, -2.5F, -2F, 6, 5, 3, 0.1F);
        lambHead.setRotationPoint(0.0F, 13F, -4F);
        lambBody = new ModelRenderer(this, 15, 4);
        lambBody.addBox(-3F, -4.5F, -2.5F, 6, 9, 5, 0.1F);
        lambBody.setRotationPoint(0.0F, 15.5F, 0.0F);
        lambLeg1 = new ModelRenderer(this, 0, 9);
        lambLeg1.addBox(-1F, 0.0F, -1F, 2, 2, 2, 0.1F);
        lambLeg1.setRotationPoint(-2F, 18F, 4F);
        lambLeg2 = new ModelRenderer(this, 0, 9);
        lambLeg2.addBox(-1F, 0.0F, -1F, 2, 2, 2, 0.1F);
        lambLeg2.setRotationPoint(2.0F, 18F, 4F);
        lambLeg3 = new ModelRenderer(this, 0, 9);
        lambLeg3.addBox(-1F, 0.0F, -1F, 2, 2, 2, 0.1F);
        lambLeg3.setRotationPoint(-2F, 18F, -3F);
        lambLeg4 = new ModelRenderer(this, 0, 9);
        lambLeg4.addBox(-1F, 0.0F, -1F, 2, 2, 2, 0.1F);
        lambLeg4.setRotationPoint(2.0F, 18F, -3F);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        lambHead.render(scale);
        lambBody.render(scale);
        lambLeg1.render(scale);
        lambLeg2.render(scale);
        lambLeg3.render(scale);
        lambLeg4.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        lambHead.rotateAngleX = head.rotateAngleX;
        lambHead.rotateAngleY = head.rotateAngleY;
        lambBody.rotateAngleX = body.rotateAngleX;
        lambLeg1.rotateAngleX = leg1.rotateAngleX;
        lambLeg2.rotateAngleX = leg2.rotateAngleX;
        lambLeg3.rotateAngleX = leg3.rotateAngleX;
        lambLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
