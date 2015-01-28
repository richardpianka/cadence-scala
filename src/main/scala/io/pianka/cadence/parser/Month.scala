package io.pianka.cadence.parser

import io.pianka.cadence.model.Month

trait Month extends Parser with Common {

  def january   = "[J|j]anuary"   .r ^^ { _ => Month.January }
  def february  = "[F|f]ebruary"  .r ^^ { _ => Month.February }
  def march     = "[M|m]arch"     .r ^^ { _ => Month.March }
  def april     = "[A|a]pril"     .r ^^ { _ => Month.April }
  def may       = "[M|m]ay"       .r ^^ { _ => Month.May }
  def june      = "[J|j]une"      .r ^^ { _ => Month.June }
  def july      = "[J|j|uly"      .r ^^ { _ => Month.July }
  def august    = "[A|a]ugust"    .r ^^ { _ => Month.August }
  def september = "[S|s]eptember" .r ^^ { _ => Month.September }
  def october   = "[O|o]ctober"   .r ^^ { _ => Month.October }
  def november  = "[N|n]ovember"  .r ^^ { _ => Month.November }
  def december  = "[D|d]ecember"  .r ^^ { _ => Month.December}

  def monthLiteral =
    january   |
    february  |
    march     |
    april     |
    may       |
    june      |
    july      |
    august    |
    september |
    october   |
    november  |
    december

  def monthLiterals = repsep(monthLiteral, separator)

  def months = monthLiterals
}