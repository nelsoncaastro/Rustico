package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

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

    @RequestMapping("/sucursal/perfil/{idSucursal}", method = [RequestMethod.GET, RequestMethod.POST])
    fun perfilSucursal(@PathVariable("idSucursal") id: Int, model: Model): String {
        val sucursalActual = sucursalService.findOne(id)
        if (sucursalActual.isPresent){
            val sucursal = sucursalActual.get()
            model.addAttribute("sucursal", sucursal)
            return "profile"
        }
        return "home"
    }

    @RequestMapping("/sucursal/editar/{idSucursal}", method = [RequestMethod.GET, RequestMethod.POST])
    fun editarSucursal(@PathVariable("idSucursal") id: Int, model: Model): String {
        val sucursalActual = sucursalService.findOne(id)
        if (sucursalActual.isPresent){
            val sucursal = sucursalActual.get()
            model.addAttribute("sucursal", sucursal)
            return "profile"
        }
        return "home"
    }
}