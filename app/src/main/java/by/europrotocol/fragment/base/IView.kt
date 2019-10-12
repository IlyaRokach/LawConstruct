package by.europrotocol.fragment.base

import android.content.Context
import androidx.fragment.app.FragmentActivity
import by.europrotocol.EuroProtocolApplication

interface IView {
    fun hideLoading() {}

    fun showLoading() {}

    fun getActivity(): FragmentActivity?

    fun getApplication(): EuroProtocolApplication
}