package com.example.firebaseauth___

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauth___.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private var binding:ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        auth= Firebase.auth

        binding?.btnSignOut?.setOnClickListener{
            if (auth.currentUser!=null){
                auth.signOut()
                startActivity(Intent(this,GetStatedActivity::class.java))
                finish()
            }
        }
    }
}