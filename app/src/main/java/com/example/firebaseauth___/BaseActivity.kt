package com.example.firebaseauth___

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

open class BaseActivity : AppCompatActivity() {
    private lateinit var pb:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

    fun showProgressBar(){
        pb=Dialog(this)
        pb.setContentView(R.layout.progressbar)
        pb.setCancelable(false)
        pb.show()
    }

    fun hidProgressBar(){
        pb.hide()
    }

    fun showToast(activity: Activity,msg:String){
        Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show()
    }
}