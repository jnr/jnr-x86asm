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

import java.util.LinkedList;
import java.util.List;
import static com.kenai.jnr.x86asm.LABEL_STATE.*;

/**
 *
 */
@Deprecated
public final class Label extends Operand {

    /** Label Id (0 means unknown). */
    final int id;
    /** State of label, see {@link LABEL_STATE}. */
    LABEL_STATE state;
    /** Position (always positive, information depends to @c state). */
    int position;

    final List<LinkData> links = new LinkedList<LinkData>();

    public Label() {
        this(0);
    }

    public Label(int id) {
        super(OP.OP_LABEL, 4);
        this.id = id;
        this.state = LABEL_STATE_UNUSED;
        this.position = -1;
    }

    /** Returns @c true if label is unused (not bound or linked). */
    final boolean isUnused() {
        return state == LABEL_STATE_UNUSED;
    }

    /** Returns @c true if label is linked. */
    final boolean isLinked() {
        return state == LABEL_STATE_LINKED;
    }

    /** Returns @c true if label is bound. */
    final boolean isBound() {
        return state == LABEL_STATE_BOUND;
    }

    /** Returns the position of bound or linked labels, -1 if label
     * is unused.
     */
    final int position() {
        return position;
    }

    final void link(LinkData link) {
        links.add(link);
        state = LABEL_STATE_LINKED;
    }
}
