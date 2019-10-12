package by.europrotocol.fragment.driverinfo

import by.europrotocol.fragment.base.IPresenter

interface IDriverInfoPresenter: IPresenter {

    fun onChangeFirstName(changedText: String)

    fun onChangeName(changedText: String)

    fun onChangePatronymic(changedText: String)

    fun onResidenceAdress(changedText: String)

    fun onDateBirthday(changedText: String)

    fun onCountry(changedText: String)

    fun onZipCode(changedText: String)

    fun onSeries(changedText: String)

    fun onNumber(changedText: String)

    fun onCategory(changedText: String)

    fun onValidFinishDate(changedText: String)

    fun onCheckBox(isChecked: Boolean)

    fun onNextRequest()
}