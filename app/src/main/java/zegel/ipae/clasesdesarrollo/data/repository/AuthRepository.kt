package zegel.ipae.clasesdesarrollo.data.repository

import zegel.ipae.clasesdesarrollo.data.model.Usuario
import zegel.ipae.clasesdesarrollo.util.UiState

interface AuthRepository {
    fun registerUsuario(correo: String, contrasena: String, usuario: Usuario, result: (UiState<String>) -> Unit)
    fun actualizarUsuario(usuario: Usuario, result: (UiState<String>) -> Unit)
    fun loginUsuario (correo: String, contrasena: String, result: (UiState<String>) -> Unit)
    fun recuperarContrasena( correo: String, result: (UiState<String>) -> Unit)
    fun cerrarSesion(result: () -> Unit)
    fun AlmacenamientoSesion(id: String, result: (Usuario?) -> Unit)
    fun getSesion(result: (Usuario?) -> Unit)
}