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

public final class XMMRegister extends BaseReg {
    /** Internal cache of xmm registers */
    static final XMMRegister[] cache = new XMMRegister[16];

    static {
        for (int i = 0; i < cache.length; ++i) {
            cache[i] = new XMMRegister(REG.REG_XMM | i, 16);
        }
    }

    private XMMRegister(int code, int size) {
        super(code, size);
    }

    public static final XMMRegister xmm(int idx) {
        if (idx >= 0 && idx < cache.length) {
            return cache[idx];
        }

        throw new IllegalArgumentException("invalid xmm register");
    }
}
