package io.pianka.cadence.parser

trait CommonParser extends Parser {

  def separator = ", and ".r | " and ".r | ", ?".r | whiteSpace
}