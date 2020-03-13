package com.example.funface.feature

import android.app.Activity
import android.drm.DrmStore
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.*
import com.example.funface.R
import java.lang.ref.WeakReference

open class FunFaceNavigator {
    private var activityWeakReference: WeakReference<Activity>? = null

    fun set(activity: Activity) {
        activityWeakReference = WeakReference(activity)
    }

    fun set(fragment: Fragment) {
        fragment.activity?.let {activityWeakReference = WeakReference(it) }
    }

    private fun navigate(direction: NavDirections, popBackStack: Boolean = false, navOptions: NavOptions?= null) {
        activityWeakReference?.get()?.run{
            findNavController(R.id.main_activity_fragment).apply {
                if (popBackStack){
                    popBackStack()
                }
                navigate(direction, navOptions)
            }
        }
    }

    private fun navigate(direction: NavDirections, popBackStack: Boolean = false, navOptions: NavOptions?= null, arg: String){
        activityWeakReference?.get()?.run{
            findNavController(R.id.main_activity_fragment).apply {
                if (popBackStack){
                    popBackStack()
                }
                direction.arguments.putString("stickerpackName", arg)
                navigate(direction, navOptions)
            }
        }
    }

    fun selectNewStickerPack(){
        navigate(newStickerPackAction())
    }

    fun selectAStickerPack(param: String){
        navigate(stickerPackOnClickAction(), arg = param)
    }

    companion object {
        fun newStickerPackAction(): NavDirections = ActionOnlyNavDirections(R.id.navigationCollectionNewName)
        fun stickerPackOnClickAction(): NavDirections = ActionOnlyNavDirections(R.id.navigationStickers)
    }
}