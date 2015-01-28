package io.pianka.cadence.parser

trait Unit extends Parser with Common {

  def millisecond = "[M|m]illiseconds?".r
  def second      = "[S|s]econds?".r
  def minute      = "[M|m]inutes?".r
  def hour        = "[H|h]ours?".r
  def day         = "[D|d]ays?".r
  def week        = "[W|w]eeks?".r
  def month       = "[M|m]onths?".r
  def year        = "[Y|y]ears?".r
}