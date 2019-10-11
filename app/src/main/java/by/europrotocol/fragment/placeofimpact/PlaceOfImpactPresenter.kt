package by.europrotocol.fragment.placeofimpact

import by.europrotocol.data.model.PlaceOfImpact
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver

class PlaceOfImpactPresenter(
    placeOfImpactView: IPlaceOfImpactView
) : BaseRegistrationPresenter<IPlaceOfImpactView>(placeOfImpactView), IPlaceOfImpactPresenter  {

    private val setPlaceOfImpact: MutableSet<PlaceOfImpact> = mutableSetOf()

    override fun onAddPlaceOfImpact(placeOfImpact: PlaceOfImpact) {
        setPlaceOfImpact.add(placeOfImpact)
    }

    override fun onRemovePlaceOfImpact(placeOfImpact: PlaceOfImpact) {
        setPlaceOfImpact.remove(placeOfImpact)
    }

    override fun onNextRequest() {

        val result = setPlaceOfImpact.isNotEmpty()

        if(result) {
            when (getView()!!.getTypeDriver().type) {
                TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                    setPlaceOfImpact
                )
                TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                    setPlaceOfImpact
                )
            }
        }

        getView()!!.approveNext(result)
    }
}