package by.europrotocol.fragment.InsurerInformation

import by.europrotocol.fragment.base.IPresenter

interface IInsurerInformationPresenter: IPresenter {

    fun onChangeNameCompany(changedText: String)

    fun onChangeCertificate(changedText: String)

    fun onChangeSeries(changedText: String)

    fun onChangeNumber(changedText: String)

    fun onChangeCountry(changedText: String)

    fun onChangeStartDate(changedText: String)

    fun onChangeFinishDate(changedText: String)

    fun onChangeCheckedVoluntary(isAvailable: Boolean)

    fun onNextRequest()
}