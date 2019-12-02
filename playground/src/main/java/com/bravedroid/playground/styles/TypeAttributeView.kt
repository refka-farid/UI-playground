package com.bravedroid.playground.styles

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.bravedroid.playground.R
import com.bravedroid.playground.databinding.LayoutTypeAttributeViewBinding

private const val DEFAULT_TYPE_ATTR_TEXT: String = "?textAppearanceHeadline1"
private const val DEFAULT_TYPE_ATTR_PREVIEW_TEXT: Int = R.string.text_appearance_h1_label
private const val DEFAULT_TYPE_ATTR_PREVIEW_TEXT_APPEARANCE: Int = R.attr.textAppearanceHeadline1
private const val DEFAULT_TYPE_ATTR_PREVIEW_ALPHA: Float = 1F


class TypeAttributeView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = DataBindingUtil.inflate<LayoutTypeAttributeViewBinding>(
                inflater,
                R.layout.layout_type_attribute_view,
                this,
                true)
        val typeAttributeNameTextView: TextView = binding.textViewTypeAttributeName
        val typeAttributePreviewTextView: TextView = binding.textViewTypeAttributePreview

        val array: TypedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.TypeAttributeView,
                defStyleAttr,
                0
        )
        val typeAttrText = array.getString(R.styleable.TypeAttributeView_android_text)
                ?: DEFAULT_TYPE_ATTR_TEXT
        typeAttributeNameTextView.text = typeAttrText

        val typeAttrPreviewText = array.getString(
                R.styleable.TypeAttributeView_previewText
        ) ?: context.getString(DEFAULT_TYPE_ATTR_PREVIEW_TEXT)
        typeAttributePreviewTextView.text = typeAttrPreviewText

        val typeAttrPreviewTextAppearance = array.getResourceId(
                R.styleable.TypeAttributeView_previewTextAppearance,
                DEFAULT_TYPE_ATTR_PREVIEW_TEXT_APPEARANCE
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            typeAttributePreviewTextView.setTextAppearance(typeAttrPreviewTextAppearance)
        } else {
            typeAttributePreviewTextView.setTextAppearance(context, typeAttrPreviewTextAppearance)
        }

        val typeAttrPreviewAlpha = array.getFloat(
                R.styleable.TypeAttributeView_previewAlpha,
                DEFAULT_TYPE_ATTR_PREVIEW_ALPHA
        )
        typeAttributePreviewTextView.alpha = typeAttrPreviewAlpha
        array.recycle()
    }
}
