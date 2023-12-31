package zegel.ipae.clasesdesarrollo.util

object FireStoreCollection{
    val NOTA = "nota"
    val USUARIO = "usuario"
}

object FireStoreDocumentField{
    val FECHA = "fecha"
    val USUARIO_ID = "usuario_id"
}

object SharedPrefConstants{
    val LOCAL_SHARED_PREF = "local_shared_pref"
    val USUARIO_SESION = "usuario_sesion"
}

object FirebaseStorageConstants{
    val ROOT_DIRECTORY = "app"
    val NOTA_IMAGEN = "nota_imagen"
}

enum class HomeTabs(val index:Int, val key: String){
    NOTAS(0, "notas"),
    TAREAS(1, "tareas")
}