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
import com.example.newsapplication.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private lateinit var signBinding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signBinding  = DataBindingUtil.setContentView(this, R.layout.activity_signup)


        signBinding.buttonSignUp.setOnClickListener {
            onLoginClicked()
        }
        signBinding.textViewLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

        signBinding.textUsernameLayout.editText
            ?.addTextChangedListener(createTextWatcher(signBinding.textUsernameLayout))

        signBinding.textPasswordInput.editText
            ?.addTextChangedListener(createTextWatcher(signBinding.textPasswordInput))

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

    private fun showErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Sign In Failed")
            .setMessage("Username or password is not correct. Please try again carefully")
            .setPositiveButton("OK") {dialog, which -> dialog.dismiss()}
            .show()
    }


    private fun onLoginClicked() {
        val username: String = signBinding.textUsernameLayout.editText?.text.toString()
        val password: String = signBinding.textPasswordInput.editText?.text.toString()
        if (username.isEmpty()) {
            signBinding.textUsernameLayout.error = "Username must not be empty"
        } else if (password.isEmpty()) {
            signBinding.textPasswordInput.error = "Password must not be empty"
        }else if (username != "Oluwole" && password != "Ajayi") {
            showErrorDialog()
        }else {
            performSignIn()
        }
    }

    private fun performSignIn() {
        signBinding.textUsernameLayout.isEnabled = false
        signBinding.textPasswordInput.isEnabled = false
        signBinding.buttonSignUp.visibility = View.INVISIBLE
        signBinding.progressBar.visibility = View.VISIBLE

        Handler().postDelayed({
            startHomePageActivity()
            finish()
        }, 2000)
    }

    private fun startHomePageActivity() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }


}