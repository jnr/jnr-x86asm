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

import static jnr.x86asm.REG.*;
import static jnr.x86asm.SEGMENT.*;

/**
 *
 */
public final class Mem extends Operand {
    //! @brief Base register index, see @c REG.
    private final int base;
    //! @brief Index register index, see @c REG.
    private final int index;
    //! @brief Index register shift (0 to 3 included).
    private final int shift;
    //! @brief Segment override prefix, see @c AsmJit::SEGMENT.
    private final SEGMENT segmentPrefix;
    
    private final Label label;
    private final long target;

    private final long displacement;

    
    Mem(Label label, long displacement, int size) {
        this(NO_REG, NO_REG, 0, SEGMENT_NONE, label, 0, displacement, size);
    }

    Mem(Register base, long displacement, int size) {
        this(base.index(), NO_REG, 0, SEGMENT_NONE, null, 0, displacement, size);
    }

    Mem(Register base, Register index, int shift, long displacement, int size) {
        this(base.index(), index.index(), shift, SEGMENT_NONE, null, 0, displacement, size);
    }

    Mem(Label label, Register index, int shift, long disp, int ptrSize) {
        this(0, index.index(), shift, SEGMENT_NONE, label, 0, disp, ptrSize);
    }

    Mem(long target, long disp, SEGMENT segmentPrefix, int ptrSize) {
        this(NO_REG, NO_REG, 0, segmentPrefix, null, target, disp, ptrSize);
    }

    Mem(long target, Register index, int shift, SEGMENT segmentPrefix, long disp, int ptrSize) {
        this(NO_REG, index.index(), shift, segmentPrefix, null, target, disp, ptrSize);
    }
    
    private Mem(int base, int index, int shift, SEGMENT segmentPrefix, Label label, long target, long displacement, int size) {
        super(OP.OP_MEM, size);

        assert(shift <= 3);

        this.base = base;
        this.index = index;
        this.shift = shift;
        this.segmentPrefix = segmentPrefix;
        this.label = label;
        this.target = target;
        this.displacement = displacement;
    }

    public final boolean hasLabel() {
        return label != null;
    }

    //! @brief Return if address has base register.
    public final boolean hasBase() {
        return base != NO_REG;
    }

    //! @brief Return if address has index register.
    boolean hasIndex() {
        return index != NO_REG;
    }

    public final SEGMENT segmentPrefix() {
        return segmentPrefix;
    }

    public final int base() {
        return base;
    }


    public final long displacement() {
        return displacement;
    }

    public final int index() {
        return index;
    }

    public final Label label() {
        return label;
    }

    public final int shift() {
        return shift;
    }

    public final long target() {
        return target;
    }

}
