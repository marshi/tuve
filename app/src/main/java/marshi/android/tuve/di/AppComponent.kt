package marshi.android.tuve.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import marshi.android.tuve.repository.database.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  AppModule::class,
  ApiModule::class,
  ActivityModules::class,
  DatabaseModule::class
])
interface AppComponent : AndroidInjector<App> {

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }
  
  fun build(): AppComponent

  override fun inject(instance: App)
  
}
