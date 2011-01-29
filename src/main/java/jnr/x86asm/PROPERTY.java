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

/**
 * Assembler/Compiler properties.
 */
public final class PROPERTY {
  /**
   * Optimize align for current processor.
   *
   * Default: @c true.
   */
  public static final int PROPERTY_OPTIMIZE_ALIGN = 0;

  /**
   * Force rex prefix emitting.
   *
   * Default: @c false.
   *
   * @note This is X86/X86 property only.
   */
  public static final int PROPERTY_X86_FORCE_REX = 1;

  /**
   * Emit hints added to jcc() instructions.
   *
   * Default: @c true.
   *
   * @note This is X86/X86 property only.
   */
  public static final int PROPERTY_X86_JCC_HINTS = 2;
}
