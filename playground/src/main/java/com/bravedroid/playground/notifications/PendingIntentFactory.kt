package com.bravedroid.playground.notifications

import android.app.Activity
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.core.app.TaskStackBuilder
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkBuilder

class PendingIntentFactory {
    fun createPendingIntent(context: Context, activity: Activity): PendingIntent {
        val intent = Intent(context, activity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT)
    }

    fun createPendingIntentWithBackStack(context: Context, activity: Activity): PendingIntent? {
        val resultIntent = Intent(context, activity::class.java)
        // Create the TaskStackBuilder
        return TaskStackBuilder.create(context).run {
            // Add the intent, which inflates the back stack
            addNextIntentWithParentStack(resultIntent)
            // Get the PendingIntent containing the entire back stack
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    fun createExplicitDeepLink(
            context: Context,
            @NavigationRes navGraphId: Int,
            @IdRes destinationId: Int,
            args: Bundle?
    ): PendingIntent {
        return NavDeepLinkBuilder(context)
                .setGraph(navGraphId)
                .setDestination(destinationId)
                .setArguments(args)
                .createPendingIntent()
    }

    fun createExplicitDeepLink(
            navController: NavController,
            @NavigationRes navGraphId: Int,
            @IdRes destinationId: Int,
            args: Bundle?
    ): PendingIntent {
        return navController.createDeepLink()
                .setGraph(navGraphId)
                .setDestination(destinationId)
                .setArguments(args)
                .createPendingIntent()
    }
}
