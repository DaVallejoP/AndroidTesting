package liquidsquad.es.evilplans.platform

import android.app.Application

class EvilApplication: Application(), ServiceLocator {
    override fun getMainActivityComponent(): MainComponent {
        //Dagger.Builder.build
        return MainComponentImpl()
    }

    override fun onCreate() {
        super.onCreate()
    }
}

