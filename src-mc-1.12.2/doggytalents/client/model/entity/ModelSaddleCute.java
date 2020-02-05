package doggytalents.client.model.entity;

import doggytalents.entity.EntityDog;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSaddleCute extends ModelBase {
    
    // public ModelRenderer chest1;
    // public ModelRenderer chest2;
    // public ModelRenderer chest3;
    public ModelRenderer ring;
    
    public ModelSaddleCute(float scaleFactor) {   
        // this.chest1 = new ModelRenderer(this, 52, 11);
        // this.chest1.addBox(-2.5F, 0F, 3F, 5, 6, 1, scaleFactor);
        // this.chest1.setRotationPoint(0.0F, 14.0F, 2.0F);
        // this.chest2 = new ModelRenderer(this, 52, 18);
        // this.chest2.addBox(-2.0F, 0F, 3.5F, 4, 1, 1, scaleFactor);
        // this.chest2.setRotationPoint(0.0F, 14.0F, 2.0F);   
        // this.chest3 = new ModelRenderer(this, 52, 18);
        // this.chest3.addBox(-2.0F, 5F, 3.5F, 4, 1, 1, scaleFactor);
        // this.chest3.setRotationPoint(0.0F, 14.0F, 2.0F);   
        this.ring = new ModelRenderer(this, 0, 0);
		this.ring.addBox(-3.5F, -8.0F, -3.0F, 7, 1, 6, scaleFactor);
		this.ring.setRotationPoint(0.0F, 9.0F, 0.0F);
		this.ring.setTextureSize(this.textureWidth, this.textureHeight);
		this.ring.mirror = true;
    }
  
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();
        EntityDog entitywolf = (EntityDog) entityIn;
        if (entitywolf.isBeingRidden())
			GlStateManager.translate(0.0f, 0.0, 10.0 * scale);
        this.ring.render(scale);
        GlStateManager.popMatrix();
    }
  
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityDog dog = (EntityDog)entitylivingbaseIn;

        if (dog.isSitting()) {
            this.ring.setRotationPoint(0.0F, 12.0F, 0.0F);
        }
        else {
            this.ring.setRotationPoint(0.0F, 9.0F, 0.0F);
        }
    }
  
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }  
}