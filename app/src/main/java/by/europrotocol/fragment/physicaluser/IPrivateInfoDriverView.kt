package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.IView

interface IPrivateInfoDriverView: IView {

    fun showFirstNameRequiredError(errorMessage: String)
    fun showNameRequiredError(errorMessage: String)

    fun approveNext(isApprove: Boolean)
}