package com.example.funface.feature.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.funface.R
import com.example.funface.feature.FunFaceNavigator
import com.example.funface.feature.StickerPack
import com.example.funface.feature.viewModel.CollectionViewModel
import kotlinx.android.synthetic.main.collection_sticker_button.view.*

class CollectionAdaptor(val listener: (StickerPack) -> Unit, param: List<StickerPack>, vmParam: CollectionViewModel): RecyclerView.Adapter<CollectionAdaptor.ItemViewHolder>(){

    var stickerpacks : List<StickerPack>
    var viewModel : CollectionViewModel

    init {
        stickerpacks = param
        viewModel = vmParam
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder = ItemViewHolder(parent)

    override fun getItemCount() = stickerpacks.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply{

            with(stickerpacks.get(position)){
                if (trayImageFile == ""){
                    collection_sticker_icon.background = ResourcesCompat.getDrawable(resources, R.drawable.ic_sticker_empty, null)
                    collection_sticker_name.text = name
                }
                collection_sticker_icon.setOnLongClickListener{
                    viewModel.delete(stickerpacks.get(position))
                    notifyDataSetChanged()
                    Toast.makeText(context, R.string.toast_stickerpack_delete_successful, Toast.LENGTH_LONG).show()
                    true
                }
                collection_sticker_icon.setOnClickListener{
                    listener(this)
                }
            }
        }

    }

    fun setStickerPack(stickerPacks: List<StickerPack>){
        stickerpacks = stickerPacks
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.collection_sticker_button))
}

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context)
    .inflate(layoutId, this, attachToRoot)