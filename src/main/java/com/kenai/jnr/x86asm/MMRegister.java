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

package com.kenai.jnr.x86asm;

@Deprecated
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
