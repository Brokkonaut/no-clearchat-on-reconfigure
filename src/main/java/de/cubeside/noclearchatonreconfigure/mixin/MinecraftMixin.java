package de.cubeside.noclearchatonreconfigure.mixin;

import de.cubeside.noclearchatonreconfigure.plugin.Globals;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Inject(method = "clearClientLevel(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At(value = "HEAD"))
    public void clearClientLevelHead(final CallbackInfo ci) {
        Globals.inClearLevel = true;
    }

    @Inject(method = "clearClientLevel(Lnet/minecraft/client/gui/screens/Screen;)V", at = @At(value = "TAIL"))
    public void clearClientLevelTail(final CallbackInfo ci) {
        Globals.inClearLevel = false;
    }
}
