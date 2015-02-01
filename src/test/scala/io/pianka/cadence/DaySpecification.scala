package io.pianka.cadence

import io.pianka.cadence.model.{CardinalDayCadence, OrdinalDaysCadence}
import org.scalatest.{Matchers, WordSpec}

class DaySpecification extends WordSpec with Matchers {

  "Days" when {
    val day = new parser.DayParser {}

    "singular" should {
      "parse" in {
        day.parse(day.day, "Sunday").get     shouldEqual model.Day.Sunday
        day.parse(day.day, "sunday").get     shouldEqual model.Day.Sunday

        day.parse(day.day, "Monday").get     shouldEqual model.Day.Monday
        day.parse(day.day, "monday").get     shouldEqual model.Day.Monday

        day.parse(day.day, "Tuesday").get    shouldEqual model.Day.Tuesday
        day.parse(day.day, "tuesday").get    shouldEqual model.Day.Tuesday

        day.parse(day.day, "Wednesday").get  shouldEqual model.Day.Wednesday
        day.parse(day.day, "wednesday").get  shouldEqual model.Day.Wednesday

        day.parse(day.day, "Thursday").get   shouldEqual model.Day.Thursday
        day.parse(day.day, "thursday").get   shouldEqual model.Day.Thursday

        day.parse(day.day, "Friday").get     shouldEqual model.Day.Friday
        day.parse(day.day, "friday").get     shouldEqual model.Day.Friday

        day.parse(day.day, "Saturday").get   shouldEqual model.Day.Saturday
        day.parse(day.day, "saturday").get   shouldEqual model.Day.Saturday
      }
    }

    "plural" should {
      "allow a space separator" in {
        day.parse(day.dayList, "Monday Tuesday").get shouldEqual List(model.Day.Monday, model.Day.Tuesday)
      }

      "allow a comma separator" in {
        day.parse(day.dayList, "Monday,Tuesday").get  shouldEqual List(model.Day.Monday, model.Day.Tuesday)
        day.parse(day.dayList, "Monday, Tuesday").get shouldEqual List(model.Day.Monday, model.Day.Tuesday)
      }

      "allow an and separator" in {
        day.parse(day.dayList, "Monday and Tuesday").get shouldEqual List(model.Day.Monday, model.Day.Tuesday)
      }

      "support the oxford comma" in {
        day.parse(day.dayList, "Monday, and Tuesday").get shouldEqual List(model.Day.Monday, model.Day.Tuesday)
      }

      "support mixed separators" in {
        day.parse(day.dayList, "Monday Tuesday, Wednesday and Thursday, and Friday").get shouldEqual List(
          model.Day.Monday,
          model.Day.Tuesday,
          model.Day.Wednesday,
          model.Day.Thursday,
          model.Day.Friday
        )
      }
    }

    "cardinal" should {
      "support integers" in {
        day.parse(day.cardinalDays, "5 days").get shouldEqual CardinalDayCadence(5)
      }

      "support singularity" in {
        day.parse(day.cardinalDays, "1 day").get shouldEqual CardinalDayCadence(1)
      }

      "disallow negative cardinalities" in {
        an [Exception] should be thrownBy day.parse(day.cardinalDays, "-2 days")
      }
    }

    "ordinal" should {
      "support a single ordinal" in {
        day.parse(day.ordinalDays, "First Monday").get shouldEqual OrdinalDaysCadence(
          List(model.Ordinal.First),
          List(model.Day.Monday)
        )
      }

      "support multiple ordinals" in {
        day.parse(day.ordinalDays, "First, Second, and Last Friday").get shouldEqual OrdinalDaysCadence(
          List(model.Ordinal.First, model.Ordinal.Second, model.Ordinal.Last),
          List(model.Day.Friday)
        )
      }

      "support multiple days" in {
        day.parse(day.ordinalDays, "Third Monday and Friday").get shouldEqual OrdinalDaysCadence(
          List(model.Ordinal.Third),
          List(model.Day.Monday, model.Day.Friday)
        )
      }

      "support multiple ordinals and multiple days" in {
        day.parse(day.ordinalDays, "First and Third Monday, Wednesday, and Friday").get shouldEqual OrdinalDaysCadence(
          List(model.Ordinal.First, model.Ordinal.Third),
          List(model.Day.Monday, model.Day.Wednesday, model.Day.Friday)
        )
      }
    }
  }
}