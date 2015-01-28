package io.pianka.cadence.parser

import io.pianka.cadence.model.Day

trait Day extends Parser with Common {

  def sunday    = "[S|s]unday"    .r ^^ { _ => Day.Sunday }
  def monday    = "[M|m]onday"    .r ^^ { _ => Day.Monday }
  def tuesday   = "[T|t]uesday"   .r ^^ { _ => Day.Tuesday }
  def wednesday = "[W|w]ednesday" .r ^^ { _ => Day.Wednesday }
  def thursday  = "[T|t]hursday"  .r ^^ { _ => Day.Thursday }
  def friday    = "[F|f]riday"    .r ^^ { _ => Day.Friday }
  def saturday  = "[S|s]aturday"  .r ^^ { _ => Day.Saturday }

  def dayLiteral =
    sunday    |
    monday    |
    tuesday   |
    wednesday |
    thursday  |
    friday    |
    saturday

  def dayLiterals = repsep(dayLiteral, separator)

  def days = dayLiterals
}