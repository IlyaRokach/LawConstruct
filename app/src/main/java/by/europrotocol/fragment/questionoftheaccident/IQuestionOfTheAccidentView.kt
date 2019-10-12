package by.europrotocol.fragment.questionoftheaccident

import by.europrotocol.fragment.base.IView

interface IQuestionOfTheAccidentView: IView {

    fun showNeedStateTrafficInspectorateCall()

    fun approveNext(isApprove: Boolean)
}