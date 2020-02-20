package com.bravedroid.playground.notifications


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bravedroid.playground.DashboardActivity
import com.bravedroid.playground.NotificationFactory
import com.bravedroid.playground.PendingIntentFactory
import com.bravedroid.playground.R
import kotlinx.android.synthetic.main.fragment_persisitent_notification.*

class PersistentNotificationFragment : Fragment() {
    private val notificationFactory: NotificationFactory = NotificationFactory()
    private val pendingIntentFactory: PendingIntentFactory = PendingIntentFactory()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_persisitent_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sampleNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendSampleNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_medium), requireContext(), pendingIntent)
        }

        bigImageNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendBigImageNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_small), requireContext(), pendingIntent)
        }

        bigImageNotificationYoutube_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendBigImageNotificationYoutubeStyle(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_small), requireContext(), pendingIntent)
        }

        bigTextNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendBigTextNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_large), requireContext(), pendingIntent)
        }

        inboxNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendInboxNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_small), requireContext(), pendingIntent)
        }

        messagingNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendMessagingNotification(requireContext(), pendingIntent)
        }

        progressBarNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendProgressBarNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_small), requireContext(), pendingIntent)
        }

        mediaNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendMediaNotification(requireActivity().getString(R.string.dummy_text_title), requireActivity().getString(R.string.dummy_text_title), requireContext(), pendingIntent)
        }

        highPriority_Notification.setOnClickListener {
            registerNotificationChannel()
            val fullScreenIntent = Intent(requireContext(), DashboardActivity::class.java)
            val fullScreenPendingIntent = PendingIntent.getActivity(requireContext(), 0,
                    fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            notificationFactory.sendHighPriorityNotification("high priority",requireActivity().getString(R.string.dummy_text_small), requireContext(),fullScreenPendingIntent)
        }

        groupNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendGroupNotification(requireContext(), pendingIntent)
        }

        customNotification_btn.setOnClickListener {
            registerNotificationChannel()
            //NewMessageNotification.notify(requireContext(),"Reminder",1)
            //val pendingIntent = pendingIntentFactory.createPendingIntent(requireContext(), DashboardActivity())
            notificationFactory.sendCustomNotification(requireContext())
        }
    }

    private fun registerNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = requireContext().getSystemService((Context.NOTIFICATION_SERVICE)) as NotificationManager
            val channel = NotificationChannel(NewMessageNotification.channel1,
                    "Note Reminders",
                    NotificationManager.IMPORTANCE_DEFAULT)
            nm.createNotificationChannel(channel)
        }
    }
}
