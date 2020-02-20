package com.bravedroid.playground


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val callback: (View) -> Unit = { view ->
            when (view.id) {
                R.id.user_input_cardview -> {
                }
                R.id.output_content_cardview -> {
                }
                R.id.widgets_cardview -> {
                    findNavController().navigate(
                            MainFragmentDirections.actionMainFragmentToWidgetsFragment())
                }
                R.id.notifications_cardview -> {
                    findNavController().navigate(
                            MainFragmentDirections.actionMainFragmentToNotificationFragment())
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

