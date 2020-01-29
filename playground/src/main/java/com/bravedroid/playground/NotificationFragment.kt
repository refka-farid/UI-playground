package com.bravedroid.playground


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val callback: (View) -> Unit = { view ->
            when (view.id) {
                R.id.toast_types_btn -> {
                    view.findNavController().navigate(
                            NotificationFragmentDirections.actionNotificationFragmentToToastActivity()
                    )

                }
                R.id.alert_dialog_types_btn -> {
                    view.findNavController().navigate(
                            NotificationFragmentDirections.actionNotificationFragmentToAlertDialogActivity()
                    )
                }
                R.id.snackbar_types_btn -> {
                    view.findNavController().navigate(
                            NotificationFragmentDirections.actionNotificationFragmentToSnackbarActivity())
                }
                R.id.persistent_notification_btn -> {
                    view.findNavController().navigate(
                            NotificationFragmentDirections.actionNotificationFragmentToPersistentNotificationFragment())
                }
            }
        }

        toast_types_btn.setOnClickListener(callback)
        alert_dialog_types_btn.setOnClickListener(callback)
        snackbar_types_btn.setOnClickListener(callback)
        persistent_notification_btn.setOnClickListener(callback)
    }
}
