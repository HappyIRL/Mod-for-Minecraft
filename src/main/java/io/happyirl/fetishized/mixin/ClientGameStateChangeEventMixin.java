package io.happyirl.fetishized.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientGameStateChangeEventMixin
{
    @Inject(method = "onGameStateChange", at = @At("HEAD"), cancellable = true)
    private void injectMethod(GameStateChangeS2CPacket packet, CallbackInfo callbackInfo)
    {
        if(packet.getReason() == GameStateChangeS2CPacket.DEMO_MESSAGE_SHOWN)
            callbackInfo.cancel();
        if(packet.getReason() == GameStateChangeS2CPacket.GAME_WON)
        {
            float f = packet.getValue();
            int i = MathHelper.floor(f + 0.5F);
            if(i == 1)
                callbackInfo.cancel();
        }
    }
}
