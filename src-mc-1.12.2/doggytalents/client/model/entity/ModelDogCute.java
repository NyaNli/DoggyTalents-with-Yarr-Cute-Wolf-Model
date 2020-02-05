package doggytalents.client.model.entity;

import doggytalents.entity.EntityDog;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDogCute extends ModelBase {
	private final static String README_0 = "The original author of this model is Yarrmateys";
	private final static String README_1 = "Original class name: yarrmateys.cuteMobModelsRemake.mobs.ModelCMMRWolf";
	public ModelRenderer wolfHeadMain;
	ModelRenderer REar;
	ModelRenderer LEar;
	ModelRenderer HTop;
	ModelRenderer Hood1;
	ModelRenderer Hood2;
	ModelRenderer Head;
	ModelRenderer Neck1;
	ModelRenderer Neck2;
	ModelRenderer RArm;
	ModelRenderer LArm;
	ModelRenderer Body;
	ModelRenderer Skirt1;
	ModelRenderer Skirt2;
	ModelRenderer Tail;
	ModelRenderer RLeg;
	ModelRenderer LLeg;

	public ModelDogCute(float modelSize) {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.REar = new ModelRenderer(this, 26, 0);
		this.REar.addBox(-4.0F, -10.0F, 0.0F, 2, 3, 1, modelSize);
		this.REar.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.REar.setTextureSize(this.textureWidth, this.textureHeight);
		this.REar.mirror = true;
		this.setRotation(this.REar, 0.0F, 0.0F, 0.0F);
		this.LEar = new ModelRenderer(this, 26, 4);
		this.LEar.addBox(2.0F, -10.0F, 0.0F, 2, 3, 1, modelSize);
		this.LEar.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.LEar.setTextureSize(this.textureWidth, this.textureHeight);
		this.LEar.mirror = true;
		this.setRotation(this.LEar, 0.0F, 0.0F, 0.0F);
		this.HTop = new ModelRenderer(this, 0, 28);
		this.HTop.addBox(-3.5F, -8.0F, -3.0F, 7, 1, 6, modelSize);
		this.HTop.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.HTop.setTextureSize(this.textureWidth, this.textureHeight);
		this.HTop.mirror = true;
		this.setRotation(this.HTop, 0.0F, 0.0F, 0.0F);
		this.Hood1 = new ModelRenderer(this, 0, 13);
		this.Hood1.addBox(-4.0F, -7.0F, -3.5F, 8, 8, 7, modelSize);
		this.Hood1.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Hood1.setTextureSize(this.textureWidth, this.textureHeight);
		this.Hood1.mirror = true;
		this.setRotation(this.Hood1, 0.0F, 0.0F, 0.0F);
		this.Hood2 = new ModelRenderer(this, 30, 17);
		this.Hood2.addBox(-5.0F, -5.0F, -3.5F, 10, 5, 6, modelSize);
		this.Hood2.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Hood2.setTextureSize(this.textureWidth, this.textureHeight);
		this.Hood2.mirror = true;
		this.setRotation(this.Hood2, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.addBox(-3.5F, -7.0F, -3.0F, 7, 7, 6, modelSize);
		this.Head.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Head.setTextureSize(this.textureWidth, this.textureHeight);
		this.Head.mirror = true;
		this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
		wolfHeadMain = Head;
		this.Neck1 = new ModelRenderer(this, 26, 8);
		this.Neck1.addBox(-2.5F, 0.0F, -2.5F, 5, 1, 5, modelSize);
		this.Neck1.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Neck1.setTextureSize(this.textureWidth, this.textureHeight);
		this.Neck1.mirror = true;
		this.setRotation(this.Neck1, 0.0F, 0.0F, 0.0F);
		this.Neck2 = new ModelRenderer(this, 42, 28);
		this.Neck2.addBox(-1.5F, -1.0F, -1.5F, 3, 2, 3, modelSize);
		this.Neck2.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Neck2.setTextureSize(this.textureWidth, this.textureHeight);
		this.Neck2.mirror = true;
		this.setRotation(this.Neck2, 0.0F, 0.0F, 0.0F);
		this.RArm = new ModelRenderer(this, 32, 0);
		this.RArm.addBox(-2.0F, -1.0F, -1.0F, 2, 6, 2, modelSize);
		this.RArm.setRotationPoint(-2.5F, 15.0F, 0.0F);
		this.RArm.setTextureSize(this.textureWidth, this.textureHeight);
		this.RArm.mirror = true;
		this.setRotation(this.RArm, 0.0F, 0.0F, 0.0F);
		this.LArm = new ModelRenderer(this, 40, 0);
		this.LArm.addBox(0.0F, -1.0F, -1.0F, 2, 6, 2, modelSize);
		this.LArm.setRotationPoint(2.5F, 15.0F, 0.0F);
		this.LArm.setTextureSize(this.textureWidth, this.textureHeight);
		this.LArm.mirror = true;
		this.setRotation(this.LArm, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 26, 28);
		this.Body.addBox(-2.5F, 0.0F, -1.5F, 5, 5, 3, modelSize);
		this.Body.setRotationPoint(0.0F, 14.0F, 0.0F);
		this.Body.setTextureSize(this.textureWidth, this.textureHeight);
		this.Body.mirror = true;
		this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
		this.Skirt1 = new ModelRenderer(this, 0, 35);
		this.Skirt1.addBox(-3.5F, 0.0F, -2.0F, 7, 2, 4, modelSize);
		this.Skirt1.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.Skirt1.setTextureSize(this.textureWidth, this.textureHeight);
		this.Skirt1.mirror = true;
		this.setRotation(this.Skirt1, 0.0F, 0.0F, 0.0F);
		this.Skirt2 = new ModelRenderer(this, 0, 41);
		this.Skirt2.addBox(-4.0F, 2.0F, -2.5F, 8, 3, 5, modelSize);
		this.Skirt2.setRotationPoint(0.0F, 17.0F, 0.0F);
		this.Skirt2.setTextureSize(this.textureWidth, this.textureHeight);
		this.Skirt2.mirror = true;
		this.setRotation(this.Skirt2, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 48, 7);
		this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2, 7, 2, modelSize);
		this.Tail.setRotationPoint(0.0F, 18.0F, 2.0F);
		this.Tail.setTextureSize(this.textureWidth, this.textureHeight);
		this.Tail.mirror = true;
		this.setRotation(this.Tail, 0.0F, 0.0F, 0.0F);
		this.RLeg = new ModelRenderer(this, 48, 0);
		this.RLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, modelSize);
		this.RLeg.setRotationPoint(-1.5F, 19.0F, 0.0F);
		this.RLeg.setTextureSize(this.textureWidth, this.textureHeight);
		this.RLeg.mirror = true;
		this.setRotation(this.RLeg, 0.0F, 0.0F, 0.0F);
		this.LLeg = new ModelRenderer(this, 56, 0);
		this.LLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, modelSize);
		this.LLeg.setRotationPoint(1.5F, 19.0F, 0.0F);
		this.LLeg.setTextureSize(this.textureWidth, this.textureHeight);
		this.LLeg.mirror = true;
		this.setRotation(this.LLeg, 0.0F, 0.0F, 0.0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		EntityDog entitywolf = (EntityDog) par1EntityLivingBase;
		this.Tail.rotateAngleY = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
		if (entitywolf.isSitting()) {
			this.Head.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.LEar.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.REar.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.HTop.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.Hood1.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.Hood2.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.Neck1.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.Neck2.setRotationPoint(0.0F, 16.0F, 0.0F);
			this.Body.setRotationPoint(0.0F, 17.0F, 0.0F);
			this.RArm.setRotationPoint(-2.5F, 18.0F, 0.0F);
			this.LArm.setRotationPoint(2.5F, 18.0F, 0.0F);
			this.Skirt1.setRotationPoint(0.0F, 20.0F, -0.25F);
			this.Skirt2.setRotationPoint(0.0F, 19.0F, -0.5F);
			this.Tail.setRotationPoint(0.0F, 21.0F, 2.0F);
			this.RLeg.setRotationPoint(-1.5F, 23.0F, 0.0F);
			this.LLeg.setRotationPoint(1.5F, 23.0F, 0.0F);
			this.RLeg.rotateAngleX = 4.712389F;
			this.LLeg.rotateAngleX = 4.712389F;
			this.RArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 0.6F * par3;
			this.RArm.rotateAngleY = 0.0F;
			this.RArm.rotateAngleZ = 0.1F * MathHelper.sin(par4 * 0.1F) + 0.1F;
			this.LArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 0.6F * par3;
			this.LArm.rotateAngleY = 0.0F;
			this.LArm.rotateAngleZ = -0.1F * MathHelper.sin(par4 * 0.1F) - 0.1F;
		} else {
			this.Head.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.LEar.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.REar.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.HTop.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.Hood1.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.Hood2.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.Neck1.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.Neck2.setRotationPoint(0.0F, 13.0F, 0.0F);
			this.Body.setRotationPoint(0.0F, 14.0F, 0.0F);
			this.RArm.setRotationPoint(-2.5F, 15.0F, 0.0F);
			this.LArm.setRotationPoint(2.5F, 15.0F, 0.0F);
			this.Skirt1.setRotationPoint(0.0F, 17.0F, 0.0F);
			this.Skirt2.setRotationPoint(0.0F, 17.0F, 0.0F);
			this.Tail.setRotationPoint(0.0F, 18.0F, 2.0F);
			this.RLeg.setRotationPoint(-1.5F, 19.0F, 0.0F);
			this.LLeg.setRotationPoint(1.5F, 19.0F, 0.0F);
			this.RLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 0.6F * par3;
			this.LLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 0.6F * par3;
			this.RArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F + 3.1415927F) * 0.6F * par3;
			this.RArm.rotateAngleY = 0.0F;
			this.RArm.rotateAngleZ = 0.1F * MathHelper.sin(par4 * 0.1F) + 0.1F;
			this.LArm.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 0.6F * par3;
			this.LArm.rotateAngleY = 0.0F;
			this.LArm.rotateAngleZ = -0.1F * MathHelper.sin(par4 * 0.1F) - 0.1F;
		}

//		this.Head.rotateAngleZ = entitywolf.getInterestedAngle(par4) + entitywolf.getShakeAngle(par4, 0.0F);
//		this.REar.rotateAngleZ = this.Head.rotateAngleZ;
//		this.LEar.rotateAngleZ = this.Head.rotateAngleZ;
//		this.HTop.rotateAngleZ = this.Head.rotateAngleZ;
//		this.Hood1.rotateAngleZ = this.Head.rotateAngleZ;
//		this.Hood2.rotateAngleZ = this.Head.rotateAngleZ;
//		this.Tail.rotateAngleZ = entitywolf.getShakeAngle(par4, -0.2F);
		
		// 2020-02-02 Copy from doggytalents.client.model.entity.ModelDog
		this.Head.rotateAngleZ = entitywolf.getInterestedAngle(par4)
				+ entitywolf.getShakeAngle(par4, 0.0f);
		this.REar.rotateAngleZ = this.Head.rotateAngleZ;
		this.LEar.rotateAngleZ = this.Head.rotateAngleZ;
		this.HTop.rotateAngleZ = this.Head.rotateAngleZ;
		this.Hood1.rotateAngleZ = this.Head.rotateAngleZ;
		this.Hood2.rotateAngleZ = this.Head.rotateAngleZ;
		this.Tail.rotateAngleZ = entitywolf.getShakeAngle(par4, -0.2f);
		if ((entitywolf.isSitting() || (entitywolf.motionX == 0.0 && entitywolf.motionZ == 0.0)) && entitywolf.getHealth() > 1.0f) {
			float wagAngleY = entitywolf.getWagAngle(par4, 0.0f);
			if (wagAngleY == 0.0f) {
				wagAngleY = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
			}
			this.Tail.rotateAngleY = wagAngleY;
		}
		// ===========Copy End
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6,
			Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		EntityDog entitywolf = (EntityDog) par7Entity;
		this.Head.rotateAngleY = par4 / 57.295776F;
		this.Head.rotateAngleX = par5 / 57.295776F;
		this.REar.rotateAngleY = this.Head.rotateAngleY;
		this.REar.rotateAngleX = this.Head.rotateAngleX;
		this.LEar.rotateAngleY = this.Head.rotateAngleY;
		this.LEar.rotateAngleX = this.Head.rotateAngleX;
		this.HTop.rotateAngleY = this.Head.rotateAngleY;
		this.HTop.rotateAngleX = this.Head.rotateAngleX;
		this.Hood1.rotateAngleY = this.Head.rotateAngleY;
		this.Hood1.rotateAngleX = this.Head.rotateAngleX;
		this.Hood2.rotateAngleY = this.Head.rotateAngleY;
		this.Hood2.rotateAngleX = this.Head.rotateAngleX;
		this.Neck1.rotateAngleY = this.Head.rotateAngleY / 4.0F;
		this.Neck2.rotateAngleY = this.Head.rotateAngleY / 2.0F;
		this.Skirt1.rotateAngleX = 0.0F;
		this.Skirt1.rotateAngleY = 0.0F;
		this.Skirt2.rotateAngleX = this.Skirt1.rotateAngleX;
		this.Skirt2.rotateAngleY = this.Skirt1.rotateAngleY;
		this.Tail.rotateAngleX = par3;
		if (!par7Entity.onGround && !par7Entity.isInWater() && !this.isRiding) {
			float varX = -2.317994F;
			float varY = 0.617994F;
			this.RArm.rotateAngleX = varX;
			this.RArm.rotateAngleY = varY;
			this.LArm.rotateAngleX = varX;
			this.LArm.rotateAngleY = -varY;
		} else {
			this.RArm.rotateAngleZ = 0.1F * MathHelper.sin(par3 * 0.1F) + 0.1F;
			this.LArm.rotateAngleZ = -0.1F * MathHelper.sin(par3 * 0.1F) - 0.1F;
			this.RArm.rotateAngleX = 0.0F;
			this.RArm.rotateAngleY = 0.0F;
			this.LArm.rotateAngleX = 0.0F;
			this.LArm.rotateAngleY = 0.0F;
		}

		if (this.isRiding) {
			this.RArm.rotateAngleX += -0.62831855F;
			this.LArm.rotateAngleX += -0.62831855F;
			this.RLeg.rotateAngleX = -1.2566371F;
			this.LLeg.rotateAngleX = -1.2566371F;
			this.RLeg.rotateAngleY = 0.31415927F;
			this.LLeg.rotateAngleY = -0.31415927F;
			this.RLeg.setRotationPoint(-1.5F, 19.0F, 0.0F);
			this.LLeg.setRotationPoint(1.5F, 19.0F, 0.0F);
			this.Skirt1.setRotationPoint(0.0F, 16.0F, -0.25F);
			this.Skirt2.setRotationPoint(0.0F, 15.0F, -0.5F);
		}

		// 2020-02-02 Add: Put up arm when being ridden
		if (entitywolf.isBeingRidden()) { 
			float varX = -2.317994F;
			float varY = 0.617994F;
			this.RArm.rotateAngleX = varX;
			this.RArm.rotateAngleY = varY;
			this.LArm.rotateAngleX = varX;
			this.LArm.rotateAngleY = -varY;
		}
		// ============Add End
	}

	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float scale) {
		EntityDog entitywolf = (EntityDog) par1Entity;
		super.render(par1Entity, par2, par3, par4, par5, par6, scale);
		GlStateManager.pushMatrix();
		this.setRotationAngles(par2, par3, par4, par5, par6, scale, par1Entity);
		// 2020-02-02 Edit: Translate Position when being ridden and resize child model
		if (entitywolf.isBeingRidden())
			GlStateManager.translate(0.0f, 0.0, 10.0 * scale);
//			scale *= 0.75;
		if (this.isChild) {
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			GlStateManager.translate(0.0F, 11.0F * scale, 0.0F);
		}
		this.REar.renderWithRotation(scale);
		this.LEar.renderWithRotation(scale);
		this.HTop.renderWithRotation(scale);
		this.Hood1.renderWithRotation(scale);
		this.Hood2.renderWithRotation(scale);
		this.Head.renderWithRotation(scale);
		if (this.isChild) {
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			GlStateManager.translate(0.0F, 4.0F * scale, 0.0F);
		}
		// =============Edit End
		this.Neck1.render(scale);
		this.Neck2.render(scale);
		this.RArm.render(scale);
		this.LArm.render(scale);
		this.Body.render(scale);
		this.Skirt1.render(scale);
		this.Skirt2.render(scale);
		this.Tail.renderWithRotation(scale);
		this.RLeg.render(scale);
		this.LLeg.render(scale);
		GlStateManager.popMatrix();
	}
}