package by.europrotocol.fragment.placeofaccident

import by.europrotocol.data.model.EuroProtocolInternModel
import by.europrotocol.data.model.EuroProtocolModel
import by.europrotocol.fragment.base.BaseRegistrationPresenter

class PlaceOfAccidentPresenter (
    questionOfTheAccidentView: IPlaceOfAccidentView
) : BaseRegistrationPresenter<IPlaceOfAccidentView>(questionOfTheAccidentView),
    IPlaceOfAccidentPresenter {

    private val placeOfAccidentModel: PlaceOfAccidentModel = PlaceOfAccidentModel()
    override fun onDate(date: String) {
        placeOfAccidentModel.dateAccident.dateCarAccident = date
    }

    override fun onTime(time: String) {
        placeOfAccidentModel.dateAccident.timeCarAccident = time
    }

    override fun onPlace(place: String) {
        placeOfAccidentModel.placeAccident.placeCarAccident = place
    }

    override fun onFIo(fio: String) {
        placeOfAccidentModel.witnesses.plus(fio).plus(" ")
    }

    override fun onAddress(address: String) {
        placeOfAccidentModel.witnesses.plus(address).plus(" ")
    }

    override fun onPhone(phone: String) {
        placeOfAccidentModel.witnesses.plus(phone).plus(" ")
    }

    override fun onNextRequest() {
        val result = placeOfAccidentModel.dateAccident.dateCarAccident.isNotEmpty() &&
                placeOfAccidentModel.dateAccident.timeCarAccident.isNotEmpty() &&
                placeOfAccidentModel.placeAccident.placeCarAccident.isNotEmpty()

        if (result) {

            getView()!!.getApplication().getEuroProtocolRepository().saveEuroProtocolInternModel(
                EuroProtocolInternModel(
                    EuroProtocolModel.DateAccident(
                        placeOfAccidentModel.dateAccident.dateCarAccident,
                        placeOfAccidentModel.dateAccident.timeCarAccident),
                    EuroProtocolModel.PlaceAccident(
                        placeOfAccidentModel.placeAccident.county,
                        placeOfAccidentModel.placeAccident.placeCarAccident
                    ),
                    placeOfAccidentModel.isInjuredPersons,
                    placeOfAccidentModel.isotherVehicles,
                    placeOfAccidentModel.isOtherObject,
                    placeOfAccidentModel.witnesses
                )
            )
        }
        getView()!!.approveNext(
            result
        )
    }
}