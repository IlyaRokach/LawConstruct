package by.europrotocol.fragment.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import by.europrotocol.EuroProtocolApplication
import by.europrotocol.activity.registration.INextCallback


private const val TITLE = "title"
private const val TITLE_STRING = "titleString"

open abstract class BaseRegistrationFragment<T: IPresenter>: Fragment, IView {

    protected lateinit var presenter: T
    protected var nextCallback: INextCallback? = null
    protected var title = 0
    protected var titleString: String? = null

    abstract fun onInflateViewFragment(): Int

    fun onCreateFragment(instance: Bundle?) {}

    abstract fun onCreateViewFragment(view: View): View

    fun onAttachFragment(activity: Context){}

    abstract fun onNextClick()

    fun getController(): T {
        return this.presenter
    }

    constructor(): super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //permissions = RxPermissions(this)
        onCreateFragment(savedInstanceState)

        if (savedInstanceState != null) {
            title = savedInstanceState.getInt(TITLE)
            if (savedInstanceState.containsKey(TITLE_STRING)) {
                titleString = savedInstanceState.getString(TITLE_STRING)
            }
        }

        presenter.onCreate()
    }

    override fun getApplication(): EuroProtocolApplication = this.activity!!.application as EuroProtocolApplication

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(onInflateViewFragment(), container, false)
        ButterKnife.bind(this, view)
        view = onCreateViewFragment(view)
        if (presenter != null) {
            presenter.onCreateView()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onAttachFragment(context)
        if (context is INextCallback) {
            nextCallback = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onResume() {
        super.onResume()
        if (presenter != null) {
            presenter.onResume()
        }
    }

    override fun onPause() {
        super.onPause()
        if (presenter != null) {
            presenter.onPause()
        }

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        if (presenter != null) {
            presenter.onDestroy()
        }
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
        nextCallback = null
    }
}