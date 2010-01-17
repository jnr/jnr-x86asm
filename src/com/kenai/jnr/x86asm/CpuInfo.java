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
 * Information about target CPU
 */
public class CpuInfo {

    final Vendor vendor;
    final int family;
    
    public enum Vendor {
        INTEL,
        AMD,
        GENERIC;
    }

    public static final CpuInfo GENERIC = new CpuInfo(Vendor.GENERIC, 0);

    public CpuInfo(Vendor vendor, int family) {
        this.vendor = vendor;
        this.family = family;
    }
}
