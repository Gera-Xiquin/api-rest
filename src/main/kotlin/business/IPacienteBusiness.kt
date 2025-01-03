package com.geraxiquin.restapi.business

import com.geraxiquin.restapi.model.Paciente

interface IPacienteBusiness {
    fun list(): List<Paciente>
    fun load(idPaciente: Int): Paciente
    fun save(paciente: Paciente): Paciente
    fun remove(idPaciente: Int)
}