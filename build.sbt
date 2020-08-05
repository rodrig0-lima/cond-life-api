scalaVersion := "2.13.2"

lazy val `cond-life-api` = (project in file("."))
  .aggregate(
    `cond-life-http`
  )

lazy val `cond-life-http` = project
  .settings(
    version := "1.0",
    packageName in Docker := "cond-life-api",
    dockerExposedPorts := Seq(5000),

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-stream" % "2.5.26",
      "com.typesafe.akka" %% "akka-http"   % "10.1.11",
      "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.11",
      "org.scalatest" %% "scalatest" % "3.1.1" % "test"
    )
  )
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)