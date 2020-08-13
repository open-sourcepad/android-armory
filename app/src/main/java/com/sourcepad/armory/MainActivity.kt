package com.sourcepad.armory

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.sourcepad.armory.android.R
import com.sourcepad.armory.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        retrieveFirebaseToken()
    }

    private fun retrieveFirebaseToken() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                binding.textView.setText(token)
                // Log and toast
                Log.d(TAG, "Armory token: $token")
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
