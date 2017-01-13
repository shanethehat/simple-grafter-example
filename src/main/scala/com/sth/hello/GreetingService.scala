package com.sth.hello

import org.zalando.grafter.macros.reader

@reader[ApplicationConfig]
case class GreetingService(nameGenerator: NameGenerator) {

  def sayHello: String = "Hello " + nameGenerator.getName

  def sayGoodbye: String = "Goodbye " + nameGenerator.getName

}
