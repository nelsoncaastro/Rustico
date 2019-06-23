package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "sucursal")
data class sucursal(
        @Id
        @GeneratedValue(generator = "sucursal_c_sucursal_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "sucursal_c_sucursal_seq", sequenceName = "public.sucursal_c_sucursal_seq", allocationSize = 1)
        @Column(name = "c_sucursal")
        var id: Int = 0,
        @Column(name = "s_nombre")
        var nombre: String = "",
        @Column(name = "s_ubicacion")
        var ubicacion: String = "",
        @Column(name = "s_horario")
        var horarios: String = "",
        @Column(name = "s_nmesas")
        var mesas: Int = 0 ,
        @Column(name = "s_nomgerente")
        var nomGerente: String = "",
        @OneToMany(fetch = FetchType.EAGER, mappedBy = "sucursal")
        var empleados: List<empleado> = listOf()
) {
        fun getApertura() = horarios.split(" ")[0]

        fun getCierre() = horarios.split(" ")[1]
}