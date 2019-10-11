package by.europrotocol.fragment.questionoftheaccident

import by.europrotocol.fragment.base.IPresenter

interface IQuestionOfTheAccidentPresenter: IPresenter {
    fun onChangeItem1(isChecked: Boolean)
    fun onChangeItem2(isChecked: Boolean)
    fun onChangeItem3(isChecked: Boolean)
    fun onChangeItem4(isChecked: Boolean)
    fun onChangeItem5(isChecked: Boolean)
    fun onChangeItem6(isChecked: Boolean)
    fun onChangeItem7(isChecked: Boolean)
    fun onChangeItem8(isChecked: Boolean)

    fun onNextRequest()
}