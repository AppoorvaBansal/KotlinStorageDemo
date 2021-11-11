package com.example.kotlinstoragedemo.FireBaseLoginAuth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinstoragedemo.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_fbregister.*

class FBRegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fbregister)

        auth = FirebaseAuth.getInstance()
        appCompatButtonRegister.setOnClickListener {

            var email=textInputEditTextEmail.text.toString()
            var pass=textInputEditTextPassword.text.toString()
            var confirPass=textInputEditTextConfirmPassword.text.toString()


            if(check(email)){

            }
            else if(check(pass)){

            }
            else if(check(confirPass)){

            }

            else if(pass!=confirPass)
            {
                Toast.makeText(this,"PASSWORD DOESNT MATCH",Toast.LENGTH_LONG).show()
            }
            else{
                // adding the user

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {

                    if(it.isSuccessful)
                    {
                        Toast.makeText(this,"DATA SAVED",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Toast.makeText(this,it.exception!!.localizedMessage,Toast.LENGTH_LONG).show()
                    }
                }



            }


        }

    }


    fun check(ed:String):Boolean
    {
        if(ed=="")
        {
            Toast.makeText(this,"ENTER THE DATA",Toast.LENGTH_LONG).show()
            return true
        }
        else
        return false
    }


}
