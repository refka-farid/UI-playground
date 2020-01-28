package com.bravedroid.playground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val callback: (View) -> Unit = { view ->
            when (view.id) {
                R.id.toast_types_btn -> {
                    view.findNavController().navigate(
                            NotificationsActivityDirections.actionNotificationsActivity2ToToastActivity()
                    )
                }
                R.id.alert_dialog_types_btn -> {
                    view.findNavController().navigate(
                            NotificationsActivityDirections.actionNotificationsActivity2ToAlertDialogActivity()
                    )
                }
                R.id.snackbar_types_btn -> {
                    view.findNavController().navigate(
                            NotificationsActivityDirections.actionNotificationsActivity2ToSnackbarActivity()
                    )
                }
            }
        }

        toast_types_btn.setOnClickListener { callback }
        alert_dialog_types_btn.setOnClickListener(callback)
        snackbar_types_btn.setOnClickListener(callback)
    }
}
