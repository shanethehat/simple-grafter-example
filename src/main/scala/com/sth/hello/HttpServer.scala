package com.sth.hello

import cats.data.Reader
import org.http4s.server.blaze.BlazeBuilder
import org.zalando.grafter.GenericReader._

case class HttpServer(config: HttpConfig, route: Routes) {
  private lazy val builder: BlazeBuilder =
    BlazeBuilder
      .bindHttp(config.port, config.host)
      .mountService(route.httpService)

  private lazy val server = builder.run
}

object HttpServer {
  implicit def reader: Reader[ApplicationConfig, HttpServer] = genericReader
}