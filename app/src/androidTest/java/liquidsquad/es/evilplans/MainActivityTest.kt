package liquidsquad.es.evilplans

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import liquidsquad.EvilApplicationTest
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class MainActivityTest {

    lateinit var presenter:MainPresenterMock
    lateinit var sut:MainActivity

    @get:Rule
    val testRule = object :ActivityTestRule<MainActivity>(MainActivity::class.java,false,false){
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            val app = InstrumentationRegistry.getTargetContext().applicationContext as EvilApplicationTest
            app.mpresenter = presenter
        }
    }

    @Before
    fun setUp() {
        presenter = MainPresenterMock()
        sut = testRule.launchActivity(Intent(Intent.ACTION_MAIN))
    }

    @After
    fun tearDown() {
    }


    inner class MainPresenterMock : MainPresenter{
        var isReadyCalled = false
        override fun isReady() {
            isReadyCalled = true
        }

    }

    @Test
    fun presenterIsReadyAfterActivityOnCreate() {
        //Arrange
        //Act
        //Assert
        assertTrue(presenter.isReadyCalled)
    }

}
