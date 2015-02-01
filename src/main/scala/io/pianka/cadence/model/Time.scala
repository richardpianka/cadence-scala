package io.pianka.cadence.model

sealed trait Meridian

object Meridian {
  case object AnteMeridian extends Meridian
  case object PostMeridian extends Meridian
}

trait Time

sealed trait TimeLiteral extends Time {
  def hour: Int
  def minute: Option[Int]
  def second: Option[Int]
}

sealed class SpecialTime(
  val hour: Int,
  val minute: Option[Int],
  val second: Option[Int]
) extends TimeLiteral

object SpecialTime {
  case object Midnight extends SpecialTime( 0, Some(0), Some(0))
  case object Noon     extends SpecialTime(12, Some(0), Some(0))
}

case class TwelveHourTimeLiteral(
  hour: Int,
  minute: Option[Int],
  second: Option[Int],
  meridian: Meridian
) extends TimeLiteral {
  require(minute.isDefined || minute.isEmpty) // second cannot be defined without minute

  require(hour >= 1 && hour <= 12)
  require(minute.map(m => m >= 0 && m <= 59).getOrElse(true))
  require(second.map(s => s >= 0 && s <= 59).getOrElse(true))
}

case class TwentyFourHourTimeLiteral(
  hour: Int,
  minute: Option[Int],
  second: Option[Int]
) extends TimeLiteral {
  require(minute.isDefined || minute.isEmpty) // second cannot be defined without minute

  require(hour >= 0 && hour <= 23)
  require(minute.map(m => m >= 0 && m <= 59).getOrElse(true))
  require(second.map(s => s >= 0 && s <= 59).getOrElse(true))
}