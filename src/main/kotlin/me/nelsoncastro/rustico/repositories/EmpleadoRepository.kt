package me.nelsoncastro.rustico.repositories

import me.nelsoncastro.rustico.domain.empleado
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpleadoRepository : CrudRepository<empleado, Int> {
}