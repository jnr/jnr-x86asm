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

package jnr.x86asm;

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
