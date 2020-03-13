package com.example.funface.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.funface.R
import com.example.funface.feature.adapter.StickerAdaptor
import com.example.funface.feature.viewModel.CollectionViewModel
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.stickerpack_fragment.*

class StickerPackFragment: BaseFragment() {

    private lateinit var viewLayoutManager: GridLayoutManager
    private lateinit var viewAdapter: StickerAdaptor
    private val navigator = FunFaceNavigator()
    private lateinit var viewModel: CollectionViewModel
    lateinit var stickerPackName: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator.set(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var argument: Bundle? = arguments
        if (argument != null) {
            stickerPackName = argument.getString("stickerpackName") ?: "Default2"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.stickerpack_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        customToolbarLeftButton.background = ResourcesCompat.getDrawable(resources, R.drawable.ic_toolbar_back, null)
        customToolbarLeftButton.setOnClickListener{
            activity?.onBackPressed()
        }

        stickerpack_name.text = stickerPackName
    }
}