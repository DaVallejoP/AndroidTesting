package liquidsquad.es.evilplans

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import liquidsquad.es.evilplans.platform.ServiceLocator

class MainActivity : AppCompatActivity() , MainView {
    override fun activateLoginButton(b: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var b: Button
    lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        (application as ServiceLocator).getMainActivityComponent().inject(this)

        b = buttonLogin

        b.setOnClickListener{

        }
        editTextUsername.addTextChangedListener(
                object : TextWatcher{
                    override fun afterTextChanged(p0: Editable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                }
        )
        editTextPasswd.addTextChangedListener(
                object : TextWatcher{
                    override fun afterTextChanged(p0: Editable?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                }
        )

        mainPresenter.isReady()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
