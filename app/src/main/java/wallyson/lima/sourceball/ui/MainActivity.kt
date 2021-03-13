package wallyson.lima.sourceball.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.register.view.*
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

    fun registerFacebook() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.register, null)

        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.buttonLog.setOnClickListener {
            val facebook = it.editTextLogin.text.toString()
            val password = it.editTextPass.text.toString()

            if ( facebook.isNotEmpty() && password.isNotEmpty() ) {
                mAlertDialog.dismiss()
                val intent = Intent(this, OptionsActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.errorlogin), Toast.LENGTH_SHORT).show()
            }

        }
    }
}