package com.sth.hello

import cats.data.Reader
import org.zalando.grafter.GenericReader._

case class GreetingService(nameGenerator: NameGenerator) {

  def sayHello: String = "Hello " + nameGenerator.getName

  def sayGoodbye: String = "Goodbye " + nameGenerator.getName

}

object GreetingService {
  implicit def reader: Reader[ApplicationConfig, GreetingService] = genericReader
}
