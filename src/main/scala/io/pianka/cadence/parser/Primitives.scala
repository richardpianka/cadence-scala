package io.pianka.cadence.parser

trait Primitives extends Parser {

  def integer = """-?\d+""".r ^^ { _.toInt }
}
