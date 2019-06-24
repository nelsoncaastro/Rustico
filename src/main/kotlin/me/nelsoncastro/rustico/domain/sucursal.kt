package me.nelsoncastro.rustico.domain

import org.intellij.lang.annotations.RegExp
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Positive

@Entity
@Table(schema = "public", name = "sucursal")
data class sucursal(
        @Id
        @GeneratedValue(generator = "sucursal_c_sucursal_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "sucursal_c_sucursal_seq", sequenceName = "public.sucursal_c_sucursal_seq", allocationSize = 1)
        @Column(name = "c_sucursal")
        var id: Int = 0,
        @Column(name = "s_nombre")
        @field:NotEmpty(message = "Ingrese un nombre que no este vacío")
        @field:NotBlank(message = "Ingrese un nombre que no este en blanco")
        var nombre: String = "",
        @Column(name = "s_ubicacion")
        @field:NotEmpty(message = "Ingrese una ubicación que no este vacía")
        @field:NotBlank(message = "Ingrese una ubicación que no este en blanco")
        var ubicacion: String = "",
        @Column(name = "s_horario")
        @field:NotEmpty(message = "Ingrese un horario que no este vacío")
        @field:NotBlank(message = "Ingrese un horario que no este en blanco")
        @field:Pattern(regexp = "((?:(?:0|1)\\d|2[0-3])):([0-5]\\d) ((?:(?:0|1)\\d|2[0-3])):([0-5]\\d)", message = "Ingrese un horario valido: Inicio Fin")
        var horarios: String = "",
        @Column(name = "s_nmesas")
        @field:Positive
        var mesas: Int = 0,
        @Column(name = "s_nomgerente")
        @field:NotEmpty(message = "Ingrese un gerente que no este vacío")
        @field:NotBlank(message = "Ingrese un gerente que no este en blanco")
        var nomGerente: String = "",
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "sucursal")
        var empleados: List<empleado> = listOf()
) {
        fun getApertura() = horarios.split(" ")[0]

        fun getCierre() = horarios.split(" ")[1]
}