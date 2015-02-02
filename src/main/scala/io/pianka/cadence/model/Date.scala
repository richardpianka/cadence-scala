package io.pianka.cadence.model

/**
 * Represents a day in a Gregorian calendar.
 *
 * @param year The full year, natural numbers. A value of 89 is not 1989, but simply 89.
 * @param month The month, natural numbers.
 * @param day The day, natural numbers.
 */
case class Date(
  year: Int,
  month: Option[Int],
  day: Option[Int]
)