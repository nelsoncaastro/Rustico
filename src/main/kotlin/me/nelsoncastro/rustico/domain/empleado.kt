package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "empleado")
data class empleado(
        @Id
        @GeneratedValue(generator = "empleado_código_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "empleado_código_seq", sequenceName = "public.empleado_código_seq", allocationSize = 1)
        @Column(name = "código")
        val id: Int,
        var nombre: String,
        var edad: Int,
        var genero: String,
        var estado: Boolean,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "sucursal")
        var sucursal: Int
) {
}