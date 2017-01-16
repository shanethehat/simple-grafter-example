package com.sth.hello

import cats.data.Reader
import org.zalando.grafter.GenericReader._

trait NameGenerator {
  def getName: String
}

object NameGenerator {
  implicit def reader: Reader[ApplicationConfig, NameGenerator] = NiceNameGenerator.reader
}


case class NiceNameGenerator() extends NameGenerator {
  def getName: String = "Friend"
}

object NiceNameGenerator {
  implicit def reader: Reader[ApplicationConfig, NiceNameGenerator] = genericReader
}
