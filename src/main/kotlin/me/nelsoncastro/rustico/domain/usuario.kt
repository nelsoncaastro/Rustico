package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "usuario")
data class usuario(

        @Id
        @GeneratedValue(generator = "usuario_id_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "usuario_id_seq", sequenceName = "public.usuario_id_seq", allocationSize = 1)
        val id: Int,
        var usuario: String,
        var clave: String
)


