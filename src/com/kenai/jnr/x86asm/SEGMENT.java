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

/**
 * Segment override prefixes.
 */
public enum SEGMENT {
    SEGMENT_NONE(0), SEGMENT_CS(0x2E), SEGMENT_SS(0x36),
    SEGMENT_DS(0x3E), SEGMENT_ES(0x26), SEGMENT_FS(0x64), SEGMENT_GS(0x64);
    
    private final int prefix;

    SEGMENT(int prefix) {
        this.prefix = prefix;
    }

    public final int prefix() {
        return this.prefix;
    }
}
