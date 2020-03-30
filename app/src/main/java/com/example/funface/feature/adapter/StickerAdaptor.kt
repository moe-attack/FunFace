package com.example.funface.feature.adapter

import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.funface.R
import com.example.funface.feature.Sticker
import com.example.funface.feature.StickerPack
import com.example.funface.feature.viewModel.CollectionViewModel
import com.example.funface.feature.viewModel.StickerPackViewModel
import kotlinx.android.synthetic.main.stickerpack_sticker_button.view.*

class StickerAdaptor(vmParam: StickerPackViewModel): RecyclerView.Adapter<StickerAdaptor.ItemViewHolder>(){

    var stickers: MutableList<Sticker> = mutableListOf()
    var viewModel: StickerPackViewModel

    init {
        viewModel = vmParam
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder = ItemViewHolder(parent)

    override fun getItemCount() = stickers.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply{
            with(stickers.get(position)){
                // TODO: Fix hardcoded imageFileName
                if (imageFileName == ""){
                    stickerpack_sticker_icon.background = ResourcesCompat.getDrawable(resources, R.drawable.ic_edit_pen, null)
                }
            }
        }

    }

    fun setUpStickers(stickersParam: MutableList<Sticker>){
        stickers = stickersParam
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.stickerpack_sticker_button))
}