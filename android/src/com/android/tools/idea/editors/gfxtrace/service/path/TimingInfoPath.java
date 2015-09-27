/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * THIS FILE WAS GENERATED BY codergen. EDIT WITH CARE.
 */
package com.android.tools.idea.editors.gfxtrace.service.path;

import com.android.tools.rpclib.binary.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class TimingInfoPath extends Path {
  @Override
  public StringBuilder stringPath(StringBuilder builder) {
    return builder.append("TimingInfo(").append(myID).append(")");
  }

  //<<<Start:Java.ClassBody:1>>>
  private BinaryID myID;

  // Constructs a default-initialized {@link TimingInfoPath}.
  public TimingInfoPath() {}


  public BinaryID getID() {
    return myID;
  }

  public TimingInfoPath setID(BinaryID v) {
    myID = v;
    return this;
  }

  @Override @NotNull
  public BinaryClass klass() { return Klass.INSTANCE; }

  private static final byte[] IDBytes = {21, -24, 91, -97, 127, -43, -87, 33, 84, -104, 127, -71, 92, 61, 124, -62, 71, -47, 38, 90, };
  public static final BinaryID ID = new BinaryID(IDBytes);

  static {
    Namespace.register(ID, Klass.INSTANCE);
  }
  public static void register() {}
  //<<<End:Java.ClassBody:1>>>
  public enum Klass implements BinaryClass {
    //<<<Start:Java.KlassBody:2>>>
    INSTANCE;

    @Override @NotNull
    public BinaryID id() { return ID; }

    @Override @NotNull
    public BinaryObject create() { return new TimingInfoPath(); }

    @Override
    public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
      TimingInfoPath o = (TimingInfoPath)obj;
      e.id(o.myID);
    }

    @Override
    public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
      TimingInfoPath o = (TimingInfoPath)obj;
      o.myID = d.id();
    }
    //<<<End:Java.KlassBody:2>>>
  }
}
