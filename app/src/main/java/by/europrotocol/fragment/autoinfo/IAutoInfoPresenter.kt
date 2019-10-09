package by.europrotocol.fragment.physicaluser

import by.europrotocol.fragment.base.IPresenter

interface IAutoInfoPresenter: IPresenter {

    fun onChangeCarModel(changedText: String)

    fun onChangeRegistrationNumber(changedText: String)

    fun onChangeCountryRegistration(changedText: String)

    fun onChangeRegistrationNumberTrailer(changedText: String)

    fun onChangeCountryRegistrationTrailer(changedText: String)

    fun onChangeChecedAvailableTrailer(isAvailable: Boolean)

    fun onNextRequest()
}