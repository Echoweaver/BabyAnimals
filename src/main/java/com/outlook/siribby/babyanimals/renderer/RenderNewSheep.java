package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import java.util.ListIterator;

public class RenderNewSheep extends RenderSheep {
    public static final ResourceLocation LAMB_TEXTURES = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/sheep/sheep.png");

    public RenderNewSheep(RenderManager renderManager, ModelBase modelBase, float par3) {
        super(renderManager, modelBase, par3);

        ListIterator layerIterator = layerRenderers.listIterator();
        while (layerIterator.hasNext()) {
            if (layerIterator.next().getClass() == LayerSheepWool.class) {
                layerIterator.set(new LayerNewSheepWool(this));
                break;
            }
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySheep entitySheep) {
        if (entitySheep.isChild()) {
            return LAMB_TEXTURES;
        }

        return super.getEntityTexture(entitySheep);
    }
}
