package com.geraxiquin.restapi.web

import com.geraxiquin.restapi.business.IUsuarioBusiness
import com.geraxiquin.restapi.exception.BusinnesExceprion
import com.geraxiquin.restapi.exception.NotFoundException
import com.geraxiquin.restapi.model.Usuario
import com.geraxiquin.restapi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_USUARIOS)
class UsuarioRestContoller {
    @Autowired
    val usuarioBusinness:IUsuarioBusiness?=null

    @GetMapping("")
    fun list():ResponseEntity<List<Usuario>>{
        return try {
            ResponseEntity(usuarioBusinness!!.list(),HttpStatus.OK)
        }catch (e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idUsuario: Int):ResponseEntity<Usuario>{
        return try {
            ResponseEntity(usuarioBusinness!!.load(idUsuario),HttpStatus.OK)
        }catch (e:BusinnesExceprion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody usuario:Usuario):ResponseEntity<Any>{
        return try {
            usuarioBusinness!!.save(usuario)
            val responseHeader=HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_USUARIOS+"/"+usuario.id)
            ResponseEntity(responseHeader,HttpStatus.CREATED)
        }catch (e:BusinnesExceprion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody usuario: Usuario):ResponseEntity<Any>{
        return try {
            usuarioBusinness!!.save(usuario)
            ResponseEntity(HttpStatus.OK)
        }catch (e:BusinnesExceprion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idUsuario: Int):ResponseEntity<Any>{
        return try {
            usuarioBusinness!!.remove(idUsuario)
            ResponseEntity(HttpStatus.OK)
        }catch (e:BusinnesExceprion){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}