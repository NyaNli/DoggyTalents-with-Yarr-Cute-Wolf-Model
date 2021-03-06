package doggytalents.addon.botania;

import doggytalents.addon.AddonEvent;
import doggytalents.addon.AddonManager;
import doggytalents.block.DogBedRegistry;
import doggytalents.lib.ConfigValues;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author ProPercivalalb
 */
public class BotaniaAddon {

    @SubscribeEvent
    public void onPost(AddonEvent.Post event) {
        if(!AddonManager.areModsLoaded(BotaniaLib.MOD_ID) || !ConfigValues.MOD_BED_STUFF)
            return;
        
        Block planks1 = Block.getBlockFromName(BotaniaLib.ITEM_NAME_1);
        Block planks2 = Block.getBlockFromName(BotaniaLib.ITEM_NAME_2);
        Block planks3 = Block.getBlockFromName(BotaniaLib.ITEM_NAME_3);

        DogBedRegistry.CASINGS.registerMaterial(planks1, 0, new ResourceLocation(BotaniaLib.TEXTURE_LOCATION + "shimmerwoodplanks"));
        DogBedRegistry.CASINGS.registerMaterial(planks2, 1, new ResourceLocation(BotaniaLib.TEXTURE_LOCATION + "livingwood1"));
        DogBedRegistry.CASINGS.registerMaterial(planks2, 2, new ResourceLocation(BotaniaLib.TEXTURE_LOCATION + "livingwood2"));
        DogBedRegistry.CASINGS.registerMaterial(planks3, 1, new ResourceLocation(BotaniaLib.TEXTURE_LOCATION + "dreamwood1"));
        DogBedRegistry.CASINGS.registerMaterial(planks3, 2, new ResourceLocation(BotaniaLib.TEXTURE_LOCATION + "dreamwood2"));
    }
}
