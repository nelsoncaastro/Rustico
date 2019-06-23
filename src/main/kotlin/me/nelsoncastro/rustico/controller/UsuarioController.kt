package me.nelsoncastro.rustico.controller

import me.nelsoncastro.rustico.domain.form.UsuarioForm
import me.nelsoncastro.rustico.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.validation.Valid

@Controller
class UsuarioController {
    @Autowired
    lateinit var usuarioService: UsuarioService

    @RequestMapping("/")
    fun entry(model: Model): String {
        model.addAttribute("usuarioForm", UsuarioForm())
        return "login"
    }

    @RequestMapping("/login", method = [RequestMethod.POST])
    fun login(@Valid usuarioForm: UsuarioForm, result: BindingResult, model: Model): String {
        return if (result.hasErrors()){
            model.addAttribute("usuarioForm", usuarioForm)
            "login"
        }else{
            val usuarioResultante = usuarioService.login(usuarioForm.usuario, usuarioForm.clave)
            val usuarioExiste = usuarioResultante.isPresent
            if (usuarioExiste){
                model.addAttribute("Logeado", usuarioForm.usuario)
                "redirect:/sucursal"
            }
            else{
                model.addAttribute("errorLogin", "Usuario no encontrado")
                "login"
            }
        }
    }
}