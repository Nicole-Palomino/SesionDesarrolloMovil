package zegel.ipae.clasesdesarrollo.di

import dagger.Module
import zegel.ipae.clasesdesarrollo.data.repository.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideNotaRepository(database: FirebaseStorage, storageReference: StorageReference): NotaRepository{
        return NotaRepositoryImp(database, storageReference)
    }
    // puedes definir los proveedores de dependencias relacionados con los repositorios de tu aplicación utilizando anotaciones de Dagger
}