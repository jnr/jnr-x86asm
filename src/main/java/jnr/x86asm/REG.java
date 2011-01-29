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

public class REG {
    private REG() {}
    //! @brief Mask for register type.
    public static final int REGTYPE_MASK = 0xF0,
        //! @brief Mask for register code (index).
        REGCODE_MASK = 0x0F,

        // First nibble contains register type (mask 0xF0), Second nibble contains
        // register index code.

        // [8 bit, 16 bit and 32 bit general purpose registers]

        //! @brief 8 bit general purpose register type.
        REG_GPB = 0x00,
        //! @brief 16 bit general purpose register type.
        REG_GPW = 0x10,
        //! @brief 32 bit general purpose register type.
        REG_GPD = 0x20,

        // [64 bit registers (RAX, RBX, ...), not available in 32 bit mode]

        //! @brief 64 bit general purpose register type.
        REG_GPQ = 0x30,

        //! @var REG_GPN
        //! @brief 32 bit or 64 bit general purpose register type.

        // native 32 bit or 64 bit registers
        //#if defined(ASMJIT_X86)
        //  REG_GPN = REG_GPD,
        //#else
        //  REG_GPN = REG_GPQ,
        //#endif

        //! @brief X87 (FPU) register type.
        REG_X87 = 0x50,

        //! @brief 64 bit mmx register type.
        REG_MM = 0x60,

        //! @brief 128 bit sse register type.
        REG_XMM = 0x70,

        // 8/16 bit registers
        REG_AL = REG_GPB + 0,
        REG_CL = REG_GPB + 1,
        REG_DL = REG_GPB + 2,
        REG_BL = REG_GPB + 3,
        REG_AH = REG_GPB + 4,
        REG_CH = REG_GPB + 5,
        REG_DH = REG_GPB + 6,
        REG_BH = REG_GPB + 7,

        REG_R8B = REG_GPB + 8,
        REG_R9B = REG_GPB + 9,
        REG_R10B = REG_GPB + 10,
        REG_R11B = REG_GPB + 11,
        REG_R12B = REG_GPB + 12,
        REG_R13B = REG_GPB + 13,
        REG_R14B = REG_GPB + 14,
        REG_R15B = REG_GPB + 15,

        REG_AX = REG_GPW + 0,
        REG_CX = REG_GPW + 1,
        REG_DX = REG_GPW + 2,
        REG_BX = REG_GPW + 3,
        REG_SP = REG_GPW + 4,
        REG_BP = REG_GPW + 5,
        REG_SI = REG_GPW + 6,
        REG_DI = REG_GPW + 7,
        REG_R8W = REG_GPW + 8,
        REG_R9W = REG_GPW + 9,
        REG_R10W = REG_GPW + 10,
        REG_R11W = REG_GPW + 11,
        REG_R12W = REG_GPW + 12,
        REG_R13W = REG_GPW + 13,
        REG_R14W = REG_GPW + 14,
        REG_R15W = REG_GPW + 15,


        // 32 bit registers
        REG_EAX = REG_GPD + 0,
        REG_ECX = REG_GPD + 1,
        REG_EDX = REG_GPD + 2,
        REG_EBX = REG_GPD + 3,
        REG_ESP = REG_GPD + 4,
        REG_EBP = REG_GPD + 5,
        REG_ESI = REG_GPD + 6,
        REG_EDI = REG_GPD + 7,

        REG_R8D = REG_GPD + 8,
        REG_R9D = REG_GPD + 9,
        REG_R10D = REG_GPD + 10,
        REG_R11D = REG_GPD + 11,
        REG_R12D = REG_GPD + 12,
        REG_R13D = REG_GPD + 13,
        REG_R14D = REG_GPD + 14,
        REG_R15D = REG_GPD + 15,


        // 64 bit registers
        REG_RAX = REG_GPQ + 0,
        REG_RCX = REG_GPQ + 1,
        REG_RDX = REG_GPQ + 2,
        REG_RBX = REG_GPQ + 3,
        REG_RSP = REG_GPQ + 4,
        REG_RBP = REG_GPQ + 5,
        REG_RSI = REG_GPQ + 6,
        REG_RDI = REG_GPQ + 7,
        REG_R8 = REG_GPQ + 8,
        REG_R9 = REG_GPQ + 9,
        REG_R10 = REG_GPQ + 10,
        REG_R11 = REG_GPQ + 11,
        REG_R12 = REG_GPQ + 12,
        REG_R13 = REG_GPQ + 13,
        REG_R14 = REG_GPQ + 14,
        REG_R15 = REG_GPQ + 15,


        // MMX registers
        REG_MM0 = REG_MM + 0,
        REG_MM1 = REG_MM + 1,
        REG_MM2 = REG_MM + 2,
        REG_MM3 = REG_MM + 3,
        REG_MM4 = REG_MM + 4,
        REG_MM5 = REG_MM + 5,
        REG_MM6 = REG_MM + 6,
        REG_MM7 = REG_MM + 7,

        // SSE registers
        REG_XMM0 = REG_XMM + 0,
        REG_XMM1 = REG_XMM + 1,
        REG_XMM2 = REG_XMM + 2,
        REG_XMM3 = REG_XMM + 3,
        REG_XMM4 = REG_XMM + 4,
        REG_XMM5 = REG_XMM + 5,
        REG_XMM6 = REG_XMM + 6,
        REG_XMM7 = REG_XMM + 7,
        REG_XMM8 = REG_XMM + 8,
        REG_XMM9 = REG_XMM + 9,
        REG_XMM10 = REG_XMM + 10,
        REG_XMM11 = REG_XMM + 11,
        REG_XMM12 = REG_XMM + 12,
        REG_XMM13 = REG_XMM + 13,
        REG_XMM14 = REG_XMM + 14,
        REG_XMM15 = REG_XMM + 15,

        // native registers (depends if processor runs in 32 bit or 64 bit mode)
        //#if defined(ASMJIT_X86)
        //  REG_NAX  = REG_GPD , REG_NCX  , REG_NDX  , REG_NBX  , REG_NSP  , REG_NBP  , REG_NSI  , REG_NDI  ,
        //#else
        //  REG_NAX  = REG_GPQ , REG_NCX  , REG_NDX  , REG_NBX  , REG_NSP  , REG_NBP  , REG_NSI  , REG_NDI  ,
        //#endif

        //! @brief Invalid register code.
        NO_REG = 0xFF;
}
