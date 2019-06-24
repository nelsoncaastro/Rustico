package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.domain.empleado
import me.nelsoncastro.rustico.service.EmpleadoService
import me.nelsoncastro.rustico.service.SucursalService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@Controller
class EmpleadoController {
    @Autowired
    lateinit var empleadoService: EmpleadoService

    @Autowired
    lateinit var sucursalService: SucursalService

    @RequestMapping("/sucursal/perfil/{idSucursal}/empleado/crear")
    fun crearEmpleado(@PathVariable("idSucursal") idSucursal:Int, model: Model): String{
        model.addAttribute("header", "Crear Empleado")
        model.addAttribute("empleado", empleado())
        model.addAttribute("idSucursal", idSucursal)
        return "editempleado"
    }

    @GetMapping("/sucursal/perfil/{idSucursal}/empleado/editar/{idEmpleado}")
    fun editarEmpleado(@PathVariable("idSucursal") idSucursal:Int,
                       @PathVariable("idEmpleado") idEmpleado: Int,
                       @Valid empleado: empleado,
                       result: BindingResult,
                       model: Model): String {
        val empleadoActual = empleadoService.findOne(idEmpleado)
        if (empleadoActual.isPresent){
            val empleado = empleadoActual.get()
            model.addAttribute("header", "Editar Empleado")
            model.addAttribute("empleado", empleado)
            model.addAttribute("idSucursal", idSucursal)
            return "editempleado"
        }
        return "redirect:/sucursal/perfil/$idSucursal"
    }

    @PostMapping("/sucursal/perfil/{idSucursal}/empleado/actualizar/{idEmpleado}")
    fun actualizarEmpleado(@PathVariable("idSucursal") idSucursal:Int,
                           @PathVariable("idEmpleado") idEmpleado:Int,
                           @Valid empleado: empleado,
                           result: BindingResult,
                           model: Model): String{
        model.addAttribute("header", "Edit Empleado")
        model.addAttribute("empleado", empleado)
        model.addAttribute("idSucursal", idSucursal)
        empleado.id = idEmpleado
        if (result.hasErrors()) return "editempleado"
        empleado.sucursal = sucursalService.findOne(idSucursal).get()
        empleadoService.save(empleado)
        return "redirect:/sucursal/perfil/$idSucursal"
    }

    @GetMapping("/sucursal/perfil/{idSucursal}/empleado/borrar/{idEmpleado}")
    fun borrarEmpleado(@PathVariable("idSucursal") idSucursal: Int, @PathVariable("idEmpleado") idEmpleado: Int, model: Model): String{
        empleadoService.findOne(idEmpleado).ifPresent { empleadoService.delete(it) }
        return "redirect:/sucursal/perfil/$idSucursal"
    }
}