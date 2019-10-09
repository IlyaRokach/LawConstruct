package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.IView

interface IPrivateInfoDriverView: IView {

    fun showFirstNameReqiredError()
    fun showNameReqiredError()

    fun approveNext(isApprove: Boolean)
}