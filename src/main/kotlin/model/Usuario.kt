package com.geraxiquin.restapi.model

import jakarta.persistence.*

@Entity
@Table(name = "usuario")
class Usuario(
    var usuario: String = "",
    var zona: String = "",
    var pin: String = "",
    var orientacionDireccion: String = "",
    var nombre: String = "",
    var cantidadCalle: Int = 0
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
}
