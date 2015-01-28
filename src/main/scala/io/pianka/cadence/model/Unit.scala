package io.pianka.cadence.model

trait Unit

object Unit {
  case object Millisecond extends Unit
  case object Second      extends Unit
  case object Minute      extends Unit
  case object Hour        extends Unit
  case object Day         extends Unit
  case object Week        extends Unit
  case object Month       extends Unit
  case object Year        extends Unit
}