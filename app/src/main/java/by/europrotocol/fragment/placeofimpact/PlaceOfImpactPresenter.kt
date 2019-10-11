package by.europrotocol.fragment.placeofimpact

import by.europrotocol.data.model.PlaceOfImpact
import by.europrotocol.fragment.base.BaseRegistrationPresenter

class PlaceOfImpactPresenter(placeOfImpactView: IPlaceOfImpactView) : BaseRegistrationPresenter<IPlaceOfImpactView>(placeOfImpactView), IPlaceOfImpactPresenter  {

    private val setPlaceOfImpact: MutableSet<PlaceOfImpact> = mutableSetOf()

    override fun onAddPlaceOfImpact(placeOfImpact: PlaceOfImpact) {
        setPlaceOfImpact.add(placeOfImpact)
    }

    override fun onRemovePlaceOfImpact(placeOfImpact: PlaceOfImpact) {
        setPlaceOfImpact.remove(placeOfImpact)
    }

    override fun onNextRequest() {
        getView()!!.approveNext(setPlaceOfImpact.isNotEmpty())
    }
}