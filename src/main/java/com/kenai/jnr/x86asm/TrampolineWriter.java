//
// Copyright (C) 2010 Wayne Meissner
// Copyright (c) 2008-2009, Petr Kobalicek <kobalicek.petr@gmail.com>
//
// Permission is hereby granted, free of charge, to any person
// obtaining a copy of this software and associated documentation
// files (the "Software"), to deal in the Software without
// restriction, including without limitation the rights to use,
// copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following
// conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
// OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
// HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
// WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
// OTHER DEALINGS IN THE SOFTWARE.

package com.kenai.jnr.x86asm;

import java.nio.ByteBuffer;

/**
 * Class used to determine size of trampoline and as trampoline writer.
 */
@Deprecated
final class TrampolineWriter {
    // Size of trampoline

    public static final int TRAMPOLINE_JMP = 6;
    public static final int TRAMPOLINE_ADDR = 8;
    public static final int TRAMPOLINE_SIZE = TRAMPOLINE_JMP + TRAMPOLINE_ADDR;

    // Write trampoline into code at address @a code that will jump to @a target.
    static void writeTrampoline(ByteBuffer buf, long target) {
        // Jmp.
        buf.put((byte) 0xFF);

        // ModM (RIP addressing).
        buf.put((byte) 0x25);
        // Offset (zero).
        buf.putInt(0);
        // Absolute address.
        buf.putLong(target);
    }
}
