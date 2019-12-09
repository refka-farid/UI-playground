package com.bravedroid.playground.notifications

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.playground.R
import com.bravedroid.ui.notifications.toast.showErrorToast
import com.bravedroid.ui.notifications.toast.showSuccessToast
import com.bravedroid.ui.notifications.toast.showWarningToast
import kotlinx.android.synthetic.main.activity_toast.*

class ToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        val callback: (View) -> Unit = {
            when (it.id) {
                R.id.buttonSuccessToast -> showSuccessToast(this, "Success Toast")
                R.id.buttonErrorToast -> showWarningToast(this, "Error Toast")
                R.id.buttonWarningToast -> showErrorToast(this, "Warning Toast")
            }
        }
        buttonSuccessToast.setOnClickListener(callback)
        buttonErrorToast.setOnClickListener(callback)
        buttonWarningToast.setOnClickListener(callback)
    }
}
