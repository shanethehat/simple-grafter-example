
name := "grafter-simple-example"

version := "1.0.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % "0.15.2",
  "org.http4s" %% "http4s-blaze-server" % "0.15.2",
  "org.zalando" %% "grafter" % "1.3.1"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
