package doggytalents.lib;

import java.util.HashMap;
import net.minecraft.util.ResourceLocation;

public class ResourceLib {
	public static final ResourceLocation GUI_FOOD_BOWL = getGuiTexturePath("food_bowl.png");
	public static final ResourceLocation GUI_PACK_PUPPY = getGuiTexturePath("pack_puppy.png");
	public static final ResourceLocation GUI_TREAT_BAG = getGuiTexturePath("treat_bag.png");
	public static HashMap<Integer, ResourceLocation> doggyTameSkins = new HashMap(128);
	public static HashMap<Integer, ResourceLocation> doggyFancyCollars = new HashMap(128);
	public static final ResourceLocation MOB_LAYER_CHEST = getMobTexturePath("doggy_chest.png");
	public static final ResourceLocation MOB_LAYER_SADDLE = getMobTexturePath("doggy_saddle.png");
	public static final ResourceLocation MOB_LAYER_WINGS = getMobTexturePath("doggy_wings.png");
	public static final ResourceLocation MOB_LAYER_DOG_COLLAR = getMobTexturePath("doggy_collar.png");
	public static final ResourceLocation MOB_LAYER_DOG_HURT = getMobTexturePath("doggy_hurt.png");
	public static final ResourceLocation MOB_LAYER_RADIO_COLLAR = getMobTexturePath("doggy_radio_collar.png");
	public static final ResourceLocation MOB_LAYER_CAPE = getMobTexturePath("doggy_cape.png");
	public static final ResourceLocation MOB_LAYER_SUNGLASSES = getMobTexturePath("doggy_sunglasses.png");
	public static final ResourceLocation MOB_LAYER_SUNGLASSES_NIGHT = getMobTexturePath("doggy_sunglasses_night.png");
	public static final ResourceLocation MOB_LAYER_CAPE_COLOURED = getMobTexturePath("doggy_cape_coloured.png");
	public static final ResourceLocation MOB_LAYER_LEATHER_JACKET = getMobTexturePath("doggy_leather_jacket.png");
	public static final ResourceLocation MOB_LAYER_CAPE2_1 = getMobTexturePath("doggy_cape1_1.png");
	public static final ResourceLocation MOB_LAYER_ARMOR = getMobTexturePath("doggy_armor.png");
	
	// 2020-02-02 Add Cute Resources
	public static final ResourceLocation MOB_DOG_TAME_CUTE = getMobTexturePath("cute/doggy_tame.png");
	public static final ResourceLocation MOB_DOG_WILD_CUTE = getMobTexturePath("cute/doggy.png");
	public static final ResourceLocation MOB_DOG_SAD_CUTE = getMobTexturePath("cute/doggy_sad.png");
	public static final ResourceLocation MOB_LAYER_CHEST_CUTE = getMobTexturePath("cute/doggy_chest.png");
	public static final ResourceLocation MOB_LAYER_SADDLE_CUTE = getMobTexturePath("cute/doggy_saddle.png");
	public static final ResourceLocation MOB_LAYER_WINGS_CUTE = getMobTexturePath("cute/doggy_wings.png");
	public static final ResourceLocation MOB_LAYER_DOG_COLLAR_CUTE = getMobTexturePath("cute/doggy_collar.png");
	public static final ResourceLocation MOB_LAYER_DOG_HURT_CUTE = getMobTexturePath("cute/doggy_hurt.png");
	public static final ResourceLocation MOB_LAYER_RADIO_COLLAR_CUTE = getMobTexturePath("cute/doggy_radio_collar.png");
	public static final ResourceLocation MOB_LAYER_CAPE_CUTE = getMobTexturePath("cute/doggy_cape.png");
	public static final ResourceLocation MOB_LAYER_SUNGLASSES_CUTE = getMobTexturePath("cute/doggy_sunglasses.png");
	public static final ResourceLocation MOB_LAYER_SUNGLASSES_NIGHT_CUTE = getMobTexturePath("cute/doggy_sunglasses_night.png");
	public static final ResourceLocation MOB_LAYER_CAPE_COLOURED_CUTE = getMobTexturePath("cute/doggy_cape_coloured.png");
	public static final ResourceLocation MOB_LAYER_LEATHER_JACKET_CUTE = getMobTexturePath("cute/doggy_leather_jacket.png");
	public static final ResourceLocation MOB_LAYER_CAPE2_1_CUTE = getMobTexturePath("cute/doggy_cape1_1.png");
	public static final ResourceLocation MOB_LAYER_ARMOR_CUTE = getMobTexturePath("cute/doggy_armor.png");
	// ========Add End

	public static ResourceLocation getTameSkin(int index) {
		if (!doggyTameSkins.containsKey(Integer.valueOf(index))) {
			doggyTameSkins.put(Integer.valueOf(index), getMobTexturePath("dog/doggytex" + index + ".png"));
		}

		return (ResourceLocation) doggyTameSkins.get(Integer.valueOf(index));
	}

	public static ResourceLocation getFancyCollar(int index) {
		if (!doggyFancyCollars.containsKey(Integer.valueOf(index))) {
			if (ConfigValues.USE_DT_TEXTURES)
				doggyFancyCollars.put(Integer.valueOf(index), getMobTexturePath("doggy_collar_" + index + ".png"));
			else
				doggyFancyCollars.put(Integer.valueOf(index), getMobTexturePath("cute/doggy_collar_" + index + ".png"));
		}

		return (ResourceLocation) doggyFancyCollars.get(Integer.valueOf(index));
	}

	public static ResourceLocation getGuiTexturePath(String textureFileName) {
		return get("textures/gui/" + textureFileName);
	}

	public static ResourceLocation getMobTexturePath(String textureFileName) {
		return get("textures/mob/" + textureFileName);
	}

	public static ResourceLocation get(String resourcePathIn) {
		return new ResourceLocation("doggytalents", resourcePathIn);
	}
}