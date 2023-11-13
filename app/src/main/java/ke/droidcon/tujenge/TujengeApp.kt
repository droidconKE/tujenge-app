package ke.droidcon.tujenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TujengeApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}