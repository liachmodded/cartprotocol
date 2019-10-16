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

import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;

/**
 * The generic callback interface shared by all packet callbacks.
 *
 * @param <H> the packet listener
 * @param <P> the packet
 */
public interface PacketCallback<H extends PacketListener, P extends Packet<? super H>> {

  /**
   * The receiver method for the packet.
   *
   * @param packet the packet
   * @param listener the packet listener
   * @return {@code true} to prevent default packet logic from executing
   */
  boolean onPacket(P packet, H listener);

}
