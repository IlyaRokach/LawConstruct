package by.europrotocol.fragment.placeofimpact

import by.europrotocol.fragment.base.IView
import by.europrotocol.fragment.base.TypeDriver

interface IPlaceOfImpactView: IView {

    fun getTypeDriver(): TypeDriver

    fun approveNext(isApprove: Boolean)
}