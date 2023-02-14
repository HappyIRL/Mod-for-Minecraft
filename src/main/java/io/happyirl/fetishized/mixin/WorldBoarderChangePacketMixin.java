package io.happyirl.fetishized.mixin;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class WorldBoarderChangePacketMixin
{
    @Inject(method = "onWorldBorderInitialize", at = @At("HEAD"), cancellable = true)
    private void injectMethod(WorldBorderInitializeS2CPacket packet, CallbackInfo callbackInfo)
    {
        if(packet.getSize() == 30)
            callbackInfo.cancel();
    }
}
