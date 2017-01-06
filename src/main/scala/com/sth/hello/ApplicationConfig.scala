package com.sth.hello

import cats.data.Reader


case class ApplicationConfig(http: HttpConfig)


case class HttpConfig(host: String, port: Int)

object HttpConfig {
  implicit def reader: Reader[ApplicationConfig, HttpConfig] = Reader(_.http)
}
