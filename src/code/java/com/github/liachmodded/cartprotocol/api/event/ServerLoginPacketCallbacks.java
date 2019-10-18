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
package com.github.liachmodded.cartprotocol.api.event;

import static com.github.liachmodded.cartprotocol.api.event.EventTools.event;

import net.fabricmc.fabric.api.event.Event;
import net.minecraft.server.network.ServerLoginNetworkHandler;
import net.minecraft.server.network.packet.LoginHelloC2SPacket;
import net.minecraft.server.network.packet.LoginKeyC2SPacket;
import net.minecraft.server.network.packet.LoginQueryResponseC2SPacket;

/**
 * A list of callbacks available for the server login network handler.
 *
 * <p><b>Note: All these events are fired off-thread!</b>
 */
public final class ServerLoginPacketCallbacks {

  public static final Event<PacketCallback<ServerLoginNetworkHandler, LoginHelloC2SPacket>> HELLO = event();
  public static final Event<PacketCallback<ServerLoginNetworkHandler, LoginKeyC2SPacket>> KEY = event();
  public static final Event<PacketCallback<ServerLoginNetworkHandler, LoginQueryResponseC2SPacket>> QUERY_RESPONSE = event();

  private ServerLoginPacketCallbacks() {}
}
