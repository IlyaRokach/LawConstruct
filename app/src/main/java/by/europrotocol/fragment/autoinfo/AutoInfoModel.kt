package by.europrotocol.fragment.autoinfo

class AutoInfoModel (
    var carModel: String = "",
    var registrationNumber: String = "",
    var countryRegistration: String = "",
    var trailerInfo: TrailerInfo? = null
) {
    class TrailerInfo (
        var registrationNumber: String,
        var countryRegistration: String
    )
}