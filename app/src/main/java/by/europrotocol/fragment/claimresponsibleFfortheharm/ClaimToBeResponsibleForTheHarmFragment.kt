package by.europrotocol.fragment.claimresponsibleFfortheharm

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.utils.CustomTextWatcher

class ClaimToBeResponsibleForTheHarmFragment: BaseRegistrationFragment<IClaimToBeResponsibleForTheHarmPresenter>(),
    IClaimToBeResponsibleForTheHarmView {
    override fun onInflateViewFragment(): Int = R.layout.fragment_notes_driver

    @BindView(R.id.cb_i_claim_to_be_responsible_for_the_harm)
    protected lateinit var cbIClaimToBeResponsibleForTheHarm: CheckBox

    @BindView(R.id.notes)
    protected lateinit var notes: EditText

    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        initListener()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            ClaimToBeResponsibleForTheHarmFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    private fun initListener() {
        notes.addTextChangedListener(object: CustomTextWatcher() {

            override fun afterTextChanged(s: Editable?) {
                if (s?.isEmpty() == true) {
                    notes.error = getString(R.string.error_required_field)
                    getController().onChangeNotes(s.toString())
                } else {
                    notes.error = null
                    getController().onChangeNotes(s.toString())
                }
            }
        })
        cbIClaimToBeResponsibleForTheHarm.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onCheckedIm(isChecked)}
    }

    private fun initPresenter(){
        presenter = ClaimToBeResponsibleForTheHarmPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep.STEP_MY_NOTES)
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver
}