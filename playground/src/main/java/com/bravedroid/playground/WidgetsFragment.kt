package com.bravedroid.playground


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_widgets.*

/**
 * A simple [Fragment] subclass.
 */
class WidgetsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_widgets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val callback: (View) -> Unit = { view ->
            when (view.id) {
                R.id.buttonsSamples_btn -> {
                    view.findNavController().navigate(
                            WidgetsFragmentDirections.actionWidgetsFragmentToButtonsFragment()
                    )

                }
                R.id.buttonsToggleGroup_btn ->{
                    view.findNavController().navigate(
                            WidgetsFragmentDirections.actionWidgetsFragmentToButtonsToggleGroupFragment()
                    )
                }

            }
        }

        buttonsSamples_btn.setOnClickListener(callback)
        buttonsToggleGroup_btn.setOnClickListener(callback)
    }
}
