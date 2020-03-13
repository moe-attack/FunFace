package com.example.funface.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.funface.R
import com.example.funface.feature.viewModel.CollectionViewModel
import kotlinx.android.synthetic.main.collection_name_fragment.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class CollectionNameFragment: BaseFragment() {

    private val navigator = FunFaceNavigator()
    private lateinit var viewModel: CollectionViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator.set(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.collection_name_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionViewModel:: class.java)
        customToolbarLeftButton.background = ResourcesCompat.getDrawable(resources, R.drawable.ic_toolbar_back, null)

        customToolbarLeftButton.setOnClickListener{
            hideKeyboard()
            activity?.onBackPressed()
        }

        collection_name_bottom_button.setOnClickListener{
            hideKeyboard()
            var tempText = collection_name_edit_text.text.toString()
            var stickerPack = StickerPack(0, tempText)
            viewModel.insert(stickerPack)
            activity?.onBackPressed()
            Toast.makeText(context, R.string.toast_stickerpack_create_successful, Toast.LENGTH_LONG).show()
        }

        collection_name_edit_text.addTextChangedListener{
            if (collection_name_edit_text.text.isNotEmpty()){
                collection_name_bottom_button.isEnabled = true
                collection_name_bottom_button.setTextColor(ResourcesCompat.getColor(resources, R.color.lightRed, null))
            } else {
                collection_name_bottom_button.isEnabled = false
                collection_name_bottom_button.setTextColor(ResourcesCompat.getColor(resources, R.color.lightGray, null))
            }
        }
    }

}