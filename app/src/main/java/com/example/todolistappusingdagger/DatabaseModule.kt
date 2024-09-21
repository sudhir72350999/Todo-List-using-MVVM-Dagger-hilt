package com.example.todolistappusingdagger

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ToDoDatabase {
        return ToDoDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideToDoDao(database: ToDoDatabase): ToDoDao {
        return database.todoDao()
    }
}
