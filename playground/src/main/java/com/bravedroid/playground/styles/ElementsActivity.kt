package com.bravedroid.playground.styles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.bravedroid.playground.R
import kotlinx.android.synthetic.main.activity_elements.*

class ElementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elements)

        switch_elements_darkTheme.setOnCheckedChangeListener { _, isChecked ->
            delegate.localNightMode = if (isChecked) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        }


    }
}
