package io.pianka.cadence.parser

import io.pianka.cadence.model.Ordinal

trait Ordinal extends Parser with Common {

  def first  = "[F|f]irst"  .r ^^ { _ => Ordinal.First}
  def second = "[S|s]econd" .r ^^ { _ => Ordinal.Second }
  def third  = "[T|t]hird"  .r ^^ { _ => Ordinal.Third }
  def fourth = "[F|f]ourth" .r ^^ { _ => Ordinal.Fourth }
  def last   = "[L|l]ast"   .r ^^ { _ => Ordinal.Last }

  def ordinalLiteral =
    first   |
    second  |
    third   |
    fourth  |
    last

  def ordinalLiterals = repsep(ordinalLiteral, separator)
}
