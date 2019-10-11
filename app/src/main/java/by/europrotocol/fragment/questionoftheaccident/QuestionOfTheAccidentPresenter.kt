package by.europrotocol.fragment.questionoftheaccident

import by.europrotocol.fragment.base.BaseRegistrationPresenter

class QuestionOfTheAccidentPresenter(
    questionOfTheAccidentView: IQuestionOfTheAccidentView
) : BaseRegistrationPresenter<IQuestionOfTheAccidentView>(questionOfTheAccidentView),
    IQuestionOfTheAccidentPresenter {

    private val questionOfTheAccidentModel: QuestionOfTheAccidentModel =
        QuestionOfTheAccidentModel()

    override fun onChangeItem1(isChecked: Boolean) {
        questionOfTheAccidentModel.item1 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem2(isChecked: Boolean) {
        questionOfTheAccidentModel.item2 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem3(isChecked: Boolean) {
        questionOfTheAccidentModel.item3 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem4(isChecked: Boolean) {
        questionOfTheAccidentModel.item4 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem5(isChecked: Boolean) {
        questionOfTheAccidentModel.item5 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem6(isChecked: Boolean) {
        questionOfTheAccidentModel.item6 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem7(isChecked: Boolean) {
        questionOfTheAccidentModel.item7 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onChangeItem8(isChecked: Boolean) {
        questionOfTheAccidentModel.item8 = isChecked
        if (isChecked) {
            getView()!!.showNeedStateTrafficInspectorateCall()
        }
    }

    override fun onNextRequest() {
        var result = true

        result = !(questionOfTheAccidentModel.item1 ?: false) and result
        result = !(questionOfTheAccidentModel.item2 ?: false) and result
        result = !(questionOfTheAccidentModel.item3 ?: false) and result
        result = !(questionOfTheAccidentModel.item4 ?: false) and result
        result = !(questionOfTheAccidentModel.item5 ?: false) and result
        result = !(questionOfTheAccidentModel.item6 ?: false) and result
        result = !(questionOfTheAccidentModel.item7 ?: false) and result
        result = !(questionOfTheAccidentModel.item8 ?: false) and result

        getView()!!.approveNext(result)
    }
}