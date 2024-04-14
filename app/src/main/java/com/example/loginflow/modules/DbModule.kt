package com.example.loginflow.modules

import android.content.Context
import androidx.room.Room
import com.example.loginflow.appDB.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DbModule() {

    @Provides
    fun providesDbService(@ApplicationContext context: Context):AppDB {
        return Room.databaseBuilder(
            context,
            AppDB::class.java, "appDB"
        ).build()
    }
}