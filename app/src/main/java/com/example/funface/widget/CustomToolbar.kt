package com.example.funface.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.core.view.forEachIndexed
import com.example.funface.R
import kotlinx.android.synthetic.main.custom_toolbar.view.*

class CustomToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr){

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_toolbar, this, true)


        attrs?.run {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar, 0, 0)
            val titleRes = a.getResourceId(R.styleable.CustomToolbar_custom_toolbar_title, -1)
            if (titleRes != -1) {
                customToolbar.customToolbarTitle.setText(titleRes)
            }
            a.recycle()
        }
    }

    fun setMenu(menuId: Int, vararg onItemSelected: () -> Unit){
        menu.clear()
        inflateMenu(menuId)
        menu.forEachIndexed{index, menu ->
            menu.setOnMenuItemClickListener {
                onItemSelected[index]()
                true
            }
        }
    }
}