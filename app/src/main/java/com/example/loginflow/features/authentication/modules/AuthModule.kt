package com.example.loginflow.features.authentication.modules

import com.example.loginflow.features.authentication.api.AuthenticationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class AuthModule {

    @Provides
    fun ProviderUserApi(retrofit: Retrofit):AuthenticationApi{
        return retrofit.create(AuthenticationApi::class.java)
    }

}