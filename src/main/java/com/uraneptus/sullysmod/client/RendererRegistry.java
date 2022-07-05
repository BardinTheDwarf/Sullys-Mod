package com.uraneptus.sullysmod.client;

import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.client.models.TortoiseModel;
import com.uraneptus.sullysmod.client.renderer.entities.CopperGolemRenderer;
import com.uraneptus.sullysmod.client.renderer.entities.LanternfishRenderer;
import com.uraneptus.sullysmod.client.renderer.entities.TortoiseRenderer;
import com.uraneptus.sullysmod.client.models.LanternfishModel;
import com.uraneptus.sullysmod.core.registry.SMEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SullysMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererRegistry {

    @SubscribeEvent
    public static void registerEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SMEntityTypes.COPPER_GOLEM.get(), CopperGolemRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.LANTERNFISH.get(), LanternfishRenderer::new);
        event.registerEntityRenderer(SMEntityTypes.TORTOISE.get(), TortoiseRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerLocation(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LanternfishModel.LAYER_LOCATION, LanternfishModel::createBodyLayer);
        event.registerLayerDefinition(TortoiseModel.LAYER_LOCATION, TortoiseModel::createBodyLayer);
    }
}
