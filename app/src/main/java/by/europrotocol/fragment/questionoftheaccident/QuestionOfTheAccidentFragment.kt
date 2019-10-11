package by.europrotocol.fragment.questionoftheaccident

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.InsurerInformation.InsurerInformationPresenter
import by.europrotocol.fragment.RegNewLegalEntityUserFragment
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.utils.IntentUtils

class QuestionOfTheAccidentFragment: BaseRegistrationFragment<IQuestionOfTheAccidentPresenter>(), IQuestionOfTheAccidentView{

    private var ad: AlertDialog.Builder? = null

    companion object {
        @JvmStatic
        fun newInstance() =
            QuestionOfTheAccidentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private val listenerGroup1: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_1_yes -> getController().onChangeItem1(true)
                R.id.circumstances_of_the_accident_item_1_no -> getController().onChangeItem1(false)
            }
        }

    private val listenerGroup2: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_2_yes -> getController().onChangeItem2(true)
                R.id.circumstances_of_the_accident_item_2_no -> getController().onChangeItem2(false)
            }
        }

    private val listenerGroup3: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_3_yes -> getController().onChangeItem3(true)
                R.id.circumstances_of_the_accident_item_3_no -> getController().onChangeItem3(false)
            }
        }

    private val listenerGroup4: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_4_yes -> getController().onChangeItem4(true)
                R.id.circumstances_of_the_accident_item_4_no -> getController().onChangeItem4(false)
            }
        }

    private val listenerGroup5: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_5_yes -> getController().onChangeItem5(true)
                R.id.circumstances_of_the_accident_item_5_no -> getController().onChangeItem5(false)
            }
        }

    private val listenerGroup6: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_6_yes -> getController().onChangeItem6(true)
                R.id.circumstances_of_the_accident_item_6_no -> getController().onChangeItem6(false)
            }
        }

    private val listenerGroup7: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_7_yes -> getController().onChangeItem7(true)
                R.id.circumstances_of_the_accident_item_7_no -> getController().onChangeItem7(false)
                R.id.circumstances_of_the_accident_item_8_yes -> getController().onChangeItem8(true)
                R.id.circumstances_of_the_accident_item_8_no -> getController().onChangeItem8(false)
            }
        }

    private val listenerGroup8: RadioGroup.OnCheckedChangeListener =
        RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.circumstances_of_the_accident_item_8_yes -> getController().onChangeItem8(true)
                R.id.circumstances_of_the_accident_item_8_no -> getController().onChangeItem8(false)
            }
        }


    override fun onInflateViewFragment(): Int = R.layout.fragment_question_of_the_accident

    override fun showNeedStateTrafficInspectorateCall() {
        ad?.show()
    }

    override fun onCreateViewFragment(view: View): View {
        ad = AlertDialog.Builder(context!!)
        ad?.setTitle(getString(R.string.question_of_the_accident_title_dialog))  // заголовок
        ad?.setMessage(getString(R.string.question_of_the_accident_message_dialog)) // сообщение
        ad?.setPositiveButton(getString(R.string.question_of_the_accident_approve_call)) { dialog, arg1 ->
            IntentUtils.getDialIntent("102")
            dialog.dismiss()
        }

        ad?.setNegativeButton(getString(R.string.question_of_the_accident_not_approve_call)) { dialog, arg1 ->
            dialog.dismiss()
        }

        ad?.setCancelable(false)

        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_1)
            .setOnCheckedChangeListener(listenerGroup1)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_2)
            .setOnCheckedChangeListener(listenerGroup2)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_3)
            .setOnCheckedChangeListener(listenerGroup3)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_4)
            .setOnCheckedChangeListener(listenerGroup4)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_5)
            .setOnCheckedChangeListener(listenerGroup5)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_6)
            .setOnCheckedChangeListener(listenerGroup6)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_7)
            .setOnCheckedChangeListener(listenerGroup7)
        view.findViewById<RadioGroup>(R.id.circumstances_of_the_accident_item_8)
            .setOnCheckedChangeListener(listenerGroup8)

        initPresenter()

        return view
    }
    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    private fun initPresenter(){
        presenter = QuestionOfTheAccidentPresenter(this)
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep.STEP_QUESTION_ACCIDENT)
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT).show()
        }
    }
}