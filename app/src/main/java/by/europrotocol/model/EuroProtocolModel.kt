package by.europrotocol.model

class EuroProtocolModel (

    // Лица получившие телесные повреждения
    val isInjuredPersons: Boolean,
    // прочине транспортные средства
    val isotherVehicles: Boolean,
    // инные объекты кроме транспортных средств
    val isOtherObject: Boolean,
    val roadAccidentParticipantOne: RoadAccidentParticipant,
    val roadAccidentParticipantTwo: RoadAccidentParticipant
) {

    class DateAccident (
        // Дата ДТП
        val dateCarAccident: String,
        // Время ДТП
        val timeCarAccident: String
    )

    class PlaceAccident (
        // страна
        val county: String,
        // местро ДТП
        val placeCarAccident: String
    )

    class RoadAccidentParticipant (
        val policyholderInformation: PolicyholderInformation,
        val insurerInformation: InsurerInformation,
        val driverInfo: DriverInfo,
        val autoInfo: AutoInfo,
        val accidentCircumstances: AccidentCircumstances,
        val myNotes: String
    )
}