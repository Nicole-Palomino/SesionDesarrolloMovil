package zegel.ipae.clasesdesarrollo.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import zegel.ipae.clasesdesarrollo.util.SharedPrefConstants
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class, RepositoryModule::class])
object AppModule {
    @Provides
    @Singleton
    fun providesSharedPref(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences(SharedPrefConstants.LOCAL_SHARED_PREF, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson{
        return Gson()
    }

    // Puedes agregar más dependencias necesarias para la inyección de dependencias
}