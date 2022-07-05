package com.uraneptus.sullysmod.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.client.animations.TortoiseAnimations;
import com.uraneptus.sullysmod.common.entities.Tortoise;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

//Made by Sully using Blockbench

public class TortoiseModel<T extends Tortoise> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(SullysMod.modPrefix("tortoise"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart shell;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;

    public TortoiseModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild("head");
        this.shell = root.getChild("shell");
        this.left_front_leg = root.getChild("left_front_leg");
        this.right_front_leg = root.getChild("right_front_leg");
        this.left_back_leg = root.getChild("left_back_leg");
        this.right_back_leg = root.getChild("right_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(51, 0).addBox(-3.5F, -3.0F, -6.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -9.0F));

        PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -9.0F, 16.0F, 13.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-8.0F, -11.0F, -9.0F, 16.0F, 7.0F, 19.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left_front_leg = partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(51, 32).mirror().addBox(-2.0F, -1.0F, -2.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 19.0F, -8.0F));

        PartDefinition right_front_leg = partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(51, 32).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 19.0F, -8.0F));

        PartDefinition left_back_leg = partdefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(51, 32).mirror().addBox(-2.0F, -1.0F, -3.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 19.0F, 9.0F));

        PartDefinition right_back_leg = partdefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(51, 32).addBox(-3.0F, -1.0F, -3.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 19.0F, 9.0F));

        return LayerDefinition.create(meshdefinition, 96, 96);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animateHeadLookTarget(netHeadYaw, headPitch);
        this.animate(entity.walkingState, TortoiseAnimations.TORTOISE_WALKING, ageInTicks);
        this.animate(entity.hideState, TortoiseAnimations.TORTOISE_HIDE, ageInTicks);
        this.animate(entity.hidingState, TortoiseAnimations.TORTOISE_HIDING, ageInTicks);
        this.animate(entity.revealState, TortoiseAnimations.TORTOISE_REVEAL, ageInTicks);
    }

    private void animateHeadLookTarget(float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_front_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_front_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        left_back_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_back_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }


}

/*public class TortoiseModel extends AnimatedGeoModel<Tortoise> {
    @Override
    public ResourceLocation getModelResource(Tortoise object) {
        return SullysMod.modPrefix("geo/tortoise.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Tortoise object) {
        return SullysMod.modPrefix("textures/entity/tortoise/tortoise.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Tortoise animatable) {
        return SullysMod.modPrefix("animations/tortoise.animation.json");
    }


    @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
    @Override
    public void setLivingAnimations(Tortoise entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        LivingEntity entityIn = entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}*/
