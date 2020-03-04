package com.bravedroid.playground.userInput


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.bravedroid.playground.R
import kotlinx.android.synthetic.main.fragment_user_inputs.*

/**
 * A simple [Fragment] subclass.
 */
class UserInputsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_inputs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val callback: (View) -> Unit
        callback = { view ->
            when (view.id) {
                R.id.textFields_btn ->
                    view.findNavController().navigate(R.id.action_userInputsFragment_to_textFieldFragment
                            // UserInputsFragmentDirections.actionUserInputsFragmentToTextFieldFragment()
                    )
            }
        }

        textFields_btn.setOnClickListener(callback)
    }
}
