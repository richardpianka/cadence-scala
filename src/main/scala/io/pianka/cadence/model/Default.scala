package io.pianka.cadence.model

trait Default {
  def month:       Month = Month.January
  def week:        Int   = 1
  def day:         Day   = Day.Monday
  def time:        Time  = SpecialTime.Midnight
  def hour:        Int   = 0
  def minute:      Int   = 0
  def second:      Int   = 0
  def millisecond: Int   = 0
}

object Default {

  implicit lazy val default = new Default {}
}