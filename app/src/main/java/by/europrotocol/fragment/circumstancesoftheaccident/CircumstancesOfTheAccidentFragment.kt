package by.europrotocol.fragment.circumstancesoftheaccident

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.annotation.Nullable
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver

class CircumstancesOfTheAccidentFragment: BaseRegistrationFragment<ICircumstancesOfTheAccidentPresenter>(), ICircumstancesOfTheAccidentView {

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            CircumstancesOfTheAccidentFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    @BindView(R.id.cb_circumstances_of_the_accident_item_1)
    protected lateinit var cbItem1: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_2)
    protected lateinit var cbItem2: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_3)
    protected lateinit var cbItem3: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_4)
    protected lateinit var cbItem4: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_5)
    protected lateinit var cbItem5: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_6)
    protected lateinit var cbItem6: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_7)
    protected lateinit var cbItem7: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_8)
    protected lateinit var cbItem8: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_9)
    protected lateinit var cbItem9: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_10)
    protected lateinit var cbItem10: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_11)
    protected lateinit var cbItem11: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_12)
    protected lateinit var cbItem12: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_13)
    protected lateinit var cbItem13: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_14)
    protected lateinit var cbItem14: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_15)
    protected lateinit var cbItem15: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_16)
    protected lateinit var cbItem16: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_17)
    protected lateinit var cbItem17: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_18)
    protected lateinit var cbItem18: CheckBox

    @BindView(R.id.cb_circumstances_of_the_accident_item_19)
    protected lateinit var cbItem19: CheckBox

    override fun onInflateViewFragment(): Int = R.layout.fragment_circumstances_of_the_accident

    override fun onCreateViewFragment(view: View): View {
        getTitleScreen()

        initPresenter()
        initListener()
        return view
    }

    private fun initListener() {
        cbItem1.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem1(isChecked)}
        cbItem2.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem2(isChecked)}
        cbItem3.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem3(isChecked)}
        cbItem4.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem4(isChecked)}
        cbItem5.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem5(isChecked)}
        cbItem6.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem6(isChecked)}
        cbItem7.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem7(isChecked)}
        cbItem8.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem8(isChecked)}
        cbItem9.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem9(isChecked)}
        cbItem10.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem10(isChecked)}
        cbItem11.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem11(isChecked)}
        cbItem12.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem12(isChecked)}
        cbItem13.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem13(isChecked)}
        cbItem14.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem14(isChecked)}
        cbItem15.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem15(isChecked)}
        cbItem16.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem16(isChecked)}
        cbItem17.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem17(isChecked)}
        cbItem18.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem18(isChecked)}
        cbItem19.setOnCheckedChangeListener { buttonView, isChecked ->  getController().onChangeItem19(isChecked)}
    }

    private fun initPresenter(){
        presenter = CircumstancesOfTheAccidentPresenter(this)
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep(RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT), getTypeDriver())
        } else {
            Toast.makeText(activity, "Минимум один пункт должен быть выбран!!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver

    private fun getTitleScreen(){
        titleString = String.format("Обстоятельства ДТП %s", when (getTypeDriver().type){
            TypeDriver.ONE -> "А"
            TypeDriver.TWO -> "Б"
            else -> ""
        })
    }

}