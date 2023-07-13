package zegel.ipae.clasesdesarrollo.data.repository

import android.net.Uri
import zegel.ipae.clasesdesarrollo.data.model.Nota
import zegel.ipae.clasesdesarrollo.data.model.Usuario
import zegel.ipae.clasesdesarrollo.util.UiState

interface NotaRepository {
    fun getNotas(usuario: Usuario?, result: (UiState<List<Nota>>) -> Unit)
    fun addNotas(nota: Nota, result: (UiState<Pair<Nota, String>>) -> Unit)
    fun updateNotas(nota: Nota, result: (UiState<String>) -> Unit)
    fun deleteNotas(nota: Nota, result: (UiState<String>) -> Unit)
}