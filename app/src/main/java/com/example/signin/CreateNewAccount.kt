package com.example.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_new_account.*

class CreateNewAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_account)

        btnacc.setOnClickListener {
            var fn = editTextfname.text.toString().trim()
            var ln = editTextlname.text.toString().trim()
            var email = editTextemail.text.toString().trim()
            var pw = editTextpassword.text.toString().trim()

            if (fn.isEmpty() || ln.isEmpty() || email.isEmpty() || pw.isEmpty()) {
                if (fn.isEmpty())
                    editTextfname.error = "Please Enter First Name "

                if (ln.isEmpty())
                    editTextlname.error = "Please Enter Last Name"

                if(email.isEmpty())
                    editTextemail.error = "Please Enter Email"

                if(email.isEmpty())
                    editTextpassword.error = "Please Enter Password"
            } else {
                var user = User (fn,ln,email,pw)
                intent.putExtra("user", user)

                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}