package com.bravedroid.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

fun showToast(context: Context, toastType: ToastType, message: CharSequence) {
    val toastView = LayoutInflater.from(context).inflate(R.layout.layout_toast, null)
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
    with(Toast(context)) {
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
