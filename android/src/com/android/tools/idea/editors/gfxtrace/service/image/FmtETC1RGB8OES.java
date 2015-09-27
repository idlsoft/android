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
package com.android.tools.idea.editors.gfxtrace.service.image;

import com.android.tools.rpclib.binary.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

final public class FmtETC1RGB8OES extends Format {
  //<<<Start:Java.ClassBody:1>>>

  // Constructs a default-initialized {@link FmtETC1RGB8OES}.
  public FmtETC1RGB8OES() {}


  @Override @NotNull
  public BinaryClass klass() { return Klass.INSTANCE; }

  private static final byte[] IDBytes = {116, 86, 77, -41, 59, 54, 127, -65, 89, -75, 52, -69, -104, 8, 32, 124, 97, 25, 76, 0, };
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
    public BinaryObject create() { return new FmtETC1RGB8OES(); }

    @Override
    public void encode(@NotNull Encoder e, BinaryObject obj) throws IOException {
      FmtETC1RGB8OES o = (FmtETC1RGB8OES)obj;
    }

    @Override
    public void decode(@NotNull Decoder d, BinaryObject obj) throws IOException {
      FmtETC1RGB8OES o = (FmtETC1RGB8OES)obj;
    }
    //<<<End:Java.KlassBody:2>>>
  }
}
