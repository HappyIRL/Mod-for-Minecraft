package io.happyirl.fetishized.mixin;

import io.happyirl.fetishized.utlis.roundUtil;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class VehicleMoveEventPacketMixin
{
    @Inject(method = "sendPacket", at = @At("HEAD"))
    private void injectMethod(Packet<?> packet, CallbackInfo callbackInfo)
    {
        if(packet instanceof VehicleMoveC2SPacket vehicleMoveC2SPacket)
        {
            VehicleMovePacketAccessor accessor = (VehicleMovePacketAccessor) packet;
            accessor.setX(roundUtil.roundDouble(vehicleMoveC2SPacket.getX()));
            accessor.setZ(roundUtil.roundDouble(vehicleMoveC2SPacket.getZ()));
        }
    }
}
