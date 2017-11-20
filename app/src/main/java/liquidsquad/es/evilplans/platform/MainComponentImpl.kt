package liquidsquad.es.evilplans.platform

import liquidsquad.es.evilplans.MainActivity
import liquidsquad.es.evilplans.MainPresenterImpl

class MainComponentImpl : MainComponent {
    override fun inject(activity: MainActivity) {
        activity.mainPresenter = MainPresenterImpl()

    }

}
