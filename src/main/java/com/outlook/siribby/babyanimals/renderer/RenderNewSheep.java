package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderNewSheep extends RenderSheep {
    public static final ResourceLocation LAMB_FUR_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/sheep/sheep_fur.png");
    public static final ResourceLocation LAMB_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/sheep/sheep.png");

    public RenderNewSheep(ModelBase modelBase1, ModelBase modelBase2, float par3) {
        super(modelBase1, modelBase2, par3);
    }

    @Override
    protected int shouldRenderPass(EntitySheep entitySheep, int par2, float par3) {
        if (entitySheep.isChild()) {
            if (par2 == 0 && !entitySheep.getSheared()) {
                bindTexture(LAMB_FUR_TEXTURES);

                if (entitySheep.hasCustomNameTag() && "jeb_".equals(entitySheep.getCustomNameTag())) {
                    boolean var9 = true;
                    int var5 = entitySheep.ticksExisted / 25 + entitySheep.getEntityId();
                    int var6 = var5 % EntitySheep.fleeceColorTable.length;
                    int var7 = (var5 + 1) % EntitySheep.fleeceColorTable.length;
                    float var8 = ((float) (entitySheep.ticksExisted % 25) + par3) / 25.0F;
                    GL11.glColor3f(EntitySheep.fleeceColorTable[var6][0] * (1.0F - var8) + EntitySheep.fleeceColorTable[var7][0] * var8, EntitySheep.fleeceColorTable[var6][1] * (1.0F - var8) + EntitySheep.fleeceColorTable[var7][1] * var8, EntitySheep.fleeceColorTable[var6][2] * (1.0F - var8) + EntitySheep.fleeceColorTable[var7][2] * var8);
                } else {
                    int var4 = entitySheep.getFleeceColor();
                    GL11.glColor3f(EntitySheep.fleeceColorTable[var4][0], EntitySheep.fleeceColorTable[var4][1], EntitySheep.fleeceColorTable[var4][2]);
                }

                return 1;
            }

            return -1;
        }

        return super.shouldRenderPass(entitySheep, par2, par3);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySheep entitySheep) {
        if (entitySheep.isChild()) {
            return LAMB_TEXTURES;
        }

        return super.getEntityTexture(entitySheep);
    }
}
