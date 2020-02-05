package doggytalents.client.model.entity;

import doggytalents.entity.EntityDog;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelWingsCute extends ModelBase {
    
    public ModelRenderer wingA;
    public ModelRenderer wingB;
  
    public ModelWingsCute() {   
        this.wingA = new ModelRenderer(this, 50, 14);
        this.wingA.addBox(-3F, -3F, 0F, 6, 17, 1);
        this.wingA.setRotationPoint(0F, 15F, 4F);
        this.setRotation(this.wingA, 0F, 0F, -1.570796F);     
      
        this.wingB = new ModelRenderer(this, 50, 14);
        this.wingB.mirror = true;
        this.wingB.addBox(-3F, -3F, 0F, 6, 17, 1);
        this.wingB.setRotationPoint(0F, 15F, 4F);
        this.setRotation(this.wingB, 0F, 0F, 1.570796F);     
    }
  
    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();
        EntityDog entitywolf = (EntityDog) entityIn;
        if (entitywolf.isBeingRidden())
			GlStateManager.translate(0.0f, 0.0, 10.0 * scale);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.translate(0F, 16.0F * scale, 0F);
        this.wingA.render(scale);         
        this.wingB.render(scale);
        GlStateManager.popMatrix();
    }
  
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityDog dog = (EntityDog)entitylivingbaseIn;

        if(dog.isSitting()) {
            this.wingA.setRotationPoint(0F, 21.0F, 4F);
            this.wingB.setRotationPoint(0F, 21.0F, 4F);
        }     
        else {
            this.wingA.setRotationPoint(0F, 15F, 4F);
            this.wingB.setRotationPoint(0F, 15F, 4F);
          
            // if(!dog.onGround) {
            //     if(!Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
            //         float c = 4.0F;
            //         this.wingA.rotateAngleY = 1.570796F - (float) ((Math.atan(Math.abs(dog.motionX*c)+Math.abs(dog.motionZ*c))));
            //         this.wingB.rotateAngleY = -1.570796F - (float) -((Math.atan(Math.abs(dog.motionX*c)+Math.abs(dog.motionZ*c))));
            //     } 
            //     else {
            //         float c2 = 0.5F;
            //         this.wingA.rotateAngleY = 1.570796F - (float) ((Math.atan(Math.abs(dog.motionX*c2)+Math.abs(dog.motionZ*c2))));
            //         this.wingB.rotateAngleY = -1.570796F - (float) -((Math.atan(Math.abs(dog.motionX*c2)+Math.abs(dog.motionZ*c2))));
            //     }
            // }
        }
    }
  
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    
        /*Wing1.rotateAngleY = -1.48353F;
        Wing2.rotateAngleY = 1.48353F; */   
    }  
  
    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}