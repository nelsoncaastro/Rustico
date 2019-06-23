package me.nelsoncastro.rustico.service

import me.nelsoncastro.rustico.domain.empleado
import me.nelsoncastro.rustico.repositories.EmpleadoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmpleadoService {

    @Autowired
    lateinit var empleadoRepository: EmpleadoRepository

    fun findAll() = empleadoRepository.findAll()

    fun findOne(id: Int) = empleadoRepository.findById(id)

    fun delete(empleado:empleado) = empleadoRepository.delete(empleado)

    fun save(empleado: empleado) = empleadoRepository.save(empleado)
}