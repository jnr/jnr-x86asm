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


public enum InstructionGroup {
    I_EMIT,

    I_ALU,
    I_BSWAP,
    I_BT,
    I_CALL,
    I_CRC32,
    I_ENTER,
    I_IMUL,
    I_INC_DEC,
    I_J,
    I_JMP,
    I_LEA,
    I_M,
    I_MOV,
    I_MOV_PTR,
    I_MOVSX_MOVZX,
    I_MOVSXD,
    I_PUSH, // I_PUSH is implemented before I_POP
    I_POP,
    I_R_RM,
    I_RM_B,
    I_RM,
    I_RM_R,
    I_RET,
    I_ROT,
    I_SHLD_SHRD,
    I_TEST,
    I_XCHG,

    // Group for x87 FP instructions in format mem or st(i), st(i) (fadd, fsub, fdiv, ...)
    I_X87_FPU,
    // Group for x87 FP instructions in format st(i), st(i)
    I_X87_STI,
    // Group for fld/fst/fstp instruction, internally uses I_X87_MEM group.
    I_X87_MEM_STI,
    // Group for x87 FP instructions that uses Word, DWord, QWord or TWord memory pointer.
    I_X87_MEM,
    // Group for x87 FSTSW/FNSTSW instructions
    I_X87_FSTSW,

    // Group for movbe instruction
    I_MOVBE,

    // Group for MMX/SSE instructions in format (X)MM|Reg|Mem <- (X)MM|Reg|Mem,
    // 0x66 prefix must be set manually in opcodes.
    // - Primary opcode is used for instructions in (X)MM <- (X)MM/Mem format,
    // - Secondary opcode is used for instructions in (X)MM/Mem <- (X)MM format.
    I_MMU_MOV,

    // Group for movd and movq instructions.
    I_MMU_MOVD,
    I_MMU_MOVQ,

    // Group for pextrd, pextrq and pextrw instructions (it's special instruction
    // not similar to others)
    I_MMU_PEXTR,

    // Group for prefetch instruction
    I_MMU_PREFETCH,

    // Group for MMX/SSE instructions in format (X)MM|Reg <- (X)MM|Reg|Mem|Imm,
    // 0x66 prefix is added for MMX instructions that used by SSE2 registers.
    // - Primary opcode is used for instructions in (X)MM|Reg <- (X)MM|Reg|Mem format,
    // - Secondary opcode is iused for instructions in (X)MM|Reg <- Imm format.
    I_MMU_RMI,
    I_MMU_RM_IMM8,

    // Group for 3dNow instructions
    I_MMU_RM_3DNOW;
}
