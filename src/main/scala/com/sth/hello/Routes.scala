package com.sth.hello

import org.http4s.HttpService
import org.http4s.dsl._
import org.zalando.grafter.macros.reader

@reader[ApplicationConfig]
case class Routes(greetingService: GreetingService) {

  lazy val httpService = HttpService {
    case GET -> Root / "hello" => Ok(greetingService.sayHello)
    case GET -> Root / "bye" => Ok(greetingService.sayGoodbye)
  }

}