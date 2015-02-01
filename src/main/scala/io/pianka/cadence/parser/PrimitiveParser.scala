package io.pianka.cadence.parser

trait PrimitiveParser extends Parser {

  def integer = """-?\d+""".r ^^ { _.toInt }
}
