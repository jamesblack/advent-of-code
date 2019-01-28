name := "adventofcode"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  "co.fs2" %% "fs2-core" % "1.0.1"
  , "co.fs2" %% "fs2-io" % "1.0.1"
//  , "ch.qos.logback" % "logback-classic" % "1.2.3"
//  , "io.confluent" % "kafka-avro-serializer" % "4.1.2"
//  , "com.github.pureconfig" %% "pureconfig" % "0.10.1"
//  , "io.circe" %% "circe-core" % "0.10.0"
//  , "io.circe" %% "circe-generic" % "0.10.0"
//  , "io.circe" %% "circe-parser" % "0.10.0"
//  , "ch.qos.logback" % "logback-classic" % "1.2.3"
//  , "com.beachape" %% "enumeratum" % "1.5.13"
//  , "org.scalatest" % "scalatest_2.12" % "3.0.5" % Test
//  , "org.scalamock" %% "scalamock" % "4.1.0" % Test
//  , "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided"
//  , "com.softwaremill.macwire" %% "util" % "2.3.1"
)

excludeDependencies ++= Seq(
  ExclusionRule("log4j", "log4j"),
  ExclusionRule("org.slf4j", "slf4j-log4j12"),
)
