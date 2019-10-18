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
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.packet.AdvancementUpdateS2CPacket;
import net.minecraft.client.network.packet.BlockActionS2CPacket;
import net.minecraft.client.network.packet.BlockBreakingProgressS2CPacket;
import net.minecraft.client.network.packet.BlockEntityUpdateS2CPacket;
import net.minecraft.client.network.packet.BlockUpdateS2CPacket;
import net.minecraft.client.network.packet.BossBarS2CPacket;
import net.minecraft.client.network.packet.ChatMessageS2CPacket;
import net.minecraft.client.network.packet.ChunkDataS2CPacket;
import net.minecraft.client.network.packet.ChunkDeltaUpdateS2CPacket;
import net.minecraft.client.network.packet.ChunkLoadDistanceS2CPacket;
import net.minecraft.client.network.packet.ChunkRenderDistanceCenterS2CPacket;
import net.minecraft.client.network.packet.CombatEventS2CPacket;
import net.minecraft.client.network.packet.CommandSuggestionsS2CPacket;
import net.minecraft.client.network.packet.CommandTreeS2CPacket;
import net.minecraft.client.network.packet.ConfirmGuiActionS2CPacket;
import net.minecraft.client.network.packet.CooldownUpdateS2CPacket;
import net.minecraft.client.network.packet.CraftFailedResponseS2CPacket;
import net.minecraft.client.network.packet.CustomPayloadS2CPacket;
import net.minecraft.client.network.packet.DifficultyS2CPacket;
import net.minecraft.client.network.packet.DisconnectS2CPacket;
import net.minecraft.client.network.packet.EntitiesDestroyS2CPacket;
import net.minecraft.client.network.packet.EntityAnimationS2CPacket;
import net.minecraft.client.network.packet.EntityAttachS2CPacket;
import net.minecraft.client.network.packet.EntityAttributesS2CPacket;
import net.minecraft.client.network.packet.EntityEquipmentUpdateS2CPacket;
import net.minecraft.client.network.packet.EntityPassengersSetS2CPacket;
import net.minecraft.client.network.packet.EntityPositionS2CPacket;
import net.minecraft.client.network.packet.EntityPotionEffectS2CPacket;
import net.minecraft.client.network.packet.EntityS2CPacket;
import net.minecraft.client.network.packet.EntitySetHeadYawS2CPacket;
import net.minecraft.client.network.packet.EntitySpawnGlobalS2CPacket;
import net.minecraft.client.network.packet.EntitySpawnS2CPacket;
import net.minecraft.client.network.packet.EntityStatusS2CPacket;
import net.minecraft.client.network.packet.EntityTrackerUpdateS2CPacket;
import net.minecraft.client.network.packet.EntityVelocityUpdateS2CPacket;
import net.minecraft.client.network.packet.ExperienceBarUpdateS2CPacket;
import net.minecraft.client.network.packet.ExperienceOrbSpawnS2CPacket;
import net.minecraft.client.network.packet.ExplosionS2CPacket;
import net.minecraft.client.network.packet.GameJoinS2CPacket;
import net.minecraft.client.network.packet.GameStateChangeS2CPacket;
import net.minecraft.client.network.packet.GuiCloseS2CPacket;
import net.minecraft.client.network.packet.GuiOpenS2CPacket;
import net.minecraft.client.network.packet.GuiSlotUpdateS2CPacket;
import net.minecraft.client.network.packet.GuiUpdateS2CPacket;
import net.minecraft.client.network.packet.HealthUpdateS2CPacket;
import net.minecraft.client.network.packet.HeldItemChangeS2CPacket;
import net.minecraft.client.network.packet.InventoryS2CPacket;
import net.minecraft.client.network.packet.ItemPickupAnimationS2CPacket;
import net.minecraft.client.network.packet.KeepAliveS2CPacket;
import net.minecraft.client.network.packet.LightUpdateS2CPacket;
import net.minecraft.client.network.packet.LookAtS2CPacket;
import net.minecraft.client.network.packet.MapUpdateS2CPacket;
import net.minecraft.client.network.packet.MobSpawnS2CPacket;
import net.minecraft.client.network.packet.OpenContainerPacket;
import net.minecraft.client.network.packet.OpenWrittenBookS2CPacket;
import net.minecraft.client.network.packet.PaintingSpawnS2CPacket;
import net.minecraft.client.network.packet.ParticleS2CPacket;
import net.minecraft.client.network.packet.PlaySoundFromEntityS2CPacket;
import net.minecraft.client.network.packet.PlaySoundIdS2CPacket;
import net.minecraft.client.network.packet.PlaySoundS2CPacket;
import net.minecraft.client.network.packet.PlayerAbilitiesS2CPacket;
import net.minecraft.client.network.packet.PlayerActionResponseS2CPacket;
import net.minecraft.client.network.packet.PlayerListHeaderS2CPacket;
import net.minecraft.client.network.packet.PlayerListS2CPacket;
import net.minecraft.client.network.packet.PlayerPositionLookS2CPacket;
import net.minecraft.client.network.packet.PlayerRespawnS2CPacket;
import net.minecraft.client.network.packet.PlayerSpawnPositionS2CPacket;
import net.minecraft.client.network.packet.PlayerSpawnS2CPacket;
import net.minecraft.client.network.packet.RemoveEntityEffectS2CPacket;
import net.minecraft.client.network.packet.ResourcePackSendS2CPacket;
import net.minecraft.client.network.packet.ScoreboardDisplayS2CPacket;
import net.minecraft.client.network.packet.ScoreboardObjectiveUpdateS2CPacket;
import net.minecraft.client.network.packet.ScoreboardPlayerUpdateS2CPacket;
import net.minecraft.client.network.packet.SelectAdvancementTabS2CPacket;
import net.minecraft.client.network.packet.SetCameraEntityS2CPacket;
import net.minecraft.client.network.packet.SetTradeOffersPacket;
import net.minecraft.client.network.packet.SignEditorOpenS2CPacket;
import net.minecraft.client.network.packet.StatisticsS2CPacket;
import net.minecraft.client.network.packet.StopSoundS2CPacket;
import net.minecraft.client.network.packet.SynchronizeRecipesS2CPacket;
import net.minecraft.client.network.packet.SynchronizeTagsS2CPacket;
import net.minecraft.client.network.packet.TagQueryResponseS2CPacket;
import net.minecraft.client.network.packet.TeamS2CPacket;
import net.minecraft.client.network.packet.TitleS2CPacket;
import net.minecraft.client.network.packet.UnloadChunkS2CPacket;
import net.minecraft.client.network.packet.UnlockRecipesS2CPacket;
import net.minecraft.client.network.packet.VehicleMoveS2CPacket;
import net.minecraft.client.network.packet.WorldBorderS2CPacket;
import net.minecraft.client.network.packet.WorldEventS2CPacket;
import net.minecraft.client.network.packet.WorldTimeUpdateS2CPacket;

/**
 * A list of callbacks available for the client play network handler.
 */
// TODO not implemented yet
public final class ClientPlayPacketCallbacks {

  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntitySpawnS2CPacket>> ENTITY_SPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ExperienceOrbSpawnS2CPacket>> EXPERIENCE_ORB_SPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntitySpawnGlobalS2CPacket>> ENTITY_SPAWN_GLOBAL = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, MobSpawnS2CPacket>> MOB_SPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ScoreboardObjectiveUpdateS2CPacket>> SCOREBOARD_OBJECTIVE_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PaintingSpawnS2CPacket>> PAINTING_SPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerSpawnS2CPacket>> PLAYER_SPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityAnimationS2CPacket>> ENTITY_ANIMATION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, StatisticsS2CPacket>> STATISTICS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, UnlockRecipesS2CPacket>> UNLOCK_RECIPES = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, BlockBreakingProgressS2CPacket>> BLOCK_BREAKING_PROGRESS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SignEditorOpenS2CPacket>> SIGN_EDITOR_OPEN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, BlockEntityUpdateS2CPacket>> BLOCK_ENTITY_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, BlockActionS2CPacket>> BLOCK_ACTION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, BlockUpdateS2CPacket>> BLOCK_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ChatMessageS2CPacket>> CHAT_MESSAGE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ChunkDeltaUpdateS2CPacket>> CHUNK_DELTA_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, MapUpdateS2CPacket>> MAP_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ConfirmGuiActionS2CPacket>> CONFIRM_GUI_ACTION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GuiCloseS2CPacket>> GUI_CLOSE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, InventoryS2CPacket>> INVENTORY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GuiOpenS2CPacket>> GUI_OPEN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GuiUpdateS2CPacket>> GUI_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GuiSlotUpdateS2CPacket>> GUI_SLOT_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CustomPayloadS2CPacket>> CUSTOM_PAYLOAD = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, DisconnectS2CPacket>> DISCONNECT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityStatusS2CPacket>> ENTITY_STATUS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityAttachS2CPacket>> ENTITY_ATTACH = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityPassengersSetS2CPacket>> ENTITY_PASSENGERS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ExplosionS2CPacket>> EXPLOSION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GameStateChangeS2CPacket>> GAME_STATE_CHANGE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, KeepAliveS2CPacket>> KEEP_ALIVE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ChunkDataS2CPacket>> CHUNK_DATA = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, UnloadChunkS2CPacket>> UNLOAD_CHUNK = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, WorldEventS2CPacket>> WORLD_EVENT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, GameJoinS2CPacket>> GAME_JOIN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityS2CPacket>> ENTITY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerPositionLookS2CPacket>> PLAYER_POSITION_LOOK = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ParticleS2CPacket>> PARTICLE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerAbilitiesS2CPacket>> PLAYER_ABILITIES = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerListS2CPacket>> PLAYER_LIST = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntitiesDestroyS2CPacket>> ENTITIES_DESTROY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, RemoveEntityEffectS2CPacket>> REMOVE_ENTITY_EFFECT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerRespawnS2CPacket>> PLAYER_RESPAWN = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntitySetHeadYawS2CPacket>> ENTITY_SET_HEAD_YAW = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, HeldItemChangeS2CPacket>> HELD_ITEM_CHANGE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ScoreboardDisplayS2CPacket>> SCOREBOARD_DISPLAY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityTrackerUpdateS2CPacket>> ENTITY_TRACKER_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityVelocityUpdateS2CPacket>> ENTITY_VELOCITY_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityEquipmentUpdateS2CPacket>> ENTITY_EQUIPMENT_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ExperienceBarUpdateS2CPacket>> EXPERIENCE_BAR_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, HealthUpdateS2CPacket>> HEALTH_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, TeamS2CPacket>> TEAM = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ScoreboardPlayerUpdateS2CPacket>> SCOREBOARD_PLAYER_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerSpawnPositionS2CPacket>> PLAYER_SPAWN_POSITION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, WorldTimeUpdateS2CPacket>> WORLD_TIME_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlaySoundS2CPacket>> PLAY_SOUND = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlaySoundFromEntityS2CPacket>> PLAY_SOUND_FROM_ENTITY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlaySoundIdS2CPacket>> PLAY_SOUND_ID = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ItemPickupAnimationS2CPacket>> ITEM_PICKUP_ANIMATION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityPositionS2CPacket>> ENTITY_POSITION = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityAttributesS2CPacket>> ENTITY_ATTRIBUTES = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, EntityPotionEffectS2CPacket>> ENTITY_STATUS_EFFECT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SynchronizeTagsS2CPacket>> SYNCHRONIZE_TAGS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CombatEventS2CPacket>> COMBAT_EVENT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, DifficultyS2CPacket>> DIFFICULTY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SetCameraEntityS2CPacket>> SET_CAMERA_ENTITY = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, WorldBorderS2CPacket>> WORLD_BORDER = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, TitleS2CPacket>> TITLE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerListHeaderS2CPacket>> PLAYER_LIST_HEADER = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ResourcePackSendS2CPacket>> RESOURCE_PACK_SEND = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, BossBarS2CPacket>> BOSS_BAR = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CooldownUpdateS2CPacket>> COOLDOWN_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, VehicleMoveS2CPacket>> VEHICLE_MOVE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, AdvancementUpdateS2CPacket>> ADVANCEMENT_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SelectAdvancementTabS2CPacket>> SELECT_ADVANCEMENT_TAB = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CraftFailedResponseS2CPacket>> CRAFT_FAILED_RESPONSE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CommandTreeS2CPacket>> COMMAND_TREE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, StopSoundS2CPacket>> STOP_SOUND = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, CommandSuggestionsS2CPacket>> COMMAND_SUGGESTIONS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SynchronizeRecipesS2CPacket>> SYNCHRONIZE_RECIPES = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, LookAtS2CPacket>> LOOK_AT = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, TagQueryResponseS2CPacket>> TAG_QUERY_RESPONSE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, LightUpdateS2CPacket>> LIGHT_UPDATE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, OpenWrittenBookS2CPacket>> OPEN_WRITTEN_BOOK = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, OpenContainerPacket>> OPEN_CONTAINER = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, SetTradeOffersPacket>> SET_TRADE_OFFERS = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ChunkLoadDistanceS2CPacket>> CHUNK_LOAD_DISTANCE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, ChunkRenderDistanceCenterS2CPacket>> CHUNK_RENDER_DISTANCE = event();
  public static final Event<PacketCallback<ClientPlayNetworkHandler, PlayerActionResponseS2CPacket>> PLAYER_ACTION_RESPONSE = event();

  private ClientPlayPacketCallbacks() {}
}
