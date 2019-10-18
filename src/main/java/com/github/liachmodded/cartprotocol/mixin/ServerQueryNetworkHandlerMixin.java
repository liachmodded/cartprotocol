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

import com.github.liachmodded.cartprotocol.api.event.ServerQueryPacketCallbacks;
import net.minecraft.server.network.ServerQueryNetworkHandler;
import net.minecraft.server.network.packet.QueryPingC2SPacket;
import net.minecraft.server.network.packet.QueryRequestC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerQueryNetworkHandler.class)
public abstract class ServerQueryNetworkHandlerMixin {

  @Inject(method = "onPing", at = @At("HEAD"), cancellable = true)
  public void handlePing(QueryPingC2SPacket packet, CallbackInfo ci) {
    if (ServerQueryPacketCallbacks.PING.invoker().handle(packet, (ServerQueryNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

  @Inject(method = "onRequest", at = @At("HEAD"), cancellable = true)
  public void handleRequest(QueryRequestC2SPacket packet, CallbackInfo ci) {
    if (ServerQueryPacketCallbacks.REQUEST.invoker().handle(packet, (ServerQueryNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

}
