package com.mainp.demo

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val btnCreatAcc = findViewById<AppCompatButton>(R.id.btnCreatAcc)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        ivBack.setOnClickListener{
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
           finish()
        }

        btnCreatAcc.setOnClickListener{
            val firstName = etFirstName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInputs(firstName, lastName, email, password)) {
                Toast.makeText(this, "Creat account success!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("EMAIL_ID", email)
                startActivity(intent)
                finish()
            }
        }
    }
    private fun validateInputs(firstName: String, lastName: String, email: String, password: String): Boolean {
        when {
            firstName.isEmpty() -> {
                showToast("First name must not be empty")
                return false
            }
            lastName.isEmpty() -> {
                showToast("Last name must not be empty")
                return false
            }
            email.isEmpty() -> {
                showToast("Email must not be empty")
                return false
            }
            !isValidEmail(email) -> {
                showToast("Email is not valid")
                return false
            }
            password.isEmpty() -> {
                showToast("Password must not be empty")
                return false
            }
            else -> return true
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
        return emailPattern.matcher(email).matches()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}