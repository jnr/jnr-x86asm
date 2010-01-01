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

// While jnr-x86asm is covered under the LGPL version 3 as state above, it is based
// on code from the AsmJit project, and that copyright is reproduced below.
//
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

import static com.kenai.jnr.x86asm.REG.*;

public abstract class BaseReg extends Operand {

    public final int code;

    public BaseReg(int code, int size) {
        super(OP.OP_REG, size);
        this.code = code;
    }

    //! @brief Return register type, see @c REG.
    public final int type() {
        return code() & REGTYPE_MASK;
    }

    //! @brief Return register code, see @c REG.
    public final int code() {
        return code;
    }

    //! @brief Return register index (value from 0 to 7/15).
    public final int index() {
        return code() & REGCODE_MASK;
    }


//    public final boolean isRegCode(int code) {
//        return code() == code;
//    }
//
//    public final boolean isRegType(int type) {
//        return type() == type;
//    }
//
//    public final boolean isRegIndex(int index) {
//        return index() == index;
//    }
}
