package com.example.kotlinstoragedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlinstoragedemo.SQL.DatabaseHelper
import com.example.kotlinstoragedemo.SQL.User
import com.example.kotlinstoragedemo.helpers.InputValidation
import com.google.android.material.snackbar.Snackbar

class SignUpActivity : AppCompatActivity(),View.OnClickListener {
    private  var textInputEditTextName: EditText?=null
    private  var textInputEditTextEmail: EditText?=null
    private  var textInputEditTextPassword:EditText?=null
    private  var textInputEditTextConfirmPassword: EditText?=null
    private var appCompatButtonRegister: Button?=null
    private var appCompatButtonlogin: Button?=null
//    private lateinit var appCompatTextViewLoginLink: TextView
    private lateinit var inputValidation: InputValidation
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var constlay: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
// hiding the action bar
        supportActionBar!!.hide()

        // initializing the views
        initViews()
        initObjects()
        // initializing the listeners
        initListeners()

        // initializing the objects

appCompatButtonlogin!!.setOnClickListener {

    val intent=Intent(this,LoginActivity::class.java)
    startActivity(intent)
}



    }

    private fun initObjects() {
        constlay = findViewById(R.id.constLay)
        textInputEditTextName = findViewById(R.id.textInputEditTextName)
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        textInputEditTextConfirmPassword = findViewById(R.id.textInputEditTextConfirmPassword)
        appCompatButtonRegister=findViewById(R.id.appCompatButtonRegister)
        appCompatButtonlogin=findViewById(R.id.btnlogin)

    }

    private fun initListeners() {
       appCompatButtonRegister!!.setOnClickListener(this)
    }

    private fun initViews() {
        inputValidation = InputValidation(this)
        databaseHelper = DatabaseHelper(this)


    }

    override fun onClick(v: View)
    {
        when (v.id) {

            R.id.appCompatButtonRegister -> postDataToSQLite()

          //  R.id.appCompatTextViewLoginLink -> finish()
        }
    }

    private fun postDataToSQLite() {
        if (!databaseHelper!!.checkUser(textInputEditTextEmail!!.text.toString().trim())) {

            var user = User(name = textInputEditTextName!!.text.toString().trim(),
                email = textInputEditTextEmail!!.text.toString().trim(),
                password = textInputEditTextPassword!!.text.toString().trim())

            databaseHelper!!.addUser(user)

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(constlay!!, getString(R.string.success_message), Snackbar.LENGTH_LONG).show()
            emptyInputEditText()


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(constlay!!, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun emptyInputEditText() {
        textInputEditTextName!!.text = null
        textInputEditTextEmail!!.text = null
        textInputEditTextPassword!!.text = null
        textInputEditTextConfirmPassword!!.text = null
    }
}
