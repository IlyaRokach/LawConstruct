package by.europrotocol.data.model

class EuroProtocolModel (
    // Дата инцидента
    val dateAccident: DateAccident,
    // место дтп
    val placeAccident: PlaceAccident,
    // Лица получившие телесные повреждения
    val isInjuredPersons: Boolean = false,
    // прочине транспортные средства
    val isotherVehicles: Boolean = false,
    // инные объекты кроме транспортных средств
    val isOtherObject: Boolean = false,
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
        // Мои примечания
        val myNotes: String = "",
        // утверждаю, что являюсь ответственным за причинение вреда
        val iClaimToBeResponsibleForTheHarm: Boolean = false,
        val placeOfInitialStrike: Set<PlaceOfImpact> = setOf()
    )
}