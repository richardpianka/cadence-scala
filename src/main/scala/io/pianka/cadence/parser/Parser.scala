package io.pianka.cadence.parser

import scala.util.parsing.combinator.RegexParsers

trait Parser extends RegexParsers {

  override val skipWhitespace = false
}