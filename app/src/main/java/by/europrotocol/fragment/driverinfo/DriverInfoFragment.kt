package by.europrotocol.fragment.driverinfo

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.InsurerInformation.InsurerInformationFragment
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.claimresponsibleFfortheharm.ClaimToBeResponsibleForTheHarmFragment
import by.europrotocol.fragment.physicaluser.PrivateInfoDriverPresenter
import by.europrotocol.utils.CustomTextWatcher

class DriverInfoFragment: BaseRegistrationFragment<IDriverInfoPresenter>(), IDriverInfoView{

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            DriverInfoFragment().apply {
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

    @BindView(R.id.et_date_birthday)
    protected lateinit var dateBirthday: EditText

    @BindView(R.id.et_residence_address)
    protected lateinit var residenceAdress: EditText

    @BindView(R.id.et_country_registration)
    protected lateinit var country: EditText

    @BindView(R.id.et_zip_code)
    protected lateinit var zipCode: EditText

    @BindView(R.id.et_series_license)
    protected lateinit var series: EditText

    @BindView(R.id.et_number_license)
    protected lateinit var number: EditText

    @BindView(R.id.et_category_license)
    protected lateinit var category: EditText

    @BindView(R.id.et_valid_finish_date)
    protected lateinit var validFinishDate: EditText

    @BindView(R.id.switch_is_voluntary)
    protected lateinit var switchIsVoluntary: CheckBox

    override fun onInflateViewFragment(): Int = R.layout.fragment_driver_info_user

    override fun onCreateViewFragment(view: View): View {

        getTitleScreen()
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

        dateBirthday.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    dateBirthday.error = getString(R.string.error_required_field)
                    getController().onDateBirthday(s.toString())
                } else {
                    dateBirthday.error = null
                    getController().onDateBirthday(s.toString())
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

        number.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    number.error = getString(R.string.error_required_field)
                    getController().onNumber(s.toString())
                } else {
                    number.error = null
                    getController().onNumber(s.toString())
                }
            }
        })

        series.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    series.error = getString(R.string.error_required_field)
                    getController().onSeries(s.toString())
                } else {
                    series.error = null
                    getController().onSeries(s.toString())
                }
            }
        })

        category.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    category.error = getString(R.string.error_required_field)
                    getController().onCategory(s.toString())
                } else {
                    category.error = null
                    getController().onCategory(s.toString())
                }
            }
        })

        validFinishDate.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    validFinishDate.error = getString(R.string.error_required_field)
                    getController().onValidFinishDate(s.toString())
                } else {
                    validFinishDate.error = null
                    getController().onValidFinishDate(s.toString())
                }
            }
        })
        switchIsVoluntary.setOnCheckedChangeListener { buttonView, isChecked ->
            getController().onCheckBox(isChecked)
        }
    }

    private fun initPresenter(){
        presenter = DriverInfoPresenter(this)
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
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_DRIVER_INFO), getTypeDriver())
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver

    override fun setInitData(model: DriverInfoModel) {
        etFirstName.setText(model.fistName)
        etLastName.setText(model.name)
        etPatronymicName.setText(model.patronymic)
        dateBirthday.setText(model.dateBirthday)
        residenceAdress.setText(model.residenceAdress)
        country.setText(model.country)
        zipCode.setText(model.zipCode)
        series.setText(model.driverLicense.series)
        number.setText(model.driverLicense.number)
        category.setText(model.driverLicense.category.toString())
        validFinishDate.setText(model.driverLicense.validFinishDate)
    }

    private fun getTitleScreen(){
        titleString = getString(R.string.driver_info_title_string, when (getTypeDriver().type){
            TypeDriver.ONE -> "А"
            TypeDriver.TWO -> "Б"
            else -> ""
        })
    }
}