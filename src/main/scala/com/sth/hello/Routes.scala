package com.sth.hello

import cats.data.Reader
import org.http4s.HttpService
import org.http4s.dsl._
import org.zalando.grafter.GenericReader._

case class Routes(greetingService: GreetingService) {

  lazy val httpService = HttpService {
    case GET -> Root / "hello" => Ok(greetingService.sayHello)
    case GET -> Root / "bye" => Ok(greetingService.sayGoodbye)
  }

}

object Routes {
  implicit def reader: Reader[ApplicationConfig, Routes] = genericReader
}