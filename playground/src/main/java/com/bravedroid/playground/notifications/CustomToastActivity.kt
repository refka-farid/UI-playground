package com.bravedroid.playground.notifications

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.playground.R
import com.bravedroid.ui.notifications.toast.ToastType
import com.bravedroid.ui.notifications.toast.showToast
import kotlinx.android.synthetic.main.activity_custom_toast.*

class CustomToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        val callback: (View) -> Unit = {
            when (it.id) {
                R.id.buttonSuccessToast -> showToast(this, ToastType.SUCCESS, "Success Toast")
                R.id.buttonErrorToast -> showToast(this, ToastType.ERROR, "Error Toast")
                R.id.buttonWarningToast -> showToast(this, ToastType.WARNING, "Warning Toast")
            }
        }
        buttonSuccessToast.setOnClickListener(callback)
        buttonErrorToast.setOnClickListener(callback)
        buttonWarningToast.setOnClickListener(callback)
    }
}
