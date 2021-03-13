package wallyson.lima.sourceball.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import wallyson.lima.sourceball.R

class MainActivity : AppCompatActivity() {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var textViewRegister: TextView
    private lateinit var editTextFacebook: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        btnClean.setOnClickListener {
            editTextFacebook.setText("")
            editTextPassword.setText("")
        }
    }

    fun initialize() {
        btnClean = findViewById(R.id.buttonClean)
        btnLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)
        editTextFacebook = findViewById(R.id.editTextFacebook)
        editTextPassword = findViewById(R.id.editTextPassword)
    }
}