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
        duration = Toast.LENGTH_SHORT
        view =  createToastView(context,R.drawable.background_toast_error,
                R.drawable.icon_error,
                message)
        show()
    }
}

fun showWarningToast(context: Context, message: CharSequence) {
    with(Toast(context)) {
        duration = Toast.LENGTH_SHORT
        view =   createToastView(context,R.drawable.background_toast_warning,
                R.drawable.icon_warning,
                message)
        show()
    }
}

fun showSuccessToast(context: Context, message: CharSequence) {
    with(Toast(context)) {
        duration = Toast.LENGTH_SHORT
        view =  createToastView(context, R.drawable.background_toast_success,
                R.drawable.icon_success,
                message)
        show()
    }
}

private fun createToastView(context: Context,
                      toastBackground: Int,
                      iconResource: Int,
                      message: CharSequence): View {
    val toastView = LayoutInflater.from(context).inflate(R.layout.layout_toast, null)

    val toastContainer = toastView.findViewById<LinearLayout>(R.id.layout_toast_container)
    val imageIcon = toastView.findViewById<ImageView>(R.id.imageView_toast_imageIcon)
    val textMessage = toastView.findViewById<TextView>(R.id.textView_toast_textMessage)

    toastContainer.setBackgroundResource(toastBackground)
    imageIcon.setImageResource(iconResource)
    textMessage.text = message

    return toastView
}
