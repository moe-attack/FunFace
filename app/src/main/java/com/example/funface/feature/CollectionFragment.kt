package com.example.funface.feature

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.funface.R
import com.example.funface.feature.adapter.CollectionAdaptor
import com.example.funface.feature.viewModel.CollectionViewModel
import kotlinx.android.synthetic.main.collection_fragment.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class CollectionFragment: BaseFragment() {

    private lateinit var viewLayoutManager: GridLayoutManager
    private lateinit var viewAdapter: CollectionAdaptor
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
    ): View? = inflater.inflate(R.layout.collection_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionViewModel:: class.java)
        viewLayoutManager = GridLayoutManager(activity, 3)
        viewAdapter = CollectionAdaptor(::listener, mutableListOf(), viewModel)

        with (collection_recyclerview){
            layoutManager = viewLayoutManager
            adapter = viewAdapter
        }

        setMenu()
        viewModel.allStickerPacks.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.size > 0) {
                    collection_fragment_empty_text.visibility = View.GONE
                    viewAdapter.setStickerPack(it)
                } else {
                    collection_fragment_empty_text.visibility = View.VISIBLE
                }
                viewAdapter.setStickerPack(it)
            }
        })

    }

    fun setMenu(){
        customToolbarNewButton.visibility = View.VISIBLE
        customToolbarNewButton.setOnClickListener{
            navigator.selectNewStickerPack()
        }
    }

    fun listener(stickerPack: StickerPack){
        navigator.selectAStickerPack(stickerPack.generatedPrimaryKey.toString())
    }
}