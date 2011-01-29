//
// Copyright (C) 2010 Wayne Meissner
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

import static jnr.x86asm.REG.*;
import static jnr.x86asm.SIZE.*;

public final class Register extends BaseReg {
    private static final Register[] gpb = new Register[16];
    private static final Register[] gpw = new Register[16];
    private static final Register[] gpd = new Register[16];
    private static final Register[] gpq = new Register[16];

    static {
        for (int i = 0; i < 16; ++i) {
            gpb[i] = new Register(REG_GPB | i, SIZE_BYTE);
            gpw[i] = new Register(REG_GPW | i, SIZE_WORD);
            gpd[i] = new Register(REG_GPD | i, SIZE_DWORD);
            gpq[i] = new Register(REG_GPQ | i, SIZE_QWORD);
        }
    }

    Register(int code, int size) {
        super(code, size);
    }


    public static final Register gpr(int reg) {

        switch (reg & REGTYPE_MASK) {
            case REG_GPB:
                return gpb[reg & REGCODE_MASK];

            case REG_GPW:
                return gpw[reg & REGCODE_MASK];

            case REG_GPD:
                return gpd[reg & REGCODE_MASK];

            case REG_GPQ:
                return gpq[reg & REGCODE_MASK];
        }

        throw new IllegalArgumentException("invalid register 0x" + Integer.toHexString(reg));
    }

    private static final Register gpr(Register[] cache, int idx) {
        if (idx >= 0 && idx < 16) {
            return cache[idx];
        }

        throw new IllegalArgumentException("invalid register index " + idx);
    }

    public static final Register gpb(int idx) {
        return gpr(gpb, idx);
    }

    public static final Register gpw(int idx) {
        return gpr(gpw, idx);
    }

    public static final Register gpd(int idx) {
        return gpr(gpd, idx);
    }

    public static final Register gpq(int idx) {
        return gpr(gpq, idx);
    }
}
