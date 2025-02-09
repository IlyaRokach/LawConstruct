package by.europrotocol.data.model

open class DriverInfo (
    open val fistName: String,
    open val name: String,
    open val patronymic: String,
    open val residenceAdress: String = "",
    open val dateBirthday: String = "",
    open val country: String = "",
    open val mobilePhoneOrEmail: String = "",
    open val driverLicense: DriverLicense = DriverLicense()
) {
    open class DriverLicense (
        open val series: String = "",
        open val number: String = "",
        open val category: Set<String> = setOf(),
        open val validFinishDate: String = ""
    )
}