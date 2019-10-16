/*
 * Copyright (c) liachmodded
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.liachmodded.cartprotocol.mixin;

import com.github.liachmodded.cartprotocol.api.event.ServerPlayPacketCallbacks;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.packet.HandSwingC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public abstract class ServerPlayNetworkHandlerMixin {
  
  private static final String ENFORCE_THREAD = "Lnet/minecraft/network/NetworkThreadUtils;forceMainThread(Lnet/minecraft/network/Packet;Lnet/minecraft/network/listener/PacketListener;Lnet/minecraft/server/world/ServerWorld;)V";
  
  @Inject(method = "onHandSwing", at = @At(value = "INVOKE", shift = Shift.AFTER, target = ENFORCE_THREAD), cancellable = true)
  public void handleHandSwing(HandSwingC2SPacket packet, CallbackInfo ci) {
    if (ServerPlayPacketCallbacks.HAND_SWING.invoker().onPacket(packet, (ServerPlayNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

}
