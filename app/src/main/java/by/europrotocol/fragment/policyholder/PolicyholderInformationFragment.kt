package by.europrotocol.fragment.policyholder

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
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.placeofimpact.PlaceOfImpactFragment
import by.europrotocol.utils.CustomTextWatcher

class PolicyholderInformationFragment : BaseRegistrationFragment<IPolicyholderInformationPresenter>(),
    IPolicyholderInformationView {

    override fun onInflateViewFragment(): Int  = R.layout.fragment_placeholder_info

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            PolicyholderInformationFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    @BindView(R.id.et_first_name)
    protected lateinit var etFirstName: EditText

    @BindView(R.id.et_last_name)
    protected lateinit var etLastName: EditText

    @BindView(R.id.et_patronymic_name)
    protected lateinit var etPatronymicName: EditText

    @BindView(R.id.et_phone)
    protected lateinit var etPhone: EditText

    @BindView(R.id.et_residence_address)
    protected lateinit var residenceAdress: EditText

    @BindView(R.id.et_country_registration)
    protected lateinit var country: EditText

    @BindView(R.id.et_zip_code)
    protected lateinit var zipCode: EditText

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
                if (s?.isEmpty() == true) {
                    etPatronymicName.error = getString(R.string.error_required_field)
                    getController().onChangePatronymic(s.toString())
                } else {
                    etPatronymicName.error = null
                    getController().onChangePatronymic(s.toString())
                }
            }
        })

        etPhone.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etPhone.error = getString(R.string.error_required_field)
                    getController().onMobilePhoneOrEmail(s.toString())
                } else {
                    etPhone.error = null
                    getController().onMobilePhoneOrEmail(s.toString())
                }
            }
        })

        residenceAdress.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    residenceAdress.error = getString(R.string.error_required_field)
                    getController().onResidenceAdress(s.toString())
                } else {
                    residenceAdress.error = null
                    getController().onResidenceAdress(s.toString())
                }
            }
        })

        country.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    country.error = getString(R.string.error_required_field)
                    getController().onCountry(s.toString())
                } else {
                    country.error = null
                    getController().onCountry(s.toString())
                }
            }
        })

        zipCode.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    zipCode.error = getString(R.string.error_required_field)
                    getController().onZipCode(s.toString())
                } else {
                    zipCode.error = null
                    getController().onZipCode(s.toString())
                }
            }
        })
    }

    private fun initPresenter(){
        presenter = PolicyholderInformationPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_PLACE_HOLDER_DATA), getTypeDriver())
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun initValue(model: PolicyHolderModel) {
        etFirstName.setText(model.fistName)
        etLastName.setText(model.name)
        etPatronymicName.setText(model.patronymic)
        etPhone.setText(model.mobilePhoneOrEmail)
        residenceAdress.setText(model.residenceAdress)
        country.setText(model.country)
        zipCode.setText(model.zipCode)
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver
}