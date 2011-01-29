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

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import static jnr.x86asm.HINT.*;
import static jnr.x86asm.INST_CODE.*;
import static jnr.x86asm.InstructionGroup.*;
import static jnr.x86asm.OP.*;
import static jnr.x86asm.OperandFlags.*;
import static jnr.x86asm.PROPERTY.*;
import static jnr.x86asm.RELOC_MODE.*;
import static jnr.x86asm.REG.*;

import static jnr.x86asm.Util.*;


/**
 * Low level code generation.
 */
public final class Assembler extends Serializer {
    private final CodeBuffer _buffer = new CodeBuffer();
    private final List<RelocData> _relocData = new LinkedList<RelocData>();
    private final CpuInfo cpuInfo = CpuInfo.GENERIC;
    private int _properties = 0;

    /** Size of possible trampolines. */
    int _trampolineSize;

    private final Logger _logger = null;

    private final CPU cpu;

    @Override
    boolean is64() {
        return cpu == CPU.X86_64;
    }

    private static final int intValue(boolean b) {
        return b ? 1 : 0;
    }

    public static final CPU I386 = CPU.I386;
    public static final CPU X86_64 = CPU.X86_64;

    public Assembler(CPU cpu) {
        this.cpu = cpu;
    }
    
    public final int offset() {
        return _buffer.offset();
    }

    /** Gets the required size of memory required to store all the generated code */
    public final int codeSize() {
        return _buffer.offset() + trampolineSize();
    }

    /** Return size of all possible trampolines needed to successfuly generate
     * relative jumps to absolute addresses. This value is only non-zero if jmp
     * of call instructions were used with immediate operand (this means jump or
     * call absolute address directly).
     *
     * Currently only _emitJmpOrCallReloc() method can increase trampoline size
     * value.
     */
    int trampolineSize() {
        return _trampolineSize;
    }
    
    //! @brief Set byte at position @a pos.
    public final byte getByteAt(int pos) {
        return _buffer.getByteAt(pos);
    }

    //! @brief Set word at position @a pos.
    public final short getWordAt(int pos) {
        return _buffer.getWordAt(pos);
    }

    //! @brief Set word at position @a pos.
    public final int getDWordAt(int pos) {
        return _buffer.getDWordAt(pos);
    }

    //! @brief Set word at position @a pos.
    public final long getQWordAt(int pos) {
        return _buffer.getQWordAt(pos);
    }

    //! @brief Set byte at position @a pos.
    public final void setByteAt(int pos, byte x) {
        _buffer.setByteAt(pos, x);
    }

    //! @brief Set word at position @a pos.
    public final void setWordAt(int pos, short x) {
        _buffer.setWordAt(pos, x);
    }

    //! @brief Set word at position @a pos.
    public final void setDWordAt(int pos, int x) {
        _buffer.setDWordAt(pos, x);
    }

    //! @brief Set word at position @a pos.
    public final void setQWordAt(int pos, long x) {
        _buffer.setQWordAt(pos, x);
    }

    //! @brief Set word at position @a pos.
    public final int getInt32At(int pos) {
        return (int) _buffer.getDWordAt(pos);
    }

    //! @brief Set int32 at position @a pos.
    public final void setInt32At(int pos, long x) {
        _buffer.setDWordAt(pos, (int) x);
    }

    public final void setVarAt(int pos, long i, boolean isUnsigned, int size) {
        switch (size) {
            case 1:
                setByteAt(pos, (byte) i);
                break;
            case 2:
                setWordAt(pos, (short) i);
                break;
            case 4:
                setDWordAt(pos, (int) i);
                break;
            case 8:
                setQWordAt(pos, i);
            default:
                throw new IllegalArgumentException("invalid size");
        }
    }

    /** Emit Byte to internal buffer. */
    final void _emitByte(int  x) {
        _buffer.emitByte((byte) x);
    }

    /** Emit Word (2 bytes) to internal buffer. */
    final void _emitWord(int x) {
        _buffer.emitWord((short) x);
    }

    /** Emit DWord (4 bytes) to internal buffer. */
    final void _emitDWord(int x) {
        _buffer.emitDWord(x);
    }

    /** Emit QWord (8 bytes) to internal buffer. */
    final void _emitQWord(long x) {
        _buffer.emitQWord(x);
    }

    /** Emit Int32 (4 bytes) to internal buffer. */
    final void _emitInt32(int x) {
        _buffer.emitDWord(x);
    }

    /** Emit system signed integer (4 or 8 bytes) to internal buffer. */
    final void _emitSysInt(long x) {
        if (is64()) {
            _buffer.emitQWord(x);
        } else {
            _buffer.emitDWord((int) x);
        }
    }

    //! @brief Emit single @a opCode without operands.
    final void _emitOpCode(int opCode) {
        // instruction prefix
        if ((opCode & 0xFF000000) != 0) {
            _emitByte((byte) ((opCode & 0xFF000000) >> 24));
        }
        // instruction opcodes
        if ((opCode & 0x00FF0000) != 0) {
            _emitByte((byte) ((opCode & 0x00FF0000) >> 16));
        }
        if ((opCode & 0x0000FF00) != 0) {
            _emitByte((byte) ((opCode & 0x0000FF00) >> 8));
        }
        // last opcode is always emitted (can be also 0x00)
        _emitByte((byte) (opCode & 0x000000FF));
    }
    
    void _emitSegmentPrefix(Operand rm) {
        if (rm.isMem()) {
            SEGMENT segmentPrefix = ((Mem) rm).segmentPrefix();
            if (segmentPrefix != SEGMENT.SEGMENT_NONE) {
                _emitByte(segmentPrefix.prefix());
            }
        }
    }

    void _emitImmediate(Immediate imm, int size) {
        switch (size) {
            case 1:
                _emitByte(imm.byteValue());
                break;
            case 2:
                _emitWord(imm.shortValue());
                break;
            case 4:
                _emitDWord(imm.intValue());
                break;
            case 8:
                if (!is64()) {
                    throw new IllegalArgumentException("64 bit immediate values not supported for 32bit");
                }
                _emitQWord(imm.longValue());
                break;
            default:
                throw new IllegalArgumentException("invalid immediate operand size");
        }
    }

    /** Emit REX prefix (64 bit mode only). */
    void _emitRexR(int w, int opReg, int regCode) {
        if (is64()) {

            boolean r = (opReg & 0x8) != 0;
            boolean b = (regCode & 0x8) != 0;

            // w Default operand size(0=Default, 1=64 bits).
            // r Register field (1=high bit extension of the ModR/M REG field).
            // x Index field not used in RexR
            // b Base field (1=high bit extension of the ModR/M or SIB Base field).
            if (w != 0 || r || b || (_properties & (1 << PROPERTY_X86_FORCE_REX)) != 0) {
                _emitByte(0x40 | (w << 3) | (intValue(r) << 2) | intValue(b));
            }
        }
    }
    
    void _emitRexR(boolean w, int opReg, int regCode) {
        _emitRexR(intValue(w), opReg, regCode);
    }

    /** Emit REX prefix (64 bit mode only). */
    void _emitRexRM(int w, int opReg, Operand rm) {
        if (is64()) {

            boolean r = (opReg & 0x8) != 0;
            boolean x = false;
            boolean b = false;

            if (rm.isReg()) {
                b = (((BaseReg) rm).code() & 0x8) != 0;

            } else if (rm.isMem()) {
                x = (((Mem) rm).index() & 0x8) != 0 && ((Mem) rm).index() != NO_REG;
                b = (((Mem) rm).base() & 0x8) != 0 && ((Mem) rm).base() != NO_REG;
            }

            // w Default operand size(0=Default, 1=64 bits).
            // r Register field (1=high bit extension of the ModR/M REG field).
            // x Index field (1=high bit extension of the SIB Index field).
            // b Base field (1=high bit extension of the ModR/M or SIB Base field).
            if (w != 0 || r || x || b || (_properties & (1 << PROPERTY_X86_FORCE_REX)) != 0) {
                _emitByte(0x40 | (w << 3) | (intValue(r) << 2) | (intValue(x) << 1) | intValue(b));
            }
        }
    }


    void _emitRexRM(boolean w, int opReg, Operand rm) {
        _emitRexRM(intValue(w), opReg, rm);
    }


    void _emitModM(int opReg, Mem mem, int immSize) {
        assert (mem.op() == OP_MEM);

        int baseReg = mem.base() & 0x7;
        int indexReg = mem.index() & 0x7;
        long disp = mem.displacement();
        int shift = mem.shift();

        // [base + displacemnt]
        if (mem.hasBase() && !mem.hasIndex()) {
            // ESP/RSP/R12 == 4
            if (baseReg == 4) {
                int mod = 0;

                if (disp != 0) {
                    mod = isInt8(disp) ? 1 : 2;
                }

                _emitMod(mod, opReg, 4);
                _emitSib(0, 4, 4);

                if (disp != 0) {
                    if (isInt8(disp)) {
                        _emitByte((byte) disp);
                    } else {
                        _emitInt32((int) disp);
                    }
                }
            } // EBP/RBP/R13 == 5
            else if (baseReg != 5 && disp == 0) {
                _emitMod(0, opReg, baseReg);
            } else if (isInt8(disp)) {
                _emitMod(1, opReg, baseReg);
                _emitByte((byte) disp);
            } else {
                _emitMod(2, opReg, baseReg);
                _emitInt32((int) disp);
            }
        }

        // [base + index * scale + displacemnt]
        else if (mem.hasBase() && mem.hasIndex()) {
            // ASMJIT_ASSERT(indexReg != RID_ESP);

            // EBP/RBP/R13 == 5
            if (baseReg != 5 && disp == 0) {
                _emitMod(0, opReg, 4);
                _emitSib(shift, indexReg, baseReg);
            } else if (isInt8(disp)) {
                _emitMod(1, opReg, 4);
                _emitSib(shift, indexReg, baseReg);
                _emitByte((byte) disp);
            } else {
                _emitMod(2, opReg, 4);
                _emitSib(shift, indexReg, baseReg);
                _emitInt32((int) disp);
            }
        }

        // Address                       | 32-bit mode | 64-bit mode
        // ------------------------------+-------------+---------------
        // [displacement]                |   ABSOLUTE  | RELATIVE (RIP)
        // [index * scale + displacemnt] |   ABSOLUTE  | ABSOLUTE (ZERO EXTENDED)
        else {
            // In 32 bit mode is used absolute addressing model.
            // In 64 bit mode is used relative addressing model together with absolute
            // addressing one. Main problem is that if instruction contains SIB then
            // relative addressing (RIP) is not possible.
            if (!is64()) {

                if (mem.hasIndex()) {
                    // ASMJIT_ASSERT(mem.index() != 4); // ESP/RSP == 4
                    _emitMod(0, opReg, 4);
                    _emitSib(shift, indexReg, 5);
                } else {
                    _emitMod(0, opReg, 5);
                }

                // X86 uses absolute addressing model, all relative addresses will be
                // relocated to absolute ones.
                if (mem.hasLabel()) {
                    Label label = mem.label();
                    int relocId = _relocData.size();


                    long destination = disp;
                    if (label.isBound()) {
                        destination += label.position();
                        // Dummy DWORD
                        _emitInt32(0);
                    } else {
                        _emitDisplacement(label, -4 - immSize, 4).relocId = relocId;
                    }

                    // Relative addressing will be relocated to absolute address.
                    RelocData rd = new RelocData(RelocData.Type.RELATIVE_TO_ABSOLUTE, 4, offset(), destination);

                    _relocData.add(rd);
                } else {
                    // Absolute address
                    _emitInt32((int) (mem.target() + disp));
                }

            } else {

                // X64 uses relative addressing model
                if (mem.hasLabel()) {
                    Label label = mem.label();

                    if (mem.hasIndex()) {
                        // Indexing is not possible
                        throw new IllegalArgumentException("illegal addressing");
                    }

                    // Relative address (RIP +/- displacement)
                    _emitMod(0, opReg, 5);

                    disp -= (4 + immSize);

                    if (label.isBound()) {
                        disp += offset() - label.position();
                        _emitInt32((int) disp);
                    } else {
                        _emitDisplacement(label, disp, 4);
                    }
                } else {
                    // Absolute address (truncated to 32 bits), this kind of address requires
                    // SIB byte (4)
                    _emitMod(0, opReg, 4);

                    if (mem.hasIndex()) {
                        // ASMJIT_ASSERT(mem.index() != 4); // ESP/RSP == 4
                        _emitSib(shift, indexReg, 5);
                    } else {
                        _emitSib(0, 4, 5);
                    }

                    // truncate to 32 bits
                    long target = mem.target() + disp;

                    if (target > 0xFFFFFFFFL) {
                        _logger.log("; Warning: Absolute address truncated to 32 bits\n");
                    }

                    _emitInt32((int) target);
                }

            }

        }
    }

    void _emitX86Inl(int opCode, boolean i16bit, boolean rexw, int reg) {
        _emitX86Inl(opCode, i16bit, intValue(rexw), reg);
    }

    void _emitX86Inl(int opCode, boolean i16bit, int rexw, int reg) {
        // 16 bit prefix
        if (i16bit) {
            _emitByte(0x66);
        }

        // instruction prefix
        if ((opCode & 0xFF000000) != 0) {
            _emitByte(((opCode & 0xFF000000) >> 24));
        }

        // rex prefix
        if (is64()) {
            _emitRexR(rexw, 0, reg);
        }


        // instruction opcodes
        if ((opCode & 0x00FF0000) != 0) {
            _emitByte(((opCode & 0x00FF0000) >> 16));
        }
        if ((opCode & 0x0000FF00) != 0) {
            _emitByte(((opCode & 0x0000FF00) >> 8));
        }

        _emitByte((opCode & 0x000000FF) + (reg & 0x7));
    }
    
    void _emitModRM(int opReg, Operand op, int immSize) {
        assert (op.op() == OP_REG || op.op() == OP_MEM);

        if (op.op() == OP_REG) {
            _emitModR(opReg, ((BaseReg) op).code());
        } else {
            _emitModM(opReg, (Mem) op, immSize);
        }
    }

    /** Emit MODR/M byte. */
    void _emitMod(int m, int o, int r) {
        _emitByte((byte) (((m & 0x03) << 6) | ((o & 0x07) << 3) | (r & 0x07)));
    }

    /** Emit SIB byte. */
    void _emitSib(int s, int i, int b) {
        _emitByte((byte) (((s & 0x03) << 6) | ((i & 0x07) << 3) | (b & 0x07)));
    }

    /** Emit Register / Register - calls _emitMod(3, opReg, r) */
    void _emitModR(int opReg, int r) {
        _emitMod(3, opReg, r);
    }

    /** Emit Register / Register - calls _emitMod(3, opReg, r.code()) */
    void _emitModR(int opReg, BaseReg r) {
        _emitMod(3, opReg, r.code());
    }

    void _emitX86RM(int opCode, boolean i16bit, boolean rexw, int o, Operand op, int immSize) {
        _emitX86RM(opCode, i16bit, intValue(rexw), o, op, immSize);
    }
    
    void _emitX86RM(int opCode, boolean i16bit, int rexw, int o, Operand op, int immSize) {
        // 16 bit prefix
        if (i16bit) {
            _emitByte(0x66);
        }

        // segment prefix
        _emitSegmentPrefix(op);

        // instruction prefix
        if ((opCode & 0xFF000000) != 0) {
            _emitByte(((opCode & 0xFF000000) >> 24));
        }

        // rex prefix
        if (is64()) {
            _emitRexRM(rexw, o, op);
        }

        // instruction opcodes
        if ((opCode & 0x00FF0000) != 0) {
            _emitByte((byte) ((opCode & 0x00FF0000) >> 16));
        }

        if ((opCode & 0x0000FF00) != 0) {
            _emitByte((byte) ((opCode & 0x0000FF00) >> 8));
        }

        _emitByte((byte) (opCode & 0x000000FF));

        // ModR/M
        _emitModRM(o, op, immSize);
    }
    
  void _emitX86(INST_CODE code, Operand o1, Operand o2, Operand o3) {
        
    InstructionDescription id = InstructionDescription.find(code);
    switch (id.group) {
    case I_EMIT:
    {
      _emitOpCode(id.opCode1);
      return;
    }

    case I_ALU:
    {
      int opCode = id.opCode1;
      int opReg = id.opCodeR;

      // Mem <- Reg
      if (o1.isMem() && o2.isReg())
      {
        _emitX86RM(opCode + intValue(!o2.isRegType(REG_GPB)),
          o2.isRegType(REG_GPW),
          o2.isRegType(REG_GPQ),
          ((Register) o2).code(),
          o1,
          0);
        return;
      }

      // Reg <- Reg|Mem
      if (o1.isReg() && o2.isRegMem())
      {
        _emitX86RM(opCode + 2 + intValue(!o1.isRegType(REG_GPB)),
          o1.isRegType(REG_GPW),
          o1.isRegType(REG_GPQ),
          ((Register) o1).code(),
          o2,
          0);
        return;
      }

      // AL, AX, EAX, RAX register shortcuts
      if (o1.isRegIndex(0) && o2.isImm())
      {
        if (o1.isRegType(REG_GPW))
          _emitByte(0x66); // 16 bit
        else if (o1.isRegType(REG_GPQ))
          _emitByte(0x48); // REX.W

        _emitByte((opReg << 3) | (0x04 + intValue(!o1.isRegType(REG_GPB))));
        _emitImmediate(
          (Immediate) o2, o1.size() <= 4 ? o1.size() : 4);
        return;
      }

      if (o1.isRegMem() && o2.isImm())
      {
        final Immediate imm = (Immediate) o2;
        int immSize = Util.isInt8(imm.value()) ? 1 : (o1.size() <= 4 ? o1.size() : 4);

        _emitX86RM(id.opCode2 + (o1.size() != 1 ? (immSize != 1 ? 1 : 3) : 0),
          o1.size() == 2,
          o1.size() == 8,
          opReg, o1,
          immSize);
        _emitImmediate(
          (Immediate) o2,
          immSize);
        return;
      }

      break;
    }

    case I_BSWAP:
    {
      if (o1.isReg())
      {
        final Register dst = (Register) o1;

        if (is64()) {
            _emitRexR(dst.type() == REG_GPQ, 1, dst.code());
        }

        _emitByte(0x0F);
        _emitModR(1, dst.code());
        return;
      }

      break;
    }

    case I_BT:
    {
      if (o1.isRegMem() && o2.isReg())
      {
        final Operand dst = o1;
        final Register src = (Register) o2;

        _emitX86RM(id.opCode1,
          src.isRegType(REG_GPW),
          src.isRegType(REG_GPQ),
          src.code(),
          dst,
          0);
        return;
      }

      if (o1.isRegMem() && o2.isImm())
      {
        final Operand dst = o1;
        final Immediate src = (Immediate) o2;

        _emitX86RM(id.opCode2,
          src.size() == 2,
          src.size() == 8,
          id.opCodeR,
          dst,
          1);
        _emitImmediate(src, 1);
        return;
      }

      break;
    }

    case I_CALL:
    {
      if (o1.isRegMem(is64() ? REG_GPQ : REG_GPD))
      {
        final Operand dst = o1;
        _emitX86RM(0xFF,
          false,
          false, 2, dst,
          0);
        return;
      }

      if (o1.isImm())
      {
        final Immediate imm = (Immediate) o1;
        _emitByte(0xE8);
        _emitJmpOrCallReloc(I_CALL, imm.value());
        return;
      }

      if (o1.isLabel())
      {
        Label label = (Label) o1;

        if (label.isBound())
        {
          final int rel32_size = 5;
          final int offs = label.position() - offset();
          assert(offs <= 0);

          _emitByte(0xE8);
          _emitInt32((int)(offs - rel32_size));
        }
        else
        {
          _emitByte(0xE8);
          _emitDisplacement(label, -4, 4);
        }
        return;
      }

      break;
    }

    case I_CRC32:
    {
      if (o1.isReg() && o2.isRegMem())
      {
        final Register dst = (Register) o1;
        final Operand src = o2;
        assert(dst.type() == REG_GPD || dst.type() == REG_GPQ);

        _emitX86RM(id.opCode1 + intValue(src.size() != 1),
          src.size() == 2,
          dst.type() == 8, dst.code(), src,
          0);
        return;
      }

      break;
    }

    case I_ENTER:
    {
      if (o1.isImm() && o2.isImm())
      {
        _emitByte(0xC8);
        _emitImmediate((Immediate) o1, 2);
        _emitImmediate((Immediate) o2, 1);
      }
      break;
    }

    case I_IMUL:
    {
      // 1 operand
      if (o1.isRegMem() && o2.isNone() && o3.isNone())
      {
        final Operand src = o1;
        _emitX86RM(0xF6 + intValue(src.size() != 1),
          src.size() == 2,
          src.size() == 8, 5, src,
          0);
        return;
      }
      // 2 operands
      else if (o1.isReg() && !o2.isNone() && o3.isNone())
      {
        final Register dst = (Register) o1;
        assert(!dst.isRegType(REG_GPW));

        if (o2.isRegMem())
        {
          final Operand src = o2;

          _emitX86RM(0x0FAF,
            dst.isRegType(REG_GPW),
            dst.isRegType(REG_GPQ), dst.code(), src,
            0);
          return;
        }
        else if (o2.isImm())
        {
          final Immediate imm = (Immediate) o2;

          if (isInt8(imm.value()) && imm.relocMode() == RELOC_NONE)
          {
            _emitX86RM(0x6B,
              dst.isRegType(REG_GPW),
              dst.isRegType(REG_GPQ), dst.code(), dst,
              1);
            _emitImmediate(imm, 1);
          }
          else
          {
            int immSize = dst.isRegType(REG_GPW) ? 2 : 4;
            _emitX86RM(0x69,
              dst.isRegType(REG_GPW),
              dst.isRegType(REG_GPQ), dst.code(), dst,
              immSize);
            _emitImmediate(imm, immSize);
          }
          return;
        }
      }
      // 3 operands
      else if (o1.isReg() && o2.isRegMem() && o3.isImm())
      {
        final Register dst = (Register) o1;
        final Operand src = o2;
        final Immediate imm = (Immediate) o3;

        if (isInt8(imm.value()) && imm.relocMode() == RELOC_NONE)
        {
          _emitX86RM(0x6B,
            dst.isRegType(REG_GPW),
            dst.isRegType(REG_GPQ), dst.code(), src,
            1);
          _emitImmediate(imm, 1);
        }
        else
        {
          int immSize = dst.isRegType(REG_GPW) ? 2 : 4;
          _emitX86RM(0x69,
            dst.isRegType(REG_GPW),
            dst.isRegType(REG_GPQ), dst.code(), src,
            immSize);
          _emitImmediate(imm, immSize);
        }
        return;
      }

      break;
    }

    case I_INC_DEC:
    {
      if (o1.isRegMem())
      {
        final Operand dst = o1;

        // INC [r16|r32] in 64 bit mode is not encodable.
        if (!is64() && dst.isReg() && (dst.isRegType(REG_GPW) || dst.isRegType(REG_GPD)))
        {
          _emitX86Inl(id.opCode1,
            dst.isRegType(REG_GPW),
            0, ((BaseReg) dst).code());
          return;
        }

        _emitX86RM(id.opCode2 + intValue(dst.size() != 1),
          dst.size() == 2,
          dst.size() == 8, id.opCodeR, dst,
          0);
        return;
      }

      break;
    }

    case I_J:
    {
      if (o1.isLabel())
      {
        Label label = (Label) o1;
        
        boolean isShortJump = (code.ordinal() >= INST_J_SHORT.ordinal() && code.ordinal() <= INST_JMP_SHORT.ordinal());

        final HINT hint = o2.isImm() ? HINT.valueOf((int) ((Immediate) o2).value()) : HINT.HINT_NONE;
        

        // Emit jump hint if configured for that.
        if (hint == HINT_TAKEN || hint == HINT_NOT_TAKEN
            && (_properties & (1 << PROPERTY_X86_JCC_HINTS)) != 0)
        {
            _emitByte(hint.value());
        }

        if (label.isBound())
        {
          final int rel8_size = 2;
          final int rel32_size = 6;
          final int offs = label.position() - offset();

          assert(offs <= 0);

          if (isInt8(offs - rel8_size))
          {
            _emitByte(0x70 | (id.opCode1 & 0xff));
            _emitByte((byte) (offs - rel8_size));
          }
          else
          {
            if (isShortJump && _logger != null)
            {
              _logger.log("; WARNING: Emitting long conditional jump, but short jump instruction forced!");
            }

            _emitByte(0x0F);
            _emitByte(0x80 | (id.opCode1 & 0xff));
            _emitInt32((int) (offs - rel32_size));
          }
        }
        else
        {
          if (isShortJump)
          {
            _emitByte(0x70 | (id.opCode1 & 0xff));
            _emitDisplacement(label, -1, 1);
          }
          else
          {
            _emitByte(0x0F);
            _emitByte(0x80 | (id.opCode1 & 0xff));
            _emitDisplacement(label, -4, 4);
          }
        }
        return;
      }

      break;
    }

    case I_JMP:
    {
      if (o1.isRegMem())
      {
        final Operand dst = o1;

        _emitX86RM(0xFF,
          false,
          false, 4, dst,
          0);
        return;
      }

      if (o1.isImm())
      {
        final Immediate imm = (Immediate) o1;
        _emitByte(0xE9);
        _emitJmpOrCallReloc(I_JMP, imm.value());
        return;
      }

      if (o1.isLabel())
      {
        Label label = (Label) o1;
        boolean isShortJump = (code == INST_JMP_SHORT);

        if (label.isBound())
        {
          final int rel8_size = 2;
          final int rel32_size = 5;
          final int offs = label.position() - offset();

          if (isInt8(offs - rel8_size))
          {
            _emitByte(0xEB);
            _emitByte((byte) (offs - rel8_size));
          }
          else
          {
            if (isShortJump && _logger != null)
            {
              _logger.log("; WARNING: Emitting long jump, but short jump instruction forced!");
            }

            _emitByte(0xE9);
            _emitInt32((int)(offs - rel32_size));
          }
        }
        else
        {
          if (isShortJump)
          {
            _emitByte(0xEB);
            _emitDisplacement(label, -1, 1);
          }
          else
          {
            _emitByte(0xE9);
            _emitDisplacement(label, -4, 4);
          }
        }
        return;
      }

      break;
    }

    case I_LEA:
    {
      if (o1.isReg() && o2.isMem())
      {
        final Register dst = (Register) o1;
        final Mem src = (Mem) o2;
        _emitX86RM(0x8D,
          dst.isRegType(REG_GPW),
          dst.isRegType(REG_GPQ), dst.code(), src,
          0);
        return;
      }

      break;
    }

    case I_M:
    {
      if (o1.isMem())
      {
        _emitX86RM(id.opCode1, false, (byte) id.opCode2, id.opCodeR, (Mem) o1, 0);
        return;
      }
      break;
    }

    case I_MOV:
    {
      final Operand dst = o1;
      final Operand src = o2;

      switch (dst.op() << 4 | src.op())
      {
        // Reg <- Reg/Mem
        case (OP_REG << 4) | OP_REG:
        {
          assert(src.isRegType(REG_GPB) || src.isRegType(REG_GPW) ||
                        src.isRegType(REG_GPD) || src.isRegType(REG_GPQ));
          // ... fall through ...
        }
        case (OP_REG << 4) | OP_MEM:
        {
          assert(dst.isRegType(REG_GPB) || dst.isRegType(REG_GPW) ||
                        dst.isRegType(REG_GPD) || dst.isRegType(REG_GPQ));

          _emitX86RM(0x0000008A + intValue(!dst.isRegType(REG_GPB)),
            dst.isRegType(REG_GPW),
            dst.isRegType(REG_GPQ),
            ((Register) dst).code(),
            src,
            0);
          return;
        }

        // Reg <- Imm
        case (OP_REG << 4) | OP_IMM:
        {
          final Immediate isrc = (Immediate) o2;

          // in 64 bit mode immediate can be 8 byte long!
          int immSize = dst.size();

          // Optimize instruction size by using 32 bit immediate if value can
          // fit to it
          if (is64() && immSize == 8 && isInt32(isrc.value()) && isrc.relocMode() == RELOC_NONE)
          {
            _emitX86RM(0xC7,
              dst.isRegType(REG_GPW),
              dst.isRegType(REG_GPQ),
              0,
              dst,
              0);
            immSize = 4;
          }
          else
          {
            _emitX86Inl((dst.size() == 1 ? 0xB0 : 0xB8),
              dst.isRegType(REG_GPW),
              dst.isRegType(REG_GPQ),
              ((Register) dst).code());
          }

          _emitImmediate(isrc, immSize);
          return;
        }

        // Mem <- Reg
        case (OP_MEM << 4) | OP_REG:
        {
          assert(src.isRegType(REG_GPB) || src.isRegType(REG_GPW) ||
                        src.isRegType(REG_GPD) || src.isRegType(REG_GPQ));

          _emitX86RM(0x88 + intValue(!src.isRegType(REG_GPB)),
            src.isRegType(REG_GPW),
            src.isRegType(REG_GPQ),
            ((Register) src).code(),
            dst,
            0);
          return;
        }

        // Mem <- Imm
        case (OP_MEM << 4) | OP_IMM:
        {
          int immSize = dst.size() <= 4 ? dst.size() : 4;

          _emitX86RM(0xC6 + intValue(dst.size() != 1),
            dst.size() == 2,
            dst.size() == 8,
            0,
            dst,
            immSize);
          _emitImmediate((Immediate) src,
            immSize);
          return;
        }
      }

      break;
    }

    case I_MOV_PTR:
    {
      if ((o1.isReg() && o2.isImm()) || (o1.isImm() && o2.isReg()))
      {
        boolean reverse = o1.op() == OP_REG;
        int opCode = !reverse ? 0xA0 : 0xA2;
        final Register reg = (Register)(!reverse ? o1 : o2);
        final Immediate imm = (Immediate)(!reverse ? o2 : o1);

        if (reg.index() != 0) throw new IllegalStateException("reg.index() != 0");

        if (reg.isRegType(REG_GPW)) _emitByte(0x66);

        if (is64()) {
            _emitRexR(reg.size() == 8, 0, 0);
        }

        _emitByte(opCode + intValue(reg.size() != 1));
        _emitImmediate(imm, is64() ? 8 : 4);
        return;
      }

      break;
    }

    case I_MOVSX_MOVZX:
    {
      if (o1.isReg() && o2.isRegMem())
      {
        final Register dst = (Register)(o1);
        final Operand src = (o2);

        if (dst.isRegType(REG_GPB)) throw new IllegalArgumentException("not gpb");
        if (src.size() != 1 && src.size() != 2) throw new IllegalArgumentException("src.size !=1 && src.size != 2");
        if (src.size() == 2 && dst.isRegType(REG_GPW)) throw new IllegalArgumentException("not gpw");

        _emitX86RM(id.opCode1 + intValue(src.size() != 1),
          dst.isRegType(REG_GPW),
          dst.isRegType(REG_GPQ),
          dst.code(),
          src,
          0);
        return;
      }

      break;
    }

    case I_MOVSXD:
    {
        if (!is64()) {
            throw new IllegalStateException("illegal instruction");
        }
      if (o1.isReg() && o2.isRegMem())
      {
        final Register dst = (Register)(o1);
        final Operand src = (o2);
        _emitX86RM(0x00000063,
          false,
          1, dst.code(), src,
          0);
        return;
      }

      break;
    }


    case I_PUSH:
    {
      // This section is only for immediates, memory/register operands are handled in I_POP.
      if (o1.isImm())
      {
        final Immediate imm = (Immediate)(o1);

        if (isInt8(imm.value()) && imm.relocMode() == RELOC_NONE)
        {
          _emitByte(0x6A);
          _emitImmediate(imm, 1);
        }
        else
        {
          _emitByte(0x68);
          _emitImmediate(imm, 4);
        }
        return;
      }

      // ... goto I_POP ...
    }

    case I_POP:
    {
      if (o1.isReg())
      {
        assert(o1.isRegType(REG_GPW) || o1.isRegType(is64() ? REG_GPQ : REG_GPD));
        _emitX86Inl(id.opCode1, o1.isRegType(REG_GPW), 0, ((Register) o1).code());
        return;
      }

      if (o1.isMem())
      {
        _emitX86RM(id.opCode2, o1.size() == 2, 0, id.opCodeR, (o1), 0);
        return;
      }

      break;
    }

    case I_R_RM:
    {
      if (o1.isReg() && o2.isRegMem())
      {
        final Register dst = (Register)(o1);
        assert(dst.type() != REG_GPB);
        final Operand src = (o2);

        _emitX86RM(id.opCode1,
          dst.type() == REG_GPW,
          dst.type() == REG_GPQ, dst.code(), src,
          0);
        return;
      }

      break;
    }

    case I_RM_B:
    {
      if (o1.isRegMem())
      {
        final Operand op = (o1);
        _emitX86RM(id.opCode1, false, false, 0, op, 0);
        return;
      }

      break;
    }

    case I_RM:
    {
      if (o1.isRegMem())
      {
        final Operand op = (o1);
        _emitX86RM(id.opCode1 + intValue(op.size() != 1),
          op.size() == 2,
          op.size() == 8, id.opCodeR, op,
          0);
        return;
      }

      break;
    }

    case I_RM_R:
    {
      if (o1.isRegMem() && o2.isReg())
      {
        final Operand dst = (o1);
        final Register src = (Register)(o2);
        _emitX86RM(id.opCode1 + intValue(src.type() != REG_GPB),
          src.type() == REG_GPW,
          src.type() == REG_GPQ, src.code(), dst,
          0);
        return;
      }

      break;
    }

    case I_RET:
    {
      if (o1.isNone())
      {
        _emitByte(0xC3);
        return;
      }
      else if (o1.isImm())
      {
        final Immediate imm = (Immediate)(o1);
        assert(isUInt16(imm.value()));

        if (imm.value() == 0 && imm.relocMode() == RELOC_NONE)
        {
          _emitByte(0xC3);
        }
        else
        {
          _emitByte(0xC2);
          _emitImmediate(imm, 2);
        }
        return;
      }

      break;
    }

    case I_ROT:
    {
      if (o1.isRegMem() && (o2.isRegCode(REG_CL) || o2.isImm()))
      {
        // generate opcode. For these operations is base 0xC0 or 0xD0.
        boolean useImm8 = (o2.isImm() &&
                       (((Immediate) o2).value() != 1 ||
                        ((Immediate) o2).relocMode() != RELOC_NONE));
        int opCode = useImm8 ? 0xC0 : 0xD0;

        // size and operand type modifies the opcode
        if (o1.size() != 1) opCode |= 0x01;
        if (o2.op() == OP_REG) opCode |= 0x02;

        _emitX86RM(opCode,
          o1.size() == 2,
          o1.size() == 8,
          id.opCodeR, (o1),
          intValue(useImm8));
        if (useImm8)
          _emitImmediate((Immediate)(o2), 1);
        return;
      }

      break;
    }

    case I_SHLD_SHRD:
    {
      if (o1.isRegMem() && o2.isReg() && (o3.isImm() || (o3.isReg() && o3.isRegCode(REG_CL))))
      {
        final Operand dst = (o1);
        final Register src1 = (Register)(o2);
        final Operand src2 = (o3);

        assert(dst.size() == src1.size());

        _emitX86RM(id.opCode1 + intValue(src2.isReg()),
          src1.isRegType(REG_GPW),
          src1.isRegType(REG_GPQ),
          src1.code(), dst,
          intValue(src2.isImm()));
        if (src2.isImm())
          _emitImmediate((Immediate)(src2), 1);
        return;
      }

      break;
    }

    case I_TEST:
    {
      if (o1.isRegMem() && o2.isReg())
      {
        assert(o1.size() == o2.size());
        _emitX86RM(0x84 + intValue(o2.size() != 1),
          o2.size() == 2, o2.size() == 8,
          ((BaseReg) o2).code(),
          (o1),
          0);
        return;
      }

      if (o1.isRegIndex(0) && o2.isImm())
      {
        int immSize = o1.size() <= 4 ? o1.size() : 4;

        if (o1.size() == 2) _emitByte(0x66); // 16 bit

        if (is64()) {
            _emitRexRM(o1.size() == 8, 0, (o1));
        }

        _emitByte(0xA8 + intValue(o1.size() != 1));
        _emitImmediate((Immediate)(o2), immSize);
        return;
      }

      if (o1.isRegMem() && o2.isImm())
      {
        int immSize = o1.size() <= 4 ? o1.size() : 4;

        if (o1.size() == 2) _emitByte(0x66); // 16 bit
        _emitSegmentPrefix((o1)); // segment prefix

        if (is64()) _emitRexRM(o1.size() == 8, 0, (o1));

        _emitByte(0xF6 + intValue(o1.size() != 1));
        _emitModRM(0, (o1), immSize);
        _emitImmediate((Immediate)(o2), immSize);
        return;
      }

      break;
    }

    case I_XCHG:
    {
      if (o1.isRegMem() && o2.isReg())
      {
        final Operand dst = (o1);
        final Register src = (Register)(o2);

        if (src.isRegType(REG_GPW)) _emitByte(0x66); // 16 bit
        _emitSegmentPrefix(dst); // segment prefix

        if (is64()) _emitRexRM(src.isRegType(REG_GPQ), src.code(), dst);

        // Special opcode for index 0 registers (AX, EAX, RAX vs register)
        if ((dst.op() == OP_REG && dst.size() > 1) &&
            (((Register) dst).code() == 0 ||
             ((Register) src).code() == 0))
        {
          int index = ((Register) dst).code() | src.code();
          _emitByte((byte) (0x90 + index));
          return;
        }

        _emitByte(0x86 + intValue(!src.isRegType(REG_GPB)));
        _emitModRM(src.code(), dst, 0);
        return;
      }

      break;
    }

    case I_MOVBE:
    {
      if (o1.isReg() && o2.isMem())
      {
        _emitX86RM(0x000F38F0,
          o1.isRegType(REG_GPW),
          o1.isRegType(REG_GPQ),
          ((Register) o1).code(),
          (Mem)(o2),
          0);
        return;
      }

      if (o1.isMem() && o2.isReg())
      {
        _emitX86RM(0x000F38F1,
          o2.isRegType(REG_GPW),
          o2.isRegType(REG_GPQ),
          ((Register) o2).code(),
          (Mem)(o1),
          0);
        return;
      }

      break;
    }

    case I_X87_FPU:
    {
      if (o1.isRegType(REG_X87))
      {
        int i1 = ((X87Register) o1).index();
        int i2 = 0;

        if (code != INST_FCOM && code != INST_FCOMP)
        {
          if (!o2.isRegType(REG_X87)) throw new IllegalArgumentException("not x87 reg");
          i2 = ((X87Register) o2).index();
        }
        else if (i1 != 0 && i2 != 0)
        {
          throw new IllegalArgumentException("illegal instruction");
        }

        _emitByte(i1 == 0
          ? ((id.opCode1 & 0xFF000000) >> 24)
          : ((id.opCode1 & 0x00FF0000) >> 16));
        _emitByte(i1 == 0
          ? ((id.opCode1 & 0x0000FF00) >>  8) + i2
          : ((id.opCode1 & 0x000000FF)      ) + i1);
        return;
      }

      if (o1.isMem() && (o1.size() == 4 || o1.size() == 8) && o2.isNone())
      {
        final Mem m = (Mem)(o1);

        // segment prefix
        _emitSegmentPrefix(m);

        _emitByte(o1.size() == 4
          ? ((id.opCode1 & 0xFF000000) >> 24)
          : ((id.opCode1 & 0x00FF0000) >> 16));
        _emitModM(id.opCodeR, m, 0);
        return;
      }

      break;
    }

    case I_X87_STI:
    {
      if (o1.isRegType(REG_X87))
      {
        int i = ((X87Register) o1).index();
        _emitByte(((id.opCode1 & 0x0000FF00) >> 8));
        _emitByte(((id.opCode1 & 0x000000FF) + i));
        return;
      }
      break;
    }

    case I_X87_FSTSW:
    {
      if (o1.isReg() &&
          ((BaseReg) o1).type() <= REG_GPQ &&
          ((BaseReg) o1).index() == 0)
      {
        _emitOpCode(id.opCode2);
        return;
      }

      if (o1.isMem())
      {
        _emitX86RM(id.opCode1, false, 0, id.opCodeR, (Mem)(o1), 0);
        return;
      }

      break;
    }

    case I_X87_MEM_STI:
    {
      if (o1.isRegType(REG_X87))
      {
        _emitByte(((id.opCode2 & 0xFF000000) >> 24));
        _emitByte(((id.opCode2 & 0x00FF0000) >> 16) +
          ((X87Register) o1).index());
        return;
      }

      // ... fall through to I_X87_MEM ...
    }

    case I_X87_MEM:
    {
      if (!o1.isMem()) throw new IllegalArgumentException("not x87 mem");
      final Mem m = (Mem)(o1);

      int opCode = 0x00, mod = 0;

      if (o1.size() == 2 && (id.o1Flags & O_FM_2) != 0)
      {
        opCode = ((id.opCode1 & 0xFF000000) >> 24);
        mod    = id.opCodeR;
      }
      if (o1.size() == 4 && (id.o1Flags & O_FM_4) != 0)
      {
        opCode = ((id.opCode1 & 0x00FF0000) >> 16);
        mod    = id.opCodeR;
      }
      if (o1.size() == 8 && (id.o1Flags & O_FM_8) != 0)
      {
        opCode = ((id.opCode1 & 0x0000FF00) >>  8);
        mod    = ((id.opCode1 & 0x000000FF)      );
      }

      if (opCode != 0)
      {
        _emitSegmentPrefix(m);
        _emitByte(opCode);
        _emitModM(mod, m, 0);
        return;
      }

      break;
    }

    case I_MMU_MOV:
    {
      assert(id.o1Flags != 0);
      assert(id.o2Flags != 0);

      // Check parameters (X)MM|GP32_64 <- (X)MM|GP32_64|Mem|Imm
      if ((o1.isMem()            && (id.o1Flags & O_MEM) == 0) ||
          (o1.isRegType(REG_MM ) && (id.o1Flags & O_MM ) == 0) ||
          (o1.isRegType(REG_XMM) && (id.o1Flags & O_XMM) == 0) ||
          (o1.isRegType(REG_GPD) && (id.o1Flags & O_G32) == 0) ||
          (o1.isRegType(REG_GPQ) && (id.o1Flags & O_G64) == 0) ||
          (o2.isRegType(REG_MM ) && (id.o2Flags & O_MM ) == 0) ||
          (o2.isRegType(REG_XMM) && (id.o2Flags & O_XMM) == 0) ||
          (o2.isRegType(REG_GPD) && (id.o2Flags & O_G32) == 0) ||
          (o2.isRegType(REG_GPQ) && (id.o2Flags & O_G64) == 0) ||
          (o2.isMem()            && (id.o2Flags & O_MEM) == 0) )
      {
        throw new IllegalArgumentException("illegal instruction");
      }

      // Illegal
      if (o1.isMem() && o2.isMem()) throw new IllegalArgumentException("illegal instruction");

      int rexw = ((id.o1Flags|id.o2Flags) & O_NOREX) != 0
        ? 0
        : intValue(o1.isRegType(REG_GPQ) || o1.isRegType(REG_GPQ));

      // (X)MM|Reg <- (X)MM|Reg
      if (o1.isReg() && o2.isReg())
      {
        _emitMmu(id.opCode1, rexw,
          ((BaseReg) o1).code(),
          (BaseReg)(o2),
          0);
        return;
      }

      // (X)MM|Reg <- Mem
      if (o1.isReg() && o2.isMem())
      {
        _emitMmu(id.opCode1, rexw,
          ((BaseReg) o1).code(),
          (Mem)(o2),
          0);
        return;
      }

      // Mem <- (X)MM|Reg
      if (o1.isMem() && o2.isReg())
      {
        _emitMmu(id.opCode2, rexw,
          ((BaseReg) o2).code(),
          (Mem)(o1),
          0);
        return;
      }

      break;
    }

    case I_MMU_MOVD:
    {
      if ((o1.isRegType(REG_MM) || o1.isRegType(REG_XMM)) && (o2.isRegType(REG_GPD) || o2.isMem()))
      {
        _emitMmu(o1.isRegType(REG_XMM) ? 0x66000F6E : 0x00000F6E, 0,
          ((BaseReg) o1).code(),
          (o2),
          0);
        return;
      }

      if ((o1.isRegType(REG_GPD) || o1.isMem()) && (o2.isRegType(REG_MM) || o2.isRegType(REG_XMM)))
      {
        _emitMmu(o2.isRegType(REG_XMM) ? 0x66000F7E : 0x00000F7E, 0,
          ((BaseReg) o2).code(),
          (o1),
          0);
        return;
      }

      break;
    }

    case I_MMU_MOVQ:
    {
      if (o1.isRegType(REG_MM) && o2.isRegType(REG_MM))
      {
        _emitMmu(0x00000F6F, 0,
          ((MMRegister) o1).code(),
          (MMRegister)(o2),
          0);
        return;
      }

      if (o1.isRegType(REG_XMM) && o2.isRegType(REG_XMM))
      {
        _emitMmu(0xF3000F7E, 0,
          ((XMMRegister) o1).code(),
          (XMMRegister)(o2),
          0);
        return;
      }

      // Convenience - movdq2q
      if (o1.isRegType(REG_MM) && o2.isRegType(REG_XMM))
      {
        _emitMmu(0xF2000FD6, 0,
          ((MMRegister) o1).code(),
          (XMMRegister)(o2),
          0);
        return;
      }

      // Convenience - movq2dq
      if (o1.isRegType(REG_XMM) && o2.isRegType(REG_MM))
      {
        _emitMmu(0xF3000FD6, 0,
          ((XMMRegister) o1).code(),
          (MMRegister)(o2),
          0);
        return;
      }

      if (o1.isRegType(REG_MM) && o2.isMem())
      {
        _emitMmu(0x00000F6F, 0,
          ((MMRegister) o1).code(),
          (Mem)(o2),
          0);
        return;
      }

      if (o1.isRegType(REG_XMM) && o2.isMem())
      {
        _emitMmu(0xF3000F7E, 0,
          ((XMMRegister) o1).code(),
          (Mem)(o2),
          0);
        return;
      }

      if (o1.isMem() && o2.isRegType(REG_MM))
      {
        _emitMmu(0x00000F7F, 0,
          ((MMRegister) o2).code(),
          (Mem)(o1),
          0);
        return;
      }

      if (o1.isMem() && o2.isRegType(REG_XMM))
      {
        _emitMmu(0x66000FD6, 0,
          ((XMMRegister) o2).code(),
          (Mem)(o1),
          0);
        return;
      }


        if (is64()) {
          if ((o1.isRegType(REG_MM) || o1.isRegType(REG_XMM)) && (o2.isRegType(REG_GPQ) || o2.isMem()))
          {
            _emitMmu(o1.isRegType(REG_XMM) ? 0x66000F6E : 0x00000F6E, 1,
              ((BaseReg) o1).code(),
              (o2),
              0);
            return;
          }

          if ((o1.isRegType(REG_GPQ) || o1.isMem()) && (o2.isRegType(REG_MM) || o2.isRegType(REG_XMM)))
          {
            _emitMmu(o2.isRegType(REG_XMM) ? 0x66000F7E : 0x00000F7E, 1,
              ((BaseReg) o2).code(),
              (o1),
              0);
            return;
          }
        }

      break;
    }

    case I_MMU_PREFETCH:
    {
      if (o1.isMem() && o2.isImm())
      {
        final Mem mem = (Mem)(o1);
        final Immediate hint = (Immediate)(o2);

        _emitMmu(0x00000F18, 0, (int) hint.value(), mem, 0);
        return;
      }

      break;
    }

    case I_MMU_PEXTR:
    {
      if (!(o1.isRegMem() &&
           (o2.isRegType(REG_XMM) || (code == INST_PEXTRW && o2.isRegType(REG_MM))) &&
            o3.isImm()))
      {
        throw new IllegalStateException("illegal instruction");
      }

      int opCode = id.opCode1;
      boolean isGpdGpq = o1.isRegType(REG_GPD) || o1.isRegType(REG_GPQ);

      if (code == INST_PEXTRB && (o1.size() != 0 && o1.size() != 1) && !isGpdGpq) throw new IllegalStateException("illegal instruction");
      if (code == INST_PEXTRW && (o1.size() != 0 && o1.size() != 2) && !isGpdGpq) throw new IllegalStateException("illegal instruction");
      if (code == INST_PEXTRD && (o1.size() != 0 && o1.size() != 4) && !isGpdGpq) throw new IllegalStateException("illegal instruction");
      if (code == INST_PEXTRQ && (o1.size() != 0 && o1.size() != 8) && !isGpdGpq) throw new IllegalStateException("illegal instruction");

      if (o2.isRegType(REG_XMM)) opCode |= 0x66000000;

      if (o1.isReg())
      {
        _emitMmu(opCode, id.opCodeR | intValue(o1.isRegType(REG_GPQ)),
          ((BaseReg) o2).code(),
          (BaseReg)(o1), 1);
        _emitImmediate(
          (Immediate)(o3), 1);
        return;
      }

      if (o1.isMem())
      {
        _emitMmu(opCode, id.opCodeR,
          ((BaseReg) o2).code(),
          (Mem)(o1), 1);
        _emitImmediate(
          (Immediate)(o3), 1);
        return;
      }

      break;
    }

    case I_MMU_RMI:
    {
      assert(id.o1Flags != 0);
      assert(id.o2Flags != 0);

      // Check parameters (X)MM|GP32_64 <- (X)MM|GP32_64|Mem|Imm
      if (!o1.isReg() ||
          (o1.isRegType(REG_MM ) && (id.o1Flags & O_MM ) == 0) ||
          (o1.isRegType(REG_XMM) && (id.o1Flags & O_XMM) == 0) ||
          (o1.isRegType(REG_GPD) && (id.o1Flags & O_G32) == 0) ||
          (o1.isRegType(REG_GPQ) && (id.o1Flags & O_G64) == 0) ||
          (o2.isRegType(REG_MM ) && (id.o2Flags & O_MM ) == 0) ||
          (o2.isRegType(REG_XMM) && (id.o2Flags & O_XMM) == 0) ||
          (o2.isRegType(REG_GPD) && (id.o2Flags & O_G32) == 0) ||
          (o2.isRegType(REG_GPQ) && (id.o2Flags & O_G64) == 0) ||
          (o2.isMem()            && (id.o2Flags & O_MEM) == 0) ||
          (o2.isImm()            && (id.o2Flags & O_IMM) == 0))
      {
        throw new IllegalStateException("illegal instruction");
      }

      int prefix =
        ((id.o1Flags & O_MM_XMM) == O_MM_XMM && o1.isRegType(REG_XMM)) ||
        ((id.o2Flags & O_MM_XMM) == O_MM_XMM && o2.isRegType(REG_XMM))
          ? 0x66000000
          : 0x00000000;
      int rexw = ((id.o1Flags|id.o2Flags) & O_NOREX) != 0
        ? 0
        : intValue(o1.isRegType(REG_GPQ) || o1.isRegType(REG_GPQ));

      // (X)MM <- (X)MM (opcode1)
      if (o2.isReg())
      {
        if ((id.o2Flags & (O_MM_XMM | O_G32_64)) == 0) throw new IllegalStateException("illegal instruction");
        _emitMmu(id.opCode1 | prefix, rexw,
          ((BaseReg) o1).code(),
          (BaseReg)(o2), 0);
        return;
      }
      // (X)MM <- Mem (opcode1)
      if (o2.isMem())
      {
        if ((id.o2Flags & O_MEM) == 0) throw new IllegalStateException("illegal instruction");
        _emitMmu(id.opCode1 | prefix, rexw,
          ((BaseReg) o1).code(),
          (Mem)(o2), 0);
        return;
      }
      // (X)MM <- Imm (opcode2+opcodeR)
      if (o2.isImm())
      {
        if ((id.o2Flags & O_IMM) == 0) throw new IllegalStateException("illegal instruction");
        _emitMmu(id.opCode2 | prefix, rexw,
          id.opCodeR,
          (BaseReg)(o1), 1);
        _emitImmediate(
          (Immediate)(o2), 1);
        return;
      }

      break;
    }

    case I_MMU_RM_IMM8:
    {
      assert(id.o1Flags != 0);
      assert(id.o2Flags != 0);

      // Check parameters (X)MM|GP32_64 <- (X)MM|GP32_64|Mem|Imm
      if (!o1.isReg() ||
          (o1.isRegType(REG_MM ) && (id.o1Flags & O_MM ) == 0) ||
          (o1.isRegType(REG_XMM) && (id.o1Flags & O_XMM) == 0) ||
          (o1.isRegType(REG_GPD) && (id.o1Flags & O_G32) == 0) ||
          (o1.isRegType(REG_GPQ) && (id.o1Flags & O_G64) == 0) ||
          (o2.isRegType(REG_MM ) && (id.o2Flags & O_MM ) == 0) ||
          (o2.isRegType(REG_XMM) && (id.o2Flags & O_XMM) == 0) ||
          (o2.isRegType(REG_GPD) && (id.o2Flags & O_G32) == 0) ||
          (o2.isRegType(REG_GPQ) && (id.o2Flags & O_G64) == 0) ||
          (o2.isMem()            && (id.o2Flags & O_MEM) == 0) ||
          !o3.isImm())
      {
        throw new IllegalStateException("illegal instruction");
      }

      int prefix =
        ((id.o1Flags & O_MM_XMM) == O_MM_XMM && o1.isRegType(REG_XMM)) ||
        ((id.o2Flags & O_MM_XMM) == O_MM_XMM && o2.isRegType(REG_XMM))
          ? 0x66000000
          : 0x00000000;
      int rexw = ((id.o1Flags|id.o2Flags) & O_NOREX) != 0
        ? 0
        : intValue(o1.isRegType(REG_GPQ) || o1.isRegType(REG_GPQ));

      // (X)MM <- (X)MM (opcode1)
      if (o2.isReg())
      {
        if ((id.o2Flags & (O_MM_XMM | O_G32_64)) == 0) throw new IllegalStateException("illegal instruction");
        _emitMmu(id.opCode1 | prefix, rexw,
          ((BaseReg) o1).code(),
          (BaseReg)(o2), 1);
        _emitImmediate((Immediate)(o3), 1);
        return;
      }
      // (X)MM <- Mem (opcode1)
      if (o2.isMem())
      {
        if ((id.o2Flags & O_MEM) == 0) throw new IllegalStateException("illegal instruction");
        _emitMmu(id.opCode1 | prefix, rexw,
          ((BaseReg) o1).code(),
          (Mem)(o2), 1);
        _emitImmediate((Immediate)(o3), 1);
        return;
      }

      break;
    }

    case I_MMU_RM_3DNOW:
    {
      if (o1.isRegType(REG_MM) && (o2.isRegType(REG_MM) || o2.isMem()))
      {
        _emitMmu(id.opCode1, 0,
          ((BaseReg) o1).code(),
          (Mem)(o2), 1);
        _emitByte(id.opCode2);
        return;
      }

      break;
    }
  }
    }

    void _emitFpu(int opCode) {
        _emitOpCode(opCode);
    }

    void _emitFpuSTI(int opCode, int sti) {
        // illegal stack offset
        assert (0 <= sti && sti < 8);
        _emitOpCode(opCode + sti);
    }

    void _emitFpuMEM(int opCode, int opReg, Mem mem) {
        // segment prefix
        _emitSegmentPrefix(mem);

        // instruction prefix
        if ((opCode & 0xFF000000) != 0) {
            _emitByte(((opCode & 0xFF000000) >> 24));
        }

        // rex prefix
        if (is64()) {
            _emitRexRM(0, opReg, mem);
        }

        // instruction opcodes
        if ((opCode & 0x00FF0000) != 0) {
            _emitByte(((opCode & 0x00FF0000) >> 16));
        }
        if ((opCode & 0x0000FF00) != 0) {
            _emitByte(((opCode & 0x0000FF00) >> 8));
        }

        _emitByte(((opCode & 0x000000FF)));
        _emitModM(opReg, mem, 0);
    }

    void _emitMmu(int opCode, int rexw, int opReg,
            Operand src, int immSize) {
        // Segment prefix.
        _emitSegmentPrefix(src);

        // Instruction prefix.
        if ((opCode & 0xFF000000) != 0) {
            _emitByte(((opCode & 0xFF000000) >> 24));
        }

        // Rex prefix
        if (is64()) {
            _emitRexRM(rexw, opReg, src);
        }

        // Instruction opcodes.
        if ((opCode & 0x00FF0000) != 0) {
            _emitByte(((opCode & 0x00FF0000) >> 16));
        }

        // No checking, MMX/SSE instructions have always two opcodes or more.
        _emitByte(((opCode & 0x0000FF00) >> 8));
        _emitByte(((opCode & 0x000000FF)));

        if (src.isReg()) {
            _emitModR(opReg, ((BaseReg) src).code());
        } else {
            _emitModM(opReg, (Mem) src, immSize);
        }
    }

    LinkData _emitDisplacement(Label label, long inlinedDisplacement, int size) {
        assert (!label.isBound());
        assert (size == 1 || size == 4);

        // Chain with label.
        LinkData link = new LinkData(offset(), inlinedDisplacement, -1);

        label.link(link);

        // Emit dummy DWORD.
        if (size == 1) {
            _emitByte(0x01);
        } else // if (size == 4)
        {
            _emitDWord(0x04040404);
        }

        return link;
    }

    void _emitJmpOrCallReloc(InstructionGroup instruction, long target) {


        if (is64()) {
            // If we are compiling in 64-bit mode, we can use trampoline if relative jump
            // is not possible.
            _trampolineSize += TrampolineWriter.TRAMPOLINE_SIZE;
        }

        RelocData rd = new RelocData(RelocData.Type.ABSOLUTE_TO_RELATIVE_TRAMPOLINE, 4, offset(), target);
        _relocData.add(rd);

        // Emit dummy 32-bit integer (will be overwritten by relocCode()).
        _emitInt32(0);
    }

    public void relocCode(ByteBuffer buffer, long address) {
        // Copy code to virtual memory (this is a given _dst pointer).
        int csize = codeSize();

        // We are copying exactly size of generated code. Extra code for trampolines
        // is generated on-the-fly by relocator (this code not exists at now).
        _buffer.copyTo(buffer);

        // Relocate recorded locations.
        for (RelocData r : _relocData) {

            long val;

            // Whether to use trampoline, can be only used if relocation type is
            // ABSOLUTE_TO_RELATIVE_TRAMPOLINE.
            boolean useTrampoline = false;


            // Be sure that reloc data structure is correct.
            assert ((r.offset + r.size) <= csize);

            switch (r.type) {
                case ABSOLUTE_TO_ABSOLUTE:
                    val = r.destination;
                    break;

                case RELATIVE_TO_ABSOLUTE:
                    val = address + r.destination;
                    break;

                case ABSOLUTE_TO_RELATIVE:
                case ABSOLUTE_TO_RELATIVE_TRAMPOLINE:
                    val = r.destination - (address + r.offset + 4);

                    if (is64() && r.type == RelocData.Type.ABSOLUTE_TO_RELATIVE_TRAMPOLINE && !isInt32(val)) {
                        val = (long) buffer.position() - (r.offset + 4);
                        useTrampoline = true;
                    }

                    break;

                default:
                    throw new IllegalStateException("invalid relocation type");
            }

            switch (r.size) {
                case 4:
                    buffer.putInt(r.offset, (int) val);
                    break;

                case 8:
                    buffer.putLong(r.offset, val);
                    break;

                default:
                    throw new IllegalStateException("invalid relocation size");
            }

            if (is64() && useTrampoline) {
                if (_logger != null) {
                    _logger.log(String.format("; Trampoline from %x -> %x\n", address + r.offset, r.destination));
                }

                TrampolineWriter.writeTrampoline(buffer, r.destination);
            }
        }
    }
    // NOPs optimized for Intel:
    //   Intel 64 and IA-32 Architectures Software Developer's Manual
    //   - Volume 2B
    //   - Instruction Set Reference N-Z
    //     - NOP

    // NOPs optimized for AMD:
    //   Software Optimization Guide for AMD Family 10h Processors (Quad-Core)
    //   - 4.13 - Code Padding with Operand-Size Override and Multibyte NOP
    // Intel and AMD
    private static final int nop1[] = { 0x90 };
    private static final int nop2[] = { 0x66, 0x90 };
    private static final int nop3[] = { 0x0F, 0x1F, 0x00 };
    private static final int nop4[] = { 0x0F, 0x1F, 0x40, 0x00 };
    private static final int nop5[] = { 0x0F, 0x1F, 0x44, 0x00, 0x00 };
    private static final int nop6[] = { 0x66, 0x0F, 0x1F, 0x44, 0x00, 0x00 };
    private static final int nop7[] = { 0x0F, 0x1F, 0x80, 0x00, 0x00, 0x00, 0x00 };
    private static final int nop8[] = { 0x0F, 0x1F, 0x84, 0x00, 0x00, 0x00, 0x00, 0x00 };
    private static final int nop9[] = { 0x66, 0x0F, 0x1F, 0x84, 0x00, 0x00, 0x00, 0x00, 0x00 };

    // AMD
    private static final int nop10[] = { 0x66, 0x66, 0x0F, 0x1F, 0x84, 0x00, 0x00, 0x00, 0x00, 0x00 };
    private static final int nop11[] = { 0x66, 0x66, 0x66, 0x0F, 0x1F, 0x84, 0x00, 0x00, 0x00, 0x00, 0x00 };

    public void align(long m) {
        if (_logger != null) _logger.logAlign(m);

        if (m < 1) return;

        if (m > 64) {
            assert (m <= 64);
            return;
        }

        int i = (int) (m - (offset() % m));
        if (i == m) return;

        if ((_properties & (1 << PROPERTY_OPTIMIZE_ALIGN)) != 0) {
            int n;

            if (cpuInfo.vendor == CpuInfo.Vendor.INTEL &&
               ((cpuInfo.family & 0x0F) == 6 ||
                (cpuInfo.family & 0x0F) == 15)) {
                do {
                    int[] p;
                    switch (i) {
                        case  1: p = nop1; n = 1; break;
                        case  2: p = nop2; n = 2; break;
                        case  3: p = nop3; n = 3; break;
                        case  4: p = nop4; n = 4; break;
                        case  5: p = nop5; n = 5; break;
                        case  6: p = nop6; n = 6; break;
                        case  7: p = nop7; n = 7; break;
                        case  8: p = nop8; n = 8; break;
                        default: p = nop9; n = 9; break;
                    }

                    i -= n;
                    for (int idx = 0; n > 0; ++idx, --n) {
                        _emitByte(p[idx]);
                    }
                } while (i > 0);

                return;
            }

            if (cpuInfo.vendor == CpuInfo.Vendor.AMD
                    && cpuInfo.family >= 0x0F) {
                do {
                    int[] p;
                    switch (i) {
                        case  1: p = nop1 ; n =  1; break;
                        case  2: p = nop2 ; n =  2; break;
                        case  3: p = nop3 ; n =  3; break;
                        case  4: p = nop4 ; n =  4; break;
                        case  5: p = nop5 ; n =  5; break;
                        case  6: p = nop6 ; n =  6; break;
                        case  7: p = nop7 ; n =  7; break;
                        case  8: p = nop8 ; n =  8; break;
                        case  9: p = nop9 ; n =  9; break;
                        case 10: p = nop10; n = 10; break;
                        default: p = nop11; n = 11; break;
                    }

                    i -= n;
                    for (int idx = 0; n > 0; ++idx, --n) {
                        _emitByte(p[idx]);
                    }
                } while (i > 0);

                return;
            }

            if (!is64()) {
                // legacy NOPs, 0x90 with 0x66 prefix.
                do {
                    switch (i) {
                        default: _emitByte(0x66); i--;
                        case  3: _emitByte(0x66); i--;
                        case  2: _emitByte(0x66); i--;
                        case  1: _emitByte(0x90); i--;
                    }
                } while (i > 0);
            }
        }

        // legacy NOPs, only 0x90
        // In 64-bit mode, we can't use 0x66 prefix
        while (i-- > 0) {
            _emitByte(0x90);
        }
    }

}
