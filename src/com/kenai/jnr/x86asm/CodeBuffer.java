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

package com.kenai.jnr.x86asm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 */
final class CodeBuffer {
    private ByteBuffer buf;

    public CodeBuffer() {
        buf = ByteBuffer.allocate(128).order(ByteOrder.LITTLE_ENDIAN);
    }

    public final void ensureSpace() {
        if (buf.remaining() < 16) {
            grow();
        }
    }

    public void grow() {
        int newSize = buf.capacity() * 2;
        ByteBuffer newBuffer = ByteBuffer.allocate(newSize).order(ByteOrder.LITTLE_ENDIAN);

        // Copy the data over
        buf.flip();
        newBuffer.put(buf);
        buf = newBuffer;
    }

    final void copyTo(ByteBuffer dst) {
        ByteBuffer dup = buf.duplicate();
        dup.flip();
        dst.put(dup);
    }

    public final int offset() {
        return buf.position();
    }
    
    public int capacity() {
        return buf.capacity();
    }
    
    public final void emitByte(byte x) {
        buf.put(x);
    }
    
    public final void emitWord(short x) {
        buf.putShort(x);
    }
    
    public final void emitDWord(int x) {
        buf.putInt(x);
    }
    
    public final void emitQWord(long x) {
        buf.putLong(x);
    }
    
    public final void emitData(ByteBuffer data, int len) {

        ByteBuffer dup = data.duplicate();
        if (dup.remaining() > len) {
            dup.limit(dup.position() + len);
        }
        
        buf.put(dup);
    }
    
    public final byte getByteAt(int pos) {
        return buf.get(pos);
    }

    public final short getWordAt(int pos) {
        return buf.getShort(pos);
    }
    
    public final int getDWordAt(int pos) {
        return buf.getInt(pos);
    }
    
    public final long getQWordAt(int pos) {
        return buf.getLong(pos);
    }
    
    public final void setByteAt(int pos, byte x) {
        buf.put(pos, x);
    }

    public final void setWordAt(int pos, short x) {
        buf.putShort(pos, x);
    }

    public final void setDWordAt(int pos, int x) {
        buf.putInt(pos, x);
    }
    
    public final void setQWordAt(int pos, long x) {
        buf.putLong(pos, x);
    }

}
