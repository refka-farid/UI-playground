package com.bravedroid.playground.widgets.bottomappbar

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bravedroid.playground.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_bottom_app_bar.*

class BottomAppBarFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_app_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupBottomAppBarMenuAndNavigation()
        setUpBottomDrawer()
    }

    private fun setupBottomAppBarMenuAndNavigation() {
        bottomAppBar.replaceMenu(R.menu.bottom_appbar_menu)
        bottomAppBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(requireContext(), "Clicked menu Search", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(requireContext(), "Clicked menu 3d ", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(requireContext(), "Clicked menu Wallpaper", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item4 -> {
                    Toast.makeText(requireContext(), "Clicked menu Dashboard", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_appbar_menu, menu)
    }

    private fun setUpBottomDrawer() {
        var bottomDrawerBehavior: BottomSheetBehavior<View?>? = null
        val bottomDrawer: View = coordinator_layout.findViewById(R.id.bottom_drawer)
        bottomDrawerBehavior = BottomSheetBehavior.from(bottomDrawer)
        bottomDrawerBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        bottomAppBar.setNavigationOnClickListener(
                { v: View? -> bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED) })
        bottomAppBar.setNavigationIcon(R.drawable.ic_menu_24dp)
        bottomAppBar.replaceMenu(R.menu.bottom_appbar_menu)
    }
}
