package io.pianka.cadence

import org.scalatest.{Matchers, WordSpec}

class DateSpecification extends WordSpec with Matchers {

  "Dates" when {
    val date = new parser.DateParser {}

    "partial" should {
      "parse year parts" in {
        date.parse(date.yearPart,    "9").get shouldEqual    9
        date.parse(date.yearPart,   "89").get shouldEqual   89
        date.parse(date.yearPart,  "989").get shouldEqual  989
        date.parse(date.yearPart, "1989").get shouldEqual 1989
      }

      "parse half year parts" in {
        date.parse(date.halfYearPart, "15").get shouldEqual 2015
      }

      "parse month parts" in {
        date.parse(date.monthPart, "1") .get shouldEqual 1
        date.parse(date.monthPart, "12").get shouldEqual 12
      }

      "parse day parts" in {
        date.parse(date.dayPart, "1") .get shouldEqual 1
        date.parse(date.dayPart, "12").get shouldEqual 12
      }
    }
  }
}
