package marshi.android.feedpond.di

import dagger.Module
import marshi.android.feedpond.di.activity.MainActivityModuleBuilder

@Module(includes = [MainActivityModuleBuilder::class])
interface ActivityModules
