package io.pianka.cadence.parser

trait CommonParser extends Parser {

  def listSeparator = ", and ".r | " and ".r | ", ?".r | whiteSpace

  def prepend[A](ignore: Parser[String], a: Parser[A]) =
    ignore ~ a ^^ {
      case _ ~ value => value
    }

  def append[A](a: Parser[A], ignore: Parser[String]) =
    a ~ ignore ^^ {
      case value ~ _ => value
    }
}