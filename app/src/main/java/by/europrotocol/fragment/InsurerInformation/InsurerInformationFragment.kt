package by.europrotocol.fragment.InsurerInformation

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.physicaluser.PrivateInfoDriverFragment
import by.europrotocol.utils.CustomTextWatcher

class InsurerInformationFragment: BaseRegistrationFragment<IInsurerInformationPresenter>(), IInsurerInformationView {

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            InsurerInformationFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    @BindView(R.id.et_name_company)
    protected lateinit var nameCompany: EditText

    @BindView(R.id.et_certificate)
    protected lateinit var certificate: EditText

    @BindView(R.id.et_series)
    protected lateinit var series: EditText

    @BindView(R.id.et_number)
    protected lateinit var number: EditText

    @BindView(R.id.et_country_registration)
    protected lateinit var country: EditText

    @BindView(R.id.et_start_date)
    protected lateinit var startDate: EditText

    @BindView(R.id.et_finish_date)
    protected lateinit var finishDate: EditText

    @BindView(R.id.switch_is_voluntary)
    protected lateinit var isvoluntary: Switch

    override fun onInflateViewFragment(): Int = R.layout.fragment_insurance_info_user

    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        initListener()
        return view
    }

    private fun initListener() {
        nameCompany.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    nameCompany.error = getString(R.string.error_required_field)
                    getController().onChangeNameCompany(s.toString())
                } else {
                    nameCompany.error = null
                    getController().onChangeNameCompany(s.toString())
                }
            }
        })

        certificate.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    certificate.error = getString(R.string.error_required_field)
                    getController().onChangeCertificate(s.toString())
                } else {
                    certificate.error = null
                    getController().onChangeCertificate(s.toString())
                }
            }
        })

        series.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    series.error = getString(R.string.error_required_field)
                    getController().onChangeSeries(s.toString())
                } else {
                    series.error = null
                    getController().onChangeSeries(s.toString())
                }
            }
        })

        number.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    number.error = getString(R.string.error_required_field)
                    getController().onChangeNumber(s.toString())
                } else {
                    number.error = null
                    getController().onChangeNumber(s.toString())
                }
            }
        })

        country.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    country.error = getString(R.string.error_required_field)
                    getController().onChangeCountry(s.toString())
                } else {
                    country.error = null
                    getController().onChangeCountry(s.toString())
                }
            }
        })

        startDate.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    startDate.error = getString(R.string.error_required_field)
                    getController().onChangeStartDate(s.toString())
                } else {
                    startDate.error = null
                    getController().onChangeStartDate(s.toString())
                }
            }
        })

        finishDate.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    finishDate.error = getString(R.string.error_required_field)
                    getController().onChangeFinishDate(s.toString())
                } else {
                    finishDate.error = null
                    getController().onChangeFinishDate(s.toString())
                }
            }
        })

        isvoluntary.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                getController().onChangeCheckedVoluntary(isChecked)
            }
        })
    }

    private fun initPresenter(){
        presenter = InsurerInformationPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_INSURER_INFO), getTypeDriver())
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showNameCompanyError(errorMessage: String) {
        nameCompany.error = errorMessage
    }

    override fun showCertificateError(errorMessage: String) {
        certificate.error = errorMessage
    }

    override fun showSeriesError(errorMessage: String) {
        series.error = errorMessage
    }

    override fun showNumberError(errorMessage: String) {
        number.error = errorMessage
    }

    override fun showCountryError(errorMessage: String) {
        country.error = errorMessage
    }

    override fun showStartDateError(errorMessage: String) {
        startDate.error = errorMessage
    }

    override fun showFinishDateError(errorMessage: String) {
        finishDate.error = errorMessage
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver

    override fun setValue(model: InsurerInformationModel) {
        nameCompany.setText(model.nameCompany)
        certificate.setText(model.certificate)
        series.setText(model.series)
        number.setText(model.number)
        country.setText(model.country)
        startDate.setText(model.startDate)
        finishDate.setText(model.finishDate)
        isvoluntary.isChecked = model.isvoluntary
    }
}