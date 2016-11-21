package io.github.mribby.babyanimals.model;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCalf extends ModelCow {
    public final ModelRenderer calfHead;
    public final ModelRenderer calfBody;
    public final ModelRenderer calfLeg1;
    public final ModelRenderer calfLeg2;
    public final ModelRenderer calfLeg3;
    public final ModelRenderer calfLeg4;

    public ModelCalf() {
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
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        calfHead.render(scale);
        calfBody.render(scale);
        calfLeg1.render(scale);
        calfLeg2.render(scale);
        calfLeg3.render(scale);
        calfLeg4.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        calfHead.rotateAngleX = head.rotateAngleX;
        calfHead.rotateAngleY = head.rotateAngleY;
        calfBody.rotateAngleX = body.rotateAngleX;
        calfLeg1.rotateAngleX = leg1.rotateAngleX;
        calfLeg2.rotateAngleX = leg2.rotateAngleX;
        calfLeg3.rotateAngleX = leg3.rotateAngleX;
        calfLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
