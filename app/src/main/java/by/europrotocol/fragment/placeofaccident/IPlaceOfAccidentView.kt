package by.europrotocol.fragment.placeofaccident

import by.europrotocol.fragment.base.IView

interface IPlaceOfAccidentView: IView {

    fun approveNext(isApprove: Boolean)

    fun inifValue(model: PlaceOfAccidentModel)
}