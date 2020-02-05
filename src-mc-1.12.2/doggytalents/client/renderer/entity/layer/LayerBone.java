package doggytalents.client.renderer.entity.layer;

import doggytalents.api.inferface.IThrowableItem;
import doggytalents.client.model.entity.ModelDog;
import doggytalents.client.model.entity.ModelDogCute;
import doggytalents.client.model.entity.ModelProxy;
import doggytalents.client.renderer.entity.RenderDog;
import doggytalents.entity.EntityDog;
import doggytalents.lib.ConfigValues;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerBone implements LayerRenderer<EntityDog> {
    
    protected final RenderDog dogRenderer;
    public LayerBone(RenderDog dogRendererIn) {
        this.dogRenderer = dogRendererIn;
    }

    @Override
    public void doRenderLayer(EntityDog dog, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if(dog.hasBone()) {
            
            GlStateManager.pushMatrix();

            // 2020-02-02 Add: Resize Bone when use cute model
            if (!ConfigValues.USE_DT_TEXTURES) {
                // GlStateManager.translate(0.0F, 1.5F, -0.5F);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
            // ===========Add End
            } else if (this.dogRenderer.getMainModel().isChild) {
                float f = 0.5F;
                GlStateManager.translate(0.0F, 0.75F, -0.25F);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
            }

            if(dog.isSneaking())
                GlStateManager.translate(0.0F, 0.2F, 0.0F);

            if(ConfigValues.USE_DT_TEXTURES)
            	((ModelDog) ((ModelProxy)this.dogRenderer.getMainModel()).nModel).wolfHeadMain.postRender(0.0625F);
            else
            	((ModelDogCute) ((ModelProxy)this.dogRenderer.getMainModel()).cModel).wolfHeadMain.postRender(0.0625F);
            GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(45.0F, 0.0F, 0.0F, 1.0F);

            GlStateManager.translate(0.20, -0.10, -0.10);
            // 2020-02-02 Add: Change Bone Position when use cute model
            if (!ConfigValues.USE_DT_TEXTURES) {
                if (this.dogRenderer.getMainModel().isChild)
                    GlStateManager.translate(0.0F, 0.0F, -0.3F);
                else
                    GlStateManager.translate(0.0F, 0.0F, -0.6F);
            }
            // =============Add End
            IThrowableItem throwableItem = dog.getThrowableItem();
            Minecraft.getMinecraft().getItemRenderer().renderItem(dog, throwableItem != null ? throwableItem.getRenderStack(dog.getBoneVariant()) : dog.getBoneVariant(), ItemCameraTransforms.TransformType.NONE);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}