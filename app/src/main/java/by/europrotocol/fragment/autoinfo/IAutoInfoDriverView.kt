package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.IView

interface IAutoInfoDriverView: IView {

    fun showCarModelRequiredError(errorMessage: String)
    fun showRegistrationNumberRequiredError(errorMessage: String)
    fun showCountryRegistrationRequiredError(errorMessage: String)

    fun showTrailerInfo()
    fun hideTrailerInfo()

    fun approveNext(isApprove: Boolean)
}