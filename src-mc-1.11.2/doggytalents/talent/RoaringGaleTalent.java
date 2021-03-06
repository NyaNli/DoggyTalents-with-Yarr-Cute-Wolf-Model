package doggytalents.talent;

import doggytalents.api.inferface.Talent;
import doggytalents.entity.EntityDog;
import net.minecraft.nbt.NBTTagCompound;

public class RoaringGaleTalent extends Talent {
	
	@Override
	public void onClassCreation(EntityDog dog) {
		dog.objects.put("roarcooldown", 0);
	}
	
	@Override
	public void writeAdditional(EntityDog dog, NBTTagCompound tagCompound) {
		int roarCooldown = (Integer)dog.objects.get("roarcooldown");
		tagCompound.setInteger("roarcooldown", roarCooldown);
	}
	
	@Override
	public void readAdditional(EntityDog dog, NBTTagCompound tagCompound) {
		dog.objects.put("roarcooldown", tagCompound.getInteger("roarcooldown"));
	}
	
	@Override
	public void livingTick(EntityDog dog) {
		int roarCooldown = (Integer)dog.objects.get("roarcooldown");

		if(roarCooldown > 0) {
			roarCooldown--;
			dog.objects.put("roarcooldown", roarCooldown);
			return;
		}
	}
}
