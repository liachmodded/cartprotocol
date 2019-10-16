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
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.packet.AdvancementTabC2SPacket;
import net.minecraft.server.network.packet.BoatPaddleStateC2SPacket;
import net.minecraft.server.network.packet.BookUpdateC2SPacket;
import net.minecraft.server.network.packet.ButtonClickC2SPacket;
import net.minecraft.server.network.packet.ChatMessageC2SPacket;
import net.minecraft.server.network.packet.ClickWindowC2SPacket;
import net.minecraft.server.network.packet.ClientCommandC2SPacket;
import net.minecraft.server.network.packet.ClientSettingsC2SPacket;
import net.minecraft.server.network.packet.ClientStatusC2SPacket;
import net.minecraft.server.network.packet.CraftRequestC2SPacket;
import net.minecraft.server.network.packet.CreativeInventoryActionC2SPacket;
import net.minecraft.server.network.packet.CustomPayloadC2SPacket;
import net.minecraft.server.network.packet.GuiActionConfirmC2SPacket;
import net.minecraft.server.network.packet.GuiCloseC2SPacket;
import net.minecraft.server.network.packet.HandSwingC2SPacket;
import net.minecraft.server.network.packet.KeepAliveC2SPacket;
import net.minecraft.server.network.packet.PickFromInventoryC2SPacket;
import net.minecraft.server.network.packet.PlayerActionC2SPacket;
import net.minecraft.server.network.packet.PlayerInputC2SPacket;
import net.minecraft.server.network.packet.PlayerInteractBlockC2SPacket;
import net.minecraft.server.network.packet.PlayerInteractEntityC2SPacket;
import net.minecraft.server.network.packet.PlayerInteractItemC2SPacket;
import net.minecraft.server.network.packet.PlayerMoveC2SPacket;
import net.minecraft.server.network.packet.QueryBlockNbtC2SPacket;
import net.minecraft.server.network.packet.QueryEntityNbtC2SPacket;
import net.minecraft.server.network.packet.RecipeBookDataC2SPacket;
import net.minecraft.server.network.packet.RenameItemC2SPacket;
import net.minecraft.server.network.packet.RequestCommandCompletionsC2SPacket;
import net.minecraft.server.network.packet.ResourcePackStatusC2SPacket;
import net.minecraft.server.network.packet.SelectVillagerTradeC2SPacket;
import net.minecraft.server.network.packet.SpectatorTeleportC2SPacket;
import net.minecraft.server.network.packet.TeleportConfirmC2SPacket;
import net.minecraft.server.network.packet.UpdateBeaconC2SPacket;
import net.minecraft.server.network.packet.UpdateCommandBlockC2SPacket;
import net.minecraft.server.network.packet.UpdateCommandBlockMinecartC2SPacket;
import net.minecraft.server.network.packet.UpdateDifficultyC2SPacket;
import net.minecraft.server.network.packet.UpdateDifficultyLockC2SPacket;
import net.minecraft.server.network.packet.UpdateJigsawC2SPacket;
import net.minecraft.server.network.packet.UpdatePlayerAbilitiesC2SPacket;
import net.minecraft.server.network.packet.UpdateSelectedSlotC2SPacket;
import net.minecraft.server.network.packet.UpdateSignC2SPacket;
import net.minecraft.server.network.packet.UpdateStructureBlockC2SPacket;
import net.minecraft.server.network.packet.VehicleMoveC2SPacket;

/**
 * A list of callbacks available for the server play network handler.
 */
public final class ServerPlayPacketCallbacks {

  public static final Event<PacketCallback<ServerPlayNetworkHandler, HandSwingC2SPacket>> HAND_SWING = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ChatMessageC2SPacket>> CHAT_MESSAGE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClientStatusC2SPacket>> CLIENT_STATUS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClientSettingsC2SPacket>> CLIENT_SETTINGS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, GuiActionConfirmC2SPacket>> GUI_ACTION_CONFIRM = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ButtonClickC2SPacket>> BUTTON_CLICK = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClickWindowC2SPacket>> CLICK_WINDOW = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, CraftRequestC2SPacket>> CRAFT_REQUEST = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, GuiCloseC2SPacket>> GUI_CLOSE = event();
  /** <b>Warning: this event is fired off-thread!</b> */
  public static final Event<PacketCallback<ServerPlayNetworkHandler, CustomPayloadC2SPacket>> CUSTOM_PAYLOAD = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerInteractEntityC2SPacket>> PLAYER_INTERACT_ENTITY = event();
  /** <b>Warning: this event is fired off-thread!</b> */
  public static final Event<PacketCallback<ServerPlayNetworkHandler, KeepAliveC2SPacket>> KEEP_ALIVE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerMoveC2SPacket>> PLAYER_MOVE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdatePlayerAbilitiesC2SPacket>> UPDATE_PLAYER_ABILITIES = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerActionC2SPacket>> PLAYER_ACTION = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ClientCommandC2SPacket>> CLIENT_COMMAND = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerInputC2SPacket>> PLAYER_INPUT = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateSelectedSlotC2SPacket>> UPDATE_SELECTED_SLOT = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, CreativeInventoryActionC2SPacket>> CREATIVE_INVENTORY_ACTION = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateSignC2SPacket>> UPDATE_SIGN = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerInteractBlockC2SPacket>> PLAYER_INTERACT_BLOCK = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PlayerInteractItemC2SPacket>> PLAYER_INTERACT_ITEM = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, SpectatorTeleportC2SPacket>> SPECTATOR_TELEPORT = event();
  /** <b>Warning: this event is fired off-thread!</b> */
  public static final Event<PacketCallback<ServerPlayNetworkHandler, ResourcePackStatusC2SPacket>> RESOURCE_PACK_STATUS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, BoatPaddleStateC2SPacket>> BOAT_PADDLE_STATE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, VehicleMoveC2SPacket>> VEHICLE_MOVE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, TeleportConfirmC2SPacket>> TELEPORT_CONFIRM = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, RecipeBookDataC2SPacket>> RECIPE_BOOK_DATA = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, AdvancementTabC2SPacket>> ADVANCEMENT_TAB = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, RequestCommandCompletionsC2SPacket>> REQUEST_COMMAND_COMPLETIONS = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateCommandBlockC2SPacket>> UPDATE_COMMAND_BLOCK = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateCommandBlockMinecartC2SPacket>> UPDATE_COMMAND_BLOCK_MINECART = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, PickFromInventoryC2SPacket>> PICK_FROM_INVENTORY = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, RenameItemC2SPacket>> RENAME_ITEM = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateBeaconC2SPacket>> UPDATE_BEACON = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateStructureBlockC2SPacket>> UPDATE_STRUCTURE_BLOCK = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, SelectVillagerTradeC2SPacket>> SELECT_VILLAGER_TRADE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, BookUpdateC2SPacket>> BOOK_UPDATE = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, QueryEntityNbtC2SPacket>> QUERY_ENTITY_NBT = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, QueryBlockNbtC2SPacket>> QUERY_BLOCK_NBT = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateJigsawC2SPacket>> UPDATE_JIGSAW = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateDifficultyC2SPacket>> UPDATE_DIFFICULTY = event();
  public static final Event<PacketCallback<ServerPlayNetworkHandler, UpdateDifficultyLockC2SPacket>> UPDATE_DIFFICULTY_LOCK = event();

  private ServerPlayPacketCallbacks() {}

}
