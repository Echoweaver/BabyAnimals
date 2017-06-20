package io.github.mribby.babyanimals.renderer;

import io.github.mribby.babyanimals.BabyAnimalsMod;
import io.github.mribby.babyanimals.model.ModelLamb1;
import io.github.mribby.babyanimals.model.ModelLamb2;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.glColor3f;

public class RenderLamb extends RenderSheep {
    public static final ResourceLocation LAMB_FUR_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/sheep/sheep_fur.png");
    public static final ResourceLocation LAMB_TEXTURES = new ResourceLocation(BabyAnimalsMod.MODID, "textures/entity/sheep/sheep.png");

    public RenderLamb() {
        this(new ModelLamb2(), new ModelLamb1(), 0.7F);
    }

    public RenderLamb(ModelBase modelBase, ModelBase renderPassModel, float shadowSize) {
        super(modelBase, renderPassModel, shadowSize);
    }

    @Override
    protected int shouldRenderPass(EntitySheep lambEntity, int renderPass, float partialTicks) {
        if (renderPass == 0 && !lambEntity.getSheared()) {
            bindTexture(LAMB_FUR_TEXTURES);

            if (lambEntity.hasCustomNameTag() && "jeb_".equals(lambEntity.getCustomNameTag())) {
                int ticksPerCycle = 25;
                int i = lambEntity.ticksExisted / ticksPerCycle + lambEntity.getEntityId();
                int rgbIndex1 = i % EntitySheep.fleeceColorTable.length;
                int rgbIndex2 = (i + 1) % EntitySheep.fleeceColorTable.length;
                float cycleRatio2 = (lambEntity.ticksExisted % ticksPerCycle + partialTicks) / ticksPerCycle;
                float cycleRatio1 = 1.0F - cycleRatio2;
                float[] rgb1 = EntitySheep.fleeceColorTable[rgbIndex1];
                float[] rgb2 = EntitySheep.fleeceColorTable[rgbIndex2];
                glColor3f(rgb1[0] * cycleRatio1 + rgb2[0] * cycleRatio2, rgb1[1] * cycleRatio1 + rgb2[1] * cycleRatio2, rgb1[2] * cycleRatio1 + rgb2[2] * cycleRatio2);
            } else {
                float[] rgb = EntitySheep.fleeceColorTable[lambEntity.getFleeceColor()];
                glColor3f(rgb[0], rgb[1], rgb[2]);
            }

            return 1;
        }

        return -1;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySheep lambEntity) {
        return LAMB_TEXTURES;
    }
}
