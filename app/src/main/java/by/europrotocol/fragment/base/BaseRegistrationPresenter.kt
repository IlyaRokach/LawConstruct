package by.europrotocol.fragment.base

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.Nullable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open abstract class BaseRegistrationPresenter<View: IView>(
    private var view: View?
) : IPresenter {
    private val compositeSubscription = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        this.compositeSubscription.add(disposable)
    }

    protected fun getCompositeSubscription(): CompositeDisposable {
        return this.compositeSubscription
    }

    @CallSuper
    override fun onDestroy() {
        getCompositeSubscription().clear()
        dettachView()
    }

    @CallSuper
    override fun onCreate() {

    }

    @CallSuper
    override fun onResume() {
    }

    @CallSuper
    override fun onPause() {
    }

    @CallSuper
    override fun onStop() {
        getCompositeSubscription().clear()
    }

    private fun dettachView() {
        this.view = null
    }


    protected fun isViewAttached(): Boolean {
        return getView() != null
    }

    protected fun getView(): View? {
        return view
    }


    @Throws(ViewNotAttachedException::class)
    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }

    override fun onCreateView() {

    }

    override fun onViewCreated(savedInstanceState: Bundle?) {

    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {

    }
}