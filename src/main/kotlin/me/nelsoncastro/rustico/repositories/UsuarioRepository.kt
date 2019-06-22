package me.nelsoncastro.rustico.repositories

import me.nelsoncastro.rustico.domain.usuario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : CrudRepository<usuario, Int> {
}