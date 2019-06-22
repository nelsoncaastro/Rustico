package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService


}