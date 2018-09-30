package marshi.android.tuve.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AndroidSupportInjectionModule::class,
  AppModule::class,
  ApiModule::class,
  ActivityModules::class
])
interface AppComponent : AndroidInjector<App> {

//  @Component.Builder
//  interface Builder {
//    @BindsInstance
//    fun application(application: Application): Builder
//
//    fun build(): AppComponent
//  }
  
  fun build(): AppComponent
  
  override fun inject(instance: App)
  
}
