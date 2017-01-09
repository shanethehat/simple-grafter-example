package com.sth.hello

import cats.Eval
import cats.data.Reader
import org.http4s.server.blaze.BlazeBuilder
import org.zalando.grafter.GenericReader._
import org.zalando.grafter.{Start, StartResult, Stop, StopResult}

case class HttpServer(config: HttpConfig, route: Routes) extends Start with Stop {
  private lazy val builder: BlazeBuilder =
    BlazeBuilder
      .bindHttp(config.port, config.host)
      .mountService(route.httpService)

  private lazy val server = builder.run

  def start: Eval[StartResult] = {
    StartResult.eval("http4s")(server)
  }

  def stop: Eval[StopResult] = StopResult.eval("http4s")(server.shutdownNow())
}

object HttpServer {
  implicit def reader: Reader[ApplicationConfig, HttpServer] = genericReader
}