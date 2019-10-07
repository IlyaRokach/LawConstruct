package by.europrotocol.data.repository

import by.europrotocol.data.model.*

class StubRepository: RepositoryEuroProtocolConvertPdf {
    override fun getPdfModel(): EuroProtocolModel = EuroProtocolModel(
        EuroProtocolModel.DateAccident("07-09-2019", "12:00"),
        EuroProtocolModel.PlaceAccident("РБ","ул. Захарова 25а"),
        false,
        roadAccidentParticipantOne = EuroProtocolModel.RoadAccidentParticipant(
            PolicyholderInformation(
                "Иванов",
                "Иван",
                "Иванович",
                    "РБ",
                "г. Минск ул.Шаранговича, 99-568",
                "",
                "+37529180xxxx"
            ),
            InsurerInformation(
                "ЗАСО Белнефтестрах",
                true,
                "Полис",
                "ВА",
                "5236985",
                "РБ",
                "21.09.2019",
                "20.09.2020"
            ), DriverInfo(
                "Иванов",
                "Иван",
                "Иванович",
                "г.Минск, ул. Шаранговича, 99-568",
                "28.07.1980",
                "РБ",
                "+37529180хххх",
                DriverInfo.DriverLicense(
                    "MMA", "1095988", setOf("B", "AM"), "29.04.2021"
                )
            ),
            AutoInfo(
                "PEUGEOT 406",
                "2598 PK-7",
                "РБ"
            ),
            AccidentCircumstances(turnedLeft = true, stoppedOrForcedlyStoppedOrStood = true),
            placeOfInitialStrike = setOf(PlaceOfImpact.BACK_BUMPER, PlaceOfImpact.BACK_RIGHT_WING)
        ),
        roadAccidentParticipantTwo = EuroProtocolModel.RoadAccidentParticipant(
            PolicyholderInformation(
                "Петров",
                "Пётр",
                "Петрович",
                "РБ",
                "г. Гродно ул.Киселёва, 89-622",
                "",
                "+37529569xxxx"
            ),
            InsurerInformation(
                "ЗАСО Белнефтестрах",
                true,
                "Полис",
                "ВА",
                "8592684",
                "РБ",
                "08.08.2019",
                "07.08.2020"
            ), DriverInfo(
                "Петров",
                "Пётр",
                "Петрович",
                "г. Гродно ул.Киселёво, 89-622",
                "27.03.1986",
                "РБ",
                "+37529569xxxx",
                DriverInfo.DriverLicense(
                    "КА", "0236856", setOf("B"), "24.05.2021"
                )
            ),
            AutoInfo(
                "CITROEN C3",
                "3106 HP-4",
                "РБ"
            ),
            AccidentCircumstances(didNotComplyWithRequiredLateralInterval = true),
            myNotes = "Не рассчитал габаритные размеры трансп. средства",
            placeOfInitialStrike = setOf(PlaceOfImpact.FRONT_BUMPER, PlaceOfImpact.FRONT_LEFT_WING)
        )
    )
}