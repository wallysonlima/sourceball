package wallyson.lima.sourceball.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import wallyson.lima.sourceball.R

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val handle = Handler()

        handle.postDelayed({
            showLogin()
        }, 4000)
    }

    fun showLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}