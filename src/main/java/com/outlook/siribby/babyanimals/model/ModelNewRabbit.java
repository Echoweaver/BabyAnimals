package com.outlook.siribby.babyanimals.model;

import net.minecraft.client.model.ModelRabbit;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNewRabbit extends ModelRabbit {
    public final ModelRenderer bunnyLeftFoot;
    public final ModelRenderer bunnyRightFoot;
    public final ModelRenderer bunnyLeftThigh;
    public final ModelRenderer bunnyRightThigh;
    public final ModelRenderer bunnyBody;
    public final ModelRenderer bunnyLeftArm;
    public final ModelRenderer bunnyRightArm;
    public final ModelRenderer bunnyHead;
    public final ModelRenderer bunnyRightEar;
    public final ModelRenderer bunnyLeftEar;
    public final ModelRenderer bunnyTail;

    public ModelNewRabbit() {
        textureWidth = 32;

        bunnyLeftFoot = new ModelRenderer(this, 0, 6);
        bunnyLeftFoot.addBox(-0.5F, 1F, -2.5F, 1, 1, 3);
        bunnyLeftFoot.setRotationPoint(1.5F, 22F, 1F);
        bunnyLeftFoot.mirror = true;
        bunnyRightFoot = new ModelRenderer(this, 0, 10);
        bunnyRightFoot.addBox(0F, 1F, -2.5F, 1, 1, 3);
        bunnyRightFoot.setRotationPoint(-2F, 22F, 1F);
        bunnyRightFoot.mirror = true;
        bunnyLeftThigh = new ModelRenderer(this, 6, 14);
        bunnyLeftThigh.addBox(-0.5F, -1F, -1F, 1, 2, 2);
        bunnyLeftThigh.setRotationPoint(1.5F, 22F, 1F);
        bunnyLeftThigh.mirror = true;
        setRotationOffset(bunnyLeftThigh, -0.175F, 0F, 0F);
        bunnyRightThigh = new ModelRenderer(this, 0, 14);
        bunnyRightThigh.addBox(0F, -1F, -1F, 1, 2, 2);
        bunnyRightThigh.setRotationPoint(-2F, 22F, 1F);
        bunnyRightThigh.mirror = true;
        setRotationOffset(bunnyRightThigh, -0.175F, 0F, 0F);
        bunnyBody = new ModelRenderer(this, 8, 6);
        bunnyBody.addBox(-1.5F, -1.5F, -3F, 3, 3, 5);
        bunnyBody.setRotationPoint(0F, 21F, 0F);
        bunnyBody.mirror = true;
        setRotationOffset(bunnyBody, -0.35F, 0F, 0F);
        bunnyLeftArm = new ModelRenderer(this, 0, 2);
        bunnyLeftArm.addBox(-0.5F, -1.5F, -0.75F, 1, 3, 1);
        bunnyLeftArm.setRotationPoint(1.5F, 22.5F, -2.75F);
        bunnyLeftArm.mirror = true;
        bunnyRightArm = new ModelRenderer(this, 4, 2);
        bunnyRightArm.addBox(-0.5F, -1.5F, -0.75F, 1, 3, 1);
        bunnyRightArm.setRotationPoint(-1.5F, 22.5F, -2.75F);
        bunnyRightArm.mirror = true;
        bunnyHead = new ModelRenderer(this, 12, 0);
        bunnyHead.addBox(-1.5F, -0.5F, -2F, 3, 3, 3, -0.1F);
        bunnyHead.setRotationPoint(0F, 18F, -3.5F);
        bunnyHead.mirror = true;
        bunnyRightEar = new ModelRenderer(this, 24, 0);
        bunnyRightEar.addBox(-1.3F, -2.25F, -0.5F, 1, 3, 1);
        bunnyRightEar.setRotationPoint(0F, 18F, -3.5F);
        bunnyRightEar.mirror = true;
        bunnyLeftEar = new ModelRenderer(this, 28, 0);
        bunnyLeftEar.addBox(0.3F, -2.25F, -0.5F, 1, 3, 1);
        bunnyLeftEar.setRotationPoint(0F, 18F, -3.5F);
        bunnyLeftEar.mirror = true;
        bunnyTail = new ModelRenderer(this, 24, 4);
        bunnyTail.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.2F);
        bunnyTail.setRotationPoint(0F, 22F, 2F);
        bunnyTail.mirror = true;
        setRotationOffset(bunnyTail, -0.35F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (isChild) {
            setRotationAngles(f, f1, f2, f3, f4, f5, entity);

            bunnyHead.render(f5);
            bunnyBody.render(f5);
            bunnyLeftThigh.render(f5);
            bunnyRightThigh.render(f5);
            bunnyRightArm.render(f5);
            bunnyLeftArm.render(f5);
            bunnyLeftFoot.render(f5);
            bunnyRightFoot.render(f5);
            bunnyTail.render(f5);
            bunnyRightEar.render(f5);
            bunnyLeftEar.render(f5);
        } else {
            super.render(entity, f, f1, f2, f3, f4, f5);
        }
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        bunnyHead.rotateAngleX = rabbitHead.rotateAngleX;
        bunnyHead.rotateAngleY = rabbitHead.rotateAngleY;
        bunnyRightEar.rotateAngleX = rabbitRightEar.rotateAngleX;
        bunnyRightEar.rotateAngleY = rabbitRightEar.rotateAngleY;
        bunnyLeftEar.rotateAngleX = rabbitLeftEar.rotateAngleX;
        bunnyLeftEar.rotateAngleY = rabbitLeftEar.rotateAngleY;
        bunnyLeftThigh.rotateAngleX = rabbitLeftThigh.rotateAngleX;
        bunnyRightThigh.rotateAngleX = rabbitRightThigh.rotateAngleX;
        bunnyLeftFoot.rotateAngleX = rabbitLeftFoot.rotateAngleX;
        bunnyRightFoot.rotateAngleX = rabbitRightFoot.rotateAngleX;
        bunnyLeftArm.rotateAngleX = rabbitLeftArm.rotateAngleX;
        bunnyRightArm.rotateAngleX = rabbitRightArm.rotateAngleX;
    }

    private void setRotationOffset(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
