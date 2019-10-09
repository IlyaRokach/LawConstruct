package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.BaseRegistrationPresenter

class PrivateInfoDriverPresenter(view: IPrivateInfoDriverView): BaseRegistrationPresenter<IPrivateInfoDriverView>(view), IPrivateInfoDriverPresenter {

    protected val privateInfoDriverModel: PrivateInfoDriverModel = PrivateInfoDriverModel()

    override fun onChangeFirstName(changedText: String) {
        privateInfoDriverModel.firstName = changedText
    }

    override fun onChangeName(changedText: String) {
        privateInfoDriverModel.name = changedText
    }

    override fun onChangePatronymic(changedText: String) {
        privateInfoDriverModel.patronymic
    }

    override fun onNextRequest() {

    }

}