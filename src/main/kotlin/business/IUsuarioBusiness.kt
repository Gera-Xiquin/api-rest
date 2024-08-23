package com.geraxiquin.restapi.business

import com.geraxiquin.restapi.model.Usuario

interface IUsuarioBusiness {
    fun list(): List<Usuario>
    fun load(idUsuario:Int):Usuario
    fun save(usuario:Usuario): Usuario
    fun remove(idUsuario: Int)
}