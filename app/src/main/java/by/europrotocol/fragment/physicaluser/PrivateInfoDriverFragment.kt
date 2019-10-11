package by.europrotocol.fragment.physicaluser

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.placeofimpact.PlaceOfImpactFragment
import by.europrotocol.utils.CustomTextWatcher

class PrivateInfoDriverFragment: BaseRegistrationFragment<IPrivateInfoDriverPresenter>(), IPrivateInfoDriverView {

    companion object {
        @JvmStatic
        fun newInstance() =
            PrivateInfoDriverFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    @BindView(R.id.et_first_name)
    protected lateinit var etFirstName: EditText

    @BindView(R.id.et_last_name)
    protected lateinit var etLastName: EditText

    @BindView(R.id.et_patronymic_name)
    protected lateinit var etPatronymicName: EditText

    override fun onInflateViewFragment(): Int = R.layout.fragment_private_driver_info_user


    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        initListener()
        return view
    }

    private fun initListener() {
        etFirstName.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etFirstName.error = getString(R.string.error_required_field)
                    getController().onChangeFirstName(s.toString())
                } else {
                    etFirstName.error = null
                    getController().onChangeFirstName(s.toString())
                }
            }
        })

        etLastName.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etLastName.error = getString(R.string.error_required_field)
                    getController().onChangeName(s.toString())
                } else {
                    etLastName.error = null
                    getController().onChangeName(s.toString())
                }
            }
        })
        etPatronymicName.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                getController().onChangePatronymic(s.toString())
            }
        })
    }

    private fun initPresenter(){
        presenter = PrivateInfoDriverPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun showFirstNameRequiredError(errorMessage: String) {
        etFirstName.error = errorMessage
    }

    override fun showNameRequiredError(errorMessage: String) {
        etLastName.error = errorMessage
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep.STEP_PERSONAL_DRIVER_INFO)
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }
}
