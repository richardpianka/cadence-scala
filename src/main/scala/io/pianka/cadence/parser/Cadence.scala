package io.pianka.cadence.parser

object Cadence extends Parser
  with CommonParser
  with UnitParser
  with DayParser
  with MonthParser {

  def every = "[E|e]very".r
}