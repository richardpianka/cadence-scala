package io.pianka.cadence.parser

import io.pianka.cadence.model.Date
import scala.language.postfixOps

trait DateParser extends Parser with CommonParser {

  def dashSeparator  = "-".r
  def slashSeparator = "/".r

  def yearPart     = """\d?\d?\d?\d""".r ^^ { _.toInt }
  def halfYearPart(implicit default: Default)
                   = """\d\d""" .r ^^ { y => s"${default.century}$y".toInt }
  def monthPart    = """\d?\d""".r ^^ { _.toInt }
  def dayPart      = """\d?\d""".r ^^ { _.toInt }

  /**
   * Of the yyyy, yyyy-mm, or yyyy-mm-dd formats.
   */
  def internationalDate = yearPart ~ (prepend(dashSeparator, monthPart)?) ~ (prepend(dashSeparator, dayPart)?) ^^ {
    case y ~ m ~ d => Date(y, m, d)
  }

  /**
   * Of the mm/dd, mm/dd/yyyy, or mm/dd/yy format.
   */
  def unitedStatesDate =
    monthPart ~ prepend(slashSeparator, dayPart) ~ (prepend(slashSeparator, yearPart | halfYearPart)?) ^^ {
      case m ~ d ~ y => Date(m, Some(d), y)
    }
}