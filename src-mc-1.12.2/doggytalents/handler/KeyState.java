package doggytalents.handler;

import java.util.HashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;

import doggytalents.ModItems;
import doggytalents.base.ObjectLib;
import doggytalents.entity.EntityDog;
import doggytalents.network.PacketDispatcher;
import doggytalents.network.packet.client.CommandMessage;
import doggytalents.network.packet.client.DogJumpMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 **/
public class KeyState {
	
    public static final KeyBinding come = new KeyBinding("doggytalents.key.come", Keyboard.KEY_UP, "doggytalents.key.category");
    public static final KeyBinding stay = new KeyBinding("doggytalents.key.stay", Keyboard.KEY_DOWN, "doggytalents.key.category");
    public static final KeyBinding ok = new KeyBinding("doggytalents.key.ok", Keyboard.KEY_LEFT, "doggytalents.key.category");
    public static final KeyBinding heel = new KeyBinding("doggytalents.key.heel", Keyboard.KEY_RIGHT, "doggytalents.key.category");
    public static final KeyBinding[] keyBindings = new KeyBinding[] {come, stay, ok, heel, Minecraft.getMinecraft().gameSettings.keyBindJump};
    
   	private HashMap<KeyBinding, Boolean> keyState = new HashMap<KeyBinding, Boolean>();
    private Minecraft mc = Minecraft.getMinecraft();
    
    
    @SubscribeEvent
    public void keyEvent(ClientTickEvent event) {
    	this.keyTick(event.phase == Phase.END);
    }
    
    private void keyTick(boolean tickEnd) {
    	for(KeyBinding kb : keyBindings) {
	        if(kb.isKeyDown()) {
	            if (!tickEnd && (!this.keyState.containsKey(kb) || !this.keyState.get(kb))) {
	            	this.keyState.put(kb, true);
	            	//Key Pressed
	            	EntityPlayer player = FMLClientHandler.instance().getClientPlayerEntity();
	            	
	            	if(kb == mc.gameSettings.keyBindJump) {
	            		if(ObjectLib.BRIDGE.getRidingEntity(player) instanceof EntityDog && mc.currentScreen == null) {
	            			EntityDog dog = (EntityDog)ObjectLib.BRIDGE.getRidingEntity(player);
	
	            			DogJumpMessage jumpMessage = new DogJumpMessage(dog.getEntityId());
	            			jumpMessage.process(player, Side.CLIENT);
	            			PacketDispatcher.sendToServer(jumpMessage);
	            		}
	            	}
	            	else if(FMLClientHandler.instance().getClient().inGameHasFocus && player != null) {
	            		
	            		List<ItemStack> heldStacks = ObjectLib.BRIDGE.getHeldItems(player);
	            		
	            		for(ItemStack heldStack : heldStacks) {
	            			if(ObjectLib.STACK_UTIL.isEmpty(heldStack) || heldStack.getItem() != ModItems.COMMAND_EMBLEM) continue;
		            	    int command = -1;
		            	    
		                	if(kb == come) {
		                		command = 1;
		                	}
		                	else if(kb == stay) {
		                		command = 2;
		                	}
		                	else if(kb == ok) {
		                		command = 3;
		                	}
		                	else if(kb == heel) {
		                		command = 4;
		                	}
	
		                	if(command != -1)
		                		PacketDispatcher.sendToServer(new CommandMessage(command));
		                	break;
	            		}
	               }
	            }
	            else if(!tickEnd) {
	            	//Key Released
	            	
	            }
	        }
	        else {
	        	this.keyState.put(kb, false);
	        }
    	}
    }
}