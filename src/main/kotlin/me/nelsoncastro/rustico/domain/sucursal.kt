package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "sucursal")
data class sucursal(
        @Id
        @GeneratedValue(generator = "sucursal_código_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "sucursal_código_seq", sequenceName = "public.sucursal_código_seq", allocationSize = 1)
        @Column(name = "código")
        val id: Int,
        var nombre: String,
        @Column(name = "ubicación")
        var ubicacion: String,
        var horarios: Array<String>,
        var nMesas: Int,
        var nomGerente: String
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false
                other as sucursal
                if (!horarios.contentEquals(other.horarios)) return false
                return true
        }

        override fun hashCode(): Int {
                return horarios.contentHashCode()
        }
}