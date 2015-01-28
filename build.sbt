name := "cadence"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  // main
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3",
  // test
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)