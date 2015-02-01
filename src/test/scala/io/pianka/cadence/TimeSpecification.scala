package io.pianka.cadence

import io.pianka.cadence.model.{TwentyFourHourTimeLiteral, Meridian, TwelveHourTimeLiteral}
import io.pianka.cadence.parser.TimeParser
import org.scalatest.{Matchers, WordSpec}

class TimeSpecification extends WordSpec with Matchers {

  "Times" when {
    val time = new TimeParser {}

    "partial" should {
      "parse hour parts" in {
        time.parse(time.hourPart, "0") .get shouldEqual 0
        time.parse(time.hourPart, "15").get shouldEqual 15
      }

      "parse minute parts" in {
        time.parse(time.minutePart, ":00").get shouldEqual 0
        time.parse(time.minutePart, ":15").get shouldEqual 15
      }

      "parse second parts" in {
        time.parse(time.secondPart, ":00").get shouldEqual 0
        time.parse(time.secondPart, ":15").get shouldEqual 15
      }
    }

    "twelve hours" should {
      "ignore meridian case" in {
        time.parse(time.twelveHourTimeLiteral, "1 am").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "1 AM").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.AnteMeridian)

        time.parse(time.twelveHourTimeLiteral, "1 pm").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.PostMeridian)
        time.parse(time.twelveHourTimeLiteral, "1 PM").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.PostMeridian)
      }

      "ignore meridian white space" in {
        time.parse(time.twelveHourTimeLiteral, "1am").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "1AM").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.AnteMeridian)

        time.parse(time.twelveHourTimeLiteral, "1pm").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.PostMeridian)
        time.parse(time.twelveHourTimeLiteral, "1PM").get shouldEqual TwelveHourTimeLiteral(1, None, None, Meridian.PostMeridian)
      }

      "parse hours" in {
        time.parse(time.twelveHourTimeLiteral, "12 am").get shouldEqual TwelveHourTimeLiteral(12, None, None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "12 pm").get shouldEqual TwelveHourTimeLiteral(12, None, None, Meridian.PostMeridian)

        time.parse(time.twelveHourTimeLiteral, "1 am") .get shouldEqual TwelveHourTimeLiteral(1,  None, None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "1 pm") .get shouldEqual TwelveHourTimeLiteral(1,  None, None, Meridian.PostMeridian)
      }

      "parse hours and minutes" in {
        time.parse(time.twelveHourTimeLiteral, "12:00 am").get shouldEqual TwelveHourTimeLiteral(12, Some(0),  None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "12:00 pm").get shouldEqual TwelveHourTimeLiteral(12, Some(0),  None, Meridian.PostMeridian)

        time.parse(time.twelveHourTimeLiteral, "1:59 am") .get shouldEqual TwelveHourTimeLiteral(1,  Some(59), None, Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "1:59 pm") .get shouldEqual TwelveHourTimeLiteral(1,  Some(59), None, Meridian.PostMeridian)
      }

      "parse hours, minutes, and seconds" in {
        time.parse(time.twelveHourTimeLiteral, "12:00:59 am").get shouldEqual TwelveHourTimeLiteral(12, Some(0), Some(59), Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "12:00:59 pm").get shouldEqual TwelveHourTimeLiteral(12, Some(0), Some(59), Meridian.PostMeridian)

        time.parse(time.twelveHourTimeLiteral, "1:59:00 am") .get shouldEqual TwelveHourTimeLiteral(1,  Some(59), Some(0), Meridian.AnteMeridian)
        time.parse(time.twelveHourTimeLiteral, "1:59:00 pm") .get shouldEqual TwelveHourTimeLiteral(1,  Some(59), Some(0), Meridian.PostMeridian)
      }
    }

    "twenty four hours" should {
      "parse hours" in {
        time.parse(time.twentyFourHourTimeLiteral, "00").get  shouldEqual TwentyFourHourTimeLiteral(0,  None, None)
        time.parse(time.twentyFourHourTimeLiteral, "00").get  shouldEqual TwentyFourHourTimeLiteral(0,  None, None)

        time.parse(time.twentyFourHourTimeLiteral, "23") .get shouldEqual TwentyFourHourTimeLiteral(23, None, None)
        time.parse(time.twentyFourHourTimeLiteral, "23") .get shouldEqual TwentyFourHourTimeLiteral(23, None, None)
      }

      "parse hours and minutes" in {
        time.parse(time.twentyFourHourTimeLiteral, "00:15").get  shouldEqual TwentyFourHourTimeLiteral(0,  Some(15), None)
        time.parse(time.twentyFourHourTimeLiteral, "00:15").get  shouldEqual TwentyFourHourTimeLiteral(0,  Some(15), None)

        time.parse(time.twentyFourHourTimeLiteral, "23:59") .get shouldEqual TwentyFourHourTimeLiteral(23, Some(59), None)
        time.parse(time.twentyFourHourTimeLiteral, "23:59") .get shouldEqual TwentyFourHourTimeLiteral(23, Some(59), None)
      }

      "parse hours, minutes, and seconds" in {
        time.parse(time.twentyFourHourTimeLiteral, "00:15:59").get  shouldEqual TwentyFourHourTimeLiteral(0,  Some(15), Some(59))
        time.parse(time.twentyFourHourTimeLiteral, "00:15:59").get  shouldEqual TwentyFourHourTimeLiteral(0,  Some(15), Some(59))

        time.parse(time.twentyFourHourTimeLiteral, "23:59:15") .get shouldEqual TwentyFourHourTimeLiteral(23, Some(59), Some(15))
        time.parse(time.twentyFourHourTimeLiteral, "23:59:15") .get shouldEqual TwentyFourHourTimeLiteral(23, Some(59), Some(15))
      }
    }

    "special" should {
      "parse midnight" in {
        time.parse(time.midnight, "Midnight").get shouldEqual model.SpecialTime.Midnight
        time.parse(time.midnight, "midnight").get shouldEqual model.SpecialTime.Midnight
      }

      "parse noon" in {
        time.parse(time.noon, "Noon").get shouldEqual model.SpecialTime.Noon
        time.parse(time.noon, "noon").get shouldEqual model.SpecialTime.Noon
      }
    }
  }
}