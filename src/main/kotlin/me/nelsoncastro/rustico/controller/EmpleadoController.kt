package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.service.EmpleadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class EmpleadoController {
    @Autowired
    lateinit var empleadoService: EmpleadoService


}