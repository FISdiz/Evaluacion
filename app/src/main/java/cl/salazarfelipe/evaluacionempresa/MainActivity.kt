package cl.salazarfelipe.evaluacionempresa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.salazarfelipe.evaluacionempresa.view.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_container, MenuFragment.newInstance("", ""), "Menu")
                .commit()
        } else {
            supportFragmentManager.findFragmentByTag("Menu")
        }
    }
}