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

public final class MMRegister extends BaseReg {
    /** Internal cache of mm registers */
    static final MMRegister[] cache = new MMRegister[8];

    static {
        for (int i = 0; i < cache.length; ++i) {
            cache[i] = new MMRegister(REG.REG_MM | i, 8);
        }
    }

    private MMRegister(int code, int size) {
        super(code, size);
    }

    public static final MMRegister mm(int code) {
        if (code >= 0 && code < cache.length) {
            return cache[code];
        }

        throw new IllegalArgumentException("invalid mm register");
    }
}
