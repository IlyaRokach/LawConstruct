package by.europrotocol.fragment.placeofaccident

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
import by.europrotocol.utils.CustomTextWatcher

class PlaceOfAccidentFragment: BaseRegistrationFragment<IPlaceOfAccidentPresenter>(), IPlaceOfAccidentView {

    companion object {
        @JvmStatic
        fun newInstance() =
            PlaceOfAccidentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onInflateViewFragment(): Int = R.layout.fragment_place_of_accident

    @BindView(R.id.et_date)
    protected lateinit var etDate: EditText

    @BindView(R.id.et_time)
    protected lateinit var etTime: EditText

    @BindView(R.id.et_place)
    protected lateinit var etPlace: EditText

    @BindView(R.id.et_fio)
    protected lateinit var etFio: EditText

    @BindView(R.id.et_address)
    protected lateinit var etAddress: EditText

    @BindView(R.id.et_phone)
    protected lateinit var etPhone: EditText

    override fun onCreateViewFragment(view: View): View {

        initPresenter()
        initListener()
        return view
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {

        getController().onFIo(etFio.text.toString())
        getController().onAddress(etAddress.text.toString())
        getController().onPhone(etPhone.text.toString())

        getController().onNextRequest()
    }

    fun initListener() {
        etDate.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etDate.error = getString(R.string.error_required_field)
                    getController().onDate(s.toString())
                } else {
                    etDate.error = null
                    getController().onDate(s.toString())
                }
            }
        })

        etTime.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etTime.error = getString(R.string.error_required_field)
                    getController().onTime(s.toString())
                } else {
                    etTime.error = null
                    getController().onTime(s.toString())
                }
            }
        })

        etPlace.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    etPlace.error = getString(R.string.error_required_field)
                    getController().onPlace(s.toString())
                } else {
                    etPlace.error = null
                    getController().onPlace((s.toString()))
                }
            }
        })
    }

    private fun initPresenter(){
        presenter = PlaceOfAccidentPresenter(this)
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_PLACE_OF_ACCIDENT))
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun inifValue(model: PlaceOfAccidentModel) {
        etDate.setText(model.dateAccident.dateCarAccident)
        etTime.setText(model.dateAccident.timeCarAccident)
        etPlace.setText(model.placeAccident.placeCarAccident)
    }
}