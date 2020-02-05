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
public class LayerCape implements LayerRenderer<EntityDog> {

    private final RenderDog dogRenderer;

    public LayerCape(RenderDog dogRendererIn) {
        this.dogRenderer = dogRendererIn;
    }

    @Override
    public void doRenderLayer(EntityDog dog, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(dog.hasCape()) {
            if(dog.hasCapeColoured()) {
            	if(ConfigValues.USE_DT_TEXTURES)
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_CAPE_COLOURED);
            	else
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_CAPE_COLOURED_CUTE); // 2020-02-02: Add Cute Model Texture
                if(dog.isCapeColoured()) {
                    float[] afloat = dog.getCapeColour();
                    GlStateManager.color(afloat[0], afloat[1], afloat[2]);
                }
            }
            else if(dog.hasFancyCape()) {
            	if(ConfigValues.USE_DT_TEXTURES)
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_CAPE);
            	else
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_CAPE_CUTE); // 2020-02-02: Add Cute Model Texture
                GlStateManager.color(1.0F, 1.0F, 1.0F);
            }
            else if(dog.hasLeatherJacket()) {
            	if(ConfigValues.USE_DT_TEXTURES)
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_LEATHER_JACKET);
            	else
            		this.dogRenderer.bindTexture(ResourceLib.MOB_LAYER_LEATHER_JACKET_CUTE); // 2020-02-02: Add Cute Model Texture
                GlStateManager.color(1.0F, 1.0F, 1.0F);
            }
            // 2020-02-02 Edit: Fix Z-fight
            GlStateManager.enablePolygonOffset();
        	GlStateManager.doPolygonOffset(-1.0F, -1.0F);
            this.dogRenderer.getMainModel().render(dog, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        	GlStateManager.disablePolygonOffset();
            // =========Edit End
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}