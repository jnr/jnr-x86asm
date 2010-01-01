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

import static com.kenai.jnr.x86asm.INST_CODE.*;
import static com.kenai.jnr.x86asm.REG.*;

/**
 * Assembler instruction serializer.
 */
public abstract class SerializerIntrinsics extends SerializerCore {
  // -------------------------------------------------------------------------
  // [Embed]
  // -------------------------------------------------------------------------

//  public final void db(UInt8  x) ASMJIT_NOTHROW { _embed(&x, 1); }
//  public final void dw(UInt16 x) ASMJIT_NOTHROW { _embed(&x, 2); }
//  public final void dd(UInt32 x) ASMJIT_NOTHROW { _embed(&x, 4); }
//  public final void dq(UInt64 x) ASMJIT_NOTHROW { _embed(&x, 8); }
//
//  public final void dint8(Int8 x) ASMJIT_NOTHROW { _embed(&x, sizeof(Int8)); }
//  public final void duint8(UInt8 x) ASMJIT_NOTHROW { _embed(&x, sizeof(UInt8)); }
//
//  public final void dint16(Int16 x) ASMJIT_NOTHROW { _embed(&x, sizeof(Int16)); }
//  public final void duint16(UInt16 x) ASMJIT_NOTHROW { _embed(&x, sizeof(UInt16)); }
//
//  public final void dint32(Int32 x) ASMJIT_NOTHROW { _embed(&x, sizeof(Int32)); }
//  public final void duint32(UInt32 x) ASMJIT_NOTHROW { _embed(&x, sizeof(UInt32)); }
//
//  public final void dint64(Int64 x) ASMJIT_NOTHROW { _embed(&x, sizeof(Int64)); }
//  public final void duint64(UInt64 x) ASMJIT_NOTHROW { _embed(&x, sizeof(UInt64)); }
//
//  public final void dsysint(SysInt x) ASMJIT_NOTHROW { _embed(&x, sizeof(SysInt)); }
//  public final void dsysuint(SysUInt x) ASMJIT_NOTHROW { _embed(&x, sizeof(SysUInt)); }
//
//  public final void dfloat(float x) ASMJIT_NOTHROW { _embed(&x, sizeof(float)); }
//  public final void ddouble(double x) ASMJIT_NOTHROW { _embed(&x, sizeof(double)); }
//
//  public final void dptr(void* x) ASMJIT_NOTHROW { _embed(&x, sizeof(void*)); }
//
//  public final void dmm(const MMData& x) ASMJIT_NOTHROW { _embed(&x, sizeof(MMData)); }
//  public final void dxmm(const XMMData& x) ASMJIT_NOTHROW { _embed(&x, sizeof(XMMData)); }
//
//  public final void data(const void* data, SysUInt size) ASMJIT_NOTHROW { _embed(data, size); }
//
//  template<typename T>
//  public final void dstruct(const T& x) ASMJIT_NOTHROW { _embed(&x, sizeof(T)); }

  // -------------------------------------------------------------------------
  // [X86 Instructions]
  // -------------------------------------------------------------------------

  //! @brief Add with Carry.
  public final void adc(Register dst, Register src)
  {
    emitX86(INST_ADC, dst, src);
  }
  //! @brief Add with Carry.
  public final void adc(Register dst, Mem src)
  {
    emitX86(INST_ADC, dst, src);
  }
  //! @brief Add with Carry.
  public final void adc(Register dst, Immediate src)
  {
    emitX86(INST_ADC, dst, src);
  }
  //! @brief Add with Carry.
  public final void adc(Mem dst, Register src)
  {
    emitX86(INST_ADC, dst, src);
  }
  //! @brief Add with Carry.
  public final void adc(Mem dst, Immediate src)
  {
    emitX86(INST_ADC, dst, src);
  }

  //! @brief Add.
  public final void add(Register dst, Register src)
  {
    emitX86(INST_ADD, dst, src);
  }
  //! @brief Add.
  public final void add(Register dst, Mem src)
  {
    emitX86(INST_ADD, dst, src);
  }
  //! @brief Add.
  public final void add(Register dst, Immediate src)
  {
    emitX86(INST_ADD, dst, src);
  }
  //! @brief Add.
  public final void add(Mem dst, Register src)
  {
    emitX86(INST_ADD, dst, src);
  }
  //! @brief Add.
  public final void add(Mem dst, Immediate src)
  {
    emitX86(INST_ADD, dst, src);
  }

  //! @brief Logical And.
  public final void and_(Register dst, Register src)
  {
    emitX86(INST_AND, dst, src);
  }
  //! @brief Logical And.
  public final void and_(Register dst, Mem src)
  {
    emitX86(INST_AND, dst, src);
  }
  //! @brief Logical And.
  public final void and_(Register dst, Immediate src)
  {
    emitX86(INST_AND, dst, src);
  }
  //! @brief Logical And.
  public final void and_(Mem dst, Register src)
  {
    emitX86(INST_AND, dst, src);
  }
  //! @brief Logical And.
  public final void and_(Mem dst, Immediate src)
  {
    emitX86(INST_AND, dst, src);
  }

  //! @brief Bit Scan Forward.
  public final void bsf(Register dst, Register src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_BSF, dst, src);
  }
  //! @brief Bit Scan Forward.
  public final void bsf(Register dst, Mem src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_BSF, dst, src);
  }

  //! @brief Bit Scan Reverse.
  public final void bsr(Register dst, Register src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_BSR, dst, src);
  }
  //! @brief Bit Scan Reverse.
  public final void bsr(Register dst, Mem src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_BSR, dst, src);
  }

  //! @brief Byte swap (32 bit or 64 bit registers only) (i486).
  public final void bswap(Register dst)
  {
    assert(dst.type() == REG_GPD || dst.type() == REG_GPQ);
    emitX86(INST_BSWAP, dst);
  }

  //! @brief Bit test.
  public final void bt(Register dst, Register src)
  {
    emitX86(INST_BT, dst, src);
  }
  //! @brief Bit test.
  public final void bt(Register dst, Immediate src)
  {
    emitX86(INST_BT, dst, src);
  }
  //! @brief Bit test.
  public final void bt(Mem dst, Register src)
  {
    emitX86(INST_BT, dst, src);
  }
  //! @brief Bit test.
  public final void bt(Mem dst, Immediate src)
  {
    emitX86(INST_BT, dst, src);
  }

  //! @brief Bit test and complement.
  public final void btc(Register dst, Register src)
  {
    emitX86(INST_BTC, dst, src);
  }
  //! @brief Bit test and complement.
  public final void btc(Register dst, Immediate src)
  {
    emitX86(INST_BTC, dst, src);
  }
  //! @brief Bit test and complement.
  public final void btc(Mem dst, Register src)
  {
    emitX86(INST_BTC, dst, src);
  }
  //! @brief Bit test and complement.
  public final void btc(Mem dst, Immediate src)
  {
    emitX86(INST_BTC, dst, src);
  }

  //! @brief Bit test and reset.
  public final void btr(Register dst, Register src)
  {
    emitX86(INST_BTR, dst, src);
  }
  //! @brief Bit test and reset.
  public final void btr(Register dst, Immediate src)
  {
    emitX86(INST_BTR, dst, src);
  }
  //! @brief Bit test and reset.
  public final void btr(Mem dst, Register src)
  {
    emitX86(INST_BTR, dst, src);
  }
  //! @brief Bit test and reset.
  public final void btr(Mem dst, Immediate src)
  {
    emitX86(INST_BTR, dst, src);
  }

  //! @brief Bit test and set.
  public final void bts(Register dst, Register src)
  {
    emitX86(INST_BTS, dst, src);
  }
  //! @brief Bit test and set.
  public final void bts(Register dst, Immediate src)
  {
    emitX86(INST_BTS, dst, src);
  }
  //! @brief Bit test and set.
  public final void bts(Mem dst, Register src)
  {
    emitX86(INST_BTS, dst, src);
  }
  //! @brief Bit test and set.
  public final void bts(Mem dst, Immediate src)
  {
    emitX86(INST_BTS, dst, src);
  }

  //! @brief Call Procedure.
  public final void call(Register dst)
  {
    assert(dst.isRegType(is64() ? REG_GPQ : REG_GPD));
    emitX86(INST_CALL, dst);
  }
  //! @brief Call Procedure.
  public final void call(Mem dst)
  {
    emitX86(INST_CALL, dst);
  }
  //! @brief Call Procedure.
  public final void call(Immediate dst)
  {
    emitX86(INST_CALL, dst);
  }
  //! @brief Jump.
  //! @overload
  public final void call(long dst)
  {
    emitX86(INST_CALL, Immediate.imm(dst));
  }

  //! @brief Call Procedure.
  public final void call(Label label)
  {
    emitX86(INST_CALL, label);
  }

  //! @brief Convert Byte to Word (Sign Extend).
  //!
  //! AX <- Sign Extend AL
  public final void cbw()
  {
    emitX86(INST_CBW);
  }

  //! @brief Convert Word to DWord (Sign Extend).
  //!
  //! EAX <- Sign Extend AX
  public final void cwde()
  {
    emitX86(INST_CWDE);
  }

  //! @brief Convert DWord to QWord (Sign Extend).
  //!
  //! RAX <- Sign Extend EAX
  public final void cdqe()
  {
    emitX86(INST_CDQE);
  }

  //! @brief Clear CARRY flag
  //!
  //! This instruction clears the CF flag in the EFLAGS register.
  public final void clc()
  {
    emitX86(INST_CLC);
  }

  //! @brief Clear Direction flag
  //!
  //! This instruction clears the DF flag in the EFLAGS register.
  public final void cld()
  {
    emitX86(INST_CLD);
  }

  //! @brief Complement Carry Flag.
  //!
  //! This instruction complements the CF flag in the EFLAGS register.
  //! (CF = NOT CF)
  public final void cmc()
  {
    emitX86(INST_CMC);
  }

  //! @brief Conditional Move.
  public final void cmov(CONDITION cc, Register dst, Register src)
  {
    emitX86(conditionToCMovCC(cc), dst, src);
  }

  //! @brief Conditional Move.
  public final void cmov(CONDITION cc, Register dst, Mem src)
  {
    emitX86(conditionToCMovCC(cc), dst, src);
  }

  //! @brief Conditional Move.
  public final void cmova  (Register dst, Register src) { emitX86(INST_CMOVA  , dst, src); }
  //! @brief Conditional Move.
  public final void cmova  (Register dst, Mem src)      { emitX86(INST_CMOVA  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovae (Register dst, Register src) { emitX86(INST_CMOVAE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovae (Register dst, Mem src)      { emitX86(INST_CMOVAE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovb  (Register dst, Register src) { emitX86(INST_CMOVB  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovb  (Register dst, Mem src)      { emitX86(INST_CMOVB  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovbe (Register dst, Register src) { emitX86(INST_CMOVBE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovbe (Register dst, Mem src)      { emitX86(INST_CMOVBE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovc  (Register dst, Register src) { emitX86(INST_CMOVC  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovc  (Register dst, Mem src)      { emitX86(INST_CMOVC  , dst, src); }
  //! @brief Conditional Move.
  public final void cmove  (Register dst, Register src) { emitX86(INST_CMOVE  , dst, src); }
  //! @brief Conditional Move.
  public final void cmove  (Register dst, Mem src)      { emitX86(INST_CMOVE  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovg  (Register dst, Register src) { emitX86(INST_CMOVG  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovg  (Register dst, Mem src)      { emitX86(INST_CMOVG  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovge (Register dst, Register src) { emitX86(INST_CMOVGE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovge (Register dst, Mem src)      { emitX86(INST_CMOVGE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovl  (Register dst, Register src) { emitX86(INST_CMOVL  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovl  (Register dst, Mem src)      { emitX86(INST_CMOVL  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovle (Register dst, Register src) { emitX86(INST_CMOVLE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovle (Register dst, Mem src)      { emitX86(INST_CMOVLE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovna (Register dst, Register src) { emitX86(INST_CMOVNA , dst, src); }
  //! @brief Conditional Move.
  public final void cmovna (Register dst, Mem src)      { emitX86(INST_CMOVNA , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnae(Register dst, Register src) { emitX86(INST_CMOVNAE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnae(Register dst, Mem src)      { emitX86(INST_CMOVNAE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnb (Register dst, Register src) { emitX86(INST_CMOVNB , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnb (Register dst, Mem src)      { emitX86(INST_CMOVNB , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnbe(Register dst, Register src) { emitX86(INST_CMOVNBE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnbe(Register dst, Mem src)      { emitX86(INST_CMOVNBE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnc (Register dst, Register src) { emitX86(INST_CMOVNC , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnc (Register dst, Mem src)      { emitX86(INST_CMOVNC , dst, src); }
  //! @brief Conditional Move.
  public final void cmovne (Register dst, Register src) { emitX86(INST_CMOVNE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovne (Register dst, Mem src)      { emitX86(INST_CMOVNE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovng (Register dst, Register src) { emitX86(INST_CMOVNG , dst, src); }
  //! @brief Conditional Move.
  public final void cmovng (Register dst, Mem src)      { emitX86(INST_CMOVNG , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnge(Register dst, Register src) { emitX86(INST_CMOVNGE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnge(Register dst, Mem src)      { emitX86(INST_CMOVNGE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnl (Register dst, Register src) { emitX86(INST_CMOVNL , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnl (Register dst, Mem src)      { emitX86(INST_CMOVNL , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnle(Register dst, Register src) { emitX86(INST_CMOVNLE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovnle(Register dst, Mem src)      { emitX86(INST_CMOVNLE, dst, src); }
  //! @brief Conditional Move.
  public final void cmovno (Register dst, Register src) { emitX86(INST_CMOVNO , dst, src); }
  //! @brief Conditional Move.
  public final void cmovno (Register dst, Mem src)      { emitX86(INST_CMOVNO , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnp (Register dst, Register src) { emitX86(INST_CMOVNP , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnp (Register dst, Mem src)      { emitX86(INST_CMOVNP , dst, src); }
  //! @brief Conditional Move.
  public final void cmovns (Register dst, Register src) { emitX86(INST_CMOVNS , dst, src); }
  //! @brief Conditional Move.
  public final void cmovns (Register dst, Mem src)      { emitX86(INST_CMOVNS , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnz (Register dst, Register src) { emitX86(INST_CMOVNZ , dst, src); }
  //! @brief Conditional Move.
  public final void cmovnz (Register dst, Mem src)      { emitX86(INST_CMOVNZ , dst, src); }
  //! @brief Conditional Move.
  public final void cmovo  (Register dst, Register src) { emitX86(INST_CMOVO  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovo  (Register dst, Mem src)      { emitX86(INST_CMOVO  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovp  (Register dst, Register src) { emitX86(INST_CMOVP  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovp  (Register dst, Mem src)      { emitX86(INST_CMOVP  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovpe (Register dst, Register src) { emitX86(INST_CMOVPE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovpe (Register dst, Mem src)      { emitX86(INST_CMOVPE , dst, src); }
  //! @brief Conditional Move.
  public final void cmovpo (Register dst, Register src) { emitX86(INST_CMOVPO , dst, src); }
  //! @brief Conditional Move.
  public final void cmovpo (Register dst, Mem src)      { emitX86(INST_CMOVPO , dst, src); }
  //! @brief Conditional Move.
  public final void cmovs  (Register dst, Register src) { emitX86(INST_CMOVS  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovs  (Register dst, Mem src)      { emitX86(INST_CMOVS  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovz  (Register dst, Register src) { emitX86(INST_CMOVZ  , dst, src); }
  //! @brief Conditional Move.
  public final void cmovz  (Register dst, Mem src)      { emitX86(INST_CMOVZ  , dst, src); }

  //! @brief Compare Two Operands.
  public final void cmp(Register dst, Register src)
  {
    emitX86(INST_CMP, dst, src);
  }
  //! @brief Compare Two Operands.
  public final void cmp(Register dst, Mem src)
  {
    emitX86(INST_CMP, dst, src);
  }
  //! @brief Compare Two Operands.
  public final void cmp(Register dst, Immediate src)
  {
    emitX86(INST_CMP, dst, src);
  }
  //! @brief Compare Two Operands.
  public final void cmp(Mem dst, Register src)
  {
    emitX86(INST_CMP, dst, src);
  }
  //! @brief Compare Two Operands.
  public final void cmp(Mem dst, Immediate src)
  {
    emitX86(INST_CMP, dst, src);
  }

  //! @brief Compare and Exchange (i486).
  public final void cmpxchg(Register dst, Register src)
  {
    emitX86(INST_CMPXCHG, dst, src);
  }
  //! @brief Compare and Exchange (i486).
  public final void cmpxchg(Mem dst, Register src)
  {
    emitX86(INST_CMPXCHG, dst, src);
  }

  //! @brief Compares the 64-bit value in EDX:EAX with the memory operand (Pentium).
  //!
  //! If the values are equal, then this instruction stores the 64-bit value
  //! in ECX:EBX into the memory operand and sets the zero flag. Otherwise,
  //! this instruction copies the 64-bit memory operand into the EDX:EAX
  //! registers and clears the zero flag.
  public final void cmpxchg8b(Mem dst)
  {
    emitX86(INST_CMPXCHG8B, dst);
  }

  //! @brief Compares the 128-bit value in RDX:RAX with the memory operand.
  //!
  //! If the values are equal, then this instruction stores the 128-bit value
  //! in RCX:RBX into the memory operand and sets the zero flag. Otherwise,
  //! this instruction copies the 128-bit memory operand into the RDX:RAX
  //! registers and clears the zero flag.
  public final void cmpxchg16b(Mem dst)
  {
    emitX86(INST_CMPXCHG16B, dst);
  }

  //! @brief CPU Identification (i486).
  public final void cpuid()
  {
    emitX86(INST_CPUID);
  }

  //! @brief Decimal adjust AL after addition
  //!
  //! This instruction adjusts the sum of two packed BCD values to create
  //! a packed BCD result.
  //!
  //! @note This instruction is only available in 32 bit mode.
  public final void daa()
  {
    emitX86(INST_DAA);
  }

  //! @brief Decimal adjust AL after subtraction
  //!
  //! This instruction adjusts the result of the subtraction of two packed
  //! BCD values to create a packed BCD result.
  //!
  //! @note This instruction is only available in 32 bit mode.
  public final void das()
  {
    emitX86(INST_DAS);
  }

  //! @brief Decrement by 1.
  //! @note This instruction can be slower than sub(dst, 1)
  public final void dec(Register dst)
  {
    emitX86(INST_DEC, dst);
  }
  //! @brief Decrement by 1.
  //! @note This instruction can be slower than sub(dst, 1)
  public final void dec(Mem dst)
  {
    emitX86(INST_DEC, dst);
  }

  //! @brief Unsigned divide.
  //!
  //! This instruction divides (unsigned) the value in the AL, AX, or EAX
  //! register by the source operand and stores the result in the AX,
  //! DX:AX, or EDX:EAX registers.
  public final void div(Register src)
  {
    emitX86(INST_DIV, src);
  }
  //! @brief Unsigned divide.
  //! @overload
  public final void div(Mem src)
  {
    emitX86(INST_DIV, src);
  }

  //! @brief Make Stack Frame for Procedure Parameters.
  public final void enter(Immediate imm16, Immediate imm8)
  {
    emitX86(INST_ENTER, imm16, imm8);
  }

  //! @brief Signed divide.
  //!
  //! This instruction divides (signed) the value in the AL, AX, or EAX
  //! register by the source operand and stores the result in the AX,
  //! DX:AX, or EDX:EAX registers.
  public final void idiv(Register src)
  {
    emitX86(INST_IDIV, src);
  }
  //! @brief Signed divide.
  //! @overload
  public final void idiv(Mem src)
  {
    emitX86(INST_IDIV, src);
  }

  //! @brief Signed multiply.
  //!
  //! Source operand (in a general-purpose register or memory location)
  //! is multiplied by the value in the AL, AX, or EAX register (depending
  //! on the operand size) and the product is stored in the AX, DX:AX, or
  //! EDX:EAX registers, respectively.
  public final void imul(Register src)
  {
    emitX86(INST_IMUL, src);
  }
  //! @overload
  public final void imul(Mem src)
  {
    emitX86(INST_IMUL, src);
  }

  //! @brief Signed multiply.
  //!
  //! Destination operand (the first operand) is multiplied by the source
  //! operand (second operand). The destination operand is a generalpurpose
  //! register and the source operand is an immediate value, a general-purpose
  //! register, or a memory location. The product is then stored in the
  //! destination operand location.
  public final void imul(Register dst, Register src)
  {
    emitX86(INST_IMUL, dst, src);
  }
  //! @brief Signed multiply.
  //! @overload
  public final void imul(Register dst, Mem src)
  {
    emitX86(INST_IMUL, dst, src);
  }
  //! @brief Signed multiply.
  //! @overload
  public final void imul(Register dst, Immediate src)
  {
    emitX86(INST_IMUL, dst, src);
  }

  //! @brief Signed multiply.
  //!
  //! source operand (which can be a general-purpose register or a memory
  //! location) is multiplied by the second source operand (an immediate
  //! value). The product is then stored in the destination operand
  //! (a general-purpose register).
  public final void imul(Register dst, Register src, Immediate imm)
  {
    emitX86(INST_IMUL, dst, src, imm);
  }
  //! @overload
  public final void imul(Register dst, Mem src, Immediate imm)
  {
    emitX86(INST_IMUL, dst, src, imm);
  }

  //! @brief Increment by 1.
  //! @note This instruction can be slower than add(dst, 1)
  public final void inc(Register dst)
  {
    emitX86(INST_INC, dst);
  }
  //! @brief Increment by 1.
  //! @note This instruction can be slower than add(dst, 1)
  public final void inc(Mem dst)
  {
    emitX86(INST_INC, dst);
  }

  //! @brief Interrupt 3 � trap to debugger.
  public final void int3()
  {
    emitX86(INST_INT3);
  }

  //! @brief Jump to label @a label if condition @a cc is met.
  //!
  //! This instruction checks the state of one or more of the status flags in
  //! the EFLAGS register (CF, OF, PF, SF, and ZF) and, if the flags are in the
  //! specified state (condition), performs a jump to the target instruction
  //! specified by the destination operand. A condition code (cc) is associated
  //! with each instruction to indicate the condition being tested for. If the
  //! condition is not satisfied, the jump is not performed and execution
  //! continues with the instruction following the Jcc instruction.
  public final void j(CONDITION cc, Label label, int hint)
  {
    _emitJcc(conditionToJCC(cc), label, hint);
  }

  //! @brief Jump to label @a label if condition is met.
  public final void ja  (Label label, int hint) { _emitJcc(INST_JA  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jae (Label label, int hint) { _emitJcc(INST_JAE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jb  (Label label, int hint) { _emitJcc(INST_JB  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jbe (Label label, int hint) { _emitJcc(INST_JBE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jc  (Label label, int hint) { _emitJcc(INST_JC  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void je  (Label label, int hint) { _emitJcc(INST_JE  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jg  (Label label, int hint) { _emitJcc(INST_JG  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jge (Label label, int hint) { _emitJcc(INST_JGE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jl  (Label label, int hint) { _emitJcc(INST_JL  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jle (Label label, int hint) { _emitJcc(INST_JLE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jna (Label label, int hint) { _emitJcc(INST_JNA , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnae(Label label, int hint) { _emitJcc(INST_JNAE, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnb (Label label, int hint) { _emitJcc(INST_JNB , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnbe(Label label, int hint) { _emitJcc(INST_JNBE, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnc (Label label, int hint) { _emitJcc(INST_JNC , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jne (Label label, int hint) { _emitJcc(INST_JNE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jng (Label label, int hint) { _emitJcc(INST_JNG , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnge(Label label, int hint) { _emitJcc(INST_JNGE, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnl (Label label, int hint) { _emitJcc(INST_JNL , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnle(Label label, int hint) { _emitJcc(INST_JNLE, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jno (Label label, int hint) { _emitJcc(INST_JNO , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnp (Label label, int hint) { _emitJcc(INST_JNP , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jns (Label label, int hint) { _emitJcc(INST_JNS , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnz (Label label, int hint) { _emitJcc(INST_JNZ , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jo  (Label label, int hint) { _emitJcc(INST_JO  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jp  (Label label, int hint) { _emitJcc(INST_JP  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jpe (Label label, int hint) { _emitJcc(INST_JPE , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jpo (Label label, int hint) { _emitJcc(INST_JPO , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void js  (Label label, int hint) { _emitJcc(INST_JS  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jz  (Label label, int hint) { _emitJcc(INST_JZ  , label, hint); }

  //! @brief Jump to label @a label if condition @a cc is met.
  //!
  //! This instruction checks the state of one or more of the status flags in
  //! the EFLAGS register (CF, OF, PF, SF, and ZF) and, if the flags are in the
  //! specified state (condition), performs a jump to the target instruction
  //! specified by the destination operand. A condition code (cc) is associated
  //! with each instruction to indicate the condition being tested for. If the
  //! condition is not satisfied, the jump is not performed and execution
  //! continues with the instruction following the Jcc instruction.
  public final void j_short(CONDITION cc, Label label, int hint)
  {
    // Adjust returned condition to jxx_short version.
    _emitJcc(INST_CODE.valueOf(conditionToJCC(cc).ordinal() + INST_J_SHORT.ordinal() - INST_J.ordinal()), label, hint);
  }

  //! @brief Jump to label @a label if condition is met.
  public final void ja_short  (Label label, int hint) { _emitJcc(INST_JA_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jae_short (Label label, int hint) { _emitJcc(INST_JAE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jb_short  (Label label, int hint) { _emitJcc(INST_JB_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jbe_short (Label label, int hint) { _emitJcc(INST_JBE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jc_short  (Label label, int hint) { _emitJcc(INST_JC_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void je_short  (Label label, int hint) { _emitJcc(INST_JE_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jg_short  (Label label, int hint) { _emitJcc(INST_JG_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jge_short (Label label, int hint) { _emitJcc(INST_JGE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jl_short  (Label label, int hint) { _emitJcc(INST_JL_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jle_short (Label label, int hint) { _emitJcc(INST_JLE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jna_short (Label label, int hint) { _emitJcc(INST_JNA_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnae_short(Label label, int hint) { _emitJcc(INST_JNAE_SHORT, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnb_short (Label label, int hint) { _emitJcc(INST_JNB_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnbe_short(Label label, int hint) { _emitJcc(INST_JNBE_SHORT, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnc_short (Label label, int hint) { _emitJcc(INST_JNC_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jne_short (Label label, int hint) { _emitJcc(INST_JNE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jng_short (Label label, int hint) { _emitJcc(INST_JNG_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnge_short(Label label, int hint) { _emitJcc(INST_JNGE_SHORT, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnl_short (Label label, int hint) { _emitJcc(INST_JNL_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnle_short(Label label, int hint) { _emitJcc(INST_JNLE_SHORT, label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jno_short (Label label, int hint) { _emitJcc(INST_JNO_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnp_short (Label label, int hint) { _emitJcc(INST_JNP_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jns_short (Label label, int hint) { _emitJcc(INST_JNS_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jnz_short (Label label, int hint) { _emitJcc(INST_JNZ_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jo_short  (Label label, int hint) { _emitJcc(INST_JO_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jp_short  (Label label, int hint) { _emitJcc(INST_JP_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jpe_short (Label label, int hint) { _emitJcc(INST_JPE_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jpo_short (Label label, int hint) { _emitJcc(INST_JPO_SHORT , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void js_short  (Label label, int hint) { _emitJcc(INST_JS_SHORT  , label, hint); }
  //! @brief Jump to label @a label if condition is met.
  public final void jz_short  (Label label, int hint) { _emitJcc(INST_JZ_SHORT  , label, hint); }

  //! @brief Jump.
  //! @overload
  public final void jmp(Register dst)
  {
    emitX86(INST_JMP, dst);
  }
  //! @brief Jump.
  //! @overload
  public final void jmp(Mem dst)
  {
    emitX86(INST_JMP, dst);
  }
  //! @brief Jump.
  //! @overload
  public final void jmp(Immediate dst)
  {
    emitX86(INST_JMP, dst);
  }

  //! @brief Jump.
  //! @overload
  public final void jmp(long dst)
  {
    emitX86(INST_JMP, Immediate.imm(dst));
  }

  //! @brief Jump.
  //!
  //! This instruction transfers program control to a different point
  //! in the instruction stream without recording return information.
  //! The destination (target) operand specifies the label of the
  //! instruction being jumped to.
  public final void jmp(Label label)
  {
    emitX86(INST_JMP, label);
  }
  //! @brief Jump, see @c jmp().
  public final void jmp_short(Label label)
  {
    emitX86(INST_JMP_SHORT, label);
  }

  //! @brief Load Effective Address
  //!
  //! This instruction computes the effective address of the second
  //! operand (the source operand) and stores it in the first operand
  //! (destination operand). The source operand is a memory address
  //! (offset part) specified with one of the processors addressing modes.
  //! The destination operand is a general-purpose register.
  public final void lea(Register dst, Mem src)
  {
    emitX86(INST_LEA, dst, src);
  }

  //! @brief High Level Procedure Exit.
  public final void leave()
  {
    emitX86(INST_LEAVE);
  }

  //! @brief Assert LOCK# Signal Prefix.
  //!
  //! This instruction causes the processor�s LOCK# signal to be asserted
  //! during execution of the accompanying instruction (turns the
  //! instruction into an atomic instruction). In a multiprocessor environment,
  //! the LOCK# signal insures that the processor has exclusive use of any shared
  //! memory while the signal is asserted.
  //!
  //! The LOCK prefix can be prepended only to the following instructions and
  //! to those forms of the instructions that use a memory operand: ADD, ADC,
  //! AND, BTC, BTR, BTS, CMPXCHG, DEC, INC, NEG, NOT, OR, SBB, SUB, XOR, XADD,
  //! and XCHG. An undefined opcode exception will be generated if the LOCK
  //! prefix is used with any other instruction. The XCHG instruction always
  //! asserts the LOCK# signal regardless of the presence or absence of the LOCK
  //! prefix.
  public final void lock()
  {
    emitX86(INST_LOCK);
  }

  //! @brief Move.
  //!
  //! This instruction copies the second operand (source operand) to the first
  //! operand (destination operand). The source operand can be an immediate
  //! value, general-purpose register, segment register, or memory location.
  //! The destination register can be a general-purpose register, segment
  //! register, or memory location. Both operands must be the same size, which
  //! can be a byte, a word, or a DWORD.
  //!
  //! @note To move MMX or SSE registers to/from GP registers or memory, use
  //! corresponding functions: @c movd(), @c movq(), etc. Passing MMX or SSE
  //! registers to @c mov() is illegal.
  public final void mov(Register dst, Register src)
  {
    emitX86(INST_MOV, dst, src);
  }
  //! @brief Move.
  //! @overload
  public final void mov(Register dst, Mem src)
  {
    emitX86(INST_MOV, dst, src);
  }
  //! @brief Move.
  //! @overload
  public final void mov(Register dst, Immediate src)
  {
    emitX86(INST_MOV, dst, src);
  }
  //! @brief Move.
  //! @overload
  public final void mov(Mem dst, Register src)
  {
    emitX86(INST_MOV, dst, src);
  }
  //! @brief Move.
  //! @overload
  public final void mov(Mem dst, Immediate src)
  {
    emitX86(INST_MOV, dst, src);
  }

  //! @brief Move byte, word, dword or qword from absolute address @a src to
  //! AL, AX, EAX or RAX register.
  public final void mov_ptr(Register dst, long src)
  {
    assert dst.index() == 0;
    emitX86(INST_MOV_PTR, dst, Immediate.imm(src));
  }

  //! @brief Move byte, word, dword or qword from AL, AX, EAX or RAX register
  //! to absolute address @a dst.
  public final void mov_ptr(long dst, Register src)
  {
    assert src.index() == 0;
    emitX86(INST_MOV_PTR, Immediate.imm(dst), src);
  }

  //! @brief Move with Sign-Extension.
  //!
  //! This instruction copies the contents of the source operand (register
  //! or memory location) to the destination operand (register) and sign
  //! extends the value to 16, 32 or 64 bits.
  //!
  //! @sa movsxd().
  public final void movsx(Register dst, Register src)
  {
    emitX86(INST_MOVSX, dst, src);
  }
  //! @brief Move with Sign-Extension.
  //! @overload
  public final void movsx(Register dst, Mem src)
  {
    emitX86(INST_MOVSX, dst, src);
  }

  //! @brief Move DWord to QWord with sign-extension.
  public final void movsxd(Register dst, Register src)
  {
    emitX86(INST_MOVSXD, dst, src);
  }
  //! @brief Move DWord to QWord with sign-extension.
  //! @overload
  public final void movsxd(Register dst, Mem src)
  {
    emitX86(INST_MOVSXD, dst, src);
  }

  //! @brief Move with Zero-Extend.
  //!
  //! This instruction copies the contents of the source operand (register
  //! or memory location) to the destination operand (register) and zero
  //! extends the value to 16 or 32 bits. The size of the converted value
  //! depends on the operand-size attribute.
  public final void movzx(Register dst, Register src)
  {
    emitX86(INST_MOVZX, dst, src);
  }
  //! @brief Move with Zero-Extend.
  //! @brief Overload
  public final void movzx(Register dst, Mem src)
  {
    emitX86(INST_MOVZX, dst, src);
  }

  //! @brief Unsigned multiply.
  //!
  //! Source operand (in a general-purpose register or memory location)
  //! is multiplied by the value in the AL, AX, or EAX register (depending
  //! on the operand size) and the product is stored in the AX, DX:AX, or
  //! EDX:EAX registers, respectively.
  public final void mul(Register src)
  {
    emitX86(INST_MUL, src);
  }
  //! @brief Unsigned multiply.
  //! @overload
  public final void mul(Mem src)
  {
    emitX86(INST_MUL, src);
  }

  //! @brief Two's Complement Negation.
  public final void neg(Register dst)
  {
    emitX86(INST_NEG, dst);
  }
  //! @brief Two's Complement Negation.
  public final void neg(Mem dst)
  {
    emitX86(INST_NEG, dst);
  }

  //! @brief No Operation.
  //!
  //! This instruction performs no operation. This instruction is a one-byte
  //! instruction that takes up space in the instruction stream but does not
  //! affect the machine context, except the EIP register. The NOP instruction
  //! is an alias mnemonic for the XCHG (E)AX, (E)AX instruction.
  public final void nop()
  {
    emitX86(INST_NOP);
  }

  //! @brief One's Complement Negation.
  public final void not_(Register dst)
  {
    emitX86(INST_NOT, dst);
  }
  //! @brief One's Complement Negation.
  public final void not_(Mem dst)
  {
    emitX86(INST_NOT, dst);
  }

  //! @brief Logical Inclusive OR.
  public final void or_(Register dst, Register src)
  {
    emitX86(INST_OR, dst, src);
  }
  //! @brief Logical Inclusive OR.
  public final void or_(Register dst, Mem src)
  {
    emitX86(INST_OR, dst, src);
  }
  //! @brief Logical Inclusive OR.
  public final void or_(Register dst, Immediate src)
  {
    emitX86(INST_OR, dst, src);
  }
  //! @brief Logical Inclusive OR.
  public final void or_(Mem dst, Register src)
  {
    emitX86(INST_OR, dst, src);
  }
  //! @brief Logical Inclusive OR.
  public final void or_(Mem dst, Immediate src)
  {
    emitX86(INST_OR, dst, src);
  }

  //! @brief Pop a Value from the Stack.
  //!
  //! This instruction loads the value from the top of the stack to the location
  //! specified with the destination operand and then increments the stack pointer.
  //! The destination operand can be a general purpose register, memory location,
  //! or segment register.
  public final void pop(Register dst)
  {
    assert(dst.isRegType(REG_GPW) || dst.isRegType(is64() ? REG_GPQ : REG_GPD));
    emitX86(INST_POP, dst);
  }

  public final void pop(Mem dst)
  {
    assert(dst.size() == 2 || dst.size() == (is64() ? 8 : 4));
    emitX86(INST_POP, dst);
  }

  //! @brief Pop All General-Purpose Registers.
  //!
  //! Pop EDI, ESI, EBP, EBX, EDX, ECX, and EAX.
  public final void popad()
  {
    emitX86(INST_POPAD);
  }

  //! @brief Pop Stack into EFLAGS Register (32 bit or 64 bit).
  public final void popf()
  {
      if (!is64()) {
          popfd();
      } else {
          popfq();
      }
  }


  //! @brief Pop Stack into EFLAGS Register (32 bit).
  public final void popfd() { emitX86(INST_POPFD); }

  //! @brief Pop Stack into EFLAGS Register (64 bit).
  public final void popfq() { emitX86(INST_POPFQ); }


  //! @brief Push WORD/DWORD/QWORD Onto the Stack.
  //!
  //! @note 32 bit architecture pushed DWORD while 64 bit
  //! pushes QWORD. 64 bit mode not provides instruction to
  //! push 32 bit register/memory.
  public final void push(Register src)
  {
    //assert(src.isRegType(REG_GPW) || src.isRegType(REG_GPN));
    emitX86(INST_PUSH, src);
  }
  //! @brief Push WORD/DWORD/QWORD Onto the Stack.
  public final void push(Mem src)
  {
    assert(src.size() == 2 || src.size() == (is64() ? 8 : 4));
    emitX86(INST_PUSH, src);
  }
  //! @brief Push WORD/DWORD/QWORD Onto the Stack.
  public final void push(Immediate src)
  {
    emitX86(INST_PUSH, src);
  }

  //! @brief Push All General-Purpose Registers.
  //!
  //! Push EAX, ECX, EDX, EBX, original ESP, EBP, ESI, and EDI.
  public final void pushad()
  {
    emitX86(INST_PUSHAD);
  }

  //! @brief Push EFLAGS Register (32 bit or 64 bit) onto the Stack.
  public final void pushf()
  {
    if (!is64()) {
        pushfd();
    } else {
        pushfq();
    }
  }

  //! @brief Push EFLAGS Register (32 bit) onto the Stack.
  public final void pushfd() { emitX86(INST_PUSHFD); }
  //! @brief Push EFLAGS Register (64 bit) onto the Stack.
  public final void pushfq() { emitX86(INST_PUSHFQ); }

  //! @brief Rotate Bits Left.
  //! @note @a src register can be only @c cl.
  public final void rcl(Register dst, Register src)
  {
    emitX86(INST_RCL, dst, src);
  }
  //! @brief Rotate Bits Left.
  public final void rcl(Register dst, Immediate src)
  {
    emitX86(INST_RCL, dst, src);
  }
  //! @brief Rotate Bits Left.
  //! @note @a src register can be only @c cl.
  public final void rcl(Mem dst, Register src)
  {
    emitX86(INST_RCL, dst, src);
  }
  //! @brief Rotate Bits Left.
  public final void rcl(Mem dst, Immediate src)
  {
    emitX86(INST_RCL, dst, src);
  }

  //! @brief Rotate Bits Right.
  //! @note @a src register can be only @c cl.
  public final void rcr(Register dst, Register src)
  {
    emitX86(INST_RCR, dst, src);
  }
  //! @brief Rotate Bits Right.
  public final void rcr(Register dst, Immediate src)
  {
    emitX86(INST_RCR, dst, src);
  }
  //! @brief Rotate Bits Right.
  //! @note @a src register can be only @c cl.
  public final void rcr(Mem dst, Register src)
  {
    emitX86(INST_RCR, dst, src);
  }
  //! @brief Rotate Bits Right.
  public final void rcr(Mem dst, Immediate src)
  {
    emitX86(INST_RCR, dst, src);
  }

  //! @brief Read Time-Stamp Counter (Pentium).
  public final void rdtsc()
  {
    emitX86(INST_RDTSC);
  }

  //! @brief Read Time-Stamp Counter and Processor ID (New).
  public final void rdtscp()
  {
    emitX86(INST_RDTSCP);
  }

  //! @brief Return from Procedure.
  public final void ret()
  {
    emitX86(INST_RET);
  }

  //! @brief Return from Procedure.
  public final void ret(Immediate imm16)
  {
    emitX86(INST_RET, imm16);
  }

  //! @brief Rotate Bits Left.
  //! @note @a src register can be only @c cl.
  public final void rol(Register dst, Register src)
  {
    emitX86(INST_ROL, dst, src);
  }
  //! @brief Rotate Bits Left.
  public final void rol(Register dst, Immediate src)
  {
    emitX86(INST_ROL, dst, src);
  }
  //! @brief Rotate Bits Left.
  //! @note @a src register can be only @c cl.
  public final void rol(Mem dst, Register src)
  {
    emitX86(INST_ROL, dst, src);
  }
  //! @brief Rotate Bits Left.
  public final void rol(Mem dst, Immediate src)
  {
    emitX86(INST_ROL, dst, src);
  }

  //! @brief Rotate Bits Right.
  //! @note @a src register can be only @c cl.
  public final void ror(Register dst, Register src)
  {
    emitX86(INST_ROR, dst, src);
  }
  //! @brief Rotate Bits Right.
  public final void ror(Register dst, Immediate src)
  {
    emitX86(INST_ROR, dst, src);
  }
  //! @brief Rotate Bits Right.
  //! @note @a src register can be only @c cl.
  public final void ror(Mem dst, Register src)
  {
    emitX86(INST_ROR, dst, src);
  }
  //! @brief Rotate Bits Right.
  public final void ror(Mem dst, Immediate src)
  {
    emitX86(INST_ROR, dst, src);
  }

  //! @brief Store AH into Flags.
  public final void sahf()
  {
    emitX86(INST_SAHF);
  }

  //! @brief Integer subtraction with borrow.
  public final void sbb(Register dst, Register src)
  {
    emitX86(INST_SBB, dst, src);
  }
  //! @brief Integer subtraction with borrow.
  public final void sbb(Register dst, Mem src)
  {
    emitX86(INST_SBB, dst, src);
  }
  //! @brief Integer subtraction with borrow.
  public final void sbb(Register dst, Immediate src)
  {
    emitX86(INST_SBB, dst, src);
  }
  //! @brief Integer subtraction with borrow.
  public final void sbb(Mem dst, Register src)
  {
    emitX86(INST_SBB, dst, src);
  }
  //! @brief Integer subtraction with borrow.
  public final void sbb(Mem dst, Immediate src)
  {
    emitX86(INST_SBB, dst, src);
  }

  //! @brief Shift Bits Left.
  //! @note @a src register can be only @c cl.
  public final void sal(Register dst, Register src)
  {
    emitX86(INST_SAL, dst, src);
  }
  //! @brief Shift Bits Left.
  public final void sal(Register dst, Immediate src)
  {
    emitX86(INST_SAL, dst, src);
  }
  //! @brief Shift Bits Left.
  //! @note @a src register can be only @c cl.
  public final void sal(Mem dst, Register src)
  {
    emitX86(INST_SAL, dst, src);
  }
  //! @brief Shift Bits Left.
  public final void sal(Mem dst, Immediate src)
  {
    emitX86(INST_SAL, dst, src);
  }

  //! @brief Shift Bits Right.
  //! @note @a src register can be only @c cl.
  public final void sar(Register dst, Register src)
  {
    emitX86(INST_SAR, dst, src);
  }
  //! @brief Shift Bits Right.
  public final void sar(Register dst, Immediate src)
  {
    emitX86(INST_SAR, dst, src);
  }
  //! @brief Shift Bits Right.
  //! @note @a src register can be only @c cl.
  public final void sar(Mem dst, Register src)
  {
    emitX86(INST_SAR, dst, src);
  }
  //! @brief Shift Bits Right.
  public final void sar(Mem dst, Immediate src)
  {
    emitX86(INST_SAR, dst, src);
  }

  //! @brief Set Byte on Condition.
  public final void set(CONDITION cc, Register dst)
  {
    emitX86(conditionToSetCC(cc), dst);
  }

  //! @brief Set Byte on Condition.
  public final void set(CONDITION cc, Mem dst)
  {
    emitX86(conditionToSetCC(cc), dst);
  }

  //! @brief Set Byte on Condition.
  public final void seta  (Register dst) { emitX86(INST_SETA  , dst); }
  //! @brief Set Byte on Condition.
  public final void seta  (Mem dst)      { emitX86(INST_SETA  , dst); }
  //! @brief Set Byte on Condition.
  public final void setae (Register dst) { emitX86(INST_SETAE , dst); }
  //! @brief Set Byte on Condition.
  public final void setae (Mem dst)      { emitX86(INST_SETAE , dst); }
  //! @brief Set Byte on Condition.
  public final void setb  (Register dst) { emitX86(INST_SETB  , dst); }
  //! @brief Set Byte on Condition.
  public final void setb  (Mem dst)      { emitX86(INST_SETB  , dst); }
  //! @brief Set Byte on Condition.
  public final void setbe (Register dst) { emitX86(INST_SETBE , dst); }
  //! @brief Set Byte on Condition.
  public final void setbe (Mem dst)      { emitX86(INST_SETBE , dst); }
  //! @brief Set Byte on Condition.
  public final void setc  (Register dst) { emitX86(INST_SETC  , dst); }
  //! @brief Set Byte on Condition.
  public final void setc  (Mem dst)      { emitX86(INST_SETC  , dst); }
  //! @brief Set Byte on Condition.
  public final void sete  (Register dst) { emitX86(INST_SETE  , dst); }
  //! @brief Set Byte on Condition.
  public final void sete  (Mem dst)      { emitX86(INST_SETE  , dst); }
  //! @brief Set Byte on Condition.
  public final void setg  (Register dst) { emitX86(INST_SETG  , dst); }
  //! @brief Set Byte on Condition.
  public final void setg  (Mem dst)      { emitX86(INST_SETG  , dst); }
  //! @brief Set Byte on Condition.
  public final void setge (Register dst) { emitX86(INST_SETGE , dst); }
  //! @brief Set Byte on Condition.
  public final void setge (Mem dst)      { emitX86(INST_SETGE , dst); }
  //! @brief Set Byte on Condition.
  public final void setl  (Register dst) { emitX86(INST_SETL  , dst); }
  //! @brief Set Byte on Condition.
  public final void setl  (Mem dst)      { emitX86(INST_SETL  , dst); }
  //! @brief Set Byte on Condition.
  public final void setle (Register dst) { emitX86(INST_SETLE , dst); }
  //! @brief Set Byte on Condition.
  public final void setle (Mem dst)      { emitX86(INST_SETLE , dst); }
  //! @brief Set Byte on Condition.
  public final void setna (Register dst) { emitX86(INST_SETNA , dst); }
  //! @brief Set Byte on Condition.
  public final void setna (Mem dst)      { emitX86(INST_SETNA , dst); }
  //! @brief Set Byte on Condition.
  public final void setnae(Register dst) { emitX86(INST_SETNAE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnae(Mem dst)      { emitX86(INST_SETNAE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnb (Register dst) { emitX86(INST_SETNB , dst); }
  //! @brief Set Byte on Condition.
  public final void setnb (Mem dst)      { emitX86(INST_SETNB , dst); }
  //! @brief Set Byte on Condition.
  public final void setnbe(Register dst) { emitX86(INST_SETNBE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnbe(Mem dst)      { emitX86(INST_SETNBE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnc (Register dst) { emitX86(INST_SETNC , dst); }
  //! @brief Set Byte on Condition.
  public final void setnc (Mem dst)      { emitX86(INST_SETNC , dst); }
  //! @brief Set Byte on Condition.
  public final void setne (Register dst) { emitX86(INST_SETNE , dst); }
  //! @brief Set Byte on Condition.
  public final void setne (Mem dst)      { emitX86(INST_SETNE , dst); }
  //! @brief Set Byte on Condition.
  public final void setng (Register dst) { emitX86(INST_SETNG , dst); }
  //! @brief Set Byte on Condition.
  public final void setng (Mem dst)      { emitX86(INST_SETNG , dst); }
  //! @brief Set Byte on Condition.
  public final void setnge(Register dst) { emitX86(INST_SETNGE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnge(Mem dst)      { emitX86(INST_SETNGE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnl (Register dst) { emitX86(INST_SETNL , dst); }
  //! @brief Set Byte on Condition.
  public final void setnl (Mem dst)      { emitX86(INST_SETNL , dst); }
  //! @brief Set Byte on Condition.
  public final void setnle(Register dst) { emitX86(INST_SETNLE, dst); }
  //! @brief Set Byte on Condition.
  public final void setnle(Mem dst)      { emitX86(INST_SETNLE, dst); }
  //! @brief Set Byte on Condition.
  public final void setno (Register dst) { emitX86(INST_SETNO , dst); }
  //! @brief Set Byte on Condition.
  public final void setno (Mem dst)      { emitX86(INST_SETNO , dst); }
  //! @brief Set Byte on Condition.
  public final void setnp (Register dst) { emitX86(INST_SETNP , dst); }
  //! @brief Set Byte on Condition.
  public final void setnp (Mem dst)      { emitX86(INST_SETNP , dst); }
  //! @brief Set Byte on Condition.
  public final void setns (Register dst) { emitX86(INST_SETNS , dst); }
  //! @brief Set Byte on Condition.
  public final void setns (Mem dst)      { emitX86(INST_SETNS , dst); }
  //! @brief Set Byte on Condition.
  public final void setnz (Register dst) { emitX86(INST_SETNZ , dst); }
  //! @brief Set Byte on Condition.
  public final void setnz (Mem dst)      { emitX86(INST_SETNZ , dst); }
  //! @brief Set Byte on Condition.
  public final void seto  (Register dst) { emitX86(INST_SETO  , dst); }
  //! @brief Set Byte on Condition.
  public final void seto  (Mem dst)      { emitX86(INST_SETO  , dst); }
  //! @brief Set Byte on Condition.
  public final void setp  (Register dst) { emitX86(INST_SETP  , dst); }
  //! @brief Set Byte on Condition.
  public final void setp  (Mem dst)      { emitX86(INST_SETP  , dst); }
  //! @brief Set Byte on Condition.
  public final void setpe (Register dst) { emitX86(INST_SETPE , dst); }
  //! @brief Set Byte on Condition.
  public final void setpe (Mem dst)      { emitX86(INST_SETPE , dst); }
  //! @brief Set Byte on Condition.
  public final void setpo (Register dst) { emitX86(INST_SETPO , dst); }
  //! @brief Set Byte on Condition.
  public final void setpo (Mem dst)      { emitX86(INST_SETPO , dst); }
  //! @brief Set Byte on Condition.
  public final void sets  (Register dst) { emitX86(INST_SETS  , dst); }
  //! @brief Set Byte on Condition.
  public final void sets  (Mem dst)      { emitX86(INST_SETS  , dst); }
  //! @brief Set Byte on Condition.
  public final void setz  (Register dst) { emitX86(INST_SETZ  , dst); }
  //! @brief Set Byte on Condition.
  public final void setz  (Mem dst)      { emitX86(INST_SETZ  , dst); }

  //! @brief Shift Bits Left.
  //! @note @a src register can be only @c cl.
  public final void shl(Register dst, Register src)
  {
    emitX86(INST_SHL, dst, src);
  }
  //! @brief Shift Bits Left.
  public final void shl(Register dst, Immediate src)
  {
    emitX86(INST_SHL, dst, src);
  }
  //! @brief Shift Bits Left.
  //! @note @a src register can be only @c cl.
  public final void shl(Mem dst, Register src)
  {
    emitX86(INST_SHL, dst, src);
  }
  //! @brief Shift Bits Left.
  public final void shl(Mem dst, Immediate src)
  {
    emitX86(INST_SHL, dst, src);
  }

  //! @brief Shift Bits Right.
  //! @note @a src register can be only @c cl.
  public final void shr(Register dst, Register src)
  {
    emitX86(INST_SHR, dst, src);
  }
  //! @brief Shift Bits Right.
  public final void shr(Register dst, Immediate src)
  {
    emitX86(INST_SHR, dst, src);
  }
  //! @brief Shift Bits Right.
  //! @note @a src register can be only @c cl.
  public final void shr(Mem dst, Register src)
  {
    emitX86(INST_SHR, dst, src);
  }
  //! @brief Shift Bits Right.
  public final void shr(Mem dst, Immediate src)
  {
    emitX86(INST_SHR, dst, src);
  }

  //! @brief Double Precision Shift Left.
  //! @note src2 register can be only @c cl register.
  public final void shld(Register dst, Register src1, Register src2)
  {
    emitX86(INST_SHLD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Left.
  public final void shld(Register dst, Register src1, Immediate src2)
  {
    emitX86(INST_SHLD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Left.
  //! @note src2 register can be only @c cl register.
  public final void shld(Mem dst, Register src1, Register src2)
  {
    emitX86(INST_SHLD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Left.
  public final void shld(Mem dst, Register src1, Immediate src2)
  {
    emitX86(INST_SHLD, dst, src1, src2);
  }

  //! @brief Double Precision Shift Right.
  //! @note src2 register can be only @c cl register.
  public final void shrd(Register dst, Register src1, Register src2)
  {
    emitX86(INST_SHRD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Right.
  public final void shrd(Register dst, Register src1, Immediate src2)
  {
    emitX86(INST_SHRD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Right.
  //! @note src2 register can be only @c cl register.
  public final void shrd(Mem dst, Register src1, Register src2)
  {
    emitX86(INST_SHRD, dst, src1, src2);
  }
  //! @brief Double Precision Shift Right.
  public final void shrd(Mem dst, Register src1, Immediate src2)
  {
    emitX86(INST_SHRD, dst, src1, src2);
  }

  //! @brief Set Carry Flag to 1.
  public final void stc()
  {
    emitX86(INST_STC);
  }

  //! @brief Set Direction Flag to 1.
  public final void std()
  {
    emitX86(INST_STD);
  }

  //! @brief Subtract.
  public final void sub(Register dst, Register src)
  {
    emitX86(INST_SUB, dst, src);
  }
  //! @brief Subtract.
  public final void sub(Register dst, Mem src)
  {
    emitX86(INST_SUB, dst, src);
  }
  //! @brief Subtract.
  public final void sub(Register dst, Immediate src)
  {
    emitX86(INST_SUB, dst, src);
  }
  //! @brief Subtract.
  public final void sub(Mem dst, Register src)
  {
    emitX86(INST_SUB, dst, src);
  }
  //! @brief Subtract.
  public final void sub(Mem dst, Immediate src)
  {
    emitX86(INST_SUB, dst, src);
  }

  //! @brief Logical Compare.
  public final void test(Register op1, Register op2)
  {
    emitX86(INST_TEST, op1, op2);
  }
  //! @brief Logical Compare.
  public final void test(Register op1, Immediate op2)
  {
    emitX86(INST_TEST, op1, op2);
  }
  //! @brief Logical Compare.
  public final void test(Mem op1, Register op2)
  {
    emitX86(INST_TEST, op1, op2);
  }
  //! @brief Logical Compare.
  public final void test(Mem op1, Immediate op2)
  {
    emitX86(INST_TEST, op1, op2);
  }

  //! @brief Undefined instruction - Raise invalid opcode exception.
  public final void ud2()
  {
    emitX86(INST_UD2);
  }

  //! @brief Exchange and Add.
  public final void xadd(Register dst, Register src)
  {
    emitX86(INST_XADD, dst, src);
  }
  //! @brief Exchange and Add.
  public final void xadd(Mem dst, Register src)
  {
    emitX86(INST_XADD, dst, src);
  }

  //! @brief Exchange Register/Memory with Register.
  public final void xchg(Register dst, Register src)
  {
    emitX86(INST_XCHG, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xchg(Mem dst, Register src)
  {
    emitX86(INST_XCHG, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xchg(Register dst, Mem src)
  {
    emitX86(INST_XCHG, src, dst);
  }

  //! @brief Exchange Register/Memory with Register.
  public final void xor_(Register dst, Register src)
  {
    emitX86(INST_XOR, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xor_(Register dst, Mem src)
  {
    emitX86(INST_XOR, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xor_(Register dst, Immediate src)
  {
    emitX86(INST_XOR, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xor_(Mem dst, Register src)
  {
    emitX86(INST_XOR, dst, src);
  }
  //! @brief Exchange Register/Memory with Register.
  public final void xor_(Mem dst, Immediate src)
  {
    emitX86(INST_XOR, dst, src);
  }

  // -------------------------------------------------------------------------
  // [X87 Instructions (FPU)]
  // -------------------------------------------------------------------------

  //! @brief Compute 2^x - 1 (FPU).
  public final void f2xm1()
  {
    emitX86(INST_F2XM1);
  }

  //! @brief Absolute Value of st(0) (FPU).
  public final void fabs()
  {
    emitX86(INST_FABS);
  }

  //! @brief Add @a src to @a dst and store result in @a dst (FPU).
  //!
  //! @note One of dst or src must be st(0).
  public final void fadd(X87Register dst, X87Register src)
  {
    assert dst.index() == 0 || src.index() == 0;
    emitX86(INST_FADD, dst, src);
  }

  //! @brief Add @a src to st(0) and store result in st(0) (FPU).
  //!
  //! @note SP-FP or DP-FP determined by @a adr size.
  public final void fadd(Mem src)
  {
    emitX86(INST_FADD, src);
  }

  //! @brief Add st(0) to @a dst and POP register stack (FPU).
  public final void faddp(X87Register dst)
  {
    emitX86(INST_FADDP, dst);
  }

  //! @brief Add st(0) to @a dst and POP register stack (FPU).
  public final void faddp()
  {
      faddp(X87Register.st(1));
  }

  //! @brief Load Binary Coded Decimal (FPU).
  public final void fbld(Mem src)
  {
    emitX86(INST_FBLD, src);
  }

  //! @brief Store BCD Integer and Pop (FPU).
  public final void fbstp(Mem dst)
  {
    emitX86(INST_FBSTP, dst);
  }

  //! @brief Change st(0) Sign (FPU).
  public final void fchs()
  {
    emitX86(INST_FCHS);
  }

  //! @brief Clear Exceptions (FPU).
  //!
  //! Clear floating-point exception flags after checking for pending unmasked
  //! floatingpoint exceptions.
  //!
  //! Clears the floating-point exception flags (PE, UE, OE, ZE, DE, and IE),
  //! the exception summary status flag (ES), the stack fault flag (SF), and
  //! the busy flag (B) in the FPU status word. The FCLEX instruction checks
  //! for and handles any pending unmasked floating-point exceptions before
  //! clearing the exception flags.
  public final void fclex()
  {
    emitX86(INST_FCLEX);
  }

  //! @brief FP Conditional Move (FPU).
  public final void fcmovb(X87Register src)
  {
    emitX86(INST_FCMOVB, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovbe(X87Register src)
  {
    emitX86(INST_FCMOVBE, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmove(X87Register src)
  {
    emitX86(INST_FCMOVE, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovnb(X87Register src)
  {
    emitX86(INST_FCMOVNB, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovnbe(X87Register src)
  {
    emitX86(INST_FCMOVNBE, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovne(X87Register src)
  {
    emitX86(INST_FCMOVNE, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovnu(X87Register src)
  {
    emitX86(INST_FCMOVNU, src);
  }
  //! @brief FP Conditional Move (FPU).
  public final void fcmovu(X87Register src)
  {
    emitX86(INST_FCMOVU, src);
  }

  //! @brief Compare st(0) with @a reg (FPU).
  public final void fcom(X87Register reg)
  {
    emitX86(INST_FCOM, reg);
  }

  public final void fcom()
  {
    fcom(X87Register.st(1));
  }

  //! @brief Compare st(0) with 4 byte or 8 byte FP at @a src (FPU).
  public final void fcom(Mem src)
  {
    emitX86(INST_FCOM, src);
  }

  //! @brief Compare st(0) with @a reg and pop the stack (FPU).
  public final void fcomp(X87Register reg)
  {
    emitX86(INST_FCOMP, reg);
  }

  public final void fcomp()
  {
    fcomp(X87Register.st(1));
  }

  //! @brief Compare st(0) with 4 byte or 8 byte FP at @a adr and pop the
  //! stack (FPU).
  public final void fcomp(Mem mem)
  {
    emitX86(INST_FCOMP, mem);
  }

  //! @brief Compare st(0) with st(1) and pop register stack twice (FPU).
  public final void fcompp()
  {
    emitX86(INST_FCOMPP);
  }

  //! @brief Compare st(0) and @a reg and Set EFLAGS (FPU).
  public final void fcomi(X87Register reg)
  {
    emitX86(INST_FCOMI, reg);
  }

  //! @brief Compare st(0) and @a reg and Set EFLAGS and pop the stack (FPU).
  public final void fcomip(X87Register reg)
  {
    emitX86(INST_FCOMIP, reg);
  }

  //! @brief Cosine (FPU).
  //!
  //! This instruction calculates the cosine of the source operand in
  //! register st(0) and stores the result in st(0).
  public final void fcos()
  {
    emitX86(INST_FCOS);
  }

  //! @brief Decrement Stack-Top Pointer (FPU).
  //!
  //! Subtracts one from the TOP field of the FPU status word (decrements
  //! the top-ofstack pointer). If the TOP field contains a 0, it is set
  //! to 7. The effect of this instruction is to rotate the stack by one
  //! position. The contents of the FPU data registers and tag register
  //! are not affected.
  public final void fdecstp()
  {
    emitX86(INST_FDECSTP);
  }

  //! @brief Divide @a dst by @a src (FPU).
  //!
  //! @note One of @a dst or @a src register must be st(0).
  public final void fdiv(X87Register dst, X87Register src)
  {
    assert(dst.index() == 0 || src.index() == 0);
    emitX86(INST_FDIV, dst, src);
  }
  //! @brief Divide st(0) by 32 bit or 64 bit FP value (FPU).
  public final void fdiv(Mem src)
  {
    emitX86(INST_FDIV, src);
  }

  //! @brief Divide @a reg by st(0) (FPU).
  public final void fdivp(X87Register reg)
  {
    emitX86(INST_FDIVP, reg);
  }

  public final void fdivp()
  {
      fdivp(X87Register.st(1));
  }

  //! @brief Reverse Divide @a dst by @a src (FPU).
  //!
  //! @note One of @a dst or @a src register must be st(0).
  public final void fdivr(X87Register dst, X87Register src)
  {
    assert(dst.index() == 0 || src.index() == 0);
    emitX86(INST_FDIVR, dst, src);
  }
  //! @brief Reverse Divide st(0) by 32 bit or 64 bit FP value (FPU).
  public final void fdivr(Mem src)
  {
    emitX86(INST_FDIVR, src);
  }

  //! @brief Reverse Divide @a reg by st(0) (FPU).
  public final void fdivrp(X87Register reg)
  {
    emitX86(INST_FDIVRP, reg);
  }

  public final void fdivrp()
  {
    emitX86(INST_FDIVRP, X87Register.st(1));
  }

  //! @brief Free Floating-Point Register (FPU).
  //!
  //! Sets the tag in the FPU tag register associated with register @a reg
  //! to empty (11B). The contents of @a reg and the FPU stack-top pointer
  //! (TOP) are not affected.
  public final void ffree(X87Register reg)
  {
    emitX86(INST_FFREE, reg);
  }

  //! @brief Add 16 bit or 32 bit integer to st(0) (FPU).
  public final void fiadd(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FIADD, src);
  }

  //! @brief Compare st(0) with 16 bit or 32 bit Integer (FPU).
  public final void ficom(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FICOM, src);
  }

  //! @brief Compare st(0) with 16 bit or 32 bit Integer and pop the stack (FPU).
  public final void ficomp(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FICOMP, src);
  }

  //! @brief Divide st(0) by 32 bit or 16 bit integer (@a src) (FPU).
  public final void fidiv(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FIDIV, src);
  }

  //! @brief Reverse Divide st(0) by 32 bit or 16 bit integer (@a src) (FPU).
  public final void fidivr(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FIDIVR, src);
  }

  //! @brief Load 16 bit, 32 bit or 64 bit Integer and push it to the stack (FPU).
  //!
  //! Converts the signed-integer source operand into double extended-precision
  //! floating point format and pushes the value onto the FPU register stack.
  //! The source operand can be a word, doubleword, or quadword integer. It is
  //! loaded without rounding errors. The sign of the source operand is
  //! preserved.
  public final void fild(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4 || src.size() == 8);
    emitX86(INST_FILD, src);
  }

  //! @brief Multiply st(0) by 16 bit or 32 bit integer and store it
  //! to st(0) (FPU).
  public final void fimul(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FIMUL, src);
  }

  //! @brief Increment Stack-Top Pointer (FPU).
  //!
  //! Adds one to the TOP field of the FPU status word (increments the
  //! top-of-stack pointer). If the TOP field contains a 7, it is set to 0.
  //! The effect of this instruction is to rotate the stack by one position.
  //! The contents of the FPU data registers and tag register are not affected.
  //! This operation is not equivalent to popping the stack, because the tag
  //! for the previous top-of-stack register is not marked empty.
  public final void fincstp()
  {
    emitX86(INST_FINCSTP);
  }

  //! @brief Initialize Floating-Point Unit (FPU).
  //!
  //! Initialize FPU after checking for pending unmasked floating-point
  //! exceptions.
  public final void finit()
  {
    emitX86(INST_FINIT);
  }

  //! @brief Subtract 16 bit or 32 bit integer from st(0) and store result to
  //! st(0) (FPU).
  public final void fisub(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FISUB, src);
  }

  //! @brief Reverse Subtract 16 bit or 32 bit integer from st(0) and
  //! store result to  st(0) (FPU).
  public final void fisubr(Mem src)
  {
    assert(src.size() == 2 || src.size() == 4);
    emitX86(INST_FISUBR, src);
  }

  //! @brief Initialize Floating-Point Unit (FPU).
  //!
  //! Initialize FPU without checking for pending unmasked floating-point
  //! exceptions.
  public final void fninit()
  {
    emitX86(INST_FNINIT);
  }

  //! @brief Store st(0) as 16 bit or 32 bit Integer to @a dst (FPU).
  public final void fist(Mem dst)
  {
    assert(dst.size() == 2 || dst.size() == 4);
    emitX86(INST_FIST, dst);
  }

  //! @brief Store st(0) as 16 bit, 32 bit or 64 bit Integer to @a dst and pop
  //! stack (FPU).
  public final void fistp(Mem dst)
  {
    assert(dst.size() == 2 || dst.size() == 4 || dst.size() == 8);
    emitX86(INST_FISTP, dst);
  }

  //! @brief Push 32 bit, 64 bit or 80 bit Floating Point Value onto the FPU
  //! register stack (FPU).
  public final void fld(Mem src)
  {
    assert(src.size() == 4 || src.size() == 8 || src.size() == 10);
    emitX86(INST_FLD, src);
  }

  //! @brief Push @a reg onto the FPU register stack (FPU).
  public final void fld(X87Register reg)
  {
    emitX86(INST_FLD, reg);
  }

  //! @brief Push +1.0 onto the FPU register stack (FPU).
  public final void fld1()
  {
    emitX86(INST_FLD1);
  }

  //! @brief Push log2(10) onto the FPU register stack (FPU).
  public final void fldl2t()
  {
    emitX86(INST_FLDL2T);
  }

  //! @brief Push log2(e) onto the FPU register stack (FPU).
  public final void fldl2e()
  {
    emitX86(INST_FLDL2E);
  }

  //! @brief Push pi onto the FPU register stack (FPU).
  public final void fldpi()
  {
    emitX86(INST_FLDPI);
  }

  //! @brief Push log10(2) onto the FPU register stack (FPU).
  public final void fldlg2()
  {
    emitX86(INST_FLDLG2);
  }

  //! @brief Push ln(2) onto the FPU register stack (FPU).
  public final void fldln2()
  {
    emitX86(INST_FLDLN2);
  }

  //! @brief Push +0.0 onto the FPU register stack (FPU).
  public final void fldz()
  {
    emitX86(INST_FLDZ);
  }

  //! @brief Load x87 FPU Control Word (2 bytes) (FPU).
  public final void fldcw(Mem src)
  {
    emitX86(INST_FLDCW, src);
  }

  //! @brief Load x87 FPU Environment (14 or 28 bytes) (FPU).
  public final void fldenv(Mem src)
  {
    emitX86(INST_FLDENV, src);
  }

  //! @brief Multiply @a dst by @a src and store result in @a dst (FPU).
  //!
  //! @note One of dst or src must be st(0).
  public final void fmul(X87Register dst, X87Register src)
  {
    assert(dst.index() == 0 || src.index() == 0);
    emitX86(INST_FMUL, dst, src);
  }
  //! @brief Multiply st(0) by @a src and store result in st(0) (FPU).
  //!
  //! @note SP-FP or DP-FP determined by @a adr size.
  public final void fmul(Mem src)
  {
    emitX86(INST_FMUL, src);
  }

  //! @brief Multiply st(0) by @a dst and POP register stack (FPU).
  public final void fmulp(X87Register dst)
  {
    emitX86(INST_FMULP, dst);
  }

  public final void fmulp()
  {
      fmulp(X87Register.st(1));
  }

  //! @brief Clear Exceptions (FPU).
  //!
  //! Clear floating-point exception flags without checking for pending
  //! unmasked floating-point exceptions.
  //!
  //! Clears the floating-point exception flags (PE, UE, OE, ZE, DE, and IE),
  //! the exception summary status flag (ES), the stack fault flag (SF), and
  //! the busy flag (B) in the FPU status word. The FCLEX instruction does
  //! not checks for and handles any pending unmasked floating-point exceptions
  //! before clearing the exception flags.
  public final void fnclex()
  {
    emitX86(INST_FNCLEX);
  }

  //! @brief No Operation (FPU).
  public final void fnop()
  {
    emitX86(INST_FNOP);
  }

  //! @brief Save FPU State (FPU).
  //!
  //! Store FPU environment to m94byte or m108byte without
  //! checking for pending unmasked FP exceptions.
  //! Then re-initialize the FPU.
  public final void fnsave(Mem dst)
  {
    emitX86(INST_FNSAVE, dst);
  }

  //! @brief Store x87 FPU Environment (FPU).
  //!
  //! Store FPU environment to @a dst (14 or 28 Bytes) without checking for
  //! pending unmasked floating-point exceptions. Then mask all floating
  //! point exceptions.
  public final void fnstenv(Mem dst)
  {
    emitX86(INST_FNSTENV, dst);
  }

  //! @brief Store x87 FPU Control Word (FPU).
  //!
  //! Store FPU control word to @a dst (2 Bytes) without checking for pending
  //! unmasked floating-point exceptions.
  public final void fnstcw(Mem dst)
  {
    emitX86(INST_FNSTCW, dst);
  }

  //! @brief Store x87 FPU Status Word (2 Bytes) (FPU).
  public final void fnstsw(Register dst)
  {
    assert(dst.isRegCode(REG_AX));
    emitX86(INST_FNSTSW, dst);
  }
  //! @brief Store x87 FPU Status Word (2 Bytes) (FPU).
  public final void fnstsw(Mem dst)
  {
    emitX86(INST_FNSTSW, dst);
  }

  //! @brief Partial Arctangent (FPU).
  //!
  //! Replace st(1) with arctan(st(1)/st(0)) and pop the register stack.
  public final void fpatan()
  {
    emitX86(INST_FPATAN);
  }

  //! @brief Partial Remainder (FPU).
  //!
  //! Replace st(0) with the remainder obtained from dividing st(0) by st(1).
  public final void fprem()
  {
    emitX86(INST_FPREM);
  }

  //! @brief Partial Remainder (FPU).
  //!
  //! Replace st(0) with the IEEE remainder obtained from dividing st(0) by
  //! st(1).
  public final void fprem1()
  {
    emitX86(INST_FPREM1);
  }

  //! @brief Partial Tangent (FPU).
  //!
  //! Replace st(0) with its tangent and push 1 onto the FPU stack.
  public final void fptan()
  {
    emitX86(INST_FPTAN);
  }

  //! @brief Round to Integer (FPU).
  //!
  //! Rount st(0) to an Integer.
  public final void frndint()
  {
    emitX86(INST_FRNDINT);
  }

  //! @brief Restore FPU State (FPU).
  //!
  //! Load FPU state from src (94 bytes or 108 bytes).
  public final void frstor(Mem src)
  {
    emitX86(INST_FRSTOR, src);
  }

  //! @brief Save FPU State (FPU).
  //!
  //! Store FPU state to 94 or 108 bytes after checking for
  //! pending unmasked FP exceptions. Then reinitialize
  //! the FPU.
  public final void fsave(Mem dst)
  {
    emitX86(INST_FSAVE, dst);
  }

  //! @brief Scale (FPU).
  //!
  //! Scale st(0) by st(1).
  public final void fscale()
  {
    emitX86(INST_FSCALE);
  }

  //! @brief Sine (FPU).
  //!
  //! This instruction calculates the sine of the source operand in
  //! register st(0) and stores the result in st(0).
  public final void fsin()
  {
    emitX86(INST_FSIN);
  }

  //! @brief Sine and Cosine (FPU).
  //!
  //! Compute the sine and cosine of st(0); replace st(0) with
  //! the sine, and push the cosine onto the register stack.
  public final void fsincos()
  {
    emitX86(INST_FSINCOS);
  }

  //! @brief Square Root (FPU).
  //!
  //! Calculates square root of st(0) and stores the result in st(0).
  public final void fsqrt()
  {
    emitX86(INST_FSQRT);
  }

  //! @brief Store Floating Point Value (FPU).
  //!
  //! Store st(0) as 32 bit or 64 bit floating point value to @a dst.
  public final void fst(Mem dst)
  {
    assert(dst.size() == 4 || dst.size() == 8);
    emitX86(INST_FST, dst);
  }

  //! @brief Store Floating Point Value (FPU).
  //!
  //! Store st(0) to !a reg.
  public final void fst(X87Register reg)
  {
    emitX86(INST_FST, reg);
  }

  //! @brief Store Floating Point Value and Pop Register Stack (FPU).
  //!
  //! Store st(0) as 32 bit or 64 bit floating point value to @a dst
  //! and pop register stack.
  public final void fstp(Mem dst)
  {
    assert(dst.size() == 4 || dst.size() == 8 || dst.size() == 10);
    emitX86(INST_FSTP, dst);
  }

  //! @brief Store Floating Point Value and Pop Register Stack  (FPU).
  //!
  //! Store st(0) to !a reg and pop register stack.
  public final void fstp(X87Register reg)
  {
    emitX86(INST_FSTP, reg);
  }

  //! @brief Store x87 FPU Control Word (FPU).
  //!
  //! Store FPU control word to @a dst (2 Bytes) after checking for pending
  //! unmasked floating-point exceptions.
  public final void fstcw(Mem dst)
  {
    emitX86(INST_FSTCW, dst);
  }

  //! @brief Store x87 FPU Environment (FPU).
  //!
  //! Store FPU environment to @a dst (14 or 28 Bytes) after checking for
  //! pending unmasked floating-point exceptions. Then mask all floating
  //! point exceptions.
  public final void fstenv(Mem dst)
  {
    emitX86(INST_FSTENV, dst);
  }

  //! @brief Store x87 FPU Status Word (2 Bytes) (FPU).
  public final void fstsw(Register dst)
  {
    assert(dst.isRegCode(REG_AX));
    emitX86(INST_FSTSW, dst);
  }
  //! @brief Store x87 FPU Status Word (2 Bytes) (FPU).
  public final void fstsw(Mem dst)
  {
    emitX86(INST_FSTSW, dst);
  }

  //! @brief Subtract @a src from @a dst and store result in @a dst (FPU).
  //!
  //! @note One of dst or src must be st(0).
  public final void fsub(X87Register dst, X87Register src)
  {
    assert(dst.index() == 0 || src.index() == 0);
    emitX86(INST_FSUB, dst, src);
  }
  //! @brief Subtract @a src from st(0) and store result in st(0) (FPU).
  //!
  //! @note SP-FP or DP-FP determined by @a adr size.
  public final void fsub(Mem src)
  {
    assert(src.size() == 4 || src.size() == 8);
    emitX86(INST_FSUB, src);
  }

  //! @brief Subtract st(0) from @a dst and POP register stack (FPU).
  public final void fsubp(X87Register dst)
  {
    emitX86(INST_FSUBP, dst);
  }

  public final void fsubp()
  {
    emitX86(INST_FSUBP, X87Register.st(1));
  }

  //! @brief Reverse Subtract @a src from @a dst and store result in @a dst (FPU).
  //!
  //! @note One of dst or src must be st(0).
  public final void fsubr(X87Register dst, X87Register src)
  {
    assert(dst.index() == 0 || src.index() == 0);
    emitX86(INST_FSUBR, dst, src);
  }

  //! @brief Reverse Subtract @a src from st(0) and store result in st(0) (FPU).
  //!
  //! @note SP-FP or DP-FP determined by @a adr size.
  public final void fsubr(Mem src)
  {
    assert(src.size() == 4 || src.size() == 8);
    emitX86(INST_FSUBR, src);
  }

  //! @brief Reverse Subtract st(0) from @a dst and POP register stack (FPU).
  public final void fsubrp(X87Register dst)
  {
    emitX86(INST_FSUBRP, dst);
  }

  public final void fsubrp()
  {
    emitX86(INST_FSUBRP, X87Register.st(1));
  }

  //! @brief Floating point test - Compare st(0) with 0.0. (FPU).
  public final void ftst()
  {
    emitX86(INST_FTST);
  }

  //! @brief Unordered Compare st(0) with @a reg (FPU).
  public final void fucom(X87Register reg)
  {
    emitX86(INST_FUCOM, reg);
  }

  public final void fucom()
  {
    emitX86(INST_FUCOM, X87Register.st(1));
  }

  //! @brief Unordered Compare st(0) and @a reg, check for ordered values
  //! and Set EFLAGS (FPU).
  public final void fucomi(X87Register reg)
  {
    emitX86(INST_FUCOMI, reg);
  }

  //! @brief UnorderedCompare st(0) and @a reg, Check for ordered values
  //! and Set EFLAGS and pop the stack (FPU).
  public final void fucomip(X87Register reg)
  {
    emitX86(INST_FUCOMIP, reg);
  }

  public final void fucomip()
  {
    emitX86(INST_FUCOMIP, X87Register.st(1));
  }

  //! @brief Unordered Compare st(0) with @a reg and pop register stack (FPU).
  public final void fucomp(X87Register reg)
  {
    emitX86(INST_FUCOMP, reg);
  }

  public final void fucomp()
  {
    emitX86(INST_FUCOMP, X87Register.st(1));
  }

  //! @brief Unordered compare st(0) with st(1) and pop register stack twice
  //! (FPU).
  public final void fucompp()
  {
    emitX86(INST_FUCOMPP);
  }

  public final void fwait()
  {
    emitX86(INST_FWAIT);
  }

  //! @brief Examine st(0) (FPU).
  //!
  //! Examines the contents of the ST(0) register and sets the condition code
  //! flags C0, C2, and C3 in the FPU status word to indicate the class of
  //! value or number in the register.
  public final void fxam()
  {
    emitX86(INST_FXAM);
  }

  //! @brief Exchange Register Contents (FPU).
  //!
  //! Exchange content of st(0) with @a reg.
  public final void fxch(X87Register reg)
  {
    emitX86(INST_FXCH, reg);
  }

  public final void fxch()
  {
    emitX86(INST_FXCH, X87Register.st(1));
  }

  //! @brief Restore FP And MMX(tm) State And Streaming SIMD Extension State
  //! (FPU, MMX, SSE).
  //!
  //! Load FP and MMX(tm) technology and Streaming SIMD Extension state from
  //! src (512 bytes).
  public final void fxrstor(Mem src)
  {
    emitX86(INST_FXRSTOR, src);
  }

  //! @brief Store FP and MMX(tm) State and Streaming SIMD Extension State
  //! (FPU, MMX, SSE).
  //!
  //! Store FP and MMX(tm) technology state and Streaming SIMD Extension state
  //! to dst (512 bytes).
  public final void fxsave(Mem dst)
  {
    emitX86(INST_FXSAVE, dst);
  }

  //! @brief Extract Exponent and Significand (FPU).
  //!
  //! Separate value in st(0) into exponent and significand, store exponent
  //! in st(0), and push the significand onto the register stack.
  public final void fxtract()
  {
    emitX86(INST_FXTRACT);
  }

  //! @brief Compute y * log2(x).
  //!
  //! Replace st(1) with (st(1) * log2st(0)) and pop the register stack.
  public final void fyl2x()
  {
    emitX86(INST_FYL2X);
  }

  //! @brief Compute y * log_2(x+1).
  //!
  //! Replace st(1) with (st(1) * (log2st(0) + 1.0)) and pop the register stack.
  public final void fyl2xp1()
  {
    emitX86(INST_FYL2XP1);
  }

  // -------------------------------------------------------------------------
  // [MMX]
  // -------------------------------------------------------------------------

  //! @brief Empty MMX state.
  public final void emms()
  {
    emitX86(INST_EMMS);
  }

  //! @brief Move DWord (MMX).
  public final void movd(Mem dst, MMRegister src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord (MMX).
  public final void movd(Register dst, MMRegister src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord (MMX).
  public final void movd(MMRegister dst, Mem src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord (MMX).
  public final void movd(MMRegister dst, Register src)
  {
    emitX86(INST_MOVD, dst, src);
  }

  //! @brief Move QWord (MMX).
  public final void movq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }
  //! @brief Move QWord (MMX).
  public final void movq(Mem dst, MMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }
  //! @brief Move QWord (MMX).
  public final void movq(Register dst, MMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move QWord (MMX).
  public final void movq(MMRegister dst, Mem src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move QWord (MMX).
  public final void movq(MMRegister dst, Register src)
  {
    emitX86(INST_MOVQ, dst, src);
  }


  //! @brief Pack with Unsigned Saturation (MMX).
  public final void packuswb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PACKUSWB, dst, src);
  }
  //! @brief Pack with Unsigned Saturation (MMX).
  public final void packuswb(MMRegister dst, Mem src)
  {
    emitX86(INST_PACKUSWB, dst, src);
  }

  //! @brief Packed BYTE Add (MMX).
  public final void paddb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDB, dst, src);
  }
  //! @brief Packed BYTE Add (MMX).
  public final void paddb(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDB, dst, src);
  }

  //! @brief Packed WORD Add (MMX).
  public final void paddw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDW, dst, src);
  }
  //! @brief Packed WORD Add (MMX).
  public final void paddw(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDW, dst, src);
  }

  //! @brief Packed DWORD Add (MMX).
  public final void paddd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDD, dst, src);
  }
  //! @brief Packed DWORD Add (MMX).
  public final void paddd(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDD, dst, src);
  }

  //! @brief Packed Add with Saturation (MMX).
  public final void paddsb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDSB, dst, src);
  }
  //! @brief Packed Add with Saturation (MMX).
  public final void paddsb(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDSB, dst, src);
  }

  //! @brief Packed Add with Saturation (MMX).
  public final void paddsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDSW, dst, src);
  }
  //! @brief Packed Add with Saturation (MMX).
  public final void paddsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDSW, dst, src);
  }

  //! @brief Packed Add Unsigned with Saturation (MMX).
  public final void paddusb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDUSB, dst, src);
  }
  //! @brief Packed Add Unsigned with Saturation (MMX).
  public final void paddusb(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDUSB, dst, src);
  }

  //! @brief Packed Add Unsigned with Saturation (MMX).
  public final void paddusw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDUSW, dst, src);
  }
  //! @brief Packed Add Unsigned with Saturation (MMX).
  public final void paddusw(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDUSW, dst, src);
  }

  //! @brief Logical AND (MMX).
  public final void pand(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PAND, dst, src);
  }
  //! @brief Logical AND (MMX).
  public final void pand(MMRegister dst, Mem src)
  {
    emitX86(INST_PAND, dst, src);
  }

  //! @brief Logical AND Not (MMX).
  public final void pandn(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PANDN, dst, src);
  }
  //! @brief Logical AND Not (MMX).
  public final void pandn(MMRegister dst, Mem src)
  {
    emitX86(INST_PANDN, dst, src);
  }

  //! @brief Packed Compare for Equal (BYTES) (MMX).
  public final void pcmpeqb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPEQB, dst, src);
  }
  //! @brief Packed Compare for Equal (BYTES) (MMX).
  public final void pcmpeqb(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQB, dst, src);
  }

  //! @brief Packed Compare for Equal (WORDS) (MMX).
  public final void pcmpeqw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPEQW, dst, src);
  }
  //! @brief Packed Compare for Equal (WORDS) (MMX).
  public final void pcmpeqw(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQW, dst, src);
  }

  //! @brief Packed Compare for Equal (DWORDS) (MMX).
  public final void pcmpeqd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPEQD, dst, src);
  }
  //! @brief Packed Compare for Equal (DWORDS) (MMX).
  public final void pcmpeqd(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQD, dst, src);
  }

  //! @brief Packed Compare for Greater Than (BYTES) (MMX).
  public final void pcmpgtb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPGTB, dst, src);
  }
  //! @brief Packed Compare for Greater Than (BYTES) (MMX).
  public final void pcmpgtb(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTB, dst, src);
  }

  //! @brief Packed Compare for Greater Than (WORDS) (MMX).
  public final void pcmpgtw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPGTW, dst, src);
  }
  //! @brief Packed Compare for Greater Than (WORDS) (MMX).
  public final void pcmpgtw(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTW, dst, src);
  }

  //! @brief Packed Compare for Greater Than (DWORDS) (MMX).
  public final void pcmpgtd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PCMPGTD, dst, src);
  }
  //! @brief Packed Compare for Greater Than (DWORDS) (MMX).
  public final void pcmpgtd(MMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTD, dst, src);
  }

  //! @brief Packed Multiply High (MMX).
  public final void pmulhw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMULHW, dst, src);
  }
  //! @brief Packed Multiply High (MMX).
  public final void pmulhw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMULHW, dst, src);
  }

  //! @brief Packed Multiply Low (MMX).
  public final void pmullw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMULLW, dst, src);
  }
  //! @brief Packed Multiply Low (MMX).
  public final void pmullw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMULLW, dst, src);
  }

  //! @brief Bitwise Logical OR (MMX).
  public final void por(MMRegister dst, MMRegister src)
  {
    emitX86(INST_POR, dst, src);
  }
  //! @brief Bitwise Logical OR (MMX).
  public final void por(MMRegister dst, Mem src)
  {
    emitX86(INST_POR, dst, src);
  }

  //! @brief Packed Multiply and Add (MMX).
  public final void pmaddwd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMADDWD, dst, src);
  }
  //! @brief Packed Multiply and Add (MMX).
  public final void pmaddwd(MMRegister dst, Mem src)
  {
    emitX86(INST_PMADDWD, dst, src);
  }

  //! @brief Packed Shift Left Logical (MMX).
  public final void pslld(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSLLD, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void pslld(MMRegister dst, Mem src)
  {
    emitX86(INST_PSLLD, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void pslld(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLD, dst, src);
  }

  //! @brief Packed Shift Left Logical (MMX).
  public final void psllq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void psllq(MMRegister dst, Mem src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void psllq(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }

  //! @brief Packed Shift Left Logical (MMX).
  public final void psllw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSLLW, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void psllw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSLLW, dst, src);
  }
  //! @brief Packed Shift Left Logical (MMX).
  public final void psllw(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLW, dst, src);
  }

  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psrad(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSRAD, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psrad(MMRegister dst, Mem src)
  {
    emitX86(INST_PSRAD, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psrad(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSRAD, dst, src);
  }

  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psraw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSRAW, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psraw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSRAW, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (MMX).
  public final void psraw(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSRAW, dst, src);
  }

  //! @brief Packed Shift Right Logical (MMX).
  public final void psrld(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSRLD, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrld(MMRegister dst, Mem src)
  {
    emitX86(INST_PSRLD, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrld(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLD, dst, src);
  }

  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlq(MMRegister dst, Mem src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlq(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }

  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSRLW, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSRLW, dst, src);
  }
  //! @brief Packed Shift Right Logical (MMX).
  public final void psrlw(MMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLW, dst, src);
  }

  //! @brief Packed Subtract (MMX).
  public final void psubb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBB, dst, src);
  }
  //! @brief Packed Subtract (MMX).
  public final void psubb(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBB, dst, src);
  }

  //! @brief Packed Subtract (MMX).
  public final void psubw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBW, dst, src);
  }
  //! @brief Packed Subtract (MMX).
  public final void psubw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBW, dst, src);
  }

  //! @brief Packed Subtract (MMX).
  public final void psubd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBD, dst, src);
  }
  //! @brief Packed Subtract (MMX).
  public final void psubd(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBD, dst, src);
  }

  //! @brief Packed Subtract with Saturation (MMX).
  public final void psubsb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBSB, dst, src);
  }
  //! @brief Packed Subtract with Saturation (MMX).
  public final void psubsb(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBSB, dst, src);
  }

  //! @brief Packed Subtract with Saturation (MMX).
  public final void psubsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBSW, dst, src);
  }
  //! @brief Packed Subtract with Saturation (MMX).
  public final void psubsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBSW, dst, src);
  }

  //! @brief Packed Subtract with Unsigned Saturation (MMX).
  public final void psubusb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBUSB, dst, src);
  }
  //! @brief Packed Subtract with Unsigned Saturation (MMX).
  public final void psubusb(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBUSB, dst, src);
  }

  //! @brief Packed Subtract with Unsigned Saturation (MMX).
  public final void psubusw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBUSW, dst, src);
  }
  //! @brief Packed Subtract with Unsigned Saturation (MMX).
  public final void psubusw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBUSW, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhbw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKHBW, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhbw(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHBW, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhwd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKHWD, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhwd(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHWD, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhdq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKHDQ, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpckhdq(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHDQ, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpcklbw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKLBW, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpcklbw(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLBW, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpcklwd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKLWD, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpcklwd(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLWD, dst, src);
  }

  //! @brief Unpack High Packed Data (MMX).
  public final void punpckldq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PUNPCKLDQ, dst, src);
  }
  //! @brief Unpack High Packed Data (MMX).
  public final void punpckldq(MMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLDQ, dst, src);
  }

  //! @brief Bitwise Exclusive OR (MMX).
  public final void pxor(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PXOR, dst, src);
  }
  //! @brief Bitwise Exclusive OR (MMX).
  public final void pxor(MMRegister dst, Mem src)
  {
    emitX86(INST_PXOR, dst, src);
  }

  // -------------------------------------------------------------------------
  // [3dNow]
  // -------------------------------------------------------------------------

  //! @brief Faster EMMS (3dNow!).
  //!
  //! @note Use only for early AMD processors where is only 3dNow! or SSE. If
  //! CPU contains SSE2, it's better to use @c emms() ( @c femms() is mapped
  //! to @c emms() ).
  public final void femms()
  {
    emitX86(INST_FEMMS);
  }

  //! @brief Packed SP-FP to Integer Convert (3dNow!).
  public final void pf2id(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PF2ID, dst, src);
  }
  //! @brief Packed SP-FP to Integer Convert (3dNow!).
  public final void pf2id(MMRegister dst, Mem src)
  {
    emitX86(INST_PF2ID, dst, src);
  }

  //! @brief  Packed SP-FP to Integer Word Convert (3dNow!).
  public final void pf2iw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PF2IW, dst, src);
  }
  //! @brief  Packed SP-FP to Integer Word Convert (3dNow!).
  public final void pf2iw(MMRegister dst, Mem src)
  {
    emitX86(INST_PF2IW, dst, src);
  }

  //! @brief Packed SP-FP Accumulate (3dNow!).
  public final void pfacc(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFACC, dst, src);
  }
  //! @brief Packed SP-FP Accumulate (3dNow!).
  public final void pfacc(MMRegister dst, Mem src)
  {
    emitX86(INST_PFACC, dst, src);
  }

  //! @brief Packed SP-FP Addition (3dNow!).
  public final void pfadd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFADD, dst, src);
  }
  //! @brief Packed SP-FP Addition (3dNow!).
  public final void pfadd(MMRegister dst, Mem src)
  {
    emitX86(INST_PFADD, dst, src);
  }

  //! @brief Packed SP-FP Compare - dst == src (3dNow!).
  public final void pfcmpeq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFCMPEQ, dst, src);
  }
  //! @brief Packed SP-FP Compare - dst == src (3dNow!).
  public final void pfcmpeq(MMRegister dst, Mem src)
  {
    emitX86(INST_PFCMPEQ, dst, src);
  }

  //! @brief Packed SP-FP Compare - dst >= src (3dNow!).
  public final void pfcmpge(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFCMPGE, dst, src);
  }
  //! @brief Packed SP-FP Compare - dst >= src (3dNow!).
  public final void pfcmpge(MMRegister dst, Mem src)
  {
    emitX86(INST_PFCMPGE, dst, src);
  }

  //! @brief Packed SP-FP Compare - dst > src (3dNow!).
  public final void pfcmpgt(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFCMPGT, dst, src);
  }
  //! @brief Packed SP-FP Compare - dst > src (3dNow!).
  public final void pfcmpgt(MMRegister dst, Mem src)
  {
    emitX86(INST_PFCMPGT, dst, src);
  }

  //! @brief Packed SP-FP Maximum (3dNow!).
  public final void pfmax(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFMAX, dst, src);
  }
  //! @brief Packed SP-FP Maximum (3dNow!).
  public final void pfmax(MMRegister dst, Mem src)
  {
    emitX86(INST_PFMAX, dst, src);
  }

  //! @brief Packed SP-FP Minimum (3dNow!).
  public final void pfmin(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFMIN, dst, src);
  }
  //! @brief Packed SP-FP Minimum (3dNow!).
  public final void pfmin(MMRegister dst, Mem src)
  {
    emitX86(INST_PFMIN, dst, src);
  }

  //! @brief Packed SP-FP Multiply (3dNow!).
  public final void pfmul(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFMUL, dst, src);
  }
  //! @brief Packed SP-FP Multiply (3dNow!).
  public final void pfmul(MMRegister dst, Mem src)
  {
    emitX86(INST_PFMUL, dst, src);
  }

  //! @brief Packed SP-FP Negative Accumulate (3dNow!).
  public final void pfnacc(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFNACC, dst, src);
  }
  //! @brief Packed SP-FP Negative Accumulate (3dNow!).
  public final void pfnacc(MMRegister dst, Mem src)
  {
    emitX86(INST_PFNACC, dst, src);
  }

  //! @brief Packed SP-FP Mixed Accumulate (3dNow!).
  public final void pfpnaxx(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFPNACC, dst, src);
  }
  //! @brief Packed SP-FP Mixed Accumulate (3dNow!).
  public final void pfpnacc(MMRegister dst, Mem src)
  {
    emitX86(INST_PFPNACC, dst, src);
  }

  //! @brief Packed SP-FP Reciprocal Approximation (3dNow!).
  public final void pfrcp(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFRCP, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal Approximation (3dNow!).
  public final void pfrcp(MMRegister dst, Mem src)
  {
    emitX86(INST_PFRCP, dst, src);
  }

  //! @brief Packed SP-FP Reciprocal, First Iteration Step (3dNow!).
  public final void pfrcpit1(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFRCPIT1, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal, First Iteration Step (3dNow!).
  public final void pfrcpit1(MMRegister dst, Mem src)
  {
    emitX86(INST_PFRCPIT1, dst, src);
  }

  //! @brief Packed SP-FP Reciprocal, Second Iteration Step (3dNow!).
  public final void pfrcpit2(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFRCPIT2, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal, Second Iteration Step (3dNow!).
  public final void pfrcpit2(MMRegister dst, Mem src)
  {
    emitX86(INST_PFRCPIT2, dst, src);
  }

  //! @brief Packed SP-FP Reciprocal Square Root, First Iteration Step (3dNow!).
  public final void pfrsqit1(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFRSQIT1, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal Square Root, First Iteration Step (3dNow!).
  public final void pfrsqit1(MMRegister dst, Mem src)
  {
    emitX86(INST_PFRSQIT1, dst, src);
  }

  //! @brief Packed SP-FP Reciprocal Square Root Approximation (3dNow!).
  public final void pfrsqrt(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFRSQRT, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal Square Root Approximation (3dNow!).
  public final void pfrsqrt(MMRegister dst, Mem src)
  {
    emitX86(INST_PFRSQRT, dst, src);
  }

  //! @brief Packed SP-FP Subtract (3dNow!).
  public final void pfsub(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFSUB, dst, src);
  }
  //! @brief Packed SP-FP Subtract (3dNow!).
  public final void pfsub(MMRegister dst, Mem src)
  {
    emitX86(INST_PFSUB, dst, src);
  }

  //! @brief Packed SP-FP Reverse Subtract (3dNow!).
  public final void pfsubr(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PFSUBR, dst, src);
  }
  //! @brief Packed SP-FP Reverse Subtract (3dNow!).
  public final void pfsubr(MMRegister dst, Mem src)
  {
    emitX86(INST_PFSUBR, dst, src);
  }

  //! @brief Packed DWords to SP-FP (3dNow!).
  public final void pi2fd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PI2FD, dst, src);
  }
  //! @brief Packed DWords to SP-FP (3dNow!).
  public final void pi2fd(MMRegister dst, Mem src)
  {
    emitX86(INST_PI2FD, dst, src);
  }

  //! @brief Packed Words to SP-FP (3dNow!).
  public final void pi2fw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PI2FW, dst, src);
  }
  //! @brief Packed Words to SP-FP (3dNow!).
  public final void pi2fw(MMRegister dst, Mem src)
  {
    emitX86(INST_PI2FW, dst, src);
  }

  //! @brief Packed swap DWord (3dNow!)
  public final void pswapd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSWAPD, dst, src);
  }
  //! @brief Packed swap DWord (3dNow!)
  public final void pswapd(MMRegister dst, Mem src)
  {
    emitX86(INST_PSWAPD, dst, src);
  }

  // -------------------------------------------------------------------------
  // [SSE]
  // -------------------------------------------------------------------------

  //! @brief Packed SP-FP Add (SSE).
  public final void addps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDPS, dst, src);
  }
  //! @brief Packed SP-FP Add (SSE).
  public final void addps(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDPS, dst, src);
  }

  //! @brief Scalar SP-FP Add (SSE).
  public final void addss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDSS, dst, src);
  }
  //! @brief Scalar SP-FP Add (SSE).
  public final void addss(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDSS, dst, src);
  }

  //! @brief Bit-wise Logical And Not For SP-FP (SSE).
  public final void andnps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ANDNPS, dst, src);
  }
  //! @brief Bit-wise Logical And Not For SP-FP (SSE).
  public final void andnps(XMMRegister dst, Mem src)
  {
    emitX86(INST_ANDNPS, dst, src);
  }

  //! @brief Bit-wise Logical And For SP-FP (SSE).
  public final void andps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ANDPS, dst, src);
  }
  //! @brief Bit-wise Logical And For SP-FP (SSE).
  public final void andps(XMMRegister dst, Mem src)
  {
    emitX86(INST_ANDPS, dst, src);
  }

  //! @brief Packed SP-FP Compare (SSE).
  public final void cmpps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_CMPPS, dst, src, imm8);
  }
  //! @brief Packed SP-FP Compare (SSE).
  public final void cmpps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_CMPPS, dst, src, imm8);
  }

  //! @brief Compare Scalar SP-FP Values (SSE).
  public final void cmpss(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_CMPSS, dst, src, imm8);
  }
  //! @brief Compare Scalar SP-FP Values (SSE).
  public final void cmpss(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_CMPSS, dst, src, imm8);
  }

  //! @brief Scalar Ordered SP-FP Compare and Set EFLAGS (SSE).
  public final void comiss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_COMISS, dst, src);
  }
  //! @brief Scalar Ordered SP-FP Compare and Set EFLAGS (SSE).
  public final void comiss(XMMRegister dst, Mem src)
  {
    emitX86(INST_COMISS, dst, src);
  }

  //! @brief Packed Signed INT32 to Packed SP-FP Conversion (SSE).
  public final void cvtpi2ps(XMMRegister dst, MMRegister src)
  {
    emitX86(INST_CVTPI2PS, dst, src);
  }
  //! @brief Packed Signed INT32 to Packed SP-FP Conversion (SSE).
  public final void cvtpi2ps(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPI2PS, dst, src);
  }

  //! @brief Packed SP-FP to Packed INT32 Conversion (SSE).
  public final void cvtps2pi(MMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPS2PI, dst, src);
  }
  //! @brief Packed SP-FP to Packed INT32 Conversion (SSE).
  public final void cvtps2pi(MMRegister dst, Mem src)
  {
    emitX86(INST_CVTPS2PI, dst, src);
  }

  //! @brief Scalar Signed INT32 to SP-FP Conversion (SSE).
  public final void cvtsi2ss(XMMRegister dst, Register src)
  {
    emitX86(INST_CVTSI2SS, dst, src);
  }
  //! @brief Scalar Signed INT32 to SP-FP Conversion (SSE).
  public final void cvtsi2ss(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTSI2SS, dst, src);
  }

  //! @brief Scalar SP-FP to Signed INT32 Conversion (SSE).
  public final void cvtss2si(Register dst, XMMRegister src)
  {
    emitX86(INST_CVTSS2SI, dst, src);
  }
  //! @brief Scalar SP-FP to Signed INT32 Conversion (SSE).
  public final void cvtss2si(Register dst, Mem src)
  {
    emitX86(INST_CVTSS2SI, dst, src);
  }

  //! @brief Packed SP-FP to Packed INT32 Conversion (truncate) (SSE).
  public final void cvttps2pi(MMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTTPS2PI, dst, src);
  }
  //! @brief Packed SP-FP to Packed INT32 Conversion (truncate) (SSE).
  public final void cvttps2pi(MMRegister dst, Mem src)
  {
    emitX86(INST_CVTTPS2PI, dst, src);
  }

  //! @brief Scalar SP-FP to Signed INT32 Conversion (truncate) (SSE).
  public final void cvttss2si(Register dst, XMMRegister src)
  {
    emitX86(INST_CVTTSS2SI, dst, src);
  }
  //! @brief Scalar SP-FP to Signed INT32 Conversion (truncate) (SSE).
  public final void cvttss2si(Register dst, Mem src)
  {
    emitX86(INST_CVTTSS2SI, dst, src);
  }

  //! @brief Packed SP-FP Divide (SSE).
  public final void divps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_DIVPS, dst, src);
  }
  //! @brief Packed SP-FP Divide (SSE).
  public final void divps(XMMRegister dst, Mem src)
  {
    emitX86(INST_DIVPS, dst, src);
  }

  //! @brief Scalar SP-FP Divide (SSE).
  public final void divss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_DIVSS, dst, src);
  }
  //! @brief Scalar SP-FP Divide (SSE).
  public final void divss(XMMRegister dst, Mem src)
  {
    emitX86(INST_DIVSS, dst, src);
  }

  //! @brief Load Streaming SIMD Extension Control/Status (SSE).
  public final void ldmxcsr(Mem src)
  {
    emitX86(INST_LDMXCSR, src);
  }

  //! @brief Byte Mask Write (SSE).
  //!
  //! @note The default memory location is specified by DS:EDI.
  public final void maskmovq(MMRegister data, MMRegister mask)
  {
    emitX86(INST_MASKMOVQ, data, mask);
  }

  //! @brief Packed SP-FP Maximum (SSE).
  public final void maxps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MAXPS, dst, src);
  }
  //! @brief Packed SP-FP Maximum (SSE).
  public final void maxps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MAXPS, dst, src);
  }

  //! @brief Scalar SP-FP Maximum (SSE).
  public final void maxss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MAXSS, dst, src);
  }
  //! @brief Scalar SP-FP Maximum (SSE).
  public final void maxss(XMMRegister dst, Mem src)
  {
    emitX86(INST_MAXSS, dst, src);
  }

  //! @brief Packed SP-FP Minimum (SSE).
  public final void minps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MINPS, dst, src);
  }
  //! @brief Packed SP-FP Minimum (SSE).
  public final void minps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MINPS, dst, src);
  }

  //! @brief Scalar SP-FP Minimum (SSE).
  public final void minss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MINSS, dst, src);
  }
  //! @brief Scalar SP-FP Minimum (SSE).
  public final void minss(XMMRegister dst, Mem src)
  {
    emitX86(INST_MINSS, dst, src);
  }

  //! @brief Move Aligned Packed SP-FP Values (SSE).
  public final void movaps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVAPS, dst, src);
  }
  //! @brief Move Aligned Packed SP-FP Values (SSE).
  public final void movaps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVAPS, dst, src);
  }

  //! @brief Move Aligned Packed SP-FP Values (SSE).
  public final void movaps(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVAPS, dst, src);
  }

  //! @brief Move DWord.
  public final void movd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord.
  public final void movd(Register dst, XMMRegister src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord.
  public final void movd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVD, dst, src);
  }
  //! @brief Move DWord.
  public final void movd(XMMRegister dst, Register src)
  {
    emitX86(INST_MOVD, dst, src);
  }

  //! @brief Move QWord (SSE).
  public final void movq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }
  //! @brief Move QWord (SSE).
  public final void movq(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move QWord (SSE).
  public final void movq(Register dst, XMMRegister src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move QWord (SSE).
  public final void movq(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move QWord (SSE).
  public final void movq(XMMRegister dst, Register src)
  {
    emitX86(INST_MOVQ, dst, src);
  }

  //! @brief Move 64 Bits Non Temporal (SSE).
  public final void movntq(Mem dst, MMRegister src)
  {
    emitX86(INST_MOVNTQ, dst, src);
  }

  //! @brief High to Low Packed SP-FP (SSE).
  public final void movhlps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVHLPS, dst, src);
  }

  //! @brief Move High Packed SP-FP (SSE).
  public final void movhps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVHPS, dst, src);
  }

  //! @brief Move High Packed SP-FP (SSE).
  public final void movhps(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVHPS, dst, src);
  }

  //! @brief Move Low to High Packed SP-FP (SSE).
  public final void movlhps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVLHPS, dst, src);
  }

  //! @brief Move Low Packed SP-FP (SSE).
  public final void movlps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVLPS, dst, src);
  }

  //! @brief Move Low Packed SP-FP (SSE).
  public final void movlps(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVLPS, dst, src);
  }

  //! @brief Move Aligned Four Packed SP-FP Non Temporal (SSE).
  public final void movntps(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVNTPS, dst, src);
  }

  //! @brief Move Scalar SP-FP (SSE).
  public final void movss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVSS, dst, src);
  }

  //! @brief Move Scalar SP-FP (SSE).
  public final void movss(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVSS, dst, src);
  }

  //! @brief Move Scalar SP-FP (SSE).
  public final void movss(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVSS, dst, src);
  }

  //! @brief Move Unaligned Packed SP-FP Values (SSE).
  public final void movups(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVUPS, dst, src);
  }
  //! @brief Move Unaligned Packed SP-FP Values (SSE).
  public final void movups(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVUPS, dst, src);
  }

  //! @brief Move Unaligned Packed SP-FP Values (SSE).
  public final void movups(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVUPS, dst, src);
  }

  //! @brief Packed SP-FP Multiply (SSE).
  public final void mulps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MULPS, dst, src);
  }
  //! @brief Packed SP-FP Multiply (SSE).
  public final void mulps(XMMRegister dst, Mem src)
  {
    emitX86(INST_MULPS, dst, src);
  }

  //! @brief Scalar SP-FP Multiply (SSE).
  public final void mulss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MULSS, dst, src);
  }
  //! @brief Scalar SP-FP Multiply (SSE).
  public final void mulss(XMMRegister dst, Mem src)
  {
    emitX86(INST_MULSS, dst, src);
  }

  //! @brief Bit-wise Logical OR for SP-FP Data (SSE).
  public final void orps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ORPS, dst, src);
  }
  //! @brief Bit-wise Logical OR for SP-FP Data (SSE).
  public final void orps(XMMRegister dst, Mem src)
  {
    emitX86(INST_ORPS, dst, src);
  }

  //! @brief Packed Average (SSE).
  public final void pavgb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PAVGB, dst, src);
  }
  //! @brief Packed Average (SSE).
  public final void pavgb(MMRegister dst, Mem src)
  {
    emitX86(INST_PAVGB, dst, src);
  }

  //! @brief Packed Average (SSE).
  public final void pavgw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PAVGW, dst, src);
  }
  //! @brief Packed Average (SSE).
  public final void pavgw(MMRegister dst, Mem src)
  {
    emitX86(INST_PAVGW, dst, src);
  }

  //! @brief Extract Word (SSE).
  public final void pextrw(Register dst, MMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRW, dst, src, imm8);
  }

  //! @brief Insert Word (SSE).
  public final void pinsrw(MMRegister dst, Register src, Immediate imm8)
  {
    emitX86(INST_PINSRW, dst, src, imm8);
  }
  //! @brief Insert Word (SSE).
  public final void pinsrw(MMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PINSRW, dst, src, imm8);
  }

  //! @brief Packed Signed Integer Word Maximum (SSE).
  public final void pmaxsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMAXSW, dst, src);
  }
  //! @brief Packed Signed Integer Word Maximum (SSE).
  public final void pmaxsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMAXSW, dst, src);
  }

  //! @brief Packed Unsigned Integer Byte Maximum (SSE).
  public final void pmaxub(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMAXUB, dst, src);
  }
  //! @brief Packed Unsigned Integer Byte Maximum (SSE).
  public final void pmaxub(MMRegister dst, Mem src)
  {
    emitX86(INST_PMAXUB, dst, src);
  }

  //! @brief Packed Signed Integer Word Minimum (SSE).
  public final void pminsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMINSW, dst, src);
  }
  //! @brief Packed Signed Integer Word Minimum (SSE).
  public final void pminsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMINSW, dst, src);
  }

  //! @brief Packed Unsigned Integer Byte Minimum (SSE).
  public final void pminub(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMINUB, dst, src);
  }
  //! @brief Packed Unsigned Integer Byte Minimum (SSE).
  public final void pminub(MMRegister dst, Mem src)
  {
    emitX86(INST_PMINUB, dst, src);
  }

  //! @brief Move Byte Mask To Integer (SSE).
  public final void pmovmskb(Register dst, MMRegister src)
  {
    emitX86(INST_PMOVMSKB, dst, src);
  }

  //! @brief Packed Multiply High Unsigned (SSE).
  public final void pmulhuw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMULHUW, dst, src);
  }
  //! @brief Packed Multiply High Unsigned (SSE).
  public final void pmulhuw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMULHUW, dst, src);
  }

  //! @brief Packed Sum of Absolute Differences (SSE).
  public final void psadbw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSADBW, dst, src);
  }
  //! @brief Packed Sum of Absolute Differences (SSE).
  public final void psadbw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSADBW, dst, src);
  }

  //! @brief Packed Shuffle word (SSE).
  public final void pshufw(MMRegister dst, MMRegister src, Immediate imm8)
  {
    emitX86(INST_PSHUFW, dst, src, imm8);
  }
  //! @brief Packed Shuffle word (SSE).
  public final void pshufw(MMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PSHUFW, dst, src, imm8);
  }

  //! @brief Packed SP-FP Reciprocal (SSE).
  public final void rcpps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_RCPPS, dst, src);
  }
  //! @brief Packed SP-FP Reciprocal (SSE).
  public final void rcpps(XMMRegister dst, Mem src)
  {
    emitX86(INST_RCPPS, dst, src);
  }

  //! @brief Scalar SP-FP Reciprocal (SSE).
  public final void rcpss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_RCPSS, dst, src);
  }
  //! @brief Scalar SP-FP Reciprocal (SSE).
  public final void rcpss(XMMRegister dst, Mem src)
  {
    emitX86(INST_RCPSS, dst, src);
  }

  //! @brief Prefetch (SSE).
  public final void prefetch(Mem mem, Immediate hint)
  {
    emitX86(INST_PREFETCH, mem, hint);
  }

  //! @brief Compute Sum of Absolute Differences (SSE).
  public final void psadbw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSADBW, dst, src);
  }
  //! @brief Compute Sum of Absolute Differences (SSE).
  public final void psadbw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSADBW, dst, src);
  }

  //! @brief Packed SP-FP Square Root Reciprocal (SSE).
  public final void rsqrtps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_RSQRTPS, dst, src);
  }
  //! @brief Packed SP-FP Square Root Reciprocal (SSE).
  public final void rsqrtps(XMMRegister dst, Mem src)
  {
    emitX86(INST_RSQRTPS, dst, src);
  }

  //! @brief Scalar SP-FP Square Root Reciprocal (SSE).
  public final void rsqrtss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_RSQRTSS, dst, src);
  }
  //! @brief Scalar SP-FP Square Root Reciprocal (SSE).
  public final void rsqrtss(XMMRegister dst, Mem src)
  {
    emitX86(INST_RSQRTSS, dst, src);
  }

  //! @brief Store fence (SSE).
  public final void sfence()
  {
    emitX86(INST_SFENCE);
  }

  //! @brief Shuffle SP-FP (SSE).
  public final void shufps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_SHUFPS, dst, src, imm8);
  }
  //! @brief Shuffle SP-FP (SSE).
  public final void shufps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_SHUFPS, dst, src, imm8);
  }

  //! @brief Packed SP-FP Square Root (SSE).
  public final void sqrtps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SQRTPS, dst, src);
  }
  //! @brief Packed SP-FP Square Root (SSE).
  public final void sqrtps(XMMRegister dst, Mem src)
  {
    emitX86(INST_SQRTPS, dst, src);
  }

  //! @brief Scalar SP-FP Square Root (SSE).
  public final void sqrtss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SQRTSS, dst, src);
  }
  //! @brief Scalar SP-FP Square Root (SSE).
  public final void sqrtss(XMMRegister dst, Mem src)
  {
    emitX86(INST_SQRTSS, dst, src);
  }

  //! @brief Store Streaming SIMD Extension Control/Status (SSE).
  public final void stmxcsr(Mem dst)
  {
    emitX86(INST_STMXCSR, dst);
  }

  //! @brief Packed SP-FP Subtract (SSE).
  public final void subps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SUBPS, dst, src);
  }
  //! @brief Packed SP-FP Subtract (SSE).
  public final void subps(XMMRegister dst, Mem src)
  {
    emitX86(INST_SUBPS, dst, src);
  }

  //! @brief Scalar SP-FP Subtract (SSE).
  public final void subss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SUBSS, dst, src);
  }
  //! @brief Scalar SP-FP Subtract (SSE).
  public final void subss(XMMRegister dst, Mem src)
  {
    emitX86(INST_SUBSS, dst, src);
  }

  //! @brief Unordered Scalar SP-FP compare and set EFLAGS (SSE).
  public final void ucomiss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UCOMISS, dst, src);
  }
  //! @brief Unordered Scalar SP-FP compare and set EFLAGS (SSE).
  public final void ucomiss(XMMRegister dst, Mem src)
  {
    emitX86(INST_UCOMISS, dst, src);
  }

  //! @brief Unpack High Packed SP-FP Data (SSE).
  public final void unpckhps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UNPCKHPS, dst, src);
  }
  //! @brief Unpack High Packed SP-FP Data (SSE).
  public final void unpckhps(XMMRegister dst, Mem src)
  {
    emitX86(INST_UNPCKHPS, dst, src);
  }

  //! @brief Unpack Low Packed SP-FP Data (SSE).
  public final void unpcklps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UNPCKLPS, dst, src);
  }
  //! @brief Unpack Low Packed SP-FP Data (SSE).
  public final void unpcklps(XMMRegister dst, Mem src)
  {
    emitX86(INST_UNPCKLPS, dst, src);
  }

  //! @brief Bit-wise Logical Xor for SP-FP Data (SSE).
  public final void xorps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_XORPS, dst, src);
  }
  //! @brief Bit-wise Logical Xor for SP-FP Data (SSE).
  public final void xorps(XMMRegister dst, Mem src)
  {
    emitX86(INST_XORPS, dst, src);
  }

  // -------------------------------------------------------------------------
  // [SSE2]
  // -------------------------------------------------------------------------

  //! @brief Packed DP-FP Add (SSE2).
  public final void addpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDPD, dst, src);
  }
  //! @brief Packed DP-FP Add (SSE2).
  public final void addpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDPD, dst, src);
  }

  //! @brief Scalar DP-FP Add (SSE2).
  public final void addsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDSD, dst, src);
  }
  //! @brief Scalar DP-FP Add (SSE2).
  public final void addsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDSD, dst, src);
  }

  //! @brief Bit-wise Logical And Not For DP-FP (SSE2).
  public final void andnpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ANDNPD, dst, src);
  }
  //! @brief Bit-wise Logical And Not For DP-FP (SSE2).
  public final void andnpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ANDNPD, dst, src);
  }

  //! @brief Bit-wise Logical And For DP-FP (SSE2).
  public final void andpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ANDPD, dst, src);
  }
  //! @brief Bit-wise Logical And For DP-FP (SSE2).
  public final void andpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ANDPD, dst, src);
  }

  //! @brief Flush Cache Line (SSE2).
  public final void clflush(Mem mem)
  {
    emitX86(INST_CLFLUSH, mem);
  }

  //! @brief Packed DP-FP Compare (SSE2).
  public final void cmppd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_CMPPD, dst, src, imm8);
  }
  //! @brief Packed DP-FP Compare (SSE2).
  public final void cmppd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_CMPPD, dst, src, imm8);
  }

  //! @brief Compare Scalar SP-FP Values (SSE2).
  public final void cmpsd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_CMPSD, dst, src, imm8);
  }
  //! @brief Compare Scalar SP-FP Values (SSE2).
  public final void cmpsd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_CMPSD, dst, src, imm8);
  }

  //! @brief Scalar Ordered DP-FP Compare and Set EFLAGS (SSE2).
  public final void comisd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_COMISD, dst, src);
  }
  //! @brief Scalar Ordered DP-FP Compare and Set EFLAGS (SSE2).
  public final void comisd(XMMRegister dst, Mem src)
  {
    emitX86(INST_COMISD, dst, src);
  }

  //! @brief Convert Packed Dword Integers to Packed DP-FP Values (SSE2).
  public final void cvtdq2pd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTDQ2PD, dst, src);
  }
  //! @brief Convert Packed Dword Integers to Packed DP-FP Values (SSE2).
  public final void cvtdq2pd(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTDQ2PD, dst, src);
  }

  //! @brief Convert Packed Dword Integers to Packed SP-FP Values (SSE2).
  public final void cvtdq2ps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTDQ2PS, dst, src);
  }
  //! @brief Convert Packed Dword Integers to Packed SP-FP Values (SSE2).
  public final void cvtdq2ps(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTDQ2PS, dst, src);
  }

  //! @brief Convert Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtpd2dq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPD2DQ, dst, src);
  }
  //! @brief Convert Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtpd2dq(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPD2DQ, dst, src);
  }

  //! @brief Convert Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtpd2pi(MMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPD2PI, dst, src);
  }
  //! @brief Convert Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtpd2pi(MMRegister dst, Mem src)
  {
    emitX86(INST_CVTPD2PI, dst, src);
  }

  //! @brief Convert Packed DP-FP Values to Packed SP-FP Values (SSE2).
  public final void cvtpd2ps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPD2PS, dst, src);
  }
  //! @brief Convert Packed DP-FP Values to Packed SP-FP Values (SSE2).
  public final void cvtpd2ps(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPD2PS, dst, src);
  }

  //! @brief Convert Packed Dword Integers to Packed DP-FP Values (SSE2).
  public final void cvtpi2pd(XMMRegister dst, MMRegister src)
  {
    emitX86(INST_CVTPI2PD, dst, src);
  }
  //! @brief Convert Packed Dword Integers to Packed DP-FP Values (SSE2).
  public final void cvtpi2pd(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPI2PD, dst, src);
  }

  //! @brief Convert Packed SP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtps2dq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPS2DQ, dst, src);
  }
  //! @brief Convert Packed SP-FP Values to Packed Dword Integers (SSE2).
  public final void cvtps2dq(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPS2DQ, dst, src);
  }

  //! @brief Convert Packed SP-FP Values to Packed DP-FP Values (SSE2).
  public final void cvtps2pd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTPS2PD, dst, src);
  }
  //! @brief Convert Packed SP-FP Values to Packed DP-FP Values (SSE2).
  public final void cvtps2pd(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTPS2PD, dst, src);
  }

  //! @brief Convert Scalar DP-FP Value to Dword Integer (SSE2).
  public final void cvtsd2si(Register dst, XMMRegister src)
  {
    emitX86(INST_CVTSD2SI, dst, src);
  }
  //! @brief Convert Scalar DP-FP Value to Dword Integer (SSE2).
  public final void cvtsd2si(Register dst, Mem src)
  {
    emitX86(INST_CVTSD2SI, dst, src);
  }

  //! @brief Convert Scalar DP-FP Value to Scalar SP-FP Value (SSE2).
  public final void cvtsd2ss(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTSD2SS, dst, src);
  }
  //! @brief Convert Scalar DP-FP Value to Scalar SP-FP Value (SSE2).
  public final void cvtsd2ss(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTSD2SS, dst, src);
  }

  //! @brief Convert Dword Integer to Scalar DP-FP Value (SSE2).
  public final void cvtsi2sd(XMMRegister dst, Register src)
  {
    emitX86(INST_CVTSI2SD, dst, src);
  }
  //! @brief Convert Dword Integer to Scalar DP-FP Value (SSE2).
  public final void cvtsi2sd(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTSI2SD, dst, src);
  }

  //! @brief Convert Scalar SP-FP Value to Scalar DP-FP Value (SSE2).
  public final void cvtss2sd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTSS2SD, dst, src);
  }
  //! @brief Convert Scalar SP-FP Value to Scalar DP-FP Value (SSE2).
  public final void cvtss2sd(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTSS2SD, dst, src);
  }

  //! @brief Convert with Truncation Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttpd2pi(MMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTTPD2PI, dst, src);
  }
  //! @brief Convert with Truncation Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttpd2pi(MMRegister dst, Mem src)
  {
    emitX86(INST_CVTTPD2PI, dst, src);
  }

  //! @brief Convert with Truncation Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttpd2dq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTTPD2DQ, dst, src);
  }
  //! @brief Convert with Truncation Packed DP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttpd2dq(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTTPD2DQ, dst, src);
  }

  //! @brief Convert with Truncation Packed SP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttps2dq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_CVTTPS2DQ, dst, src);
  }
  //! @brief Convert with Truncation Packed SP-FP Values to Packed Dword Integers (SSE2).
  public final void cvttps2dq(XMMRegister dst, Mem src)
  {
    emitX86(INST_CVTTPS2DQ, dst, src);
  }

  //! @brief Convert with Truncation Scalar DP-FP Value to Signed Dword Integer (SSE2).
  public final void cvttsd2si(Register dst, XMMRegister src)
  {
    emitX86(INST_CVTTSD2SI, dst, src);
  }
  //! @brief Convert with Truncation Scalar DP-FP Value to Signed Dword Integer (SSE2).
  public final void cvttsd2si(Register dst, Mem src)
  {
    emitX86(INST_CVTTSD2SI, dst, src);
  }

  //! @brief Packed DP-FP Divide (SSE2).
  public final void divpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_DIVPD, dst, src);
  }
  //! @brief Packed DP-FP Divide (SSE2).
  public final void divpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_DIVPD, dst, src);
  }

  //! @brief Scalar DP-FP Divide (SSE2).
  public final void divsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_DIVSD, dst, src);
  }
  //! @brief Scalar DP-FP Divide (SSE2).
  public final void divsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_DIVSD, dst, src);
  }

  //! @brief Load Fence (SSE2).
  public final void lfence()
  {
    emitX86(INST_LFENCE);
  }

  //! @brief Store Selected Bytes of Double Quadword (SSE2).
  //!
  //! @note Target is DS:EDI.
  public final void maskmovdqu(XMMRegister src, XMMRegister mask)
  {
    emitX86(INST_MASKMOVDQU, src, mask);
  }

  //! @brief Return Maximum Packed Double-Precision FP Values (SSE2).
  public final void maxpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MAXPD, dst, src);
  }
  //! @brief Return Maximum Packed Double-Precision FP Values (SSE2).
  public final void maxpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MAXPD, dst, src);
  }

  //! @brief Return Maximum Scalar Double-Precision FP Value (SSE2).
  public final void maxsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MAXSD, dst, src);
  }
  //! @brief Return Maximum Scalar Double-Precision FP Value (SSE2).
  public final void maxsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MAXSD, dst, src);
  }

  //! @brief Memory Fence (SSE2).
  public final void mfence()
  {
    emitX86(INST_MFENCE);
  }

  //! @brief Return Minimum Packed DP-FP Values (SSE2).
  public final void minpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MINPD, dst, src);
  }
  //! @brief Return Minimum Packed DP-FP Values (SSE2).
  public final void minpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MINPD, dst, src);
  }

  //! @brief Return Minimum Scalar DP-FP Value (SSE2).
  public final void minsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MINSD, dst, src);
  }
  //! @brief Return Minimum Scalar DP-FP Value (SSE2).
  public final void minsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MINSD, dst, src);
  }

  //! @brief Move Aligned DQWord (SSE2).
  public final void movdqa(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVDQA, dst, src);
  }
  //! @brief Move Aligned DQWord (SSE2).
  public final void movdqa(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVDQA, dst, src);
  }

  //! @brief Move Aligned DQWord (SSE2).
  public final void movdqa(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVDQA, dst, src);
  }

  //! @brief Move Unaligned Double Quadword (SSE2).
  public final void movdqu(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVDQU, dst, src);
  }
  //! @brief Move Unaligned Double Quadword (SSE2).
  public final void movdqu(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVDQU, dst, src);
  }

  //! @brief Move Unaligned Double Quadword (SSE2).
  public final void movdqu(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVDQU, dst, src);
  }

  //! @brief Extract Packed SP-FP Sign Mask (SSE2).
  public final void movmskps(Register dst, XMMRegister src)
  {
    emitX86(INST_MOVMSKPS, dst, src);
  }

  //! @brief Extract Packed DP-FP Sign Mask (SSE2).
  public final void movmskpd(Register dst, XMMRegister src)
  {
    emitX86(INST_MOVMSKPD, dst, src);
  }

  //! @brief Move Scalar Double-Precision FP Value (SSE2).
  public final void movsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVSD, dst, src);
  }
  //! @brief Move Scalar Double-Precision FP Value (SSE2).
  public final void movsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVSD, dst, src);
  }

  //! @brief Move Scalar Double-Precision FP Value (SSE2).
  public final void movsd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVSD, dst, src);
  }

  //! @brief Move Aligned Packed Double-Precision FP Values (SSE2).
  public final void movapd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVAPD, dst, src);
  }

  //! @brief Move Aligned Packed Double-Precision FP Values (SSE2).
  public final void movapd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVAPD, dst, src);
  }

  //! @brief Move Aligned Packed Double-Precision FP Values (SSE2).
  public final void movapd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVAPD, dst, src);
  }

  //! @brief Move Quadword from XMM to MMX Technology Register (SSE2).
  public final void movdq2q(MMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVDQ2Q, dst, src);
  }

  //! @brief Move Quadword from MMX Technology to XMM Register (SSE2).
  public final void movq2dq(XMMRegister dst, MMRegister src)
  {
    emitX86(INST_MOVQ2DQ, dst, src);
  }

  //! @brief Move High Packed Double-Precision FP Value (SSE2).
  public final void movhpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVHPD, dst, src);
  }

  //! @brief Move High Packed Double-Precision FP Value (SSE2).
  public final void movhpd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVHPD, dst, src);
  }

  //! @brief Move Low Packed Double-Precision FP Value (SSE2).
  public final void movlpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVLPD, dst, src);
  }

  //! @brief Move Low Packed Double-Precision FP Value (SSE2).
  public final void movlpd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVLPD, dst, src);
  }

  //! @brief Store Double Quadword Using Non-Temporal Hint (SSE2).
  public final void movntdq(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVNTDQ, dst, src);
  }

  //! @brief Store Store DWORD Using Non-Temporal Hint (SSE2).
  public final void movnti(Mem dst, Register src)
  {
    emitX86(INST_MOVNTI, dst, src);
  }

  //! @brief Store Packed Double-Precision FP Values Using Non-Temporal Hint (SSE2).
  public final void movntpd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVNTPD, dst, src);
  }

  //! @brief Move Unaligned Packed Double-Precision FP Values (SSE2).
  public final void movupd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVUPD, dst, src);
  }

  //! @brief Move Unaligned Packed Double-Precision FP Values (SSE2).
  public final void movupd(Mem dst, XMMRegister src)
  {
    emitX86(INST_MOVUPD, dst, src);
  }

  //! @brief Packed DP-FP Multiply (SSE2).
  public final void mulpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MULPD, dst, src);
  }
  //! @brief Packed DP-FP Multiply (SSE2).
  public final void mulpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MULPD, dst, src);
  }

  //! @brief Scalar DP-FP Multiply (SSE2).
  public final void mulsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MULSD, dst, src);
  }
  //! @brief Scalar DP-FP Multiply (SSE2).
  public final void mulsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_MULSD, dst, src);
  }

  //! @brief Bit-wise Logical OR for DP-FP Data (SSE2).
  public final void orpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ORPD, dst, src);
  }
  //! @brief Bit-wise Logical OR for DP-FP Data (SSE2).
  public final void orpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ORPD, dst, src);
  }

  //! @brief Pack with Signed Saturation (SSE2).
  public final void packsswb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PACKSSWB, dst, src);
  }
  //! @brief Pack with Signed Saturation (SSE2).
  public final void packsswb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PACKSSWB, dst, src);
  }

  //! @brief Pack with Signed Saturation (SSE2).
  public final void packssdw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PACKSSDW, dst, src);
  }
  //! @brief Pack with Signed Saturation (SSE2).
  public final void packssdw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PACKSSDW, dst, src);
  }

  //! @brief Pack with Unsigned Saturation (SSE2).
  public final void packuswb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PACKUSWB, dst, src);
  }
  //! @brief Pack with Unsigned Saturation (SSE2).
  public final void packuswb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PACKUSWB, dst, src);
  }

  //! @brief Packed BYTE Add (SSE2).
  public final void paddb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDB, dst, src);
  }
  //! @brief Packed BYTE Add (SSE2).
  public final void paddb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDB, dst, src);
  }

  //! @brief Packed WORD Add (SSE2).
  public final void paddw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDW, dst, src);
  }
  //! @brief Packed WORD Add (SSE2).
  public final void paddw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDW, dst, src);
  }

  //! @brief Packed DWORD Add (SSE2).
  public final void paddd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDD, dst, src);
  }
  //! @brief Packed DWORD Add (SSE2).
  public final void paddd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDD, dst, src);
  }

  //! @brief Packed QWORD Add (SSE2).
  public final void paddq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PADDQ, dst, src);
  }
  //! @brief Packed QWORD Add (SSE2).
  public final void paddq(MMRegister dst, Mem src)
  {
    emitX86(INST_PADDQ, dst, src);
  }

  //! @brief Packed QWORD Add (SSE2).
  public final void paddq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDQ, dst, src);
  }
  //! @brief Packed QWORD Add (SSE2).
  public final void paddq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDQ, dst, src);
  }

  //! @brief Packed Add with Saturation (SSE2).
  public final void paddsb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDSB, dst, src);
  }
  //! @brief Packed Add with Saturation (SSE2).
  public final void paddsb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDSB, dst, src);
  }

  //! @brief Packed Add with Saturation (SSE2).
  public final void paddsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDSW, dst, src);
  }
  //! @brief Packed Add with Saturation (SSE2).
  public final void paddsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDSW, dst, src);
  }

  //! @brief Packed Add Unsigned with Saturation (SSE2).
  public final void paddusb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDUSB, dst, src);
  }
  //! @brief Packed Add Unsigned with Saturation (SSE2).
  public final void paddusb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDUSB, dst, src);
  }

  //! @brief Packed Add Unsigned with Saturation (SSE2).
  public final void paddusw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PADDUSW, dst, src);
  }
  //! @brief Packed Add Unsigned with Saturation (SSE2).
  public final void paddusw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PADDUSW, dst, src);
  }

  //! @brief Logical AND (SSE2).
  public final void pand(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PAND, dst, src);
  }
  //! @brief Logical AND (SSE2).
  public final void pand(XMMRegister dst, Mem src)
  {
    emitX86(INST_PAND, dst, src);
  }

  //! @brief Logical AND Not (SSE2).
  public final void pandn(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PANDN, dst, src);
  }
  //! @brief Logical AND Not (SSE2).
  public final void pandn(XMMRegister dst, Mem src)
  {
    emitX86(INST_PANDN, dst, src);
  }

  //! @brief Spin Loop Hint (SSE2).
  public final void pause()
  {
    emitX86(INST_PAUSE);
  }

  //! @brief Packed Average (SSE2).
  public final void pavgb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PAVGB, dst, src);
  }
  //! @brief Packed Average (SSE2).
  public final void pavgb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PAVGB, dst, src);
  }

  //! @brief Packed Average (SSE2).
  public final void pavgw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PAVGW, dst, src);
  }
  //! @brief Packed Average (SSE2).
  public final void pavgw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PAVGW, dst, src);
  }

  //! @brief Packed Compare for Equal (BYTES) (SSE2).
  public final void pcmpeqb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPEQB, dst, src);
  }
  //! @brief Packed Compare for Equal (BYTES) (SSE2).
  public final void pcmpeqb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQB, dst, src);
  }

  //! @brief Packed Compare for Equal (WORDS) (SSE2).
  public final void pcmpeqw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPEQW, dst, src);
  }
  //! @brief Packed Compare for Equal (WORDS) (SSE2).
  public final void pcmpeqw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQW, dst, src);
  }

  //! @brief Packed Compare for Equal (DWORDS) (SSE2).
  public final void pcmpeqd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPEQD, dst, src);
  }
  //! @brief Packed Compare for Equal (DWORDS) (SSE2).
  public final void pcmpeqd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQD, dst, src);
  }

  //! @brief Packed Compare for Greater Than (BYTES) (SSE2).
  public final void pcmpgtb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPGTB, dst, src);
  }
  //! @brief Packed Compare for Greater Than (BYTES) (SSE2).
  public final void pcmpgtb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTB, dst, src);
  }

  //! @brief Packed Compare for Greater Than (WORDS) (SSE2).
  public final void pcmpgtw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPGTW, dst, src);
  }
  //! @brief Packed Compare for Greater Than (WORDS) (SSE2).
  public final void pcmpgtw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTW, dst, src);
  }

  //! @brief Packed Compare for Greater Than (DWORDS) (SSE2).
  public final void pcmpgtd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPGTD, dst, src);
  }
  //! @brief Packed Compare for Greater Than (DWORDS) (SSE2).
  public final void pcmpgtd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTD, dst, src);
  }

  //! @brief Packed Signed Integer Word Maximum (SSE2).
  public final void pmaxsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXSW, dst, src);
  }
  //! @brief Packed Signed Integer Word Maximum (SSE2).
  public final void pmaxsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXSW, dst, src);
  }

  //! @brief Packed Unsigned Integer Byte Maximum (SSE2).
  public final void pmaxub(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXUB, dst, src);
  }
  //! @brief Packed Unsigned Integer Byte Maximum (SSE2).
  public final void pmaxub(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXUB, dst, src);
  }

  //! @brief Packed Signed Integer Word Minimum (SSE2).
  public final void pminsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINSW, dst, src);
  }
  //! @brief Packed Signed Integer Word Minimum (SSE2).
  public final void pminsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINSW, dst, src);
  }

  //! @brief Packed Unsigned Integer Byte Minimum (SSE2).
  public final void pminub(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINUB, dst, src);
  }
  //! @brief Packed Unsigned Integer Byte Minimum (SSE2).
  public final void pminub(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINUB, dst, src);
  }

  //! @brief Move Byte Mask (SSE2).
  public final void pmovmskb(Register dst, XMMRegister src)
  {
    emitX86(INST_PMOVMSKB, dst, src);
  }

  //! @brief Packed Multiply High (SSE2).
  public final void pmulhw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULHW, dst, src);
  }
  //! @brief Packed Multiply High (SSE2).
  public final void pmulhw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULHW, dst, src);
  }

  //! @brief Packed Multiply High Unsigned (SSE2).
  public final void pmulhuw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULHUW, dst, src);
  }
  //! @brief Packed Multiply High Unsigned (SSE2).
  public final void pmulhuw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULHUW, dst, src);
  }

  //! @brief Packed Multiply Low (SSE2).
  public final void pmullw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULLW, dst, src);
  }
  //! @brief Packed Multiply Low (SSE2).
  public final void pmullw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULLW, dst, src);
  }

  //! @brief Packed Multiply to QWORD (SSE2).
  public final void pmuludq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMULUDQ, dst, src);
  }
  //! @brief Packed Multiply to QWORD (SSE2).
  public final void pmuludq(MMRegister dst, Mem src)
  {
    emitX86(INST_PMULUDQ, dst, src);
  }

  //! @brief Packed Multiply to QWORD (SSE2).
  public final void pmuludq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULUDQ, dst, src);
  }
  //! @brief Packed Multiply to QWORD (SSE2).
  public final void pmuludq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULUDQ, dst, src);
  }

  //! @brief Bitwise Logical OR (SSE2).
  public final void por(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_POR, dst, src);
  }
  //! @brief Bitwise Logical OR (SSE2).
  public final void por(XMMRegister dst, Mem src)
  {
    emitX86(INST_POR, dst, src);
  }

  //! @brief Packed Shift Left Logical (SSE2).
  public final void pslld(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSLLD, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void pslld(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSLLD, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void pslld(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLD, dst, src);
  }

  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllq(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLQ, dst, src);
  }

  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSLLW, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSLLW, dst, src);
  }
  //! @brief Packed Shift Left Logical (SSE2).
  public final void psllw(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLW, dst, src);
  }

  //! @brief Packed Shift Left Logical (SSE2).
  public final void pslldq(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSLLDQ, dst, src);
  }

  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psrad(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSRAD, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psrad(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSRAD, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psrad(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRAD, dst, src);
  }

  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psraw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSRAW, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psraw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSRAW, dst, src);
  }
  //! @brief Packed Shift Right Arithmetic (SSE2).
  public final void psraw(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRAW, dst, src);
  }

  //! @brief Packed Subtract (SSE2).
  public final void psubb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBB, dst, src);
  }
  //! @brief Packed Subtract (SSE2).
  public final void psubb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBB, dst, src);
  }

  //! @brief Packed Subtract (SSE2).
  public final void psubw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBW, dst, src);
  }
  //! @brief Packed Subtract (SSE2).
  public final void psubw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBW, dst, src);
  }

  //! @brief Packed Subtract (SSE2).
  public final void psubd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBD, dst, src);
  }
  //! @brief Packed Subtract (SSE2).
  public final void psubd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBD, dst, src);
  }

  //! @brief Packed Subtract (SSE2).
  public final void psubq(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSUBQ, dst, src);
  }
  //! @brief Packed Subtract (SSE2).
  public final void psubq(MMRegister dst, Mem src)
  {
    emitX86(INST_PSUBQ, dst, src);
  }

  //! @brief Packed Subtract (SSE2).
  public final void psubq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBQ, dst, src);
  }
  //! @brief Packed Subtract (SSE2).
  public final void psubq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBQ, dst, src);
  }

  //! @brief Packed Multiply and Add (SSE2).
  public final void pmaddwd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMADDWD, dst, src);
  }
  //! @brief Packed Multiply and Add (SSE2).
  public final void pmaddwd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMADDWD, dst, src);
  }

  //! @brief Shuffle Packed DWORDs (SSE2).
  public final void pshufd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PSHUFD, dst, src, imm8);
  }
  //! @brief Shuffle Packed DWORDs (SSE2).
  public final void pshufd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PSHUFD, dst, src, imm8);
  }

  //! @brief Shuffle Packed High Words (SSE2).
  public final void pshufhw(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PSHUFHW, dst, src, imm8);
  }
  //! @brief Shuffle Packed High Words (SSE2).
  public final void pshufhw(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PSHUFHW, dst, src, imm8);
  }

  //! @brief Shuffle Packed Low Words (SSE2).
  public final void pshuflw(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PSHUFLW, dst, src, imm8);
  }
  //! @brief Shuffle Packed Low Words (SSE2).
  public final void pshuflw(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PSHUFLW, dst, src, imm8);
  }

  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrld(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSRLD, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrld(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSRLD, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrld(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLD, dst, src);
  }

  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlq(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLQ, dst, src);
  }

  //! @brief DQWord Shift Right Logical (MMX).
  public final void psrldq(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLDQ, dst, src);
  }

  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSRLW, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSRLW, dst, src);
  }
  //! @brief Packed Shift Right Logical (SSE2).
  public final void psrlw(XMMRegister dst, Immediate src)
  {
    emitX86(INST_PSRLW, dst, src);
  }

  //! @brief Packed Subtract with Saturation (SSE2).
  public final void psubsb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBSB, dst, src);
  }
  //! @brief Packed Subtract with Saturation (SSE2).
  public final void psubsb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBSB, dst, src);
  }

  //! @brief Packed Subtract with Saturation (SSE2).
  public final void psubsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBSW, dst, src);
  }
  //! @brief Packed Subtract with Saturation (SSE2).
  public final void psubsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBSW, dst, src);
  }

  //! @brief Packed Subtract with Unsigned Saturation (SSE2).
  public final void psubusb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBUSB, dst, src);
  }
  //! @brief Packed Subtract with Unsigned Saturation (SSE2).
  public final void psubusb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBUSB, dst, src);
  }

  //! @brief Packed Subtract with Unsigned Saturation (SSE2).
  public final void psubusw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSUBUSW, dst, src);
  }
  //! @brief Packed Subtract with Unsigned Saturation (SSE2).
  public final void psubusw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSUBUSW, dst, src);
  }

  //! @brief Unpack High Data (SSE2).
  public final void punpckhbw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKHBW, dst, src);
  }
  //! @brief Unpack High Data (SSE2).
  public final void punpckhbw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHBW, dst, src);
  }

  //! @brief Unpack High Data (SSE2).
  public final void punpckhwd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKHWD, dst, src);
  }
  //! @brief Unpack High Data (SSE2).
  public final void punpckhwd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHWD, dst, src);
  }

  //! @brief Unpack High Data (SSE2).
  public final void punpckhdq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKHDQ, dst, src);
  }
  //! @brief Unpack High Data (SSE2).
  public final void punpckhdq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHDQ, dst, src);
  }

  //! @brief Unpack High Data (SSE2).
  public final void punpckhqdq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKHQDQ, dst, src);
  }
  //! @brief Unpack High Data (SSE2).
  public final void punpckhqdq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKHQDQ, dst, src);
  }

  //! @brief Unpack Low Data (SSE2).
  public final void punpcklbw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKLBW, dst, src);
  }
  //! @brief Unpack Low Data (SSE2).
  public final void punpcklbw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLBW, dst, src);
  }

  //! @brief Unpack Low Data (SSE2).
  public final void punpcklwd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKLWD, dst, src);
  }
  //! @brief Unpack Low Data (SSE2).
  public final void punpcklwd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLWD, dst, src);
  }

  //! @brief Unpack Low Data (SSE2).
  public final void punpckldq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKLDQ, dst, src);
  }
  //! @brief Unpack Low Data (SSE2).
  public final void punpckldq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLDQ, dst, src);
  }

  //! @brief Unpack Low Data (SSE2).
  public final void punpcklqdq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PUNPCKLQDQ, dst, src);
  }
  //! @brief Unpack Low Data (SSE2).
  public final void punpcklqdq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PUNPCKLQDQ, dst, src);
  }

  //! @brief Bitwise Exclusive OR (SSE2).
  public final void pxor(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PXOR, dst, src);
  }
  //! @brief Bitwise Exclusive OR (SSE2).
  public final void pxor(XMMRegister dst, Mem src)
  {
    emitX86(INST_PXOR, dst, src);
  }

  //! @brief Compute Square Roots of Packed DP-FP Values (SSE2).
  public final void sqrtpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SQRTPD, dst, src);
  }
  //! @brief Compute Square Roots of Packed DP-FP Values (SSE2).
  public final void sqrtpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_SQRTPD, dst, src);
  }

  //! @brief Compute Square Root of Scalar DP-FP Value (SSE2).
  public final void sqrtsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SQRTSD, dst, src);
  }
  //! @brief Compute Square Root of Scalar DP-FP Value (SSE2).
  public final void sqrtsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_SQRTSD, dst, src);
  }

  //! @brief Packed DP-FP Subtract (SSE2).
  public final void subpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SUBPD, dst, src);
  }
  //! @brief Packed DP-FP Subtract (SSE2).
  public final void subpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_SUBPD, dst, src);
  }

  //! @brief Scalar DP-FP Subtract (SSE2).
  public final void subsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_SUBSD, dst, src);
  }
  //! @brief Scalar DP-FP Subtract (SSE2).
  public final void subsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_SUBSD, dst, src);
  }

  //! @brief Scalar Unordered DP-FP Compare and Set EFLAGS (SSE2).
  public final void ucomisd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UCOMISD, dst, src);
  }
  //! @brief Scalar Unordered DP-FP Compare and Set EFLAGS (SSE2).
  public final void ucomisd(XMMRegister dst, Mem src)
  {
    emitX86(INST_UCOMISD, dst, src);
  }

  //! @brief Unpack and Interleave High Packed Double-Precision FP Values (SSE2).
  public final void unpckhpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UNPCKHPD, dst, src);
  }
  //! @brief Unpack and Interleave High Packed Double-Precision FP Values (SSE2).
  public final void unpckhpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_UNPCKHPD, dst, src);
  }

  //! @brief Unpack and Interleave Low Packed Double-Precision FP Values (SSE2).
  public final void unpcklpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_UNPCKLPD, dst, src);
  }
  //! @brief Unpack and Interleave Low Packed Double-Precision FP Values (SSE2).
  public final void unpcklpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_UNPCKLPD, dst, src);
  }

  //! @brief Bit-wise Logical OR for DP-FP Data (SSE2).
  public final void xorpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_XORPD, dst, src);
  }
  //! @brief Bit-wise Logical OR for DP-FP Data (SSE2).
  public final void xorpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_XORPD, dst, src);
  }

  // -------------------------------------------------------------------------
  // [SSE3]
  // -------------------------------------------------------------------------

  //! @brief Packed DP-FP Add/Subtract (SSE3).
  public final void addsubpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDSUBPD, dst, src);
  }
  //! @brief Packed DP-FP Add/Subtract (SSE3).
  public final void addsubpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDSUBPD, dst, src);
  }

  //! @brief Packed SP-FP Add/Subtract (SSE3).
  public final void addsubps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_ADDSUBPS, dst, src);
  }
  //! @brief Packed SP-FP Add/Subtract (SSE3).
  public final void addsubps(XMMRegister dst, Mem src)
  {
    emitX86(INST_ADDSUBPS, dst, src);
  }

  //! @brief Store Integer with Truncation (SSE3).
  public final void fisttp(Mem dst)
  {
    emitX86(INST_FISTTP, dst);
  }

  //! @brief Packed DP-FP Horizontal Add (SSE3).
  public final void haddpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_HADDPD, dst, src);
  }
  //! @brief Packed DP-FP Horizontal Add (SSE3).
  public final void haddpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_HADDPD, dst, src);
  }

  //! @brief Packed SP-FP Horizontal Add (SSE3).
  public final void haddps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_HADDPS, dst, src);
  }
  //! @brief Packed SP-FP Horizontal Add (SSE3).
  public final void haddps(XMMRegister dst, Mem src)
  {
    emitX86(INST_HADDPS, dst, src);
  }

  //! @brief Packed DP-FP Horizontal Subtract (SSE3).
  public final void hsubpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_HSUBPD, dst, src);
  }
  //! @brief Packed DP-FP Horizontal Subtract (SSE3).
  public final void hsubpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_HSUBPD, dst, src);
  }

  //! @brief Packed SP-FP Horizontal Subtract (SSE3).
  public final void hsubps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_HSUBPS, dst, src);
  }
  //! @brief Packed SP-FP Horizontal Subtract (SSE3).
  public final void hsubps(XMMRegister dst, Mem src)
  {
    emitX86(INST_HSUBPS, dst, src);
  }

  //! @brief Load Unaligned Integer 128 Bits (SSE3).
  public final void lddqu(XMMRegister dst, Mem src)
  {
    emitX86(INST_LDDQU, dst, src);
  }

  //! @brief Set Up Monitor Address (SSE3).
  public final void monitor()
  {
    emitX86(INST_MONITOR);
  }

  //! @brief Move One DP-FP and Duplicate (SSE3).
  public final void movddup(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVDDUP, dst, src);
  }
  //! @brief Move One DP-FP and Duplicate (SSE3).
  public final void movddup(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVDDUP, dst, src);
  }

  //! @brief Move Packed SP-FP High and Duplicate (SSE3).
  public final void movshdup(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVSHDUP, dst, src);
  }
  //! @brief Move Packed SP-FP High and Duplicate (SSE3).
  public final void movshdup(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVSHDUP, dst, src);
  }

  //! @brief Move Packed SP-FP Low and Duplicate (SSE3).
  public final void movsldup(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_MOVSLDUP, dst, src);
  }
  //! @brief Move Packed SP-FP Low and Duplicate (SSE3).
  public final void movsldup(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVSLDUP, dst, src);
  }

  //! @brief Monitor Wait (SSE3).
  public final void mwait()
  {
    emitX86(INST_MWAIT);
  }

  // -------------------------------------------------------------------------
  // [SSSE3]
  // -------------------------------------------------------------------------

  //! @brief Packed SIGN (SSSE3).
  public final void psignb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSIGNB, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignb(MMRegister dst, Mem src)
  {
    emitX86(INST_PSIGNB, dst, src);
  }

  //! @brief Packed SIGN (SSSE3).
  public final void psignb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSIGNB, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSIGNB, dst, src);
  }

  //! @brief Packed SIGN (SSSE3).
  public final void psignw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSIGNW, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignw(MMRegister dst, Mem src)
  {
    emitX86(INST_PSIGNW, dst, src);
  }

  //! @brief Packed SIGN (SSSE3).
  public final void psignw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSIGNW, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSIGNW, dst, src);
  }

  //! @brief Packed SIGN (SSSE3).
  public final void psignd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSIGND, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignd(MMRegister dst, Mem src)
  {
    emitX86(INST_PSIGND, dst, src);
  }

  //! @brief Packed SIGN (SSSE3).
  public final void psignd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSIGND, dst, src);
  }
  //! @brief Packed SIGN (SSSE3).
  public final void psignd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSIGND, dst, src);
  }

  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHADDW, dst, src);
  }
  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddw(MMRegister dst, Mem src)
  {
    emitX86(INST_PHADDW, dst, src);
  }

  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHADDW, dst, src);
  }
  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHADDW, dst, src);
  }

  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHADDD, dst, src);
  }
  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddd(MMRegister dst, Mem src)
  {
    emitX86(INST_PHADDD, dst, src);
  }

  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHADDD, dst, src);
  }
  //! @brief Packed Horizontal Add (SSSE3).
  public final void phaddd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHADDD, dst, src);
  }

  //! @brief Packed Horizontal Add and Saturate (SSSE3).
  public final void phaddsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHADDSW, dst, src);
  }
  //! @brief Packed Horizontal Add and Saturate (SSSE3).
  public final void phaddsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PHADDSW, dst, src);
  }

  //! @brief Packed Horizontal Add and Saturate (SSSE3).
  public final void phaddsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHADDSW, dst, src);
  }
  //! @brief Packed Horizontal Add and Saturate (SSSE3).
  public final void phaddsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHADDSW, dst, src);
  }

  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHSUBW, dst, src);
  }
  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubw(MMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBW, dst, src);
  }

  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHSUBW, dst, src);
  }
  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBW, dst, src);
  }

  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHSUBD, dst, src);
  }
  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubd(MMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBD, dst, src);
  }

  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHSUBD, dst, src);
  }
  //! @brief Packed Horizontal Subtract (SSSE3).
  public final void phsubd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBD, dst, src);
  }

  //! @brief Packed Horizontal Subtract and Saturate (SSSE3).
  public final void phsubsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PHSUBSW, dst, src);
  }
  //! @brief Packed Horizontal Subtract and Saturate (SSSE3).
  public final void phsubsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBSW, dst, src);
  }

  //! @brief Packed Horizontal Subtract and Saturate (SSSE3).
  public final void phsubsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHSUBSW, dst, src);
  }
  //! @brief Packed Horizontal Subtract and Saturate (SSSE3).
  public final void phsubsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHSUBSW, dst, src);
  }

  //! @brief Multiply and Add Packed Signed and Unsigned Bytes (SSSE3).
  public final void pmaddubsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMADDUBSW, dst, src);
  }
  //! @brief Multiply and Add Packed Signed and Unsigned Bytes (SSSE3).
  public final void pmaddubsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMADDUBSW, dst, src);
  }

  //! @brief Multiply and Add Packed Signed and Unsigned Bytes (SSSE3).
  public final void pmaddubsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMADDUBSW, dst, src);
  }
  //! @brief Multiply and Add Packed Signed and Unsigned Bytes (SSSE3).
  public final void pmaddubsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMADDUBSW, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PABSB, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsb(MMRegister dst, Mem src)
  {
    emitX86(INST_PABSB, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PABSB, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PABSB, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PABSW, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PABSW, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PABSW, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PABSW, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsd(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PABSD, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsd(MMRegister dst, Mem src)
  {
    emitX86(INST_PABSD, dst, src);
  }

  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PABSD, dst, src);
  }
  //! @brief Packed Absolute Value (SSSE3).
  public final void pabsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PABSD, dst, src);
  }

  //! @brief Packed Multiply High with Round and Scale (SSSE3).
  public final void pmulhrsw(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PMULHRSW, dst, src);
  }
  //! @brief Packed Multiply High with Round and Scale (SSSE3).
  public final void pmulhrsw(MMRegister dst, Mem src)
  {
    emitX86(INST_PMULHRSW, dst, src);
  }

  //! @brief Packed Multiply High with Round and Scale (SSSE3).
  public final void pmulhrsw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULHRSW, dst, src);
  }
  //! @brief Packed Multiply High with Round and Scale (SSSE3).
  public final void pmulhrsw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULHRSW, dst, src);
  }

  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void pshufb(MMRegister dst, MMRegister src)
  {
    emitX86(INST_PSHUFB, dst, src);
  }
  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void pshufb(MMRegister dst, Mem src)
  {
    emitX86(INST_PSHUFB, dst, src);
  }

  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void pshufb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PSHUFB, dst, src);
  }
  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void pshufb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PSHUFB, dst, src);
  }

  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void palignr(MMRegister dst, MMRegister src, Immediate imm8)
  {
    emitX86(INST_PALIGNR, dst, src, imm8);
  }
  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void palignr(MMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PALIGNR, dst, src, imm8);
  }

  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void palignr(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PALIGNR, dst, src, imm8);
  }
  //! @brief Packed Shuffle Bytes (SSSE3).
  public final void palignr(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PALIGNR, dst, src, imm8);
  }

  // -------------------------------------------------------------------------
  // [SSE4.1]
  // -------------------------------------------------------------------------

  //! @brief Blend Packed DP-FP Values (SSE4.1).
  public final void blendpd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_BLENDPD, dst, src, imm8);
  }
  //! @brief Blend Packed DP-FP Values (SSE4.1).
  public final void blendpd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_BLENDPD, dst, src, imm8);
  }

  //! @brief Blend Packed SP-FP Values (SSE4.1).
  public final void blendps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_BLENDPS, dst, src, imm8);
  }
  //! @brief Blend Packed SP-FP Values (SSE4.1).
  public final void blendps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_BLENDPS, dst, src, imm8);
  }

  //! @brief Variable Blend Packed DP-FP Values (SSE4.1).
  public final void blendvpd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_BLENDVPD, dst, src);
  }
  //! @brief Variable Blend Packed DP-FP Values (SSE4.1).
  public final void blendvpd(XMMRegister dst, Mem src)
  {
    emitX86(INST_BLENDVPD, dst, src);
  }

  //! @brief Variable Blend Packed SP-FP Values (SSE4.1).
  public final void blendvps(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_BLENDVPS, dst, src);
  }
  //! @brief Variable Blend Packed SP-FP Values (SSE4.1).
  public final void blendvps(XMMRegister dst, Mem src)
  {
    emitX86(INST_BLENDVPS, dst, src);
  }

  //! @brief Dot Product of Packed DP-FP Values (SSE4.1).
  public final void dppd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_DPPD, dst, src, imm8);
  }
  //! @brief Dot Product of Packed DP-FP Values (SSE4.1).
  public final void dppd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_DPPD, dst, src, imm8);
  }

  //! @brief Dot Product of Packed SP-FP Values (SSE4.1).
  public final void dpps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_DPPS, dst, src, imm8);
  }
  //! @brief Dot Product of Packed SP-FP Values (SSE4.1).
  public final void dpps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_DPPS, dst, src, imm8);
  }

  //! @brief Extract Packed SP-FP Value @brief (SSE4.1).
  public final void extractps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_EXTRACTPS, dst, src, imm8);
  }
  //! @brief Extract Packed SP-FP Value @brief (SSE4.1).
  public final void extractps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_EXTRACTPS, dst, src, imm8);
  }

  //! @brief Load Double Quadword Non-Temporal Aligned Hint (SSE4.1).
  public final void movntdqa(XMMRegister dst, Mem src)
  {
    emitX86(INST_MOVNTDQA, dst, src);
  }

  //! @brief Compute Multiple Packed Sums of Absolute Difference (SSE4.1).
  public final void mpsadbw(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_MPSADBW, dst, src, imm8);
  }
  //! @brief Compute Multiple Packed Sums of Absolute Difference (SSE4.1).
  public final void mpsadbw(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_MPSADBW, dst, src, imm8);
  }

  //! @brief Pack with Unsigned Saturation (SSE4.1).
  public final void packusdw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PACKUSDW, dst, src);
  }
  //! @brief Pack with Unsigned Saturation (SSE4.1).
  public final void packusdw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PACKUSDW, dst, src);
  }

  //! @brief Variable Blend Packed Bytes (SSE4.1).
  public final void pblendvb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PBLENDVB, dst, src);
  }
  //! @brief Variable Blend Packed Bytes (SSE4.1).
  public final void pblendvb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PBLENDVB, dst, src);
  }

  //! @brief Blend Packed Words (SSE4.1).
  public final void pblendw(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PBLENDW, dst, src, imm8);
  }
  //! @brief Blend Packed Words (SSE4.1).
  public final void pblendw(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PBLENDW, dst, src, imm8);
  }

  //! @brief Compare Packed Qword Data for Equal (SSE4.1).
  public final void pcmpeqq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPEQQ, dst, src);
  }
  //! @brief Compare Packed Qword Data for Equal (SSE4.1).
  public final void pcmpeqq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPEQQ, dst, src);
  }

  //! @brief Extract Byte (SSE4.1).
  public final void pextrb(Register dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRB, dst, src, imm8);
  }
  //! @brief Extract Byte (SSE4.1).
  public final void pextrb(Mem dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRB, dst, src, imm8);
  }

  //! @brief Extract Dword (SSE4.1).
  public final void pextrd(Register dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRD, dst, src, imm8);
  }
  //! @brief Extract Dword (SSE4.1).
  public final void pextrd(Mem dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRD, dst, src, imm8);
  }

  //! @brief Extract Dword (SSE4.1).
  public final void pextrq(Register dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRQ, dst, src, imm8);
  }
  //! @brief Extract Dword (SSE4.1).
  public final void pextrq(Mem dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRQ, dst, src, imm8);
  }

  //! @brief Extract Word (SSE4.1).
  public final void pextrw(Register dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRW, dst, src, imm8);
  }
  //! @brief Extract Word (SSE4.1).
  public final void pextrw(Mem dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PEXTRW, dst, src, imm8);
  }

  //! @brief Packed Horizontal Word Minimum (SSE4.1).
  public final void phminposuw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PHMINPOSUW, dst, src);
  }
  //! @brief Packed Horizontal Word Minimum (SSE4.1).
  public final void phminposuw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PHMINPOSUW, dst, src);
  }

  //! @brief Insert Byte (SSE4.1).
  public final void pinsrb(XMMRegister dst, Register src, Immediate imm8)
  {
    emitX86(INST_PINSRB, dst, src, imm8);
  }
  //! @brief Insert Byte (SSE4.1).
  public final void pinsrb(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PINSRB, dst, src, imm8);
  }

  //! @brief Insert Dword (SSE4.1).
  public final void pinsrd(XMMRegister dst, Register src, Immediate imm8)
  {
    emitX86(INST_PINSRD, dst, src, imm8);
  }
  //! @brief Insert Dword (SSE4.1).
  public final void pinsrd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PINSRD, dst, src, imm8);
  }

  //! @brief Insert Dword (SSE4.1).
  public final void pinsrq(XMMRegister dst, Register src, Immediate imm8)
  {
    emitX86(INST_PINSRQ, dst, src, imm8);
  }
  //! @brief Insert Dword (SSE4.1).
  public final void pinsrq(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PINSRQ, dst, src, imm8);
  }

  //! @brief Insert Word (SSE2).
  public final void pinsrw(XMMRegister dst, Register src, Immediate imm8)
  {
    emitX86(INST_PINSRW, dst, src, imm8);
  }
  //! @brief Insert Word (SSE2).
  public final void pinsrw(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PINSRW, dst, src, imm8);
  }

  //! @brief Maximum of Packed Word Integers (SSE4.1).
  public final void pmaxuw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXUW, dst, src);
  }
  //! @brief Maximum of Packed Word Integers (SSE4.1).
  public final void pmaxuw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXUW, dst, src);
  }

  //! @brief Maximum of Packed Signed Byte Integers (SSE4.1).
  public final void pmaxsb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXSB, dst, src);
  }
  //! @brief Maximum of Packed Signed Byte Integers (SSE4.1).
  public final void pmaxsb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXSB, dst, src);
  }

  //! @brief Maximum of Packed Signed Dword Integers (SSE4.1).
  public final void pmaxsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXSD, dst, src);
  }
  //! @brief Maximum of Packed Signed Dword Integers (SSE4.1).
  public final void pmaxsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXSD, dst, src);
  }

  //! @brief Maximum of Packed Unsigned Dword Integers (SSE4.1).
  public final void pmaxud(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMAXUD, dst, src);
  }
  //! @brief Maximum of Packed Unsigned Dword Integers (SSE4.1).
  public final void pmaxud(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMAXUD, dst, src);
  }

  //! @brief Minimum of Packed Signed Byte Integers (SSE4.1).
  public final void pminsb(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINSB, dst, src);
  }
  //! @brief Minimum of Packed Signed Byte Integers (SSE4.1).
  public final void pminsb(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINSB, dst, src);
  }

  //! @brief Minimum of Packed Word Integers (SSE4.1).
  public final void pminuw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINUW, dst, src);
  }
  //! @brief Minimum of Packed Word Integers (SSE4.1).
  public final void pminuw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINUW, dst, src);
  }

  //! @brief Minimum of Packed Dword Integers (SSE4.1).
  public final void pminud(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINUD, dst, src);
  }
  //! @brief Minimum of Packed Dword Integers (SSE4.1).
  public final void pminud(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINUD, dst, src);
  }

  //! @brief Minimum of Packed Dword Integers (SSE4.1).
  public final void pminsd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMINSD, dst, src);
  }
  //! @brief Minimum of Packed Dword Integers (SSE4.1).
  public final void pminsd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMINSD, dst, src);
  }

  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXBW, dst, src);
  }
  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXBW, dst, src);
  }

  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXBD, dst, src);
  }
  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXBD, dst, src);
  }

  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXBQ, dst, src);
  }
  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxbq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXBQ, dst, src);
  }

  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxwd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXWD, dst, src);
  }
  //! @brief Packed Move with Sign Extend (SSE4.1).
  public final void pmovsxwd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXWD, dst, src);
  }

  //! @brief (SSE4.1).
  public final void pmovsxwq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXWQ, dst, src);
  }
  //! @brief (SSE4.1).
  public final void pmovsxwq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXWQ, dst, src);
  }

  //! @brief (SSE4.1).
  public final void pmovsxdq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVSXDQ, dst, src);
  }
  //! @brief (SSE4.1).
  public final void pmovsxdq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVSXDQ, dst, src);
  }

  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbw(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXBW, dst, src);
  }
  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbw(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXBW, dst, src);
  }

  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXBD, dst, src);
  }
  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXBD, dst, src);
  }

  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXBQ, dst, src);
  }
  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxbq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXBQ, dst, src);
  }

  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxwd(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXWD, dst, src);
  }
  //! @brief Packed Move with Zero Extend (SSE4.1).
  public final void pmovzxwd(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXWD, dst, src);
  }

  //! @brief (SSE4.1).
  public final void pmovzxwq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXWQ, dst, src);
  }
  //! @brief (SSE4.1).
  public final void pmovzxwq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXWQ, dst, src);
  }

  //! @brief (SSE4.1).
  public final void pmovzxdq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMOVZXDQ, dst, src);
  }
  //! @brief (SSE4.1).
  public final void pmovzxdq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMOVZXDQ, dst, src);
  }

  //! @brief Multiply Packed Signed Dword Integers (SSE4.1).
  public final void pmuldq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULDQ, dst, src);
  }
  //! @brief Multiply Packed Signed Dword Integers (SSE4.1).
  public final void pmuldq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULDQ, dst, src);
  }

  //! @brief Multiply Packed Signed Integers and Store Low Result (SSE4.1).
  public final void pmulld(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PMULLD, dst, src);
  }
  //! @brief Multiply Packed Signed Integers and Store Low Result (SSE4.1).
  public final void pmulld(XMMRegister dst, Mem src)
  {
    emitX86(INST_PMULLD, dst, src);
  }

  //! @brief Logical Compare (SSE4.1).
  public final void ptest(XMMRegister op1, XMMRegister op2)
  {
    emitX86(INST_PTEST, op1, op2);
  }
  //! @brief Logical Compare (SSE4.1).
  public final void ptest(XMMRegister op1, Mem op2)
  {
    emitX86(INST_PTEST, op1, op2);
  }

  //! Round Packed SP-FP Values @brief (SSE4.1).
  public final void roundps(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_ROUNDPS, dst, src, imm8);
  }
  //! Round Packed SP-FP Values @brief (SSE4.1).
  public final void roundps(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_ROUNDPS, dst, src, imm8);
  }

  //! @brief Round Scalar SP-FP Values (SSE4.1).
  public final void roundss(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_ROUNDSS, dst, src, imm8);
  }
  //! @brief Round Scalar SP-FP Values (SSE4.1).
  public final void roundss(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_ROUNDSS, dst, src, imm8);
  }

  //! @brief Round Packed DP-FP Values (SSE4.1).
  public final void roundpd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_ROUNDPD, dst, src, imm8);
  }
  //! @brief Round Packed DP-FP Values (SSE4.1).
  public final void roundpd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_ROUNDPD, dst, src, imm8);
  }

  //! @brief Round Scalar DP-FP Values (SSE4.1).
  public final void roundsd(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_ROUNDSD, dst, src, imm8);
  }
  //! @brief Round Scalar DP-FP Values (SSE4.1).
  public final void roundsd(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_ROUNDSD, dst, src, imm8);
  }

  // -------------------------------------------------------------------------
  // [SSE4.2]
  // -------------------------------------------------------------------------

  //! @brief Accumulate CRC32 Value (polynomial 0x11EDC6F41) (SSE4.2).
  public final void crc32(Register dst, Register src)
  {
    assert(dst.isRegType(REG_GPD) || dst.isRegType(REG_GPQ));
    emitX86(INST_CRC32, dst, src);
  }
  //! @brief Accumulate CRC32 Value (polynomial 0x11EDC6F41) (SSE4.2).
  public final void crc32(Register dst, Mem src)
  {
    assert(dst.isRegType(REG_GPD) || dst.isRegType(REG_GPQ));
    emitX86(INST_CRC32, dst, src);
  }

  //! @brief Packed Compare Explicit Length Strings, Return Index (SSE4.2).
  public final void pcmpestri(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PCMPESTRI, dst, src, imm8);
  }
  //! @brief Packed Compare Explicit Length Strings, Return Index (SSE4.2).
  public final void pcmpestri(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PCMPESTRI, dst, src, imm8);
  }

  //! @brief Packed Compare Explicit Length Strings, Return Mask (SSE4.2).
  public final void pcmpestrm(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PCMPESTRM, dst, src, imm8);
  }
  //! @brief Packed Compare Explicit Length Strings, Return Mask (SSE4.2).
  public final void pcmpestrm(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PCMPESTRM, dst, src, imm8);
  }

  //! @brief Packed Compare Implicit Length Strings, Return Index (SSE4.2).
  public final void pcmpistri(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PCMPISTRI, dst, src, imm8);
  }
  //! @brief Packed Compare Implicit Length Strings, Return Index (SSE4.2).
  public final void pcmpistri(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PCMPISTRI, dst, src, imm8);
  }

  //! @brief Packed Compare Implicit Length Strings, Return Mask (SSE4.2).
  public final void pcmpistrm(XMMRegister dst, XMMRegister src, Immediate imm8)
  {
    emitX86(INST_PCMPISTRM, dst, src, imm8);
  }
  //! @brief Packed Compare Implicit Length Strings, Return Mask (SSE4.2).
  public final void pcmpistrm(XMMRegister dst, Mem src, Immediate imm8)
  {
    emitX86(INST_PCMPISTRM, dst, src, imm8);
  }

  //! @brief Compare Packed Data for Greater Than (SSE4.2).
  public final void pcmpgtq(XMMRegister dst, XMMRegister src)
  {
    emitX86(INST_PCMPGTQ, dst, src);
  }
  //! @brief Compare Packed Data for Greater Than (SSE4.2).
  public final void pcmpgtq(XMMRegister dst, Mem src)
  {
    emitX86(INST_PCMPGTQ, dst, src);
  }

  //! @brief Return the Count of Number of Bits Set to 1 (SSE4.2).
  public final void popcnt(Register dst, Register src)
  {
    assert(!dst.isRegType(REG_GPB));
    assert(src.type() == dst.type());
    emitX86(INST_POPCNT, dst, src);
  }
  //! @brief Return the Count of Number of Bits Set to 1 (SSE4.2).
  public final void popcnt(Register dst, Mem src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_POPCNT, dst, src);
  }

  // -------------------------------------------------------------------------
  // [AMD only]
  // -------------------------------------------------------------------------

  //! @brief Prefetch (3dNow - Amd).
  //!
  //! Loads the entire 64-byte aligned memory sequence containing the
  //! specified memory address into the L1 data cache. The position of
  //! the specified memory address within the 64-byte cache line is
  //! irrelevant. If a cache hit occurs, or if a memory fault is detected,
  //! no bus cycle is initiated and the instruction is treated as a NOP.
  public final void amd_prefetch(Mem mem)
  {
    emitX86(INST_AMD_PREFETCH, mem);
  }

  //! @brief Prefetch and set cache to modified (3dNow - Amd).
  //!
  //! The PREFETCHW instruction loads the prefetched line and sets the
  //! cache-line state to Modified, in anticipation of subsequent data
  //! writes to the line. The PREFETCH instruction, by contrast, typically
  //! sets the cache-line state to Exclusive (depending on the hardware
  //! implementation).
  public final void amd_prefetchw(Mem mem)
  {
    emitX86(INST_AMD_PREFETCHW, mem);
  }

  // -------------------------------------------------------------------------
  // [Intel only]
  // -------------------------------------------------------------------------

  //! @brief Move Data After Swapping Bytes (SSE3 - Intel Atom).
  public final void movbe(Register dst, Mem src)
  {
    assert(!dst.isRegType(REG_GPB));
    emitX86(INST_MOVBE, dst, src);
  }

  //! @brief Move Data After Swapping Bytes (SSE3 - Intel Atom).
  public final void movbe(Mem dst, Register src)
  {
    assert(!src.isRegType(REG_GPB));
    emitX86(INST_MOVBE, dst, src);
  }
}
