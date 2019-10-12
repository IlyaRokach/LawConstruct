package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.autoinfo.AutoInfoModel
import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface IAutoInfoDriverView: IView {

    fun showCarModelRequiredError(errorMessage: String)
    fun showRegistrationNumberRequiredError(errorMessage: String)
    fun showCountryRegistrationRequiredError(errorMessage: String)

    fun showTrailerInfo()
    fun hideTrailerInfo()

    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)

    fun setInitModel(model: AutoInfoModel)
}