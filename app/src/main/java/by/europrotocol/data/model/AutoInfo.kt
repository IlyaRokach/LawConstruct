package by.europrotocol.data.model

open class AutoInfo (
    open val carModel: String,
    open val registrationNumber: String,
    open val countryRegistration: String,
    open val trailerInfo: TrailerInfo? = null
)