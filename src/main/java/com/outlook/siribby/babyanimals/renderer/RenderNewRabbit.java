package com.outlook.siribby.babyanimals.renderer;

import com.outlook.siribby.babyanimals.BabyAnimals;
import com.outlook.siribby.babyanimals.model.ModelNewRabbit;
import ganymedes01.etfuturum.client.renderer.entity.RabbitRenderer;
import ganymedes01.etfuturum.entities.EntityRabbit;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class RenderNewRabbit extends RabbitRenderer {
    public static final ResourceLocation BROWN = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/brown.png");
    public static final ResourceLocation WHITE = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/white.png");
    public static final ResourceLocation BLACK = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/black.png");
    public static final ResourceLocation GOLD = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/gold.png");
    public static final ResourceLocation SALT = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/salt.png");
    public static final ResourceLocation WHITE_SPLOTCHED = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/white_splotched.png");
    public static final ResourceLocation TOAST = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/toast.png");
    public static final ResourceLocation CAERBANNOG = new ResourceLocation(BabyAnimals.MOD_ID, "textures/entity/rabbit/caerbannog.png");

    public RenderNewRabbit() {
        mainModel = new ModelNewRabbit();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        EntityRabbit rabbit = (EntityRabbit) entity;

        if (rabbit.isChild()) {
            String name = EnumChatFormatting.getTextWithoutFormattingCodes(rabbit.getCommandSenderName());

            if (name != null && name.equals("Toast")) {
                return TOAST;
            } else {
                switch (rabbit.getRabbitType()) {
                    case 0:
                    default:
                        return BROWN;
                    case 1:
                        return WHITE;
                    case 2:
                        return BLACK;
                    case 3:
                        return WHITE_SPLOTCHED;
                    case 4:
                        return GOLD;
                    case 5:
                        return SALT;
                    case 99:
                        return CAERBANNOG;
                }
            }
        }

        return super.getEntityTexture(rabbit);
    }
}
