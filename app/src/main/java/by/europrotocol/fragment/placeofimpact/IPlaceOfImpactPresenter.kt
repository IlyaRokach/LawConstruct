package by.europrotocol.fragment.placeofimpact

import by.europrotocol.data.model.PlaceOfImpact
import by.europrotocol.fragment.base.IPresenter

interface IPlaceOfImpactPresenter: IPresenter {

    fun onAddPlaceOfImpact(placeOfImpact: PlaceOfImpact)
    fun onRemovePlaceOfImpact(placeOfImpact: PlaceOfImpact)

    fun onNextRequest()
}