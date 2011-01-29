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

/**
 * Segment override prefixes.
 */
@Deprecated
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
