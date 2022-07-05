package com.uraneptus.sullysmod.client.renderer.entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.client.models.LanternfishModel;
import com.uraneptus.sullysmod.client.models.TortoiseModel;
import com.uraneptus.sullysmod.client.renderer.entities.layer.LanternfishGlowLayer;
import com.uraneptus.sullysmod.common.entities.Lanternfish;
import com.uraneptus.sullysmod.common.entities.Tortoise;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TortoiseRenderer extends MobRenderer<Tortoise, TortoiseModel<Tortoise>> {
    public static final ResourceLocation TEXTURE = SullysMod.modPrefix("textures/entity/tortoise/tortoise.png");

    public TortoiseRenderer(EntityRendererProvider.Context context) {
        super(context, new TortoiseModel<>(context.bakeLayer(TortoiseModel.LAYER_LOCATION)), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(Tortoise pEntity) {
        return TEXTURE;
    }

    @Override
    public void render(Tortoise entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            matrixStack.scale(0.15F, 0.15F, 0.15F);
            this.shadowRadius *= 0.15F;
        }
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }


}
