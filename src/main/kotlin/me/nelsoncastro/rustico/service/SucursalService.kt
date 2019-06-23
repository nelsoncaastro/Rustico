package me.nelsoncastro.rustico.service

import me.nelsoncastro.rustico.repositories.SucursalRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SucursalService {

    @Autowired
    lateinit var sucursalRepository: SucursalRepository

    fun findAll() = sucursalRepository.findAll()
}