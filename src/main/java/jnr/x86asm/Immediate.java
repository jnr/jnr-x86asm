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

package jnr.x86asm;

/**
 *
 */
public final class Immediate extends Operand {
    private final long value;
    private final boolean isUnsigned;
    private final RELOC_MODE relocMode;

    public Immediate(long value, boolean isUnsigned) {
        super(OP.OP_IMM, 0);
        this.value = value;
        this.isUnsigned = isUnsigned;
        this.relocMode = RELOC_MODE.RELOC_NONE;
    }

    public long value() {
        return value;
    }

    public final byte byteValue() {
        return (byte) value;
    }

    public final short shortValue() {
        return (short) value;
    }

    public final int intValue() {
        return (int) value;
    }

    public final long longValue() {
        return value;
    }

    /** Return true if immediate is unsigned value. */
    public final boolean isUnsigned() {
        return isUnsigned;
    }

    /** Return relocation mode. */
    RELOC_MODE relocMode() {
        return relocMode;
    }

    /**
     * Internal cache of common native long values
     */
    private static final class Cache {
        private Cache() {}

        static final Immediate[] cache = new Immediate[256];

        static {
            for (int i = 0; i < cache.length; ++i) {
                cache[i] = new Immediate(i - 128, false);
            }
        }

    }

    public static final Immediate imm(long value) {
        return value >= -128 && value <= 127
            ? Cache.cache[128 + (int) value] : new Immediate(value, false);
    }

    public static final Immediate uimm(long value) {
        return new Immediate(value, true);
    }
}
