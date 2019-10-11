package by.europrotocol.fragment.autoinfo

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.driverinfo.DriverInfoFragment
import by.europrotocol.fragment.physicaluser.*
import by.europrotocol.utils.CustomTextWatcher

class AutoInfoFragment: BaseRegistrationFragment<IAutoInfoPresenter>(),
    IAutoInfoDriverView {

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            AutoInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    @BindView(R.id.et_car_model)
    protected lateinit var etCarModel: EditText

    @BindView(R.id.et_registration_number)
    protected lateinit var etRegistrationNumber: EditText

    @BindView(R.id.et_country_registration)
    protected lateinit var etCountryRegistration: EditText

    @BindView(R.id.switch_is_available_trailer)
    protected lateinit var switchIsAvailableTrailer: Switch

    @BindView(R.id.ll_trailer_info)
    protected lateinit var llTrailerInfo: LinearLayout

    @BindView(R.id.et_registration_number_trailer)
    protected lateinit var etRegistrationNumberTrailer: EditText

    @BindView(R.id.et_country_registration_trailer)
    protected lateinit var etCountryRegistrationTrailer: EditText


    override fun onInflateViewFragment(): Int = R.layout.fragment_private_auto_info_user


    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        initListener()
        return view
    }

    private fun initListener() {
        etCarModel.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etCarModel.error = getString(R.string.error_required_field)
                    getController().onChangeCarModel(s.toString())
                } else {
                    etCarModel.error = null
                    getController().onChangeCarModel(s.toString())
                }
            }
        })

        etRegistrationNumber.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etRegistrationNumber.error = getString(R.string.error_required_field)
                    getController().onChangeRegistrationNumber(s.toString())
                } else {
                    etRegistrationNumber.error = null
                    getController().onChangeRegistrationNumber(s.toString())
                }
            }
        })
        etCountryRegistration.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etCountryRegistration.error = getString(R.string.error_required_field)
                    getController().onChangeCountryRegistration(s.toString())
                } else {
                    etCountryRegistration.error = null
                    getController().onChangeCountryRegistration(s.toString())
                }
            }
        })

        etRegistrationNumberTrailer.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                getController().onChangeRegistrationNumberTrailer(s.toString())
            }
        })

        etCountryRegistrationTrailer.addTextChangedListener(object: CustomTextWatcher(){
            override fun afterTextChanged(s: Editable?) {
                getController().onChangeCountryRegistrationTrailer(s.toString())
            }
        })

        switchIsAvailableTrailer.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                getController().onChangeChecedAvailableTrailer(isChecked)
                if (isChecked) {
                    llTrailerInfo.visibility = View.VISIBLE

                } else {
                    llTrailerInfo.visibility = View.GONE
                    getController().onChangeRegistrationNumberTrailer("")
                    getController().onChangeCountryRegistrationTrailer("")
                }
            }
        })
    }

    private fun initPresenter(){
        presenter = AutoInfoDriverPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun showCarModelRequiredError(errorMessage: String) {
        etCarModel.error = errorMessage
    }

    override fun showRegistrationNumberRequiredError(errorMessage: String) {
        etRegistrationNumber.error = errorMessage
    }

    override fun showCountryRegistrationRequiredError(errorMessage: String) {
        etCountryRegistration.error = errorMessage
    }

    override fun showTrailerInfo() {
        llTrailerInfo.visibility = View.VISIBLE
    }

    override fun hideTrailerInfo() {
        llTrailerInfo.visibility = View.GONE
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_AUTO_INFO), getTypeDriver())
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver
}