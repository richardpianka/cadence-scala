package io.pianka.cadence.model

sealed trait DayCadence

case class CardinalDayCadence(
  cardinality: Int
) extends DayCadence {

  require(cardinality > 0)
}

case class OrdinalDayCadence(
  ordinals: List[Ordinal]
) extends DayCadence

case class OrdinalDaysCadence(
  ordinals: List[Ordinal],
  days: List[Day]
) extends DayCadence