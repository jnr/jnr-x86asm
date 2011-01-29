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
import static jnr.x86asm.SIZE.*;

public final class Asm {
    private Asm() {}

    /** @deprecated Use {@link #X86_32} */
    @Deprecated
    public static final CPU I386 = CPU.I386;
    public static final CPU X86_32 = CPU.X86_32;
    public static final CPU X86_64 = CPU.X86_64;
    
    /** No register, can be used only in @c Mem operand. */
    public static final Register no_reg = new Register(NO_REG, 0);

    /** 8 bit General purpose register. */
    public static final Register al = Register.gpr(REG_AL);
    /** 8 bit General purpose register. */
    public static final Register cl = Register.gpr(REG_CL);
    /** 8 bit General purpose register. */
    public static final Register dl = Register.gpr(REG_DL);
    /** 8 bit General purpose register. */
    public static final Register bl = Register.gpr(REG_BL);
    /** 8 bit General purpose register. */
    public static final Register ah = Register.gpr(REG_AH);
    /** 8 bit General purpose register. */
    public static final Register ch = Register.gpr(REG_CH);
    /** 8 bit General purpose register. */
    public static final Register dh = Register.gpr(REG_DH);
    /** 8 bit General purpose register. */
    public static final Register bh = Register.gpr(REG_BH);

    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r8b = Register.gpr(REG_R8B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r9b = Register.gpr(REG_R9B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r10b = Register.gpr(REG_R10B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r11b = Register.gpr(REG_R11B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r12b = Register.gpr(REG_R12B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r13b = Register.gpr(REG_R13B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r14b = Register.gpr(REG_R14B);
    /** 8 bit General purpose register (64 bit mode only). */
    public static final Register r15b = Register.gpr(REG_R15B);

    /** 16 bit General purpose register. */
    public static final Register ax = Register.gpr(REG_AX);
    /** 16 bit General purpose register. */
    public static final Register cx = Register.gpr(REG_CX);
    /** 16 bit General purpose register. */
    public static final Register dx = Register.gpr(REG_DX);
    /** 16 bit General purpose register. */
    public static final Register bx = Register.gpr(REG_BX);
    /** 16 bit General purpose register. */
    public static final Register sp = Register.gpr(REG_SP);
    /** 16 bit General purpose register. */
    public static final Register bp = Register.gpr(REG_BP);
    /** 16 bit General purpose register. */
    public static final Register si = Register.gpr(REG_SI);
    /** 16 bit General purpose register. */
    public static final Register di = Register.gpr(REG_DI);

    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r8w = Register.gpr(REG_R8W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r9w = Register.gpr(REG_R9W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r10w = Register.gpr(REG_R10W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r11w = Register.gpr(REG_R11W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r12w = Register.gpr(REG_R12W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r13w = Register.gpr(REG_R13W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r14w = Register.gpr(REG_R14W);
    /** 16 bit General purpose register (64 bit mode only). */
    public static final Register r15w = Register.gpr(REG_R15W);

    /** 32 bit General purpose register. */
    public static final Register eax = Register.gpr(REG_EAX);
    /** 32 bit General purpose register. */
    public static final Register ecx = Register.gpr(REG_ECX);
    /** 32 bit General purpose register. */
    public static final Register edx = Register.gpr(REG_EDX);
    /** 32 bit General purpose register. */
    public static final Register ebx = Register.gpr(REG_EBX);
    /** 32 bit General purpose register. */
    public static final Register esp = Register.gpr(REG_ESP);
    /** 32 bit General purpose register. */
    public static final Register ebp = Register.gpr(REG_EBP);
    /** 32 bit General purpose register. */
    public static final Register esi = Register.gpr(REG_ESI);
    /** 32 bit General purpose register. */
    public static final Register edi = Register.gpr(REG_EDI);

    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rax = Register.gpr(REG_RAX);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rcx = Register.gpr(REG_RCX);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rdx = Register.gpr(REG_RDX);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rbx = Register.gpr(REG_RBX);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rsp = Register.gpr(REG_RSP);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rbp = Register.gpr(REG_RBP);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rsi = Register.gpr(REG_RSI);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register rdi = Register.gpr(REG_RDI);

    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r8 = Register.gpr(REG_R8);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r9 = Register.gpr(REG_R9);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r10 = Register.gpr(REG_R10);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r11 = Register.gpr(REG_R11);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r12 = Register.gpr(REG_R12);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r13 = Register.gpr(REG_R13);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r14 = Register.gpr(REG_R14);
    /** 64 bit General purpose register (64 bit mode only). */
    public static final Register r15 = Register.gpr(REG_R15);

    /** 64 bit MMX register. */
    public static final MMRegister mm0 = MMRegister.mm(0);
    /** 64 bit MMX register. */
    public static final MMRegister mm1 = MMRegister.mm(1);
    /** 64 bit MMX register. */
    public static final MMRegister mm2 = MMRegister.mm(2);
    /** 64 bit MMX register. */
    public static final MMRegister mm3 = MMRegister.mm(3);
    /** 64 bit MMX register. */
    public static final MMRegister mm4 = MMRegister.mm(4);
    /** 64 bit MMX register. */
    public static final MMRegister mm5 = MMRegister.mm(5);
    /** 64 bit MMX register. */
    public static final MMRegister mm6 = MMRegister.mm(6);
    /** 64 bit MMX register. */
    public static final MMRegister mm7 = MMRegister.mm(7);

    /** 128 bit SSE register. */
    public static final XMMRegister xmm0 = XMMRegister.xmm(0);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm1 = XMMRegister.xmm(1);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm2 = XMMRegister.xmm(2);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm3 = XMMRegister.xmm(3);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm4 = XMMRegister.xmm(4);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm5 = XMMRegister.xmm(5);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm6 = XMMRegister.xmm(6);
    /** 128 bit SSE register. */
    public static final XMMRegister xmm7 = XMMRegister.xmm(7);


    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm8 = XMMRegister.xmm(8);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm9 = XMMRegister.xmm(9);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm10 = XMMRegister.xmm(10);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm11 = XMMRegister.xmm(11);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm12 = XMMRegister.xmm(12);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm13 = XMMRegister.xmm(13);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm14 = XMMRegister.xmm(14);
    /** 128 bit SSE register (64 bit mode only). */
    public static final XMMRegister xmm15 = XMMRegister.xmm(15);

    static final Mem _ptr_build(Label label, long disp, int ptrSize) {
        return new Mem(label, disp, ptrSize);
    }

    static final Mem _ptr_build(Label label, Register index, int shift, long disp, int ptrSize) {
        return new Mem(label, index, shift, disp, ptrSize);
    }

    /** Absolute addressing */
    static final Mem _ptr_build_abs(long target, long disp, SEGMENT segmentPrefix, int ptrSize) {
        return new Mem(target, disp, segmentPrefix, ptrSize);
    }

    static final Mem _ptr_build_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix, int ptrSize) {
        return new Mem(target, index, shift, segmentPrefix, disp, ptrSize);
    }

    static final Mem _ptr_build(Register base, long disp, int ptrSize) {
      return new Mem(base, disp, ptrSize);
    }

    static final Mem _ptr_build(Register base, Register index, int shift, long disp, int ptrSize) {
      return new Mem(base, index, shift, disp, ptrSize);
    }


    // ============================================================================
    // [AsmJit::Mem - ptr[displacement]]
    // ============================================================================

    /** Create pointer operand with not specified size. */
    public static final Mem ptr(Label label, long disp) {
        return _ptr_build(label, disp, 0);
    }

    /** Create pointer operand with not specified size. */
    public static final Mem ptr(Label label) {
        return _ptr_build(label, 0, 0);
    }

    /**Create byte pointer operand. */
    public static final Mem byte_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_BYTE);
    }

    /**Create byte pointer operand. */
    public static final Mem byte_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_WORD);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_DWORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_QWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_TWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_DQWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_DQWORD);
    }

    /**
     * Create mmword (8 bytes) pointer operand
     *
     * <b>Note:</b>This constructor is provided only for convenience for mmx programming.
     */
    public static final Mem mmword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_QWORD);
    }

    /**
     * Create mmword (8 bytes) pointer operand
     *
     * <b>Note:</b>This constructor is provided only for convenience for mmx programming.
     */
    public static final Mem mmword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_QWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr(Label label, long disp) {
        return _ptr_build(label, disp, SIZE_DQWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr(Label label) {
        return _ptr_build(label, 0, SIZE_DQWORD);
    }

    /** Create pointer operand with not specified size. */
    public static final Mem ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, 0);
    }

    /** Create byte pointer operand. */
    public static final Mem byte_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_DQWORD);
    }

    /** Create mmword (8 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for mmx programming. */
    public static final Mem mmword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_QWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr(Label label, Register index, int shift, long disp) {
        return _ptr_build(label, index, shift, disp, SIZE_DQWORD);
    }

    /** Create pointer operand with not specified size. */
    public static final Mem ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, 0);
    }

    /** Create byte pointer operand. */
    public static final Mem byte_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_DQWORD);
    }

    /** Create mmword (8 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for mmx programming. */
    public static final Mem mmword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_QWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr_abs(long target, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, disp, segmentPrefix, SIZE_DQWORD);
    }

    /** Create pointer operand with not specified size. */
    public static final Mem ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, 0);
    }

    /** Create byte pointer operand. */
    public static final Mem byte_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_DQWORD);
    }

    /** Create mmword (8 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for mmx programming. */
    public static final Mem mmword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_QWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr_abs(long target, Register index, int shift, long disp, SEGMENT segmentPrefix) {
        return _ptr_build_abs(target, index, shift, disp, segmentPrefix, SIZE_DQWORD);
    }

// ============================================================================
// [AsmJit::Mem - ptr[base + displacement]]
// ============================================================================
    /** Create pointer operand with not specified size. */
    public static final Mem ptr(Register base, long disp) {
        return _ptr_build(base, disp, 0);
    }

    /** Create byte pointer operand. */
    public static final Mem byte_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_DQWORD);
    }

    /** Create mmword (8 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for mmx programming. */
    public static final Mem mmword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_QWORD);
    }

    /** Create xmmword (16 bytes) pointer operand
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr(Register base, long disp) {
        return _ptr_build(base, disp, SIZE_DQWORD);
    }

    // ============================================================================
    // [AsmJit::Mem - ptr[base + (index << shift) + displacement]]
    // ============================================================================
    
    /** Create pointer operand with not specified size. */
    public static final Mem ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, 0);
    }

    /** Create byte pointer operand. */
    public static final Mem byte_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_BYTE);
    }

    /** Create word (2 Bytes) pointer operand. */
    public static final Mem word_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_WORD);
    }

    /** Create dword (4 Bytes) pointer operand. */
    public static final Mem dword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_DWORD);
    }

    /** Create qword (8 Bytes) pointer operand. */
    public static final Mem qword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_QWORD);
    }

    /** Create tword (10 Bytes) pointer operand (used for 80 bit floating points). */
    public static final Mem tword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_TWORD);
    }

    /** Create dqword (16 Bytes) pointer operand. */
    public static final Mem dqword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_DQWORD);
    }

    /** Create mmword (8 Bytes) pointer operand).
    //!
    //! @note This constructor is provided only for convenience for mmx programming. */
    public static final Mem mmword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_QWORD);
    }

    /** Create xmmword (16 Bytes) pointer operand.
    //!
    //! @note This constructor is provided only for convenience for sse programming. */
    public static final Mem xmmword_ptr(Register base, Register index, int shift, long disp) {
        return _ptr_build(base, index, shift, disp, SIZE_DQWORD);
    }

     public static final Immediate imm(long value) {
        return Immediate.imm(value);
    }

    public static final Immediate uimm(long value) {
        return Immediate.imm(value);
    }
}
