package com.nerdearla.workshop.controller

import com.nerdearla.workshop.service.BuyerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("buyers")
class BuyerController(
    private val service: BuyerService
) {
    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: String) = service.findBuyer(userId, "123444459")
}