package com.geraxiquin.restapi.model

import jakarta.persistence.*

@Entity
@Table(name = "usuario")
class Usuario(val nombre: String = "", val usuario: String = "", val pass: String="") {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Int = 0
}
