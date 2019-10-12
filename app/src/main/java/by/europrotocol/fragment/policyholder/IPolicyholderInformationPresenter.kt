package by.europrotocol.fragment.policyholder

import by.europrotocol.fragment.base.IPresenter

interface IPolicyholderInformationPresenter: IPresenter {

    fun onChangeFirstName(changedText: String)

    fun onChangeName(changedText: String)

    fun onChangePatronymic(changedText: String)

    fun onResidenceAdress(changedText: String)

    fun onCountry(changedText: String)

    fun onZipCode(changedText: String)

    fun onMobilePhoneOrEmail(text: String)

    fun onNextRequest() {

    }
}