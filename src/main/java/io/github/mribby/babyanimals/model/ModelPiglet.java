package io.github.mribby.babyanimals.model;

import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPiglet extends ModelPig {
    public final ModelRenderer pigletHead;
    public final ModelRenderer pigletBody;
    public final ModelRenderer pigletLeg1;
    public final ModelRenderer pigletLeg2;
    public final ModelRenderer pigletLeg3;
    public final ModelRenderer pigletLeg4;

    public ModelPiglet() {
        this(0.0F);
    }

    public ModelPiglet(float par1) {
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
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);

        pigletHead.render(scale);
        pigletBody.render(scale);
        pigletLeg1.render(scale);
        pigletLeg2.render(scale);
        pigletLeg3.render(scale);
        pigletLeg4.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        pigletHead.rotateAngleX = head.rotateAngleX;
        pigletHead.rotateAngleY = head.rotateAngleY;
        pigletBody.rotateAngleX = body.rotateAngleX;
        pigletLeg1.rotateAngleX = leg1.rotateAngleX;
        pigletLeg2.rotateAngleX = leg2.rotateAngleX;
        pigletLeg3.rotateAngleX = leg3.rotateAngleX;
        pigletLeg4.rotateAngleX = leg4.rotateAngleX;
    }
}
