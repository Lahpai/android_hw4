package com.example.signin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_create_new_account.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var user1 = User("Dave", "DeGea", "dave@gmail.com", "123")
    var user2 = User("Bruno", "Fernandez", "bruno@gmail.com", "456")
    var user3 = User("Marcus", "Rashford", "rash@gmail.com", "789")
    var user4 = User("Cristino", "Ronaldo", "ronaldo@gmail.com", "147")
    var user5 = User("Antony", "Santos", "antony@gmail.com", "369")
    var usersList = arrayListOf<User>(user1, user2, user3, user4, user5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)


        signin.setOnClickListener {
            var email = email.text.toString()
            var pw = password.text.toString()

            for (user: User in usersList) {
                if(user.emailId == email && user.passwordId ==pw) {
                    val signinIntent = Intent(this, ShoppingCategory::class.java)
                    signinIntent.putExtra("email", email)
                  //  signinIntent.putExtra("user",user)
                    startActivity(signinIntent)
                    Toast.makeText(this, "User and Password are correct.",Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this,"User and Password are invalid.", Toast.LENGTH_LONG).show()
                }
            }
        }

        var resContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                var user: User? = it.data?.getSerializableExtra("user") as User

                user?.let {
                    usersList.add(user)
                }
            }
        }

        newAcc.setOnClickListener {
            val newaccIntent = Intent(this, CreateNewAccount::class.java)
            resContracts.launch((newaccIntent))
        }

        forgetPw.setOnClickListener{
            val email =  email.text.toString()
            for (user: User in usersList) {
                if (user.emailId == email) {
                    val mIntent = Intent(Intent.ACTION_SEND)
                    mIntent.data = Uri.parse("mailto:")
                    mIntent.type = "text/plain"
                    mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    mIntent.putExtra(Intent.EXTRA_SUBJECT, "Reset Password")
                    mIntent.putExtra(Intent.EXTRA_TEXT, user.passwordId)
                    startActivity(Intent.createChooser(mIntent, "Please Chose Application"))
                }

            }

        }
    }
}