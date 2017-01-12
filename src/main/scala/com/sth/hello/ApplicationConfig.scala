package com.sth.hello

import org.zalando.grafter.macros.readers

@readers
case class ApplicationConfig(http: HttpConfig)


case class HttpConfig(host: String, port: Int)
