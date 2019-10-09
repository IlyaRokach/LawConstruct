package by.europrotocol.fragment.driverinfo

import by.europrotocol.fragment.base.IView

interface IDriverInfoView: IView {

    fun showFirstNameRequiredError(errorMessage: String)
    fun showNameRequiredError(errorMessage: String)

    fun approveNext(isApprove: Boolean)
}