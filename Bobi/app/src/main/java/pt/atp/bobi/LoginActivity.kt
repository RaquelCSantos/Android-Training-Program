package pt.atp.bobi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setup()
    }

    private fun setup() {
        findViewById<Button>(R.id.btn_authenticate).setOnClickListener {
            validateCredentialsAndRedirect()
        }
    }

    private fun validateCredentialsAndRedirect() {
        if (areCredentialsValid()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun areCredentialsValid(): Boolean {
        val username = findViewById<TextInputEditText>(R.id.tet_username).text.toString()
        if (username.isEmpty()) {
            findViewById<TextView>(R.id.tv_error).text = getString(R.string.error_credentials_empty_username)
            return false
        }

        val password = findViewById<TextInputEditText>(R.id.tet_password).text.toString()
        if (password.isEmpty()) {
            findViewById<TextView>(R.id.tv_error).text = getString(R.string.error_credentials_empty_password)
            return false
        }

        val valid = username == password
        if (!valid) {
            findViewById<TextView>(R.id.tv_error).text = getString(R.string.error_credentials_mismatch)
        }

        return valid
    }
}