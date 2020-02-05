package doggytalents.client.renderer.entity.layer;

import doggytalents.client.renderer.entity.RenderDog;
import doggytalents.entity.EntityDog;
import doggytalents.lib.ConfigValues;
import doggytalents.lib.ResourceLib;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author ProPercivalalb
 */
@SideOnly(Side.CLIENT)
public class LayerRadioCollar implements LayerRenderer<EntityDog> {

    private final RenderDog dogRenderer;

    public LayerRadioCollar(RenderDog dogRendererIn) {
        this.dogRenderer = dogRendererIn;
    }

    @Override
    public void doRenderLayer(EntityDog dog, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(dog.isTamed() && !dog.isInvisible() && dog.hasRadarCollar()) {
        	if(ConfigValues.USE_DT_TEXTURES)
        		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_RADIO_COLLAR);
        	else
        		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_RADIO_COLLAR_CUTE);// 2020-02-02: Add Cute Model Texture
            GlStateManager.color(1.0F, 1.0F, 1.0F);
            GlStateManager.enablePolygonOffset();
        	GlStateManager.doPolygonOffset(-1.0F, -1.0F); // Fix Z-Fight
            this.dogRenderer.getMainModel().render(dog, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        	GlStateManager.disablePolygonOffset();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}