package de.cubeside.noclearchatonreconfigure.mixin;

import de.cubeside.noclearchatonreconfigure.plugin.Globals;
import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {
    @Inject(method = "clearMessages(Z)V", at = @At(value = "HEAD"), cancellable = true)
    public void clearMessages(final CallbackInfo ci) {
        if (Globals.inClearLevel) {
            ci.cancel();
        }
    }
}
