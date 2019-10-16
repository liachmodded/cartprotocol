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
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.network.packet.ChatMessageS2CPacket;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.packet.ButtonClickC2SPacket;
import net.minecraft.server.network.packet.ChatMessageC2SPacket;
import net.minecraft.server.network.packet.ClickWindowC2SPacket;
import net.minecraft.server.network.packet.ClientSettingsC2SPacket;
import net.minecraft.server.network.packet.ClientStatusC2SPacket;
import net.minecraft.server.network.packet.CraftRequestC2SPacket;
import net.minecraft.server.network.packet.GuiActionConfirmC2SPacket;
import net.minecraft.server.network.packet.HandSwingC2SPacket;

public final class ServerPlayPacketCallbacks {
  
  public static final Event<PacketCallback<ServerPlayNetworkHandler, HandSwingC2SPacket>> HAND_SWING = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ChatMessageC2SPacket>> CHAT_MESSAGE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClientStatusC2SPacket>> CLIENT_STATUS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClientSettingsC2SPacket>> CLIENT_SETTINGS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, GuiActionConfirmC2SPacket>> GUI_ACTION_CONFIRM = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ButtonClickC2SPacket>> BUTTON_CLICK = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClickWindowC2SPacket>> CLICK_WINDOW = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, CraftRequestC2SPacket>> CRAFT_REQUEST = event();

  private ServerPlayPacketCallbacks() {}

}
