package liquidsquad

import android.app.Application
import android.content.Context
import com.github.tmurakami.dexopener.DexOpenerAndroidJUnitRunner

class RunnerX : DexOpenerAndroidJUnitRunner(){
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, EvilApplicationTest::class.java.name, context)
    }

}