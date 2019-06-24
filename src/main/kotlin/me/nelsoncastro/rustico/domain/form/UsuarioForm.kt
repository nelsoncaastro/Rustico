package me.nelsoncastro.rustico.domain.form

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UsuarioForm (
        @field:Email
        @field:NotEmpty(message = "Ingrese un usuario")
        @field:NotBlank(message = "Ingrese un usuario valido")
        @field:Size(min = 8, message = "El usuario debe contener al menos 8 caracteres")
        var usuario: String = "",

        @field:NotEmpty(message = "Ingrese una contraseña")
        @field:NotBlank(message = "Ingrese una contraseña valida")
        @field:Size(min = 8, message = "La contraseña debe contener al menos 8 caracteres")
        var clave: String = ""
)