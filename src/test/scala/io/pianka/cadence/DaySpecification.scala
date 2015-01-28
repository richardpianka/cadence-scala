package io.pianka.cadence

import org.scalatest.{Matchers, WordSpec}

class DaySpecification extends WordSpec with Matchers {

  "Days" when {
    val day = new parser.Day {}

    "parsed" should {
      "understand literals" in {
        day.parse(day.dayLiteral, "Sunday").get     shouldEqual model.Day.Sunday
        day.parse(day.dayLiteral, "sunday").get     shouldEqual model.Day.Sunday

        day.parse(day.dayLiteral, "Monday").get     shouldEqual model.Day.Monday
        day.parse(day.dayLiteral, "monday").get     shouldEqual model.Day.Monday

        day.parse(day.dayLiteral, "Tuesday").get    shouldEqual model.Day.Tuesday
        day.parse(day.dayLiteral, "tuesday").get    shouldEqual model.Day.Tuesday

        day.parse(day.dayLiteral, "Wednesday").get  shouldEqual model.Day.Wednesday
        day.parse(day.dayLiteral, "wednesday").get  shouldEqual model.Day.Wednesday

        day.parse(day.dayLiteral, "Thursday").get   shouldEqual model.Day.Thursday
        day.parse(day.dayLiteral, "thursday").get   shouldEqual model.Day.Thursday

        day.parse(day.dayLiteral, "Friday").get     shouldEqual model.Day.Friday
        day.parse(day.dayLiteral, "friday").get     shouldEqual model.Day.Friday

        day.parse(day.dayLiteral, "Saturday").get   shouldEqual model.Day.Saturday
        day.parse(day.dayLiteral, "saturday").get   shouldEqual model.Day.Saturday
      }
    }
  }
}