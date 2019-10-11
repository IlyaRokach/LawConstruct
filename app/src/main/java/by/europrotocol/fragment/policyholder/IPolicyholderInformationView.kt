package by.europrotocol.fragment.policyholder

import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface IPolicyholderInformationView: IView {
    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)

    fun initValue(model: PolicyHolderModel)
}