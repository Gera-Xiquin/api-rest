package com.geraxiquin.restapi.business

import com.geraxiquin.restapi.dao.PacienteRepository
import com.geraxiquin.restapi.exception.BusinnesExceprion
import com.geraxiquin.restapi.exception.NotFoundException
import com.geraxiquin.restapi.model.Paciente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PacienteBusinness : IPacienteBusiness {
    @Autowired
    val pacienteRepository: PacienteRepository? = null

    @Throws(BusinnesExceprion::class)
    override fun list(): List<Paciente> {
        try {
            return pacienteRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
    }

    @Throws(BusinnesExceprion::class, NotFoundException::class)
    override fun load(idPaciente: Int): Paciente {
        val op: Optional<Paciente>
        try {
            op = pacienteRepository!!.findById(idPaciente)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro el paciente con id $idPaciente")
        }
        return op.get()
    }

    @Throws(BusinnesExceprion::class)
    override fun save(paciente: Paciente): Paciente {
        try {
            return pacienteRepository!!.save(paciente)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
    }

    override fun remove(idPaciente: Int) {
        val op: Optional<Paciente>
        try {
            op = pacienteRepository!!.findById(idPaciente)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro el usuario con el id $idPaciente")
        } else {
            try {
                pacienteRepository!!.deleteById(idPaciente)
            } catch (e: Exception) {
                throw BusinnesExceprion(e.message)
            }
        }
    }
}