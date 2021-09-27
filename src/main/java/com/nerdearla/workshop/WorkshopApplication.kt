package com.nerdearla.workshop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object WorkshopApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(WorkshopApplication::class.java, *args)
    }
}
