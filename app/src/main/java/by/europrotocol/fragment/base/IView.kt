package by.europrotocol.fragment.base

import android.content.Context
import androidx.fragment.app.FragmentActivity

interface IView {
    fun hideLoading() {}

    fun showLoading() {}

    fun getActivity(): FragmentActivity?
}