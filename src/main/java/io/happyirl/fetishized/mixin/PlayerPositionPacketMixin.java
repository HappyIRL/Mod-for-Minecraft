package io.happyirl.fetishized.mixin;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import io.happyirl.fetishized.utlis.roundUtil;

@Mixin(PlayerMoveC2SPacket.PositionAndOnGround.class)
public class PlayerPositionPacketMixin
{
	@ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/c2s/play/PlayerMoveC2SPacket;<init>(DDDFFZZZ)V"))
	private static void init(Args args)
	{
		args.set(0, roundUtil.roundDouble(args.get(0)));
		args.set(2, roundUtil.roundDouble(args.get(2)));
	}
}
