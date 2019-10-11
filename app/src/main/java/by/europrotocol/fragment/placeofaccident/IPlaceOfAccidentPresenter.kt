package by.europrotocol.fragment.placeofaccident

import by.europrotocol.fragment.base.IPresenter

interface IPlaceOfAccidentPresenter: IPresenter {
    fun onDate(date: String)
    fun onTime(time: String)
    fun onPlace(place: String)

    fun onFIo(fio:String)
    fun onAddress(address:String)
    fun onPhone(phone: String)

    fun onNextRequest()
}