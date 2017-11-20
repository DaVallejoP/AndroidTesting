package liquidsquad

import liquidsquad.es.evilplans.MainActivity
import liquidsquad.es.evilplans.platform.MainComponent
import liquidsquad.es.evilplans.MainPresenter

class MainComponentMockImpl(val presenter:MainPresenter): MainComponent {

    override fun inject(activity: MainActivity) {
        activity.mainPresenter = presenter
    }
}