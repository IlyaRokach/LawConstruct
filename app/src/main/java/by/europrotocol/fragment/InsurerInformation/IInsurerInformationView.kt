package by.europrotocol.fragment.InsurerInformation

import by.europrotocol.fragment.base.IView

interface IInsurerInformationView: IView {

    fun showNameCompanyError(errorMessage: String)
    fun showCertificateError(errorMessage: String)
    fun showSeriesError(errorMessage: String)
    fun showNumberError(errorMessage: String)
    fun showCountryError(errorMessage: String)
    fun showStartDateError(errorMessage: String)
    fun showFinishDateError(errorMessage: String)

    fun approveNext(isApprove: Boolean)
}