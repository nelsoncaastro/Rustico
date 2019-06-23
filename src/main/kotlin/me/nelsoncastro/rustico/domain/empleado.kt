package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "empleado")
data class empleado(
        @Id
        @GeneratedValue(generator = "empleado_c_empleado_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "empleado_c_empleado_seq", sequenceName = "public.empleado_c_empleado_seq", allocationSize = 1)
        @Column(name = "c_empleado")
        val id: Int,
        @Column(name = "e_nombre")
        var nombre: String,
        @Column(name = "e_edad")
        var edad: Int,
        @Column(name = "e_genero")
        var genero: String,
        @Column(name = "e_estado")
        var estado: Boolean,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "e_sucursal")
        var sucursal: sucursal
) {
        fun getStatus() = if (estado) "Activo" else "Inactivo"
}