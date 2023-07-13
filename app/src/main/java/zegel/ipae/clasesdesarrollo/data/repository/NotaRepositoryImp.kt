package zegel.ipae.clasesdesarrollo.data.repository

import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import zegel.ipae.clasesdesarrollo.data.model.Nota
import zegel.ipae.clasesdesarrollo.data.model.Usuario
import zegel.ipae.clasesdesarrollo.util.FireStoreCollection
import zegel.ipae.clasesdesarrollo.util.FireStoreDocumentField
import zegel.ipae.clasesdesarrollo.util.UiState

class NotaRepositoryImp(val database: FirebaseStorage, val storageReference: StorageReference): NotaRepository {
    override fun getNotas(usuario: Usuario?, result: (UiState<List<Nota>>) -> Unit) {

        database.collection(FireStoreCollection.NOTA)
            .whereEqualTo(FireStoreDocumentField.USUARIO_ID, usuario?.uid)
            .orderBy(FireStoreDocumentField.FECHA, Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener{
                val notas = arrayListOf<Nota>()
                for(document in it){
                    val nota = document.toObject(Nota::class.java)
                    notas.add(nota)
                }
                result.invoke(
                    UiState.Success(notas)
                )
            }
            .addOnFailureListener{
                result.invoke(
                    UiState.Faile(
                        it.localizedMessage
                    )
                )
            }

    }

    override fun addNotas(nota: Nota, result: (UiState<Pair<Nota, String>>) -> Unit) {
        val document = database.collection(FireStoreCollection.NOTA).document()
        nota.uid = document.id
        document
            .set(nota)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(nota, "Nota a sido creada con exito"))
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Faile(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun updateNotas(nota: Nota, result: (UiState<String>) -> Unit) {
        val document = database.collection(FireStoreCollection.NOTA).document(nota.uid)
        document
            .set(nota)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success( "Nota a sido actualizada con exito")
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Faile(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun deleteNotas(nota: Nota, result: (UiState<String>) -> Unit) {
        val document = database.collection(FireStoreCollection.NOTA).document(nota.uid)
        document
            .set(nota)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success( "Nota a sido actualizada con exito")
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Faile(
                        it.localizedMessage
                    )
                )
            }
    }
}
