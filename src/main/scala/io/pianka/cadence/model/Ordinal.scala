package io.pianka.cadence.model

trait Ordinal

case class CardinalOrdinal(cardinality: Int) extends Ordinal

object Ordinal {
  val First  = CardinalOrdinal(1)
  val Second = CardinalOrdinal(2)
  val Third  = CardinalOrdinal(3)
  val Fourth = CardinalOrdinal(4)

  case object Last   extends Ordinal
}