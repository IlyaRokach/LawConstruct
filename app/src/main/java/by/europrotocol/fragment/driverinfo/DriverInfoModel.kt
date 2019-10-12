package by.europrotocol.fragment.driverinfo

class DriverInfoModel {
    var fistName: String = ""
    var name: String = ""
    var patronymic: String = ""
    var residenceAdress: String = ""
    var dateBirthday: String = ""
    var zipCode: String = ""
    var country: String = ""
    var mobilePhoneOrEmail: String = ""
    var driverLicense: DriverLicense = DriverLicense()

    class DriverLicense {
        var series: String = ""
        var number: String = ""
        var category: Set<String> = setOf()
        var validFinishDate: String = ""
    }
}
