package com.nerdearla.workshop

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient

// Cambiar de object a class
@SpringBootApplication
class WorkshopApplication

// crear fun en vez de @jvmstatic
fun main(args: Array<String>) {
    runApplication<WorkshopApplication>(*args)
}
