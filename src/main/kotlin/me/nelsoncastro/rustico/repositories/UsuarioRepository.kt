package me.nelsoncastro.rustico.repositories

import me.nelsoncastro.rustico.domain.usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsuarioRepository : CrudRepository<usuario, Int> {
    fun findFirstByUsuarioAndClave(usuario:String, clave:String): Optional<usuario>
}