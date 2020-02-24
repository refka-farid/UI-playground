package com.bravedroid.playground.widgets


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bravedroid.playground.R
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
                R.id.buttonsToggleGroup_btn -> {
                    view.findNavController().navigate(
                            WidgetsFragmentDirections.actionWidgetsFragmentToButtonsToggleGroupFragment()
                    )
                }
                R.id.cards_btn -> {
                    view.findNavController().navigate(
                            WidgetsFragmentDirections.actionWidgetsFragmentToCardsFragment()
                    )
                }
            }
        }

        buttonsSamples_btn.setOnClickListener(callback)
        buttonsToggleGroup_btn.setOnClickListener(callback)
        cards_btn.setOnClickListener(callback)
    }
}
