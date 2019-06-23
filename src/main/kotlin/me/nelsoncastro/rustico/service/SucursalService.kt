package me.nelsoncastro.rustico.service

import me.nelsoncastro.rustico.domain.sucursal
import me.nelsoncastro.rustico.repositories.SucursalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SucursalService {

    @Autowired
    lateinit var sucursalRepository: SucursalRepository

    fun findAll() = sucursalRepository.findAll()

    fun findOne(id: Int) = sucursalRepository.findById(id)

    fun save(sucursal: sucursal) = sucursalRepository.save(sucursal)

    fun delete(sucursal: sucursal) = sucursalRepository.delete(sucursal)
}