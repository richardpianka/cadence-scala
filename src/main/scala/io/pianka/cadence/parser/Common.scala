package io.pianka.cadence.parser

trait Common extends Parser {

  def separator = ", and ".r | " and ".r | ", ?".r | whiteSpace
}