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


public enum INST_CODE {
    INST_ADC,           // X86/X64
    INST_ADD,           // X86/X64
    INST_ADDPD,
    INST_ADDPS,
    INST_ADDSD,
    INST_ADDSS,
    INST_ADDSUBPD,
    INST_ADDSUBPS,
    INST_AMD_PREFETCH,
    INST_AMD_PREFETCHW,
    INST_AND,           // X86/X64
    INST_ANDNPD,
    INST_ANDNPS,
    INST_ANDPD,
    INST_ANDPS,
    INST_BLENDPD,
    INST_BLENDPS,
    INST_BLENDVPD,
    INST_BLENDVPS,
    INST_BSF,           // X86/X64
    INST_BSR,           // X86/X64
    INST_BSWAP,         // X86/X64 (i486)
    INST_BT,            // X86/X64
    INST_BTC,           // X86/X64
    INST_BTR,           // X86/X64
    INST_BTS,           // X86/X64
    INST_CALL,          // X86/X64
    INST_CBW,           // X86/X64
    INST_CDQE,          // X64 only
    INST_CLC,           // X86/X64
    INST_CLD,           // X86/X64
    INST_CLFLUSH,
    INST_CMC,           // X86/X64

    INST_CMOVA,         //X86/X64 (cmovcc) (i586)
    INST_CMOVAE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVB,         // X86/X64 (cmovcc) (i586)
    INST_CMOVBE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVC,         // X86/X64 (cmovcc) (i586)
    INST_CMOVE,         // X86/X64 (cmovcc) (i586)
    INST_CMOVG,         // X86/X64 (cmovcc) (i586)
    INST_CMOVGE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVL,         // X86/X64 (cmovcc) (i586)
    INST_CMOVLE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNA,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNAE,       // X86/X64 (cmovcc) (i586)
    INST_CMOVNB,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNBE,       // X86/X64 (cmovcc) (i586)
    INST_CMOVNC,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNG,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNGE,       // X86/X64 (cmovcc) (i586)
    INST_CMOVNL,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNLE,       // X86/X64 (cmovcc) (i586)
    INST_CMOVNO,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNP,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNS,        // X86/X64 (cmovcc) (i586)
    INST_CMOVNZ,        // X86/X64 (cmovcc) (i586)
    INST_CMOVO,         // X86/X64 (cmovcc) (i586)
    INST_CMOVP,         // X86/X64 (cmovcc) (i586)
    INST_CMOVPE,        // X86/X64 (cmovcc) (i586)
    INST_CMOVPO,        // X86/X64 (cmovcc) (i586)
    INST_CMOVS,         // X86/X64 (cmovcc) (i586)
    INST_CMOVZ,         // X86/X64 (cmovcc) (i586)

    INST_CMP,           // X86/X64
    INST_CMPPD,
    INST_CMPPS,
    INST_CMPSD,
    INST_CMPSS,
    INST_CMPXCHG,       // X86/X64 (i486)
    INST_CMPXCHG16B,    // X64 only
    INST_CMPXCHG8B,     // X86/X64 (i586)
    INST_COMISD,
    INST_COMISS,
    INST_CPUID,         // X86/X64 (i486)
    INST_CRC32,
    INST_CVTDQ2PD,
    INST_CVTDQ2PS,
    INST_CVTPD2DQ,
    INST_CVTPD2PI,
    INST_CVTPD2PS,
    INST_CVTPI2PD,
    INST_CVTPI2PS,
    INST_CVTPS2DQ,
    INST_CVTPS2PD,
    INST_CVTPS2PI,
    INST_CVTSD2SI,
    INST_CVTSD2SS,
    INST_CVTSI2SD,
    INST_CVTSI2SS,
    INST_CVTSS2SD,
    INST_CVTSS2SI,
    INST_CVTTPD2DQ,
    INST_CVTTPD2PI,
    INST_CVTTPS2DQ,
    INST_CVTTPS2PI,
    INST_CVTTSD2SI,
    INST_CVTTSS2SI,
    INST_CWDE,          // X86/X64
    INST_DAA,           // X86 only
    INST_DAS,           // X86 only
    INST_DEC,           // X86/X64
    INST_DIV,           // X86/X64
    INST_DIVPD,
    INST_DIVPS,
    INST_DIVSD,
    INST_DIVSS,
    INST_DPPD,
    INST_DPPS,
    INST_EMMS,          // MMX
    INST_ENTER,         // X86/X64
    INST_EXTRACTPS,
    INST_F2XM1,         // X87
    INST_FABS,          // X87
    INST_FADD,          // X87
    INST_FADDP,         // X87
    INST_FBLD,          // X87
    INST_FBSTP,         // X87
    INST_FCHS,          // X87
    INST_FCLEX,         // X87
    INST_FCMOVB,        // X87
    INST_FCMOVBE,       // X87
    INST_FCMOVE,        // X87
    INST_FCMOVNB,       // X87
    INST_FCMOVNBE,      // X87
    INST_FCMOVNE,       // X87
    INST_FCMOVNU,       // X87
    INST_FCMOVU,        // X87
    INST_FCOM,          // X87
    INST_FCOMI,         // X87
    INST_FCOMIP,        // X87
    INST_FCOMP,         // X87
    INST_FCOMPP,        // X87
    INST_FCOS,          // X87
    INST_FDECSTP,       // X87
    INST_FDIV,          // X87
    INST_FDIVP,         // X87
    INST_FDIVR,         // X87
    INST_FDIVRP,        // X87
    INST_FEMMS,         // 3dNow!
    INST_FFREE,         // X87
    INST_FIADD,         // X87
    INST_FICOM,         // X87
    INST_FICOMP,        // X87
    INST_FIDIV,         // X87
    INST_FIDIVR,        // X87
    INST_FILD,          // X87
    INST_FIMUL,         // X87
    INST_FINCSTP,       // X87
    INST_FINIT,         // X87
    INST_FIST,          // X87
    INST_FISTP,         // X87
    INST_FISTTP,
    INST_FISUB,         // X87
    INST_FISUBR,        // X87
    INST_FLD,           // X87
    INST_FLD1,          // X87
    INST_FLDCW,         // X87
    INST_FLDENV,        // X87
    INST_FLDL2E,        // X87
    INST_FLDL2T,        // X87
    INST_FLDLG2,        // X87
    INST_FLDLN2,        // X87
    INST_FLDPI,         // X87
    INST_FLDZ,          // X87
    INST_FMUL,          // X87
    INST_FMULP,         // X87
    INST_FNCLEX,        // X87
    INST_FNINIT,        // X87
    INST_FNOP,          // X87
    INST_FNSAVE,        // X87
    INST_FNSTCW,        // X87
    INST_FNSTENV,       // X87
    INST_FNSTSW,        // X87
    INST_FPATAN,        // X87
    INST_FPREM,         // X87
    INST_FPREM1,        // X87
    INST_FPTAN,         // X87
    INST_FRNDINT,       // X87
    INST_FRSTOR,        // X87
    INST_FSAVE,         // X87
    INST_FSCALE,        // X87
    INST_FSIN,          // X87
    INST_FSINCOS,       // X87
    INST_FSQRT,         // X87
    INST_FST,           // X87
    INST_FSTCW,         // X87
    INST_FSTENV,        // X87
    INST_FSTP,          // X87
    INST_FSTSW,         // X87
    INST_FSUB,          // X87
    INST_FSUBP,         // X87
    INST_FSUBR,         // X87
    INST_FSUBRP,        // X87
    INST_FTST,          // X87
    INST_FUCOM,         // X87
    INST_FUCOMI,        // X87
    INST_FUCOMIP,       // X87
    INST_FUCOMP,        // X87
    INST_FUCOMPP,       // X87
    INST_FWAIT,         // X87
    INST_FXAM,          // X87
    INST_FXCH,          // X87
    INST_FXRSTOR,       // X87
    INST_FXSAVE,        // X87
    INST_FXTRACT,       // X87
    INST_FYL2X,         // X87
    INST_FYL2XP1,       // X87
    INST_HADDPD,
    INST_HADDPS,
    INST_HSUBPD,
    INST_HSUBPS,
    INST_IDIV,          // X86/X64
    INST_IMUL,          // X86/X64
    INST_INC,           // X86/X64
    INST_INT3,          // X86/X64

    INST_JA,            // X86/X64 (jcc)
    INST_JAE,           // X86/X64 (jcc)
    INST_JB,            // X86/X64 (jcc)
    INST_JBE,           // X86/X64 (jcc)
    INST_JC,            // X86/X64 (jcc)
    INST_JE,            // X86/X64 (jcc)
    INST_JG,            // X86/X64 (jcc)
    INST_JGE,           // X86/X64 (jcc)
    INST_JL,            // X86/X64 (jcc)
    INST_JLE,           // X86/X64 (jcc)
    INST_JNA,           // X86/X64 (jcc)
    INST_JNAE,          // X86/X64 (jcc)
    INST_JNB,           // X86/X64 (jcc)
    INST_JNBE,          // X86/X64 (jcc)
    INST_JNC,           // X86/X64 (jcc)
    INST_JNE,           // X86/X64 (jcc)
    INST_JNG,           // X86/X64 (jcc)
    INST_JNGE,          // X86/X64 (jcc)
    INST_JNL,           // X86/X64 (jcc)
    INST_JNLE,          // X86/X64 (jcc)
    INST_JNO,           // X86/X64 (jcc)
    INST_JNP,           // X86/X64 (jcc)
    INST_JNS,           // X86/X64 (jcc)
    INST_JNZ,           // X86/X64 (jcc)
    INST_JO,            // X86/X64 (jcc)
    INST_JP,            // X86/X64 (jcc)
    INST_JPE,           // X86/X64 (jcc)
    INST_JPO,           // X86/X64 (jcc)
    INST_JS,            // X86/X64 (jcc)
    INST_JZ,            // X86/X64 (jcc)
    INST_JMP,           // X86/X64 (jmp)

    INST_JA_SHORT,      // X86/X64 (jcc short)
    INST_JAE_SHORT,     // X86/X64 (jcc short)
    INST_JB_SHORT,      // X86/X64 (jcc short)
    INST_JBE_SHORT,     // X86/X64 (jcc short)
    INST_JC_SHORT,      // X86/X64 (jcc short)
    INST_JE_SHORT,      // X86/X64 (jcc short)
    INST_JG_SHORT,      // X86/X64 (jcc short)
    INST_JGE_SHORT,     // X86/X64 (jcc short)
    INST_JL_SHORT,      // X86/X64 (jcc short)
    INST_JLE_SHORT,     // X86/X64 (jcc short)
    INST_JNA_SHORT,     // X86/X64 (jcc short)
    INST_JNAE_SHORT,    // X86/X64 (jcc short)
    INST_JNB_SHORT,     // X86/X64 (jcc short)
    INST_JNBE_SHORT,    // X86/X64 (jcc short)
    INST_JNC_SHORT,     // X86/X64 (jcc short)
    INST_JNE_SHORT,     // X86/X64 (jcc short)
    INST_JNG_SHORT,     // X86/X64 (jcc short)
    INST_JNGE_SHORT,    // X86/X64 (jcc short)
    INST_JNL_SHORT,     // X86/X64 (jcc short)
    INST_JNLE_SHORT,    // X86/X64 (jcc short)
    INST_JNO_SHORT,     // X86/X64 (jcc short)
    INST_JNP_SHORT,     // X86/X64 (jcc short)
    INST_JNS_SHORT,     // X86/X64 (jcc short)
    INST_JNZ_SHORT,     // X86/X64 (jcc short)
    INST_JO_SHORT,      // X86/X64 (jcc short)
    INST_JP_SHORT,      // X86/X64 (jcc short)
    INST_JPE_SHORT,     // X86/X64 (jcc short)
    INST_JPO_SHORT,     // X86/X64 (jcc short)
    INST_JS_SHORT,      // X86/X64 (jcc short)
    INST_JZ_SHORT,      // X86/X64 (jcc short)
    INST_JMP_SHORT,     // X86/Z64 (jmp short)

    INST_LDDQU,
    INST_LDMXCSR,
    INST_LEA,           // X86/X64
    INST_LEAVE,         // X86/X64
    INST_LFENCE,
    INST_LOCK,          // X86/X64
    INST_MASKMOVDQU,
    INST_MASKMOVQ,      // MMX Extensions
    INST_MAXPD,
    INST_MAXPS,
    INST_MAXSD,
    INST_MAXSS,
    INST_MFENCE,
    INST_MINPD,
    INST_MINPS,
    INST_MINSD,
    INST_MINSS,
    INST_MONITOR,
    INST_MOV,           // X86/X64
    INST_MOVAPD,
    INST_MOVAPS,
    INST_MOVBE,
    INST_MOVD,
    INST_MOVDDUP,
    INST_MOVDQ2Q,
    INST_MOVDQA,
    INST_MOVDQU,
    INST_MOVHLPS,
    INST_MOVHPD,
    INST_MOVHPS,
    INST_MOVLHPS,
    INST_MOVLPD,
    INST_MOVLPS,
    INST_MOVMSKPD,
    INST_MOVMSKPS,
    INST_MOVNTDQ,
    INST_MOVNTDQA,
    INST_MOVNTI,
    INST_MOVNTPD,
    INST_MOVNTPS,
    INST_MOVNTQ,        // MMX Extensions
    INST_MOVQ,
    INST_MOVQ2DQ,
    INST_MOVSD,
    INST_MOVSHDUP,
    INST_MOVSLDUP,
    INST_MOVSS,
    INST_MOVSX,         // X86/X64
    INST_MOVSXD,        // X86/X64
    INST_MOVUPD,
    INST_MOVUPS,
    INST_MOVZX,         // X86/X64
    INST_MOV_PTR,       // X86/X64
    INST_MPSADBW,
    INST_MUL,           // X86/X64
    INST_MULPD,
    INST_MULPS,
    INST_MULSD,
    INST_MULSS,
    INST_MWAIT,
    INST_NEG,           // X86/X64
    INST_NOP,           // X86/X64
    INST_NOT,           // X86/X64
    INST_OR,            // X86/X64
    INST_ORPD,
    INST_ORPS,
    INST_PABSB,
    INST_PABSD,
    INST_PABSW,
    INST_PACKSSDW,
    INST_PACKSSWB,
    INST_PACKUSDW,
    INST_PACKUSWB,
    INST_PADDB,
    INST_PADDD,
    INST_PADDQ,
    INST_PADDSB,
    INST_PADDSW,
    INST_PADDUSB,
    INST_PADDUSW,
    INST_PADDW,
    INST_PALIGNR,
    INST_PAND,
    INST_PANDN,
    INST_PAUSE,
    INST_PAVGB,         // MMX Extensions
    INST_PAVGW,         // MMX Extensions
    INST_PBLENDVB,
    INST_PBLENDW,
    INST_PCMPEQB,
    INST_PCMPEQD,
    INST_PCMPEQQ,
    INST_PCMPEQW,
    INST_PCMPESTRI,
    INST_PCMPESTRM,
    INST_PCMPGTB,
    INST_PCMPGTD,
    INST_PCMPGTQ,
    INST_PCMPGTW,
    INST_PCMPISTRI,
    INST_PCMPISTRM,
    INST_PEXTRB,
    INST_PEXTRD,
    INST_PEXTRQ,
    INST_PEXTRW,        // MMX Extensions
    INST_PF2ID,         // 3dNow!
    INST_PF2IW,         // 3dNow! Extensions
    INST_PFACC,         // 3dNow!
    INST_PFADD,         // 3dNow!
    INST_PFCMPEQ,       // 3dNow!
    INST_PFCMPGE,       // 3dNow!
    INST_PFCMPGT,       // 3dNow!
    INST_PFMAX,         // 3dNow!
    INST_PFMIN,         // 3dNow!
    INST_PFMUL,         // 3dNow!
    INST_PFNACC,        // 3dNow! Extensions
    INST_PFPNACC,       // 3dNow! Extensions
    INST_PFRCP,         // 3dNow!
    INST_PFRCPIT1,      // 3dNow!
    INST_PFRCPIT2,      // 3dNow!
    INST_PFRSQIT1,      // 3dNow!
    INST_PFRSQRT,       // 3dNow!
    INST_PFSUB,         // 3dNow!
    INST_PFSUBR,        // 3dNow!
    INST_PHADDD,
    INST_PHADDSW,
    INST_PHADDW,
    INST_PHMINPOSUW,
    INST_PHSUBD,
    INST_PHSUBSW,
    INST_PHSUBW,
    INST_PI2FD,         // 3dNow!
    INST_PI2FW,         // 3dNow! Extensions
    INST_PINSRB,
    INST_PINSRD,
    INST_PINSRQ,
    INST_PINSRW,        // MMX Extensions
    INST_PMADDUBSW,
    INST_PMADDWD,
    INST_PMAXSB,
    INST_PMAXSD,
    INST_PMAXSW,        // MMX Extensions
    INST_PMAXUB,        // MMX Extensions
    INST_PMAXUD,
    INST_PMAXUW,
    INST_PMINSB,
    INST_PMINSD,
    INST_PMINSW,        // MMX Extensions
    INST_PMINUB,        // MMX Extensions
    INST_PMINUD,
    INST_PMINUW,
    INST_PMOVMSKB,      // MMX Extensions
    INST_PMOVSXBD,
    INST_PMOVSXBQ,
    INST_PMOVSXBW,
    INST_PMOVSXDQ,
    INST_PMOVSXWD,
    INST_PMOVSXWQ,
    INST_PMOVZXBD,
    INST_PMOVZXBQ,
    INST_PMOVZXBW,
    INST_PMOVZXDQ,
    INST_PMOVZXWD,
    INST_PMOVZXWQ,
    INST_PMULDQ,
    INST_PMULHRSW,
    INST_PMULHUW,       // MMX Extensions
    INST_PMULHW,
    INST_PMULLD,
    INST_PMULLW,
    INST_PMULUDQ,
    INST_POP,           // X86/X64
    INST_POPAD,         // X86 only
    INST_POPCNT,
    INST_POPFD,         // X86 only
    INST_POPFQ,         // X64 only
    INST_POR,
    INST_PREFETCH,      // MMX Extensions
    INST_PSADBW,        // MMX Extensions
    INST_PSHUFB,
    INST_PSHUFD,
    INST_PSHUFW,        // MMX Extensions
    INST_PSHUFHW,
    INST_PSHUFLW,
    INST_PSIGNB,
    INST_PSIGND,
    INST_PSIGNW,
    INST_PSLLD,
    INST_PSLLDQ,
    INST_PSLLQ,
    INST_PSLLW,
    INST_PSRAD,
    INST_PSRAW,
    INST_PSRLD,
    INST_PSRLDQ,
    INST_PSRLQ,
    INST_PSRLW,
    INST_PSUBB,
    INST_PSUBD,
    INST_PSUBQ,
    INST_PSUBSB,
    INST_PSUBSW,
    INST_PSUBUSB,
    INST_PSUBUSW,
    INST_PSUBW,
    INST_PSWAPD,        // 3dNow! Extensions
    INST_PTEST,
    INST_PUNPCKHBW,
    INST_PUNPCKHDQ,
    INST_PUNPCKHQDQ,
    INST_PUNPCKHWD,
    INST_PUNPCKLBW,
    INST_PUNPCKLDQ,
    INST_PUNPCKLQDQ,
    INST_PUNPCKLWD,
    INST_PUSH,          // X86/X64
    INST_PUSHAD,        // X86 only
    INST_PUSHFD,        // X86 only
    INST_PUSHFQ,        // X64 only
    INST_PXOR,
    INST_RCL,           // X86/X64
    INST_RCPPS,
    INST_RCPSS,
    INST_RCR,           // X86/X64
    INST_RDTSC,         // X86/X64
    INST_RDTSCP,        // X86/X64
    INST_RET,           // X86/X64
    INST_ROL,           // X86/X64
    INST_ROR,           // X86/X64
    INST_ROUNDPD,
    INST_ROUNDPS,
    INST_ROUNDSD,
    INST_ROUNDSS,
    INST_RSQRTPS,
    INST_RSQRTSS,
    INST_SAHF,          // X86 only
    INST_SAL,           // X86/X64
    INST_SAR,           // X86/X64
    INST_SBB,           // X86/X64

    INST_SETA,          // X86/X64 (setcc)
    INST_SETAE,         // X86/X64 (setcc)
    INST_SETB,          // X86/X64 (setcc)
    INST_SETBE,         // X86/X64 (setcc)
    INST_SETC,          // X86/X64 (setcc)
    INST_SETE,          // X86/X64 (setcc)
    INST_SETG,          // X86/X64 (setcc)
    INST_SETGE,         // X86/X64 (setcc)
    INST_SETL,          // X86/X64 (setcc)
    INST_SETLE,         // X86/X64 (setcc)
    INST_SETNA,         // X86/X64 (setcc)
    INST_SETNAE,        // X86/X64 (setcc)
    INST_SETNB,         // X86/X64 (setcc)
    INST_SETNBE,        // X86/X64 (setcc)
    INST_SETNC,         // X86/X64 (setcc)
    INST_SETNE,         // X86/X64 (setcc)
    INST_SETNG,         // X86/X64 (setcc)
    INST_SETNGE,        // X86/X64 (setcc)
    INST_SETNL,         // X86/X64 (setcc)
    INST_SETNLE,        // X86/X64 (setcc)
    INST_SETNO,         // X86/X64 (setcc)
    INST_SETNP,         // X86/X64 (setcc)
    INST_SETNS,         // X86/X64 (setcc)
    INST_SETNZ,         // X86/X64 (setcc)
    INST_SETO,          // X86/X64 (setcc)
    INST_SETP,          // X86/X64 (setcc)
    INST_SETPE,         // X86/X64 (setcc)
    INST_SETPO,         // X86/X64 (setcc)
    INST_SETS,          // X86/X64 (setcc)
    INST_SETZ,          // X86/X64 (setcc)
    INST_SFENCE,        // MMX Extensions
    INST_SHL,           // X86/X64
    INST_SHLD,          // X86/X64
    INST_SHR,           // X86/X64
    INST_SHRD,          // X86/X64
    INST_SHUFPS,
    INST_SQRTPD,
    INST_SQRTPS,
    INST_SQRTSD,
    INST_SQRTSS,
    INST_STC,           // X86/X64
    INST_STD,           // X86/X64
    INST_STMXCSR,
    INST_SUB,           // X86/X64
    INST_SUBPD,
    INST_SUBPS,
    INST_SUBSD,
    INST_SUBSS,
    INST_TEST,          // X86/X64
    INST_UCOMISD,
    INST_UCOMISS,
    INST_UD2,           // X86/X64
    INST_UNPCKHPD,
    INST_UNPCKHPS,
    INST_UNPCKLPD,
    INST_UNPCKLPS,
    INST_XADD,          // X86/X64 (i486)
    INST_XCHG,          // X86/X64 (i386)
    INST_XOR,           // X86/X64
    INST_XORPD,
    INST_XORPS;

    public static final INST_CODE INST_J = INST_JA;
    public static final INST_CODE INST_J_SHORT = INST_JA_SHORT;

    public final boolean isShortJump() {
        return compareTo(INST_J_SHORT) >= 0 && compareTo(INST_JMP_SHORT) <= 0;
    }

    public static final INST_CODE valueOf(int idx) {
        return values()[idx];
    }
}
