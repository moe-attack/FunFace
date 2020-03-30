package com.example.funface.feature

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.funface.R
import com.example.funface.feature.adapter.StickerAdaptor
import com.example.funface.feature.viewModel.StickerPackViewModel
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.stickerpack_fragment.*

class StickerPackFragment: BaseFragment() {

    private lateinit var viewLayoutManager: GridLayoutManager
    private lateinit var viewAdapter: StickerAdaptor
    private val navigator = FunFaceNavigator()
    private lateinit var viewModel: StickerPackViewModel
    lateinit var stickerpackPrimaryKey: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator.set(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var argument: Bundle? = arguments
        if (argument != null) {
            stickerpackPrimaryKey = argument.getString("stickerpackPrimaryKey") ?: "-1"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.stickerpack_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, StickerPackViewModelFactory(activity!!.application, stickerpackPrimaryKey.toInt())).get(StickerPackViewModel:: class.java)
        viewLayoutManager = GridLayoutManager(activity, 3)
        viewAdapter = StickerAdaptor(viewModel)

        with (stickerpack_recyclerview){
            layoutManager = viewLayoutManager
            adapter = viewAdapter
        }

        customToolbarLeftButton.background = ResourcesCompat.getDrawable(resources, R.drawable.ic_toolbar_back, null)
        customToolbarLeftButton.setOnClickListener{
            activity?.onBackPressed()
        }

        customToolbarNewButton.visibility = View.VISIBLE
        customToolbarNewButton.setOnClickListener {
            viewModel.addNewSticker()
        }

        //TODO: update name to actual name instead of PK
        stickerpack_name.text = stickerpackPrimaryKey

        viewModel.stickers.observe(viewLifecycleOwner, Observer {
            it?.let{
                if (it.size > 0 ){
                    stickerpack_fragment_empty_text.visibility = View.GONE
                    viewAdapter.setUpStickers(it)
                } else {
                    stickerpack_fragment_empty_text.visibility = View.VISIBLE
                }
                viewAdapter.setUpStickers(it)
            }
        })
    }
}