package de.cubeside.noclearchatonreconfigure.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "onDisconnected()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/DebugScreenOverlay;reset()V", shift = At.Shift.AFTER), cancellable = true)
    public void onDisconnectedCancel(final CallbackInfo ci) {
        if (this.minecraft.getConnection() == null || this.minecraft.getConnection().getLevel() != null) {
            ci.cancel();
        }
    }
}
