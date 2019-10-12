package by.europrotocol.data.model

class EuroProtocolInternModel (
    // Дата инцидента
    val dateAccident: EuroProtocolModel.DateAccident,
    // место дтп
    val placeAccident: EuroProtocolModel.PlaceAccident,
    // Лица получившие телесные повреждения
    val isInjuredPersons: Boolean = false,
    // прочине транспортные средства
    val isotherVehicles: Boolean = false,
    // инные объекты кроме транспортных средств
    val isOtherObject: Boolean = false,
    // свидетели
    val witnesses: String
)