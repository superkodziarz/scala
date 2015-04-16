net.virtualvoid.sbt.graph.Plugin.graphSettings

name := "ScalaProject"

version := "1.0"

scalaVersion := "2.11.6"

val slf4jVersion = "1.7.12"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

conflictManager := ConflictManager.latestRevision

//In case additional repositories are required
//resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

val logging = Seq(
  "org.slf4j" % "slf4j-api" % slf4jVersion force(),
  "org.slf4j" % "jcl-over-slf4j" % slf4jVersion,
  "org.slf4j" % "log4j-over-slf4j" % slf4jVersion,
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.codehaus.janino" % "janino" % "2.7.8"
)

val testDeps = Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

libraryDependencies ++= (logging ++ testDeps).map(_.exclude("log4j", "log4j").exclude("commons-logging", "commons-logging"))