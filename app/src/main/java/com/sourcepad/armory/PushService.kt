package com.sourcepad.armory

import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PushService: FirebaseMessagingService(){


    override fun onNewToken(p0: String) {
        Log.d("Armory", "New Token:$p0")

        super.onNewToken(p0)

    }

    override fun onMessageReceived(p0: RemoteMessage) {
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                Toast.makeText(applicationContext, "Notification received", Toast.LENGTH_LONG).show()
            }
        }
        super.onMessageReceived(p0)
    }
}