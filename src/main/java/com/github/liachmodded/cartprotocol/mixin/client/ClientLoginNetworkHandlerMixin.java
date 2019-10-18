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

import com.github.liachmodded.cartprotocol.api.client.event.ClientLoginPacketCallbacks;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import net.minecraft.client.network.packet.LoginCompressionS2CPacket;
import net.minecraft.client.network.packet.LoginDisconnectS2CPacket;
import net.minecraft.client.network.packet.LoginHelloS2CPacket;
import net.minecraft.client.network.packet.LoginQueryRequestS2CPacket;
import net.minecraft.client.network.packet.LoginSuccessS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientLoginNetworkHandler.class)
public abstract class ClientLoginNetworkHandlerMixin {

  @Inject(method = "onHello", at = @At("HEAD"), cancellable = true)
  public void handleHello(LoginHelloS2CPacket packet, CallbackInfo ci) {
    if (ClientLoginPacketCallbacks.HELLO.invoker().handle(packet, (ClientLoginNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

  @Inject(method = "onLoginSuccess", at = @At("HEAD"), cancellable = true)
  public void handleLoginSuccess(LoginSuccessS2CPacket packet, CallbackInfo ci) {
    if (ClientLoginPacketCallbacks.LOGIN_SUCCESS.invoker().handle(packet, (ClientLoginNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

  @Inject(method = "onDisconnect", at = @At("HEAD"), cancellable = true)
  public void handleDisconnect(LoginDisconnectS2CPacket packet, CallbackInfo ci) {
    if (ClientLoginPacketCallbacks.DISCONNECT.invoker().handle(packet, (ClientLoginNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

  @Inject(method = "onCompression", at = @At("HEAD"), cancellable = true)
  public void handleCompression(LoginCompressionS2CPacket packet, CallbackInfo ci) {
    if (ClientLoginPacketCallbacks.COMPRESSION.invoker().handle(packet, (ClientLoginNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }


  @Inject(method = "onQueryRequest", at = @At("HEAD"), cancellable = true)
  public void handleQueryRequest(LoginQueryRequestS2CPacket packet, CallbackInfo ci) {
    if (ClientLoginPacketCallbacks.QUERY_REQUEST.invoker().handle(packet, (ClientLoginNetworkHandler) (Object) this)) {
      ci.cancel();
    }
  }

}
