package com.geraxiquin.restapi.web

import com.geraxiquin.restapi.business.IPacienteBusiness
import com.geraxiquin.restapi.exception.BusinnesExceprion
import com.geraxiquin.restapi.exception.NotFoundException
import com.geraxiquin.restapi.model.Paciente
import com.geraxiquin.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

class PacienteRestContoller {

    @Autowired
    val pacienteBusinness: IPacienteBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Paciente>> {
        return try {
            ResponseEntity(pacienteBusinness!!.list(), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPaciente: Int): ResponseEntity<Paciente> {
        return try {
            ResponseEntity(pacienteBusinness!!.load(idPaciente), HttpStatus.OK)
        } catch (e: BusinnesExceprion) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody paciente: Paciente): ResponseEntity<Any> {
        return try {
            pacienteBusinness!!.save(paciente)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_PACIENTES + "/" + paciente.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        } catch (e: BusinnesExceprion) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody paciente: Paciente): ResponseEntity<Any> {
        return try {
            pacienteBusinness!!.save(paciente)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinnesExceprion) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idpaciente: Int): ResponseEntity<Any> {
        return try {
            pacienteBusinness!!.remove(idpaciente)
            ResponseEntity(HttpStatus.OK)
        } catch (e: BusinnesExceprion) {
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        } catch (e: NotFoundException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}