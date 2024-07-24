package com.example.firebaseauth___

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import com.example.firebaseauth___.databinding.ActivityForgetPasswordBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class ForgetPasswordActivity : BaseActivity() {
    private var binding:ActivityForgetPasswordBinding?=null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth= Firebase.auth
        binding?.btnForgotPasswordSubmit?.setOnClickListener {
            resetPassword()
        }
    }

    private fun resetPassword(){
        val email=binding?.etForgotPasswordEmail?.text.toString()
        if (validateForm(email)) {
            showProgressBar()
            auth.sendPasswordResetEmail(email).addOnCompleteListener{task->
                if(task.isSuccessful){
                    hidProgressBar()

                binding?.tilEmailForgetPassword?.visibility= View.GONE
                binding?.tvSubmitMsg?.visibility=View.VISIBLE
                binding?.btnForgotPasswordSubmit?.visibility=View.GONE
                }else{
                    hidProgressBar()
                    showToast(this,"Can't reset your password, Try after sometime")
                }
            }
        }
    }

    private fun validateForm(email: String): Boolean {
        return when {
            TextUtils.isEmpty(email) && !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding?.tilEmailForgetPassword?.error = "Enter valid email address"
                false
            }

            else -> true
        }
    }
        @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
       override fun onBackPressed() {
            super.onBackPressed()
            finish()
    }
}