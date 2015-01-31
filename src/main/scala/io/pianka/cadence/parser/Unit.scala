package io.pianka.cadence.parser

trait Unit extends Parser with Common {

  def milliseconds = "[M|m]illiseconds?".r
  def seconds      = "[S|s]econds?".r
  def minutes      = "[M|m]inutes?".r
  def hours        = "[H|h]ours?".r
  def days         = "[D|d]ays?".r
  def weeks        = "[W|w]eeks?".r
  def months       = "[M|m]onths?".r
  def years        = "[Y|y]ears?".r
}