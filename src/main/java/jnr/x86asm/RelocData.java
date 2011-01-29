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
 * Reloc to absolute address data
 */
class RelocData {

    static enum Type {

        ABSOLUTE_TO_ABSOLUTE,
        RELATIVE_TO_ABSOLUTE,
        ABSOLUTE_TO_RELATIVE,
        ABSOLUTE_TO_RELATIVE_TRAMPOLINE;
    };
    
    /** Type of relocation. */
    final Type type;
    
    /** Size of relocation (4 or 8 bytes). */
    final int size;
    
    /** Offset from code begin address (in the emitted code data stream). */
    final int offset;
    
    /** Relative displacement or absolute address. */
    final long destination;

    public RelocData(Type type, int size, int offset, long destination) {
        this.type = type;
        this.size = size;
        this.offset = offset;
        this.destination = destination;
    }
}
