package com.sth.hello

import cats.data.Reader
import org.zalando.grafter.GenericReader._
import org.zalando.grafter.macros.reader

trait NameGenerator {
  def getName: String
}

object NameGenerator {
  implicit def reader: Reader[ApplicationConfig, NameGenerator] = NiceNameGenerator.reader
}

@reader[ApplicationConfig]
case class NiceNameGenerator() extends NameGenerator {
  def getName: String = "Friend"
}
