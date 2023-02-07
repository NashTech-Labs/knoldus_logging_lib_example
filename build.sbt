ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "knoldus_logging_lib_example"
  )

resolvers += "google-artifact-registry" at "https://asia-maven.pkg.dev/sonarqube-289802/knoldus-aws-lib/"

libraryDependencies += "knoldus" % "logging_lib_2.13" % "1.0"