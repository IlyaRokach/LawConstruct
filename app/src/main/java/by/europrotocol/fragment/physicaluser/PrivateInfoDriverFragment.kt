package by.europrotocol.fragment.physicaluser

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import kotlinx.android.synthetic.main.fragment_private_driver_info_user.*

class PrivateInfoDriverFragment : BaseRegistrationFragment<IPrivateInfoDriverPresenter>(), IPrivateInfoDriverView {

    override fun onInflateViewFragment(): Int = R.layout.fragment_private_driver_info_user

    override fun onCreateFragment(instance: Bundle?) {

    }

    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        return view
    }
    
    fun initPresenter(){
        presenter = PrivateInfoDriverPresenter(this)
    }

    override fun onAttachFragment(activity: Context) {

    }

    override fun onNextClick() {

    }

    override fun showFirstNameReqiredError() {

    }

    override fun showNameReqiredError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep.STEP_PERSONAL_DRIVER_INFO)
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }
}
