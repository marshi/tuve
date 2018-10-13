package marshi.android.tuve.di

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.builder()
      .application(this)
      .build()
  }

  override fun onCreate() {
    super.onCreate()
    Stetho.initializeWithDefaults(this)
  }
}
