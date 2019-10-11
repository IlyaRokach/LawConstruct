package by.europrotocol.fragment.driverinfo

import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface IDriverInfoView: IView {

    fun showFirstNameRequiredError(errorMessage: String)
    fun showNameRequiredError(errorMessage: String)

    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)

    fun setInitData(model: DriverInfoModel)
}