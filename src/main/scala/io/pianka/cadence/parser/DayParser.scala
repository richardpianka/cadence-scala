package io.pianka.cadence.parser

import io.pianka.cadence.model._

trait DayParser extends Parser with CommonParser with PrimitiveParser with OrdinalParser {

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

  def dayList = repsep(day, listSeparator)

  def cardinalDays = integer ~ whiteSpace ~ "days?".r ^^ {
    case n ~ _ ~ _ => CardinalDayCadence(n)
  }

  def ordinalDay = ordinals ~ whiteSpace ~ "day" ^^ {
    case o ~ _ ~ _ => OrdinalDayCadence(o)
  }

  def ordinalDays = ordinals ~ whiteSpace ~ dayList ^^ {
    case o ~ _ ~ d => OrdinalDaysCadence(o, d)
  }

  def dayCadence = cardinalDays | ordinalDay | ordinalDays
}

// Every third wednesday of the month at noon
// every monday, wednesday, and friday at midnight and noon