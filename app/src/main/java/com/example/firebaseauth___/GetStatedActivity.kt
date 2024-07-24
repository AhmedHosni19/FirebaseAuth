package com.example.firebaseauth___

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauth___.databinding.ActivityGetStatedBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class GetStatedActivity : AppCompatActivity() {
    private var binding:ActivityGetStatedBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGetStatedBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.cvGetStarted?.setOnClickListener{
            startActivity(Intent(this,SignInActivity::class.java))
            finish()
        }
        val auth= Firebase.auth
        if (auth.currentUser != null) {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }
}