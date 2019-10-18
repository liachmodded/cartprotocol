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
package com.github.liachmodded.cartprotocol.api.client.event;

import static com.github.liachmodded.cartprotocol.api.event.EventTools.event;

import com.github.liachmodded.cartprotocol.api.event.PacketCallback;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.network.ClientLoginNetworkHandler;
import net.minecraft.client.network.packet.LoginCompressionS2CPacket;
import net.minecraft.client.network.packet.LoginDisconnectS2CPacket;
import net.minecraft.client.network.packet.LoginHelloS2CPacket;
import net.minecraft.client.network.packet.LoginQueryRequestS2CPacket;
import net.minecraft.client.network.packet.LoginSuccessS2CPacket;
import net.minecraft.client.network.packet.QueryPongS2CPacket;
import net.minecraft.client.network.packet.QueryResponseS2CPacket;
import net.minecraft.network.listener.ClientQueryPacketListener;

/**
 * A list of callbacks available for the client query network handler.
 * 
 * <p>Because the concrete implementation of the query packet listener is an anonymous class, the
 * interface is exposed in the packet callback instead.
 *
 * <p><b>Note: All these events are fired off-thread!</b>
 */
public final class ClientQueryPacketCallbacks {

  public static final Event<PacketCallback<ClientQueryPacketListener, QueryResponseS2CPacket>> RESPONSE = event();
  public static final Event<PacketCallback<ClientQueryPacketListener, QueryPongS2CPacket>> PONG = event();

  private ClientQueryPacketCallbacks() {}
}
