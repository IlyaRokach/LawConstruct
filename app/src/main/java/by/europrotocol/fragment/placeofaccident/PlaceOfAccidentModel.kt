package by.europrotocol.fragment.placeofaccident

class PlaceOfAccidentModel (
    // Дата инцидента
    var dateAccident: DateAccident = DateAccident(),
    // место дтп
    var placeAccident: PlaceAccident = PlaceAccident(),
    // Лица получившие телесные повреждения
    var isInjuredPersons: Boolean = false,
    // прочине транспортные средства
    var isotherVehicles: Boolean = false,
    // инные объекты кроме транспортных средств
    var isOtherObject: Boolean = false,
    // свидетели
    var witnesses: String = ""
) {
    class DateAccident (
        // Дата ДТП
        var dateCarAccident: String = "",
        // Время ДТП
        var timeCarAccident: String = ""
    )

    class PlaceAccident (
        // страна
        var county: String = "РБ",
        // местро ДТП
        var placeCarAccident: String = ""
    )
}