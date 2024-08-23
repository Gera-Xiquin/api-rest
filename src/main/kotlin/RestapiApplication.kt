package com.geraxiquin.restapi

import com.geraxiquin.restapi.dao.UsuarioRepository
import com.geraxiquin.restapi.model.Usuario
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestapiApplication

fun main(args: Array<String>) {
    runApplication<RestapiApplication>(*args)
}