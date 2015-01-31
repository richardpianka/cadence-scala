package io.pianka.cadence.parser

import io.pianka.cadence.model.{CardinalDayCadence, OrdinalDaysCadence, Day}

trait Day extends Parser with Common with Primitives with Ordinal {

  def sunday    = "[S|s]unday"    .r ^^ { _ => Day.Sunday }
  def monday    = "[M|m]onday"    .r ^^ { _ => Day.Monday }
  def tuesday   = "[T|t]uesday"   .r ^^ { _ => Day.Tuesday }
  def wednesday = "[W|w]ednesday" .r ^^ { _ => Day.Wednesday }
  def thursday  = "[T|t]hursday"  .r ^^ { _ => Day.Thursday }
  def friday    = "[F|f]riday"    .r ^^ { _ => Day.Friday }
  def saturday  = "[S|s]aturday"  .r ^^ { _ => Day.Saturday }

  def day =
    sunday    |
    monday    |
    tuesday   |
    wednesday |
    thursday  |
    friday    |
    saturday

  def dayList = repsep(day, separator)

  def cardinalDays = integer ~ whiteSpace ~ "days?".r ^^ {
    case n ~ _ ~ _ => CardinalDayCadence(n)
  }

  def ordinalDay = ordinals ~ whiteSpace ~ "day" ^^ {
    case o ~ _ ~ _ => OrdinalDaysCadence(o,)
  }

  def ordinalDays = ordinals ~ whiteSpace ~ dayList ^^ {
    case o ~ _ ~ d => OrdinalDaysCadence(o, d)
  }
}