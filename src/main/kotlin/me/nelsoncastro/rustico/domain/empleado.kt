package me.nelsoncastro.rustico.domain

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Positive

@Entity
@Table(schema = "public", name = "empleado")
data class empleado(
        @Id
        @GeneratedValue(generator = "empleado_c_empleado_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "empleado_c_empleado_seq", sequenceName = "public.empleado_c_empleado_seq", allocationSize = 1)
        @Column(name = "c_empleado")
        var id: Int = 0,
        @Column(name = "e_nombre")
        @field:NotEmpty(message = "Ingrese un nombre que no este vacío")
        @field:NotBlank(message = "Ingrese un nombre que no este en blanco")
        var nombre: String = "",
        @Column(name = "e_edad")
        @field:Positive
        var edad: Int = 0,
        @Column(name = "e_genero")
        @field:NotEmpty(message = "Ingrese un genero que no este vacío")
        @field:NotBlank(message = "Ingrese un genero que no este en blanco")
        var genero: String = "",
        @Column(name = "e_estado")
        var estado: Boolean = false,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "e_sucursal")
        var sucursal: sucursal = sucursal()
) {
        fun getStatus() = if (estado) "Activo" else "Inactivo"
}