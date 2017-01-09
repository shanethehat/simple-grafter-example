package com.sth.hello

import java.util.concurrent.CountDownLatch

import org.zalando.grafter._
// these imports are used, intellij just can't tell
import GenericReader._
import cats.data.Reader

case class Application(httpServer: HttpServer)

object Main extends App {
  val latch = new CountDownLatch(1)

  val application: Application = GenericReader[ApplicationConfig, Application]
    .run(ApplicationConfig(HttpConfig("localhost", 8080)))

  Rewriter.start(application).value

  sys.addShutdownHook {
    Rewriter.stop(application).value
    latch.countDown()
  }

  latch.await()
}
