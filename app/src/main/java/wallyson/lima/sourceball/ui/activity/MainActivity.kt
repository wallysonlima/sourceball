package wallyson.lima.sourceball.ui.activity

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
import wallyson.lima.sourceball.database.dao.AppDatabase
import wallyson.lima.sourceball.repository.MainRepository
import wallyson.lima.sourceball.ui.viewmodel.factory.MainViewModelFactory
import androidx.lifecycle.ViewModelProviders
import wallyson.lima.sourceball.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var btnClean: Button
    private lateinit var btnLogin: Button
    private lateinit var textViewRegister: TextView
    private lateinit var editTextLogin: EditText
    private lateinit var editTextPassword: EditText

    private val viewModel by lazy {
        val repository = MainRepository(AppDatabase.getInstance(this)?.userDao)
        val factory = MainViewModelFactory(repository)
        val provedor = ViewModelProviders.of(this, factory)
        provedor.get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        btnClean.setOnClickListener {
            editTextLogin.setText("")
            editTextPassword.setText("")
        }

        textViewRegister.setOnClickListener {
            register()
        }

        btnLogin.setOnClickListener {

        }
    }

    fun login () {
        if ( isEmpty( editTextLogin.text.toString(), editTextPassword.text.toString() ) ) {
            openOptionsActivity()
        } else {
            Toast.makeText(this, getString(R.string.errorlogin), Toast.LENGTH_SHORT).show()
        }
    }

    fun initialize() {
        btnClean = findViewById(R.id.buttonClean)
        btnLogin = findViewById(R.id.buttonLogin)
        textViewRegister = findViewById(R.id.textViewRegister)
        editTextLogin = findViewById(R.id.editTextFacebook)
        editTextPassword = findViewById(R.id.editTextPassword)
    }

    fun register() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.register, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.buttonLog.setOnClickListener {
            val login = it.editTextLogin.text.toString()
            val password = it.editTextPass.text.toString()

            if ( isEmpty(login, password) ) {
                mAlertDialog.dismiss()
                insertUser(login, password)
                openOptionsActivity()
            } else {
                Toast.makeText(this, getString(R.string.errorlogin), Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun isEmpty(login: String, password: String) =
        login.isNotEmpty() && password.isNotEmpty()

    private fun openOptionsActivity() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

    private fun insertUser(login: String, password: String) {
        val user = viewModel.getUser(login)

        if (user.getName().isNotEmpty())
            viewModel.inserUser(login, password)
        else
            Toast.makeText(this, getString(R.string.userexist), Toast.LENGTH_SHORT).show()
    }
}