package com.bravedroid.playground.userInput


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bravedroid.playground.R

/**
 * A simple [Fragment] subclass.
 */
class TextFieldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_text_field, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val callback: (View) -> Unit = {
//            when (view.id) {
//                R.id.textFields_btn ->
//                    view.findNavController().navigate(
//                            UserInputsFragmentDirections.actionUserInputsFragmentToTextFieldFragment()
//                    )
//            }
//        }
//
//        textFields_btn.setOnClickListener(callback)
    }
}
