package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.IPresenter

interface IPrivateInfoDriverPresenter: IPresenter {

    fun onChangeFirstName(changedText: String)

    fun onChangeName(changedText: String)

    fun onChangePatronymic(changedText: String)

    fun onNextRequest()
}