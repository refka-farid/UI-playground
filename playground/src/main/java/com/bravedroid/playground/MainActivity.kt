package com.bravedroid.playground

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.ui.notifications.toast.ToastHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)
        findViewById<TextView>(R.id.textView_main_messageToaster).setOnClickListener {
            ToastHelper.show(this,"this is a test !!!!!")
        }
    }
}
