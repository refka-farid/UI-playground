package com.bravedroid.playground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.layout_activityhome.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activityhome)

        val callback: (View) -> Unit = { view ->
            when (view.id) {
                R.id.user_input_cardview -> {
                }
                R.id.output_content_cardview -> {
                }
                R.id.widgets_cardview -> {
                }
                R.id.notifications_cardview -> {
                    findNavController(view.id).navigate(
                            HomeActivityDirections.actionHomeActivityToNotificationsActivity2()
                    )
                }
                R.id.tool_cardview -> {
                }
                R.id.samples_cardview -> {
                }
            }
        }

        user_input_cardview.setOnClickListener(callback)
        output_content_cardview.setOnClickListener(callback)
        widgets_cardview.setOnClickListener(callback)
        notifications_cardview.setOnClickListener(callback)
        tool_cardview.setOnClickListener(callback)
        samples_cardview.setOnClickListener(callback)

    }
}
