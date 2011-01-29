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
 *
 */
public enum CONDITION {
  //! @brief No condition code.
  C_NO_CONDITION  (-1),

  // Condition codes from processor manuals.
  C_A             (0x7),
  C_AE            (0x3),
  C_B             (0x2),
  C_BE            (0x6),
  C_C             (0x2),
  C_E             (0x4),
  C_G             (0xF),
  C_GE            (0xD),
  C_L             (0xC),
  C_LE            (0xE),
  C_NA            (0x6),
  C_NAE           (0x2),
  C_NB            (0x3),
  C_NBE           (0x7),
  C_NC            (0x3),
  C_NE            (0x5),
  C_NG            (0xE),
  C_NGE           (0xC),
  C_NL            (0xD),
  C_NLE           (0xF),
  C_NO            (0x1),
  C_NP            (0xB),
  C_NS            (0x9),
  C_NZ            (0x5),
  C_O             (0x0),
  C_P             (0xA),
  C_PE            (0xA),
  C_PO            (0xB),
  C_S             (0x8),
  C_Z             (0x4),

  // Simplified condition codes
  C_OVERFLOW      (0x0),
  C_NO_OVERFLOW   (0x1),
  C_BELOW         (0x2),
  C_ABOVE_EQUAL   (0x3),
  C_EQUAL         (0x4),
  C_NOT_EQUAL     (0x5),
  C_BELOW_EQUAL   (0x6),
  C_ABOVE         (0x7),
  C_SIGN          (0x8),
  C_NOT_SIGN      (0x9),
  C_PARITY_EVEN   (0xA),
  C_PARITY_ODD    (0xB),
  C_LESS          (0xC),
  C_GREATER_EQUAL (0xD),
  C_LESS_EQUAL    (0xE),
  C_GREATER       (0xF),

  // aliases
  C_ZERO          (0x4),
  C_NOT_ZERO      (0x5),
  C_NEGATIVE      (0x8),
  C_POSITIVE      (0x9),

  // x87 floating point only
  C_FP_UNORDERED  (16),
  C_FP_NOT_UNORDERED(17);

  private final int value;

  CONDITION(int value) {
      this.value = value;
  }

  public final int value() {
      return this.value;
  }
}
