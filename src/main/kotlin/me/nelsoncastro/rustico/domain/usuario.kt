package me.nelsoncastro.rustico.domain

import javax.persistence.*

@Entity
@Table(schema = "public", name = "usuario")
data class usuario(

        @Id
        @GeneratedValue(generator = "usuario_c_usuario_seq",strategy = GenerationType.AUTO)
        @SequenceGenerator(name = "usuario_c_usuario_seq", sequenceName = "public.usuario_c_usuario_seq", allocationSize = 1)
        @Column(name = "c_usuario")
        val id: Int,
        @Column(name = "u_usuario")
        var usuario: String,
        @Column(name = "u_clave")
        var clave: String
)


