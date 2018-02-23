package doggytalents.client.renderer.entity.layer;

import doggytalents.ModItems;
import doggytalents.client.model.entity.ModelDog;
import doggytalents.client.renderer.entity.RenderDog;
import doggytalents.entity.EntityDog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerBone implements LayerRenderer<EntityDog> {
	
    protected final RenderDog dogRenderer;
    public ItemStack[] itemToRender;
    
    public LayerBone(RenderDog dogRendererIn) {
        this.dogRenderer = dogRendererIn;
        this.itemToRender = new ItemStack[] {new ItemStack(Items.BONE), new ItemStack(ModItems.THROW_BONE, 1, 2)};
    }

    @Override
    public void doRenderLayer(EntityDog dog, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	if(dog.hasBone()) {
	    	
	        GlStateManager.pushMatrix();
	
	        if (this.dogRenderer.getMainModel().isChild) {
	            float f = 0.5F;
	            GlStateManager.translate(0.0F, 0.75F, 0.0F);
	            GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        }

            if(dog.isSneaking())
                GlStateManager.translate(0.0F, 0.2F, 0.0F);

            ((ModelDog)this.dogRenderer.getMainModel()).wolfHeadMain.postRender(0.0625F);
            GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(45.0F, 0.0F, 0.0F, 1.0F);

            GlStateManager.translate(0.20, -0.10, -0.10);
            Minecraft.getMinecraft().getItemRenderer().renderItem(dog, this.itemToRender[dog.getBoneVariant()], ItemCameraTransforms.TransformType.NONE);
	        GlStateManager.popMatrix();
    	}
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}