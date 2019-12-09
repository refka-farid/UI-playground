package com.bravedroid.ui.notifications.toast

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bravedroid.ui.notifications.R

fun showErrorToast(context: Context, message: CharSequence) {
    with(Toast(context)) {
        duration = Toast.LENGTH_LONG
        view =  createToastView(context,R.drawable.toast_error_background,
                R.drawable.ic_error,
                message)
        show()
    }
}

fun showWarningToast(context: Context, message: CharSequence) {
    with(Toast(context)) {
        duration = Toast.LENGTH_LONG
        view =   createToastView(context,R.drawable.toast_warning_background,
                R.drawable.ic_warning,
                message)
        show()
    }
}

fun showSuccessToast(context: Context, message: CharSequence) {
    with(Toast(context)) {
        duration = Toast.LENGTH_LONG
        view =  createToastView(context, R.drawable.toast_success_background,
                R.drawable.ic_success,
                message)
        show()
    }
}

private fun createToastView(context: Context,
                      toastBackground: Int,
                      iconResource: Int,
                      message: CharSequence): View {
    val toastView = LayoutInflater.from(context).inflate(R.layout.layout_toast, null)

    val toastContainer = toastView.findViewById<LinearLayout>(R.id.layoutToastContainer)
    val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
    val textMessage = toastView.findViewById<TextView>(R.id.textMessage)

    toastContainer.setBackgroundResource(toastBackground)
    imageIcon.setImageResource(iconResource)
    textMessage.text = message

    return toastView
}
