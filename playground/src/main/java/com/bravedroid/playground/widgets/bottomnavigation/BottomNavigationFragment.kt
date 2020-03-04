package com.bravedroid.playground.widgets.bottomnavigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import com.bravedroid.playground.R
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*
import kotlin.math.pow

/**
 * A simple [Fragment] subclass.
 */
class BottomNavigationFragment : Fragment() {
    private var badgingEnabled = false

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupButtons()
        setupBottomNavigationMenu()
        setupBottomNavigationLabelVisibilityAndHorizontalTranslation()
    }

    private fun setupButtons() {
        labelVisibilityModeButton.setOnClickListener {
            val labelVisibilityMode = when (bottom_nav.labelVisibilityMode) {
                LabelVisibilityMode.LABEL_VISIBILITY_AUTO -> LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
                LabelVisibilityMode.LABEL_VISIBILITY_SELECTED -> LabelVisibilityMode.LABEL_VISIBILITY_LABELED
                LabelVisibilityMode.LABEL_VISIBILITY_LABELED -> LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                else -> LabelVisibilityMode.LABEL_VISIBILITY_AUTO
            }
            bottom_nav.labelVisibilityMode = labelVisibilityMode
        }
        horizontalTranslationEnabledButton.setOnClickListener {
            val horizontalTranslationEnabled = !bottom_nav.isItemHorizontalTranslationEnabled
            bottom_nav.isItemHorizontalTranslationEnabled = horizontalTranslationEnabled
        }
        badgingEnabledButton.setOnClickListener {
            if (!badgingEnabled) {
                bottom_nav.menu.forEachIndexed { index, item ->
                    val badgeDrawable = bottom_nav.getOrCreateBadge(item.itemId)
                    if (index > 0) {
                        val number = 10f.pow(index * 2).toInt()
                        badgeDrawable.number = number
                    }
                    // Alternatively init once and use badgeDrawable#setVisible(true, false)
                }
                badgingEnabled = true
            } else {
                bottom_nav.menu.forEach { item ->
                    bottom_nav.removeBadge(item.itemId)
                    // Alternatively init once and use badgeDrawable#setVisible(false, false)
                }
                badgingEnabled = false
            }
        }
        badgeGravityButton.setOnClickListener {
            val badgeGravity = when (bottom_nav.getBadge(R.id.action_page_1)?.badgeGravity) {
                BadgeDrawable.TOP_END -> BadgeDrawable.TOP_START
                BadgeDrawable.TOP_START -> BadgeDrawable.BOTTOM_START
                BadgeDrawable.BOTTOM_START -> BadgeDrawable.BOTTOM_END
                else -> BadgeDrawable.TOP_END
            }
            bottom_nav.menu.forEachIndexed { _, item ->
                val badgeDrawable = bottom_nav.getBadge(item.itemId)
                badgeDrawable?.badgeGravity = badgeGravity
            }
        }
    }

    private fun setupBottomNavigationMenu() {
        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_page_1 -> {
                    Toast.makeText(requireContext(), "Selected navigation item 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_page_2 -> {
                    Toast.makeText(requireContext(), "Selected navigation item 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_page_3 -> {
                    Toast.makeText(requireContext(), "Selected navigation item 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
       bottom_nav.setOnNavigationItemReselectedListener { item ->
           when (item.itemId) {
               R.id.action_page_1 -> {
                   Toast.makeText(requireContext(), "Reselected navigation item 1", Toast.LENGTH_SHORT).show()
               }
               R.id.action_page_2 -> {
                   Toast.makeText(requireContext(), "Reselected navigation item 2", Toast.LENGTH_SHORT).show()
               }
               R.id.action_page_3 -> {
                   Toast.makeText(requireContext(), "Reselected navigation item 3", Toast.LENGTH_SHORT).show()
               }
           }
       }
        // Use this to programmatically select navigation items
        //bottomNavigation.selectedItemId = R.id.item1
    }

    private fun setupBottomNavigationLabelVisibilityAndHorizontalTranslation() {
        bottom_nav.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
        //bottomNavigation.isItemHorizontalTranslationEnabled = true
    }
}
