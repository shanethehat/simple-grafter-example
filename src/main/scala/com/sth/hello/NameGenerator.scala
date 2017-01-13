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

@reader[ApplicationConfig]
case class RudeNameGenerator() extends NameGenerator {
  lazy val rand = new java.util.Random()
  lazy val names = Vector(
    "Bespawler",     // person who spits when they talk
    "Cumberworld",   // a waste of space
    "Dalcop",        // very stupid person
    "Fopdoodle",     // insignificant
    "Lubberwort",    // sluggish, fuzzy-minded
    "Raggabrash",    // disorganised, grubby,
    "Scobberlotcher" // lazy
  )

  def getName: String = names(rand.nextInt(names.length))
}
