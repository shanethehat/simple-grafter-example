package com.sth.hello

import cats.Eval
import org.http4s.server.blaze.BlazeBuilder
import org.zalando.grafter.macros.reader
import org.zalando.grafter.{Start, StartResult, Stop, StopResult}

@reader[ApplicationConfig]
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