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
 *  Condition hint, see @c AsmJit::Serializer::jz() and friends.
 */
public enum HINT {

    /** No hint. */
    HINT_NONE(0),

    /** Condition will be taken (likely). */
    HINT_TAKEN(0x3e),

    /** Condition will be not taken (unlikely). */
    HINT_NOT_TAKEN(0x2e);


    private final int value;
    HINT(int value) {
        this.value = value;
    }

    public final int value() {
        return value;
    }

    public static final HINT valueOf(int value) {
        switch (value) {
            case 0x3e:
                return HINT_TAKEN;
            case 0x2e:
                return HINT_NOT_TAKEN;
            default:
                return HINT_NONE;
        }
    }
}
