package com.bravedroid.playground.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.support.v4.media.session.MediaSessionCompat
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.bravedroid.playground.R
import androidx.media.app.NotificationCompat as MediaNotification

class NotificationFactory {
    fun sendSampleNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendBigTextNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText(messageBody)
                        .setBigContentTitle(title)
                        .setSummaryText("Summary Text")
                )
        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendBigImageNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                        .bigLargeIcon(null)
                )
        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendBigImageNotificationYoutubeStyle(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_SMALL)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                        .bigLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                )

        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendInboxNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = "description badge "
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setNumber(8)
                .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                .setStyle(NotificationCompat.InboxStyle()
                        .setBigContentTitle(title)
                        .addLine("1- $messageBody")
                        .addLine("2- $messageBody")
                        .addLine("3- $messageBody")
                        .addLine("4- $messageBody")
                        .addLine("5- $messageBody")
                        .addLine("6- $messageBody")
                        .addLine("7- $messageBody")
                        .addLine("8-this is will not be shown $messageBody")
                )

        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendMessagingNotification(
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val message1 = NotificationCompat.MessagingStyle.Message("Hi", 1000, "Adam")
        val message2 = NotificationCompat.MessagingStyle.Message("Hellooo", 1000, "Justin")
        val message3 = NotificationCompat.MessagingStyle.Message(":)  ;)", 1000, "mack")
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_time_pause, "pause", null)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
                .setStyle(NotificationCompat.MessagingStyle("justin")
                        .setConversationTitle("Conversation Title")
                        .addMessage(message1)
                        .addMessage(message2)
                        .addMessage(message3)
                )
        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendProgressBarNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setColor(Color.BLUE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.bigpicture))
        NotificationManagerCompat.from(context).apply {
            // Issue the initial notification with zero progress
            notificationBuilder.setProgress(100, 30, false)
            // For android Oreo and above  notification channel is needed.
            notificationManager.notify(0, notificationBuilder.build())
        }
    }

    fun sendMediaNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val mediaSession = MediaSessionCompat(context, "tag")
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_music_note)
                // Add media control buttons that invoke intents in your media service
                .addAction(R.drawable.ic_thumb_up, "like", null)
                .addAction(R.drawable.ic_skip_previous, "Previous", null)
                .addAction(R.drawable.ic_pause, "Pause", null)
                .addAction(R.drawable.ic_skip_next, "Next", null)
                .addAction(R.drawable.ic_thumb_down, "dislike", null)
                .setContentText(messageBody)
                .setStyle(MediaNotification.MediaStyle()
                        .setShowActionsInCompactView(1, 2, 3)
                        .setMediaSession(mediaSession.getSessionToken())
                        //.setMediaSession(null)
                )
                .setSubText("Sub Text")
                .setContentTitle("Wonderful music")
                .setContentText("My Awesome Band")
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.album))
                //.setAutoCancel(true)
                .setColor(-0xff01)
                .setSound(defaultSoundUri)
        //.setContentIntent(pendingIntent)

        // For android Oreo and above  notification channel is needed.

        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendHighPriorityNotification(
            title: String,
            messageBody: String,
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT).apply {
                setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_CALL)
                .setFullScreenIntent(pendingIntent, true)

        // For android Oreo and above  notification channel is needed.

        notificationManager.notify(0, notificationBuilder.build())
    }

    fun sendGroupNotification(
            context: Context,
            pendingIntent: PendingIntent
    ) {
        val title1: String = "Title 1"
        val message1: String = "Message 1"
        val title2: String = "Title 2"
        val message2: String = "Message 2"
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notification1: Notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup("example_group")
                .build()

        val notification2: Notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setContentTitle(title2)
                .setContentText(message2)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup("example_group")
                .build()

        val summaryNotification: Notification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_lightbulb_outline_black_24dp)
                .setStyle(NotificationCompat.InboxStyle()
                        .addLine(title2 + " " + message2)
                        .addLine(title1 + " " + message1)
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("user@example.com")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setGroup("example_group")
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setGroupSummary(true)
                .build()

        // for (i in 0..4) {
        //     SystemClock.sleep(2000)
        //     notificationManager.notify(i, notification)
        // }
        // For android Oreo and above  notification channel is needed.
        SystemClock.sleep(2000)
        notificationManager.notify(2, notification1)
        SystemClock.sleep(2000)
        notificationManager.notify(3, notification2)
        SystemClock.sleep(2000)
        notificationManager.notify(4, summaryNotification)

    }

    fun sendCustomNotification(
            //title: String,
            //messageBody: String,
            context: Context
            //pendingIntent: PendingIntent
    ) {
        val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "CHANNEL_ID_1"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId,
                    "Fcm notifications",
                    NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // Get the layouts to use in the custom notification
        val notificationLayout = RemoteViews(context.packageName, R.layout.notification_small)
        val notificationLayoutExpanded = RemoteViews(context.packageName, R.layout.notification_large)

// Apply the layouts to the notification
        val customNotification = NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_notifications)
                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setContentTitle("custom Notification title from kts")
                .setContentText("custom Notification body from kts")
                .setCustomBigContentView(notificationLayoutExpanded)
                .build()

        // For android Oreo and above  notification channel is needed.
        notificationManager.notify(0, customNotification)
    }

}
