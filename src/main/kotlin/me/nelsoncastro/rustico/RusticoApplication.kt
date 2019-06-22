package me.nelsoncastro.rustico

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RusticoApplication

fun main(args: Array<String>) {
    runApplication<RusticoApplication>(*args)
}
