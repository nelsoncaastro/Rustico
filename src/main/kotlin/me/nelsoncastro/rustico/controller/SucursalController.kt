package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.domain.sucursal
import me.nelsoncastro.rustico.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

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
        return "editsucursal"
    }

    @RequestMapping("/sucursal/editar/{idSucursal}", method = [RequestMethod.GET, RequestMethod.POST])
    fun editarSucursal(@PathVariable("idSucursal") id: Int, model: Model): String {
        val sucursalActual = sucursalService.findOne(id)
        if (sucursalActual.isPresent){
            val sucursal = sucursalActual.get()
            model.addAttribute("sucursal", sucursal)
            return "editsucursal"
        }
        return "redirect:/sucursal"
    }

    @PostMapping("/sucursal/actualizar/{idSucursal}")
    fun actualizarSucursal(@PathVariable("idSucursal") id: Int,
                           @Valid sucursal: sucursal,
                           result: BindingResult,
                           model: Model): String {
        model.addAttribute("sucursal", sucursal)
        sucursal.id = id
        if (result.hasErrors()) return "editsucursal"
        sucursalService.save(sucursal)
        val allSucursales = sucursalService.findAll().toList()
        model.addAttribute("sucursales", allSucursales)
        return "redirect:/sucursal"
    }

    @GetMapping("/sucursal/borrar/{idSucursal}")
    fun borrarSucursal(@PathVariable("idSucursal") id: Int, model: Model):String{
        sucursalService.findOne(id).ifPresent { sucursalService.delete(it) }
        return "redirect:/sucursal"
    }
}