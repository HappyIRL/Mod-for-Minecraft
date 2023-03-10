package io.happyirl.fetishized.mixin;

import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VehicleMoveC2SPacket.class)
public interface VehicleMovePacketAccessor
{
  @Mutable
  @Accessor("x")
  void setX(double x);

  @Mutable
  @Accessor("z")
  void setZ(double z);

}
