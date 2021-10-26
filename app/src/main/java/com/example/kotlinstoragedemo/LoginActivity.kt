package com.example.kotlinstoragedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlinstoragedemo.SQL.DatabaseHelper
import com.example.kotlinstoragedemo.helpers.InputValidation
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var constlay: ConstraintLayout
    private lateinit var textInputLayoutEmail: TextInputLayout
    private lateinit var textInputLayoutPassword: TextInputLayout
    private lateinit var textInputEditTextEmail: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var appCompatButtonLogin: Button
  //  private lateinit var textViewLinkRegister: AppCompatTextView
    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // initializing the objects
        initObjects()
        // hiding the action bar
        supportActionBar!!.hide()
        // initializing the views
        initViews()
        // initializing the listeners
        initListeners()

    }

    private fun initViews() {
        constlay = findViewById(R.id.ll)
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail) as TextInputLayout
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword) as TextInputLayout
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail) as TextInputEditText
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword) as TextInputEditText
        appCompatButtonLogin = findViewById(R.id.appCompatButtonLogin) as Button
        //textViewLinkRegister = findViewById(R.id.textViewLinkRegister) as AppCompatTextView

    }

    private fun initListeners() {
      appCompatButtonLogin!!.setOnClickListener {
          verifyFromSQLite()
      }
    }

    private fun initObjects() {
        databaseHelper = DatabaseHelper(this)
        inputValidation = InputValidation(this)
    }

    private fun verifyFromSQLite() {
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextEmail!!, textInputLayoutEmail!!, getString(R.string.error_message_email))) {
            return
        }
        if (!inputValidation!!.isInputEditTextEmail(textInputEditTextEmail!!, textInputLayoutEmail!!, getString(R.string.error_message_email))) {
            return
        }
        if (!inputValidation!!.isInputEditTextFilled(textInputEditTextPassword!!, textInputLayoutPassword!!, getString(R.string.error_message_email))) {
            return
        }
        if (databaseHelper!!.checkUser(textInputEditTextEmail!!.text.toString().trim { it <= ' ' }, textInputEditTextPassword!!.text.toString().trim { it <= ' ' })) {
           // val accountsIntent = Intent(activity, UsersListActivity::class.java)
            Snackbar.make(constlay!!, getString(R.string.valid_email_password), Snackbar.LENGTH_LONG).show()
            //accountsIntent.putExtra("EMAIL", textInputEditTextEmail!!.text.toString().trim { it <= ' ' })
            emptyInputEditText()
            //startActivity(accountsIntent)
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(constlay!!, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show()
        }
    }
    /**
     * This method is to empty all input edit text
     */
    private fun emptyInputEditText() {
        textInputEditTextEmail!!.text = null
        textInputEditTextPassword!!.text = null
    }
}
