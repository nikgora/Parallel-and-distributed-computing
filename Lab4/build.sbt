import Dependencies._

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.15"


lazy val root =  project
  .in(file("."))
  .settings(name := "scala-course-spring")
  .settings(commonSettings: _*)

lazy val commonSettings = Seq(
  crossScalaVersions := Seq("2.13.15","3.6.1"),
  libraryDependencies ++= dependencies,
  testFrameworks += new TestFramework("munit.Framework"),
  scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-Xfatal-warnings",
  ),
  javacOptions ++= Seq(
    "-source", "11",
    "-target", "11"
  ),
)

lazy val dependencies =
  cats ++
    `cats-effect` ++
    munit ++
    spark