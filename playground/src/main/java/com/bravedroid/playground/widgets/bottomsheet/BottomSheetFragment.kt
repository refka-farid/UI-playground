package com.bravedroid.playground.widgets.bottomsheet

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bravedroid.playground.R
import com.google.android.material.animation.ArgbEvaluatorCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomSheetFragment : Fragment() {

    private lateinit var standardBottomSheetBehavior: BottomSheetBehavior<View>
    private val startColor = Color.parseColor("#00FFFFFF")
    private val endColor = Color.parseColor("#FFFFFFFF")
    private val textColor = Color.parseColor("#FF000000")
    private var modalDismissWithAnimation = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupButtons()
        setupStandardBottomSheet()
        //animateStandardBottomSheetStates()
    }

    private fun setupButtons() {
        standardBottomSheetButton.setOnClickListener {
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        modalBottomSheetButton.setOnClickListener {
            showModalBottomSheet()
        }
        toggleModalDismissAnimationButton.setOnClickListener {
            modalDismissWithAnimation = !modalDismissWithAnimation
        }
    }

    private fun setupStandardBottomSheet() {
        standardBottomSheetBehavior = BottomSheetBehavior.from(standardBottomSheet)
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                textView.text = when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> "STATE_EXPANDED"
                    BottomSheetBehavior.STATE_COLLAPSED -> "STATE_COLLAPSED"
                    BottomSheetBehavior.STATE_DRAGGING -> "STATE_DRAGGING"
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> "STATE_HALF_EXPANDED"
                    BottomSheetBehavior.STATE_HIDDEN -> "STATE_HIDDEN"
                    BottomSheetBehavior.STATE_SETTLING -> "STATE_SETTLING"
                    else -> null
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                val fraction = (slideOffset + 1f) / 2f
                val color = ArgbEvaluatorCompat.getInstance().evaluate(fraction, startColor, endColor)
                //slideView.setBackgroundColor(color)
            }
        }
        standardBottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
        standardBottomSheetBehavior.saveFlags = BottomSheetBehavior.SAVE_ALL
        textView.setTextColor(textColor)
    }

    private fun showModalBottomSheet() {
       val modalBottomSheet = ModalBottomSheet.newInstance(modalDismissWithAnimation)
        modalBottomSheet.show(requireActivity().supportFragmentManager, ModalBottomSheet.TAG)
    }

    private fun animateStandardBottomSheetStates() {
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }, 1000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }, 2000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        }, 3000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }, 4000L)
        standardBottomSheet.postDelayed({
            standardBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }, 5000L)
    }
}
