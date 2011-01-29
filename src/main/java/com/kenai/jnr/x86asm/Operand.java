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

import static com.kenai.jnr.x86asm.OP.*;

@Deprecated
public class Operand {
    private final int op;
    private final int size;
    
    public Operand(int op, int size) {
        this.op = op;
        this.size = size;
    }

    
    /** Return type of operand, see @c OP. */
    public int op() {
        return op;
    }

    public int size() {
        return size;
    }

    /** Return @c true if operand is none (@c OP_NONE). */
    public boolean isNone() {
        return op() == OP_NONE;
    }

    /** Return @c true if operand is any (general purpose, mmx or sse) register (@c OP_REG). */
    public boolean isReg() {
        return op() == OP_REG;
    }

    /** Return @c true if operand is memory address (@c OP_MEM). */
    public boolean isMem() {
        return op() == OP_MEM;
    }

    /** Return @c true if operand is immediate (@c OP_IMM). */
    public boolean isImm() {
        return op() == OP_IMM;
    }

    /** Return @c true if operand is label (@c OP_LABEL). */
    public boolean isLabel() {
        return op() == OP_LABEL;
    }

    /** Return @c true if operand is any register or memory. */
    public final boolean isRegMem() {
        return isMem() || isReg();
    }

    public final boolean isRegCode(int code) {
        return this instanceof BaseReg && ((BaseReg) this).code() == code;
    }

    public final boolean isRegType(int type) {
        return this instanceof BaseReg && ((BaseReg) this).type() == type;
    }

    public final boolean isRegIndex(int index) {
        return this instanceof BaseReg && ((BaseReg) this).index() == index;
    }

    /** @brief Return @c true if operand is register of @a regType type or memory. */
    public final boolean isRegMem(int regType) {
        return isMem() || isRegType(regType);
    }
}
