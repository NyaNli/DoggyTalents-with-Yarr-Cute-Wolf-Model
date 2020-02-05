package doggytalents.client.renderer.entity.layer;

import doggytalents.client.renderer.entity.RenderDog;
import doggytalents.entity.EntityDog;
import doggytalents.lib.ConfigValues;
import doggytalents.lib.ResourceLib;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerDogCollar implements LayerRenderer<EntityDog> {
    
    private final RenderDog dogRenderer;

    public LayerDogCollar(RenderDog dogRendererIn) {
        this.dogRenderer = dogRendererIn;
    }

    @Override
    public void doRenderLayer(EntityDog dog, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(dog.isTamed() && !dog.isInvisible() && dog.hasCollar()) {
            if(dog.hasFancyCollar()) {
                 this.dogRenderer.bindTexture(ResourceLib.getFancyCollar(dog.getFancyCollarIndex()));
                 GlStateManager.color(1.0F, 1.0F, 1.0F);
            }
            else if(dog.hasCollarColoured()) {
            	if (ConfigValues.USE_DT_TEXTURES)
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_DOG_COLLAR);
            	else
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_DOG_COLLAR_CUTE);// 2020-02-02: Add Cute Model Texture
                if(dog.isCollarColoured()) {
                    float[] afloat = dog.getCollar();
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }
            }
            this.dogRenderer.getMainModel().render(dog, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}