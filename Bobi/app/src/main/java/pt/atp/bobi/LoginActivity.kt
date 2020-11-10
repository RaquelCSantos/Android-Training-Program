package pt.atp.bobi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Console

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setup()
    }

    private fun setup() {
        findViewById<Button>(R.id.btn_auth).setOnClickListener {
            if(areCredentialsValid()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun areCredentialsValid(): Boolean{
        val username = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
        if (username.isEmpty()) {
            findViewById<TextView>(R.id.tv_error).visibility = View.VISIBLE
            return false
        }
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
        if (password.isEmpty()) {
            findViewById<TextView>(R.id.tv_error).visibility = View.VISIBLE
            return false
        }
        return username == password
    }
}