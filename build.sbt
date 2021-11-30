name := "getting-started-scala"

version := "0.1"

scalaVersion := "2.13.7"

private val  scalaRequest = "com.lihaoyi" %% "requests" % "0.6.9"
private val  scalaXML = "org.scala-lang.modules" %% "scala-xml" % "2.0.1"
private val  scalaTest = "org.scalatest" %% "scalatest" % "3.2.9" % Test

libraryDependencies ++=Seq(
  scalaRequest,
  scalaXML,
  scalaTest
)