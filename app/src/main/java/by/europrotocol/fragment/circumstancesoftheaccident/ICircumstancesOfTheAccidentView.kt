package by.europrotocol.fragment.circumstancesoftheaccident

import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface ICircumstancesOfTheAccidentView: IView {

    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)
}