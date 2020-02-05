package doggytalents.client.renderer.entity;

import doggytalents.ModTalents;
import doggytalents.client.model.entity.ModelChest;
import doggytalents.client.model.entity.ModelDog;
import doggytalents.client.model.entity.ModelSaddle;
import doggytalents.client.model.entity.ModelWings;
import doggytalents.client.model.entity.ModelChestCute;
import doggytalents.client.model.entity.ModelDogCute;
import doggytalents.client.model.entity.ModelSaddleCute;
import doggytalents.client.model.entity.ModelWingsCute;
import doggytalents.client.model.entity.ModelProxy;
import doggytalents.client.renderer.RenderUtil;
import doggytalents.client.renderer.entity.layer.LayerBone;
import doggytalents.client.renderer.entity.layer.LayerCape;
import doggytalents.client.renderer.entity.layer.LayerCover;
import doggytalents.client.renderer.entity.layer.LayerDogCollar;
import doggytalents.client.renderer.entity.layer.LayerDogHurt;
import doggytalents.client.renderer.entity.layer.LayerModel;
import doggytalents.client.renderer.entity.layer.LayerRadioCollar;
import doggytalents.entity.EntityDog;
import doggytalents.lib.ConfigValues;
import doggytalents.lib.ResourceLib;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDog extends RenderLiving<EntityDog> {
    
    public RenderDog(RenderManager renderManagerIn) {
        // 2020-02-02 Edit: Use ModeProxy to decide which model to use
        super(renderManagerIn, new ModelProxy(new ModelDog(0.0F), new ModelDogCute(0.0F)), 0.5F);
        this.addLayer(new LayerCape(this));
        this.addLayer(new LayerRadioCollar(this));
        this.addLayer(new LayerDogCollar(this));
        this.addLayer(new LayerDogHurt(this));
        this.addLayer(new LayerBone(this));
        
        this.addLayer(new LayerCover(this, new ModelProxy(new ModelDog(0.4F), new ModelDogCute(0.4F)), ResourceLib.MOB_LAYER_SUNGLASSES, ResourceLib.MOB_LAYER_SUNGLASSES_CUTE, EntityDog::hasSunglasses));
        
        this.addLayer(new LayerModel(this, new ModelProxy(new ModelDog(0.4F), new ModelDogCute(0.4F)), ResourceLib.MOB_LAYER_ARMOR, ResourceLib.MOB_LAYER_ARMOR_CUTE, dog -> ConfigValues.RENDER_ARMOUR && dog.TALENTS.getLevel(ModTalents.GUARD_DOG) > 0));
        this.addLayer(new LayerModel(this, new ModelProxy(new ModelWings(), new ModelWingsCute()), ResourceLib.MOB_LAYER_WINGS, ResourceLib.MOB_LAYER_WINGS_CUTE, dog -> ConfigValues.RENDER_WINGS && dog.TALENTS.getLevel(ModTalents.PILLOW_PAW) == 5));
        this.addLayer(new LayerModel(this, new ModelProxy(new ModelSaddle(0.0F), new ModelSaddleCute(0.0F)), ResourceLib.MOB_LAYER_SADDLE, ResourceLib.MOB_LAYER_SADDLE_CUTE, dog -> ConfigValues.RENDER_SADDLE && dog.TALENTS.getLevel(ModTalents.WOLF_MOUNT) > 0));
        this.addLayer(new LayerModel(this, new ModelProxy(new ModelChest(0.0F), new ModelChestCute(0.0F)), ResourceLib.MOB_LAYER_CHEST, ResourceLib.MOB_LAYER_CHEST_CUTE, dog -> ConfigValues.RENDER_CHEST && dog.TALENTS.getLevel(ModTalents.PACK_PUPPY) > 0));
        // ===========Edit End
    }

    @Override
    protected float handleRotationFloat(EntityDog dog, float partialTickTime) {
        return dog.getTailRotation();
    }
    
    @Override
    protected void renderLivingAt(EntityDog dog, double x, double y, double z) {
        if(dog.isEntityAlive() && dog.isPlayerSleeping())
            super.renderLivingAt(dog, x, y + 0.5F, z);
        else
            super.renderLivingAt(dog, x, y, z);
    }
    
    @Override
    public void doRender(EntityDog dog, double x, double y, double z, float entityYaw, float partialTicks) {
        if(dog.isDogWet()) {
            float f2 = dog.getBrightness() * dog.getShadingWhileWet(partialTicks);
            GlStateManager.color(f2, f2, f2);
        }

        super.doRender(dog, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDog dog) {
        if(ConfigValues.USE_DT_TEXTURES)
            return ResourceLib.getTameSkin(dog.getTameSkin());
        else {
            if(dog.isTamed() && !dog.isInvisible() && (dog.getHealth() == 1 && dog.isImmortal()))
                return ResourceLib.MOB_DOG_SAD_CUTE;
            return ResourceLib.MOB_DOG_TAME_CUTE;
        }
    }
    
    @Override
    public void renderName(EntityDog dog, double x, double y, double z) {
        if(this.canRenderName(dog)) {
            GlStateManager.alphaFunc(516, 0.1F);
            double d0 = dog.getDistanceSq(this.renderManager.renderViewEntity);
            
            y += (double)((float)this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15F * 0.016666668F * 0.7F);
            
            String tip = dog.MODE.getMode().getTip();
                
            if(dog.isIncapacicated())
                tip = "dog.mode.incapacitated.indicator";
            
            String label = String.format("%s(%d)", 
                    new TextComponentTranslation(tip).getFormattedText(), 
                    dog.getDogHunger());
            
            if(ConfigValues.DOG_GENDER) {
                label += dog.GENDER.getGenderTip().getFormattedText();
            }
            
            if(d0 <= (double)(64 * 64)) {
                boolean flag = dog.isSneaking();
                float f = this.renderManager.playerViewY;
                float f1 = this.renderManager.playerViewX;
                boolean flag1 = this.renderManager.options.thirdPersonView == 2;
                float f2 = dog.height + 0.42F - (flag ? 0.25F : 0.0F) - (dog.isPlayerSleeping() ? 0.5F : 0);
                if (!ConfigValues.USE_DT_TEXTURES && !dog.isChild()) { // modify label pos when use cute model
                    f2 += 0.5F;
                }
        
                RenderUtil.renderLabelWithScale(this.getFontRendererFromRenderManager(), label, (float)x, (float)y + f2, (float)z, 0, f, f1, flag1, flag, 0.01F);
                RenderUtil.renderLabelWithScale(this.getFontRendererFromRenderManager(), dog.getDisplayName().getFormattedText(), (float)x, (float)y + f2 - 0.12F, (float)z, 0, f, f1, flag1, flag, 0.026F);
                
                if(d0 <= (double)(5 * 5)) {
                    if(this.renderManager.renderViewEntity.isSneaking()) {
                        String ownerName = dog.getOwnersName().getFormattedText();
                        
                        RenderUtil.renderLabelWithScale(this.getFontRendererFromRenderManager(), ownerName, (float)x, (float)y + f2 - 0.34F, (float)z, 0, f, f1, flag1, flag, 0.01F);
                    }
                }
            }
        }
    }
    
    @Override
    protected void preRenderCallback(EntityDog entitylivingbaseIn, float partialTickTime) {
        EntityDog dog = (EntityDog)entitylivingbaseIn;
        float size = dog.getDogSize() * 0.3F + 0.1F;
        GlStateManager.scale(size, size, size);
        this.shadowSize = size * 0.5F;
    }
}