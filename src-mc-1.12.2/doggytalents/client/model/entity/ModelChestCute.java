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
public class ModelChestCute extends ModelBase {
    
    public ModelRenderer chest;
    
    public ModelChestCute(float scaleFactor) {   
        // this.chest1 = new ModelRenderer(this, 52, 0);
        // this.chest1.addBox(2.0F, -1F, 0F, 2, 7, 4, scaleFactor);
        // this.chest1.setRotationPoint(0.0F, 14.0F, 2.0F);
        // this.chest2 = new ModelRenderer(this, 52, 0);
        // this.chest2.addBox(-4.0F, -1F, 0F, 2, 7, 4, scaleFactor);
        // this.chest2.setRotationPoint(0.0F, 14.0F, 2.0F);   
        this.chest = new ModelRenderer(this, 0, 0);
		this.chest.addBox(-2.5F, 0.0F, 1.5F, 5, 3, 3, scaleFactor);
		this.chest.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.chest.mirror = true;
    }
  
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();
        EntityDog entitywolf = (EntityDog) entityIn;
        if (entitywolf.isBeingRidden())
			GlStateManager.translate(0.0f, 0.0, 10.0 * scale);
        this.chest.render(scale);         
        GlStateManager.popMatrix();
        // this.chest2.render(scale);
    }
  
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityDog dog = (EntityDog)entitylivingbaseIn;

        if (dog.isSitting()) {
            this.chest.setRotationPoint(0.0F, 17.0F, 0.0F);
        }
        else {
            this.chest.setRotationPoint(0.0F, 14.0F, 0.0F);
        }
    }
  
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }  
}