package liquidsquad.es.evilplans

import android.util.Log

class MainPresenterImpl : MainPresenter{
    lateinit var mainActivity:MainView
    override fun isReady() {
        Log.d("MainPresenterImpl","isReady")
    }


}