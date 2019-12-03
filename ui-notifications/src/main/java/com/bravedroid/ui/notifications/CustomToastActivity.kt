package com.bravedroid.ui.notifications

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_custom_toast.*

class CustomToastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        val callback: (View) -> Unit = {
            when (it.id) {
                R.id.buttonSuccessToast -> showToast(ToastType.SUCCESS, "Success Toast")
                R.id.buttonErrorToast -> showToast(ToastType.ERROR, "Error Toast")
                R.id.buttonWarningToast -> showToast(ToastType.WARNING, "Warning Toast")
            }
        }
        buttonSuccessToast.setOnClickListener(callback)
        buttonErrorToast.setOnClickListener(callback)
        buttonWarningToast.setOnClickListener(callback)
    }

    private fun showToast(toastType: ToastType, message: CharSequence) {

        val toastView = layoutInflater.inflate(R.layout.layout_toast, null)
        when (toastType) {
            ToastType.SUCCESS -> {
                fillToast(toastView, R.drawable.toast_success_background,
                        R.drawable.ic_success,
                        message)
            }
            ToastType.WARNING -> {
                fillToast(toastView, R.drawable.toast_warning_background,
                        R.drawable.ic_warning,
                        message)
            }
            ToastType.ERROR -> {
                fillToast(toastView, R.drawable.toast_error_background,
                        R.drawable.ic_error,
                        message)
            }
        }
        with(Toast(this)) {
            duration = Toast.LENGTH_LONG
            view = toastView
            show()
        }
    }

    private fun fillToast(
            toastView: View,
            toastBackground: Int,
            iconResource: Int,
            message: CharSequence) {

        val toastContainer = toastView.findViewById<LinearLayout>(R.id.layoutToastContainer)
        val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
        val textMessage = toastView.findViewById<TextView>(R.id.textMessage)

        toastContainer.setBackgroundResource(toastBackground)
        imageIcon.setImageResource(iconResource)
        textMessage.text = message
    }
}
