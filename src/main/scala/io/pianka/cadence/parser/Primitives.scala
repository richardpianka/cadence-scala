package io.pianka.cadence.parser

trait Primitives extends Parser {

  def number = """\d+""".r ^^ { _.toDouble }
}
