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

@Deprecated
public class OperandFlags {
    public static final int // x86
        O_G8          = 0x01,
        O_G16         = 0x02,
        O_G32         = 0x04,
        O_G64         = 0x08,
        O_MEM         = 0x40,
        O_IMM         = 0x80,

        O_G8_16_32_64 = O_G64  | O_G32  | O_G16  | O_G8,
        O_G16_32_64   = O_G64  | O_G32  | O_G16,
        O_G32_64      = O_G64  | O_G32,

        // x87
        O_FM_1        = 0x01,
        O_FM_2        = 0x02,
        O_FM_4        = 0x04,
        O_FM_8        = 0x08,
        O_FM_10       = 0x10,

        O_FM_2_4      = O_FM_2 | O_FM_4,
        O_FM_2_4_8    = O_FM_2 | O_FM_4 | O_FM_8,
        O_FM_4_8      = O_FM_4 | O_FM_8,
        O_FM_4_8_10   = O_FM_4 | O_FM_8 | O_FM_10,

        // mm|xmm
        O_NOREX       = 0x01, // Used by MMX/SSE instructions, O_G8 is never used for them
        O_MM          = 0x10,
        O_XMM         = 0x20,

        O_MM_MEM      = O_MM   | O_MEM,
        O_XMM_MEM     = O_XMM  | O_MEM,
        O_MM_XMM      = O_MM   | O_XMM,
        O_MM_XMM_MEM  = O_MM   | O_XMM  | O_MEM;
}
