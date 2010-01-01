/*
 * Copyright (C) 2010 Wayne Meissner
 *
 * This file is part of jnr-x86asm.
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.kenai.jnr.x86asm;

import static com.kenai.jnr.x86asm.REG.*;
import static com.kenai.jnr.x86asm.SIZE.*;

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
