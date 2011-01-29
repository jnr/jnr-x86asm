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
public final class Util {
    private Util() {
    }
    
    /** Returns @c true if a given integer @a x is signed 8 bit integer */
    static final boolean isInt8(long x) {
        return x >= -128 && x <= 127;
    }
    /** Returns @c true if a given integer @a x is unsigned 8 bit integer */
    static final boolean isUInt8(long x) {
        return x >= 0 && x <= 255;
    }

    /** Returns @c true if a given integer @a x is signed 16 bit integer */
    static final boolean isInt16(long x) {
        return x >= -32768 && x <= 32767;
    }

    /** Returns @c true if a given integer @a x is unsigned 16 bit integer */
    static final boolean isUInt16(long x) {
        return x >= 0 && x <= 65535;
    }

    /** Returns @c true if a given integer @a x is signed 32 bit integer */
    static final boolean isInt32(long x) {
        return x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE;
    }

    /** Returns @c true if a given integer @a x is unsigned 32 bit integer */
    static final boolean isUInt32(long x) {
        return x >= 0 && x <= 0xffffffffL;
    }
}
