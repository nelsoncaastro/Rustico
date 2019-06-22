package me.nelsoncastro.rustico.service

import me.nelsoncastro.rustico.domain.usuario
import me.nelsoncastro.rustico.repositories.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun findAll() = usuarioRepository.findAll()

    fun save(usuario: usuario) = usuarioRepository.save(usuario)

    fun login(usuario: String, clave: String) = usuarioRepository.findFirstByUsuarioAndClave(usuario, clave)

    fun findOne(id: Int) = usuarioRepository.findById(id)
}