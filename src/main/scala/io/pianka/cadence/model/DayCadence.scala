package io.pianka.cadence.model

case class CardinalDayCadence(
  cardinality: Int
) {

  require(cardinality > 0)
}

case class OrdinalDayCadence(
  ordinals: List[Ordinal]
)

case class OrdinalDaysCadence(
  ordinals: List[Ordinal],
  days: List[Day]
)