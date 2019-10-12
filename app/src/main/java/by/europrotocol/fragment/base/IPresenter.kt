package by.europrotocol.fragment.base

import android.os.Bundle
import androidx.annotation.Nullable

interface IPresenter {
    fun onCreate() {}

    fun onResume() {}

    fun onPause() {}

    fun onStop() {}

    fun onDestroy() {}

    fun onCreateView()

    fun onViewCreated(savedInstanceState: Bundle?)

    fun onActivityCreated(@Nullable savedInstanceState: Bundle?)
}