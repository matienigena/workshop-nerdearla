package com.nerdearla.workshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// Cambiar de object a class
@SpringBootApplication
class WorkshopApplication

// crear fun en vez de @jvmstatic
fun main(args: Array<String>) {
    runApplication<WorkshopApplication>(*args)
}
