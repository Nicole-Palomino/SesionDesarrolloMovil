package zegel.ipae.clasesdesarrollo.data.model

import java.util.Date

data class Nota (
    var uid: String = "",
    val titulo: String = "",
    val usuario_id: String = "",
    val descripcion: String = "",
    val fecha: Date = Date()
)