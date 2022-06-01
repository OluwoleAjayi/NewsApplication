package com.example.newsapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newsapplication.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        loginBinding.button2.setOnClickListener {
            onLoginClicked()
        }

        loginBinding.textUsernameLayout.editText
            ?.addTextChangedListener(createTextWatcher(loginBinding.textUsernameLayout))

        loginBinding.textPasswordInput.editText
            ?.addTextChangedListener(createTextWatcher(loginBinding.textPasswordInput))



    }

    private fun createTextWatcher(textPasswordInput: TextInputLayout): TextWatcher? {

        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence,
                                           start: Int, count: Int, after: Int) {
                // not needed
            }

            override fun onTextChanged(s: CharSequence,
                                       start: Int, before: Int, count: Int) {
                textPasswordInput.error = null
            }

            override fun afterTextChanged(s: Editable) {
                // not needed
            }
        }
    }


    private fun onLoginClicked() {
        val username: String = loginBinding.textUsernameLayout.editText?.text.toString()
        val password: String = loginBinding.textPasswordInput.editText?.text.toString()
        if (username.isEmpty()) {
            loginBinding.textUsernameLayout.error = "Email must not be empty"
        } else if (password.isEmpty()) {
            loginBinding.textPasswordInput.error = "Password must not be empty"
        }else if (username != "Oluwole" && password != "Ajayi") {
            showErrorDialog()
        }else {
            performLogIn()
        }
    }

    private fun performLogIn() {
        loginBinding.textUsernameLayout.isEnabled = false
        loginBinding.textPasswordInput.isEnabled = false
        loginBinding.button2.visibility = View.INVISIBLE
        loginBinding.progressBar.visibility = View.VISIBLE

        Handler().postDelayed({
            startHomePageActivity()
            finish()
        }, 2000)
    }

    private fun startHomePageActivity() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }

    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Log In Failed")
            .setMessage("Email or password is not correct. Please try again carefully")
            .setPositiveButton("OK") {dialog, which -> dialog.dismiss()}
            .show()

    }
}