package liquidsquad

import android.app.Application
import liquidsquad.es.evilplans.platform.MainComponent
import liquidsquad.es.evilplans.MainPresenter
import liquidsquad.es.evilplans.platform.ServiceLocator

class EvilApplicationTest : Application(), ServiceLocator {
    lateinit var mpresenter: MainPresenter
    override fun getMainActivityComponent(): MainComponent {
        return MainComponentMockImpl(mpresenter)
    }

}

