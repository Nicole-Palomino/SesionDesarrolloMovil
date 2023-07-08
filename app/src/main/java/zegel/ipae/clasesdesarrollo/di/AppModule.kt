package zegel.ipae.clasesdesarrollo.di

import dagger.Module

@Module(includes = [FirebaseModule::class, RepositoryModule::class])
object AppModule {
    // Puedes agregar más dependencias necesarias para la inyección de dependencias
}