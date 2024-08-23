package com.geraxiquin.restapi.business

import com.geraxiquin.restapi.dao.UsuarioRepository
import com.geraxiquin.restapi.exception.BusinnesExceprion
import com.geraxiquin.restapi.exception.NotFoundException
import com.geraxiquin.restapi.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UsuarioBusinness : IUsuarioBusiness {

    @Autowired
    val usuarioRepository: UsuarioRepository? = null

    @Throws(BusinnesExceprion::class)
    override fun list(): List<Usuario> {
        try {
            return usuarioRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
    }

    @Throws(BusinnesExceprion::class, NotFoundException::class)
    override fun load(idUsuario: Int): Usuario {
        val op: Optional<Usuario>
        try {
            op = usuarioRepository!!.findById(idUsuario)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro el usuario con id $idUsuario")
        }
        return op.get()
    }

    @Throws(BusinnesExceprion::class)
    override fun save(usuario: Usuario): Usuario {
        try {
            return usuarioRepository!!.save(usuario)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
    }

    override fun remove(idUsuario: Int) {
        val op: Optional<Usuario>
        try {
            op = usuarioRepository!!.findById(idUsuario)
        } catch (e: Exception) {
            throw BusinnesExceprion(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontro el usuario con el id $idUsuario")
        } else {
            try {
                usuarioRepository!!.deleteById(idUsuario)
            } catch (e: Exception) {
                throw BusinnesExceprion(e.message)
            }
        }
    }
}