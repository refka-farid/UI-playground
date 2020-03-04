package com.bravedroid.playground.widgets.buttons


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bravedroid.playground.R
import kotlinx.android.synthetic.main.fragment_buttons.*

class ButtonsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val buttons = mutableListOf<Button>(
                material_icon_text_button,
                material_text_button,
                materialIcon_btn,
                materialUnelevated_btn,
                material_btn,
                materialoutlined_btn,
                iconOnly_btn
        )

        enabledButton_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            for (button in buttons) {
                var updatedText: CharSequence = "enabled"
                if (!isChecked) {
                    updatedText = "disabled"
                }
                if (!TextUtils.isEmpty(button.text)) {
                    button.setText(updatedText)
                }
                button.isEnabled = isChecked
            }
        }
    }
}
