package com.sth.hello

import org.zalando.grafter._
// these imports are used, intellij just can't tell
import GenericReader._
import cats.data.Reader

case class Application(httpServer: HttpServer)

object Main extends App {

  val application: Application = GenericReader[ApplicationConfig, Application]
    .run(ApplicationConfig(HttpConfig("localhost", 8080)))

}
