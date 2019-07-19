name := """play-java-jpa-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.0"

// https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
libraryDependencies += "org.springframework.data" % "spring-data-jpa" % "2.1.9.RELEASE"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.23"
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.23"



libraryDependencies += guice
libraryDependencies += javaJpa
libraryDependencies += "com.h2database" % "h2" % "1.4.199"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.4.0.Final"

libraryDependencies += javaWs % "test"

libraryDependencies += "org.awaitility" % "awaitility" % "3.1.5" % "test"
libraryDependencies += "org.assertj" % "assertj-core" % "3.11.1" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.23.4" % "test"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.16"
libraryDependencies += "dom4j" % "dom4j" % "1.6"

Test / testOptions += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")

ThisBuild / scalacOptions ++= List("-encoding", "utf8", "-deprecation", "-feature", "-unchecked")
ThisBuild / javacOptions ++= List("-Xlint:unchecked", "-Xlint:deprecation", "-Werror")

PlayKeys.externalizeResourcesExcludes += baseDirectory.value / "conf" / "META-INF" / "persistence.xml"



//resolvers += "Spring Snapshots" at "http://maven.springframework.org/snapshot"


// https://mvnrepository.com/artifact/com.lightbend.play/play-spring-loader
//libraryDependencies += "com.lightbend.play" %% "play-spring-loader" % "0.0.2"


//
//libraryDependencies ++= Seq(
//  "com.typesafe.play" %% "play" % "2.7.0",
//  "org.springframework" % "spring-context" % "4.3.9.RELEASE"
//)

//libraryDependencies += "com.lightbend.play" %% "play-spring-loader" % "0.0.2"
