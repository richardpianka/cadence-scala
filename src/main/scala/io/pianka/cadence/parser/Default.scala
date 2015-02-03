package io.pianka.cadence.parser

import io.pianka.cadence.model.{Day, Month, SpecialTime, Time}

trait Default {
  def month:       Month = Month.January
  def week:        Int   = 1
  def day:         Day   = Day.Monday
  def time:        Time  = SpecialTime.Midnight
  def hour:        Int   = 0
  def minute:      Int   = 0
  def second:      Int   = 0
  def millisecond: Int   = 0

  def century:     Int   = 20 //prefix, not ordinal
}

object Default {

  implicit lazy val default = new Default {}
}