package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class SucursalController {
    @Autowired
    lateinit var sucursalService: SucursalService

    @RequestMapping("/sucursal")
    fun mostrarTodos(model: Model) : String {
        val allSucursales = sucursalService.findAll().toList()
        model.addAttribute("sucursales", allSucursales)
        return "home"
    }
}