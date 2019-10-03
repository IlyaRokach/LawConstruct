package by.europrotocol.model

class EuroProtocolModel (
    val dateCarAccident: String,
    val timeCarAccident: String,
    val placeCarAccident: String,
    val isInjuredPersons: Boolean,
    val isotherVehicles: Boolean,
    val isOtherObject: Boolean,
    val roadAccidentParticipantOne: RoadAccidentParticipant,
    val roadAccidentParticipantTwo: RoadAccidentParticipant
) {
    class RoadAccidentParticipant (
        val policyholderInformation: PolicyholderInformation,
        val insurerInformation: InsurerInformation,
        val driverInfo: DriverInfo,
        val autoInfo: AutoInfo
    )
}