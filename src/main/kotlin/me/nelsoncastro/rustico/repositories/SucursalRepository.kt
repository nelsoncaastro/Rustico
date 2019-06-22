package me.nelsoncastro.rustico.repositories

import me.nelsoncastro.rustico.domain.sucursal
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SucursalRepository : CrudRepository<sucursal, Int> {
}