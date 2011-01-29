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

import static com.kenai.jnr.x86asm.INST_CODE.*;

/**
 * Assembler intrinsics seralizer.
 *
 * SerializerCore is abstract class that is used by @c Assembler and @a Compiler.
 * You probably never use this class directly, instead you use it to serialize
 * intrinsics to @c Assembler or @c Compiler. @c SerializerIntrinsics implements
 * all intruction intrinsics thats used and @c Serializer is public serializer
 * class that should be used (instead of @c SerializerCore or @c SerializerInstrinsics).
 *
 * <b>Note:</b> Use always {@link Serializer} class, this class is only designed to
 * decrease code size when exporting AsmJit library symbols. Some compilers
 * (for example MSVC) are exporting inline symbols when class is declared
 * to export them and {@link Serializer} class contains really huge count of
 * symbols that will be never used (everything is inlined).
 */
@Deprecated
public abstract class SerializerCore {

    static final Operand _none = new Operand(OP.OP_NONE, 0) {};
    
    //! @brief Emits X86/FPU or MM instruction.
    //!
    //! Operands @a o1, @a o2 or @a o3 can be @c NULL if they are not used.
    //!
    //! Hint: Use @c emitX86() helpers to emit instructions.
    abstract void _emitX86(INST_CODE code, Operand o1, Operand o2, Operand o3);


    // Helpers to decrease binary code size. These four emit methods are just
    // helpers thats used by serializer. They call _emitX86() adding NULLs
    // to first, second and third operand if needed.

    //! @brief Emits instruction with no operand.
    //!
    //! Should be use as an alternative to @c _emitX86() method.
    void emitX86(INST_CODE code) {
        _emitX86(code, _none, _none, _none);
    }

    //! @brief Emits instruction with one operand.
    //!
    //! Should be use as an alternative to @c _emitX86() method.
    void emitX86(INST_CODE code, Operand o1) {
        _emitX86(code, o1, _none, _none);
    }

    //! @brief Emits instruction with two operands.
    //!
    //! Should be use as an alternative to @c _emitX86() method.
    void emitX86(INST_CODE code, Operand o1, Operand o2) {
        _emitX86(code, o1, o2, _none);
    }

    //! @brief Emits instruction with three operands.
    //!
    //! Should be use as an alternative to @c _emitX86() method.
    void emitX86(INST_CODE code, Operand o1, Operand o2, Operand o3) {
        _emitX86(code, o1, o2, o3);
    }

    //! @brief Private method for emitting jcc.
    //! @internal This should be probably private.
    void _emitJcc(INST_CODE code, Label label, final int hint) {
        if (hint == 0) {
            emitX86(code, label);
        } else {
            emitX86(code, label, Immediate.imm(hint));
        }
    }

    //! @brief Private method for emitting jcc.
    //! @internal This should be probably private.
    void _emitJcc(INST_CODE code, Label label, final HINT hint) {
        if (hint == HINT.HINT_NONE) {
            emitX86(code, label);
        } else {
            emitX86(code, label, Immediate.imm(hint.value()));
        }
    }

    abstract boolean is64();

    //! @brief Translate condition code @a CC to AsmJit jump (jcc) instruction code.
    //! @sa @c INST_CODE, @c INST_J.
    static INST_CODE conditionToJCC(CONDITION cc) {
        assert (cc.value() <= 0xF);
        return _jcctable[cc.value()];
    }

    //! @brief Translate condition code @a CC to AsmJit cmov (cmovcc) instruction code.
    //! @sa @c INST_CODE, @c INST_CMOV.
    static INST_CODE conditionToCMovCC(CONDITION cc) {
        assert (cc.value() <= 0xF);
        return _cmovcctable[cc.value()];
    }

    //! @brief Translate condition code @a CC to AsmJit set (setcc) instruction code.
    //! @sa @c INST_CODE, @c INST_SET.
    static INST_CODE conditionToSetCC(CONDITION cc) {
        assert (cc.value() <= 0xF);
        return _setcctable[cc.value()];
    }

    /** Map used for jcc instructions. */
    static INST_CODE[] _jcctable = {
        INST_JO,
        INST_JNO,
        INST_JB,
        INST_JAE,
        INST_JE,
        INST_JNE,
        INST_JBE,
        INST_JA,
        INST_JS,
        INST_JNS,
        INST_JPE,
        INST_JPO,
        INST_JL,
        INST_JGE,
        INST_JLE,
        INST_JG
    };

    /** Map used for cmovcc instructions. */
    static INST_CODE[] _cmovcctable = {
        INST_CMOVO,
        INST_CMOVNO,
        INST_CMOVB,
        INST_CMOVAE,
        INST_CMOVE,
        INST_CMOVNE,
        INST_CMOVBE,
        INST_CMOVA,
        INST_CMOVS,
        INST_CMOVNS,
        INST_CMOVPE,
        INST_CMOVPO,
        INST_CMOVL,
        INST_CMOVGE,
        INST_CMOVLE,
        INST_CMOVG
    };

    static final INST_CODE[] _setcctable = {
        INST_SETO,
        INST_SETNO,
        INST_SETB,
        INST_SETAE,
        INST_SETE,
        INST_SETNE,
        INST_SETBE,
        INST_SETA,
        INST_SETS,
        INST_SETNS,
        INST_SETPE,
        INST_SETPO,
        INST_SETL,
        INST_SETGE,
        INST_SETLE,
        INST_SETG
    };
}
