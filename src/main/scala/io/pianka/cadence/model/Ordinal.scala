package io.pianka.cadence.model

trait Ordinal

object Ordinal {
  case object First  extends Ordinal
  case object Second extends Ordinal
  case object Third  extends Ordinal
  case object Fourth extends Ordinal
  case object Last   extends Ordinal
}