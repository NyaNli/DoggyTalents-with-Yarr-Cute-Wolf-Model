package doggytalents.client.model.entity;

import doggytalents.lib.ConfigValues;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelProxy extends ModelBase {
	
	public ModelBase nModel;
	public ModelBase cModel;
	
	public ModelProxy(ModelBase normal, ModelBase cute) {
		nModel = normal;
		cModel = cute;
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		if(ConfigValues.USE_DT_TEXTURES) {
			nModel.isChild = this.isChild;
			nModel.isRiding = this.isRiding;
			nModel.swingProgress = this.swingProgress;
			nModel.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		} else {
			cModel.isChild = this.isChild;
			cModel.isRiding = this.isRiding;
			cModel.swingProgress = this.swingProgress;
			cModel.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTickTime) {
		if(ConfigValues.USE_DT_TEXTURES) {
			nModel.isChild = this.isChild;
			nModel.isRiding = this.isRiding;
			nModel.swingProgress = this.swingProgress;
			nModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		} else {
			cModel.isChild = this.isChild;
			cModel.isRiding = this.isRiding;
			cModel.swingProgress = this.swingProgress;
			cModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		if(ConfigValues.USE_DT_TEXTURES) {
			nModel.isChild = this.isChild;
			nModel.isRiding = this.isRiding;
			nModel.swingProgress = this.swingProgress;
			nModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		} else {
			cModel.isChild = this.isChild;
			cModel.isRiding = this.isRiding;
			cModel.swingProgress = this.swingProgress;
			cModel.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		}
	}
	
	

}
