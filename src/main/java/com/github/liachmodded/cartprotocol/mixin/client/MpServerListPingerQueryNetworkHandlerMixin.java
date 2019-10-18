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
package com.github.liachmodded.cartprotocol.mixin.client;

import com.github.liachmodded.cartprotocol.api.client.event.ClientQueryPacketCallbacks;
import net.minecraft.client.network.packet.QueryPongS2CPacket;
import net.minecraft.client.network.packet.QueryResponseS2CPacket;
import net.minecraft.network.listener.ClientQueryPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net/minecraft/client/network/MultiplayerServerListPinger$1")
public abstract class MpServerListPingerQueryNetworkHandlerMixin {

  @Inject(method = "onResponse", at = @At("HEAD"), cancellable = true)
  public void handleResponse(QueryResponseS2CPacket packet, CallbackInfo ci) {
    if (ClientQueryPacketCallbacks.RESPONSE.invoker().handle(packet, (ClientQueryPacketListener) this)) {
      ci.cancel();
    }
  }

  @Inject(method = "onPong", at = @At("HEAD"), cancellable = true)
  public void handlePong(QueryPongS2CPacket packet, CallbackInfo ci) {
    if (ClientQueryPacketCallbacks.PONG.invoker().handle(packet, (ClientQueryPacketListener) this)) {
      ci.cancel();
    }
  }

}
