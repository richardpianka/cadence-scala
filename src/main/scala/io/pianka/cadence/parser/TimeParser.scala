package io.pianka.cadence.parser

import io.pianka.cadence.model._

trait TimeParser extends Parser {

  def timeSeparator = ":".r

  def midnight = "[M|m]idnight".r ^^ { _ => SpecialTime.Midnight }
  def noon     = "[N|n]oon"    .r ^^ { _ => SpecialTime.Noon }

  def hourPart   = """\d?\d""".r ^^ { _.toInt }
  def minutePart = timeSeparator ~ """\d\d""" .r ^^ { case _ ~ m => m.toInt }
  def secondPart = timeSeparator ~ """\d\d""" .r ^^ { case _ ~ s => s.toInt }

  def anteMeridian = ("am".r | "AM".r) ^^ { _ => Meridian.AnteMeridian }
  def postMeridian = ("pm".r | "PM".r) ^^ { _ => Meridian.PostMeridian }
  def meridian     = anteMeridian | postMeridian

  def twelveHourTimeLiteral = hourPart ~ (minutePart?) ~ (secondPart?) ~ (whiteSpace?) ~ meridian ^^ {
    case h ~ m ~ s  ~ _ ~ ap => TwelveHourTimeLiteral(h, m, s, ap)
  }
  def twentyFourHourTimeLiteral = hourPart ~ (minutePart?) ~ (secondPart?) ^^ {
    case h ~ m ~ s => TwentyFourHourTimeLiteral(h, m, s)
  }

  def timeLiteral = midnight | noon | twelveHourTimeLiteral | twentyFourHourTimeLiteral
}