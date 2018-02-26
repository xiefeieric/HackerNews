package me.feixie.hackernews.dagger2

import dagger.Component
import dagger.Module
import dagger.Provides
import me.feixie.hackernews.api.Service
import javax.inject.Singleton

@Module
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideService(): Service = Service
}

@Component(modules = [ApiServiceModule::class])
@Singleton
interface ServiceComponent {
    fun injectService():Service
}