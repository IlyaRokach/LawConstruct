package by.europrotocol.drawing

import android.graphics.Bitmap
import by.europrotocol.data.model.EuroProtocolModel
import by.europrotocol.data.model.drawing.CoordinatesProvider

class ProtocolDrawer(
    private val image: Bitmap,
    private val protocol: EuroProtocolModel
) {
    private val drawer: Drawer = Drawer(image)
    private val provider1 = CoordinatesProvider(1, hit = protocol.roadAccidentParticipantOne.placeOfInitialStrike)
    private val provider2 = CoordinatesProvider(2, hit = protocol.roadAccidentParticipantTwo.placeOfInitialStrike)


    fun drawProtocol():Bitmap {
        drawCommon()
        drawParticipiant(provider1, protocol.roadAccidentParticipantOne)
        drawParticipiant(provider2, protocol.roadAccidentParticipantTwo)
        return image
    }

    private fun drawCommon() {
        drawer.drawText(provider1.date, protocol.dateAccident.dateCarAccident)
        drawer.drawText(provider1.time, protocol.dateAccident.timeCarAccident)
        drawer.drawText(provider1.placeCountry, protocol.placeAccident.county)
        drawer.drawText(provider1.place, protocol.placeAccident.placeCarAccident)
        drawer.drawCross(provider1.anotherVehicles)
        drawer.drawCross(provider1.anotherObjects)
        drawer.drawCross(provider1.injuredPersons)
        drawer.drawText(provider1.witnesses, protocol.witnesses)
        if (protocol.scheme != null) {
            drawer.drawScheme(provider1.scheme, protocol.scheme ?: return)
        }
        drawer.drawText(provider1.witnesses, protocol.witnesses)
    }

    private fun drawParticipiant(
        provider: CoordinatesProvider,
        participant: EuroProtocolModel.RoadAccidentParticipant
    ) {
        drawer.drawText(provider.driverSurname, participant.driverInfo.fistName)
        drawer.drawText(provider.driverName, participant.driverInfo.name)
        drawer.drawText(provider.driverPatronymic, participant.driverInfo.patronymic)
        drawer.drawText(provider.driverAddress, participant.driverInfo.residenceAdress)
        drawer.drawText(provider.driverBirthDay, participant.driverInfo.dateBirthday)
        drawer.drawText(provider.driverCountry, participant.driverInfo.country)
        drawer.drawText(provider.driverPhoneOrEmail, participant.driverInfo.mobilePhoneOrEmail)
        drawer.drawText(provider.driverSeries, participant.driverInfo.driverLicense.series)
        drawer.drawText(provider.driverNumber, participant.driverInfo.driverLicense.number)
        var category = ""
        participant.driverInfo.driverLicense.category.forEach {
            category += "$it "
        }
        drawer.drawText(provider.driverCategory, category)
        drawer.drawText(provider.driverFinishDate, participant.driverInfo.driverLicense.validFinishDate)

        drawer.drawText(provider.holderName, participant.policyholderInformation.name)
        drawer.drawText(provider.holderSurname, participant.policyholderInformation.fistName)
        drawer.drawText(provider.holderPatronymic, participant.policyholderInformation.patronymic)
        drawer.drawText(provider.holderCountry, participant.policyholderInformation.residenceCountry)
        drawer.drawText(provider.holderAddress, participant.policyholderInformation.residenceAdress)
        drawer.drawText(provider.holderPostalCode, participant.policyholderInformation.postalCode)
        drawer.drawText(provider.holderPhoneOrEmail, participant.policyholderInformation.mobilePhoneOrEmail)

        drawer.drawText(provider.insurerCompany, participant.insurerInformation.nameCompany)
        drawer.drawLine(provider.insurerCertificate)
        drawer.drawCross(provider.voluntary)
        drawer.drawText(provider.insurerSeries, participant.insurerInformation.series)
        drawer.drawText(provider.insurerNumber, participant.insurerInformation.number)
        drawer.drawText(provider.insurerCountry, participant.insurerInformation.country)
        drawer.drawText(provider.insurerStartDate, participant.insurerInformation.startDate)
        drawer.drawText(provider.insurerFinishDate, participant.insurerInformation.finishDate)

        drawer.drawText(provider.model, participant.autoInfo.carModel)
        drawer.drawText(provider.registartionNumber, participant.autoInfo.registrationNumber)
        drawer.drawText(provider.registrationCountry, participant.autoInfo.countryRegistration)
        drawer.drawText(provider.trailerNumber, participant.autoInfo.trailerInfo?.registrationNumber ?: "")
        drawer.drawText(provider.trailerRegistrationCountry, participant.autoInfo.trailerInfo?.countryRegistration ?: "")

        if (participant.signature != null) {
            drawer.drawSignature(provider.signature, participant.signature ?: return)
            if (participant.iClaimToBeResponsibleForTheHarm) {
                drawer.drawSignature(provider.responsibleSignature, participant.signature ?: return)
                val responsibleName = "${participant.driverInfo.fistName} ${participant.driverInfo.name.first()}. ${participant.driverInfo.patronymic.first()}."
                drawer.drawText(provider.responsibleName, responsibleName)
            }
        }

        var count = 0
        if (participant.accidentCircumstances.didNotMaintainSafeDistance) {
            drawer.drawCross(provider.safeDistance)
            count++
        }
        if (participant.accidentCircumstances.didNotComplyWithRequiredLateralInterval) {
            drawer.drawCross(provider.lateralInterval)
            count++
        }
        if (participant.accidentCircumstances.rebuiltAnotherLane) {
            drawer.drawCross(provider.anotherLane)
            count++
        }
        if (participant.accidentCircumstances.turnedRight) {
            drawer.drawCross(provider.turnRight)
            count++
        }
        if (participant.accidentCircumstances.turnedLeft) {
            drawer.drawCross(provider.turnLeft)
            count++
        }
        if (participant.accidentCircumstances.turnedAround) {
            drawer.drawCross(provider.turnAround)
            count++
        }
        if (participant.accidentCircumstances.backUp) {
            drawer.drawCross(provider.backUp)
            count++
        }
        if (participant.accidentCircumstances.droveOffRoadway) {
            drawer.drawCross(provider.droveOff)
            count++
        }
        if (participant.accidentCircumstances.leftToTheIntersectionProhibitionSignal) {
            drawer.drawCross(provider.redCrossroad)
            count++
        }
        if (participant.accidentCircumstances.droveIntoTheOncomingLane) {
            drawer.drawCross(provider.oncomingLane)
            count++
        }
        if (participant.accidentCircumstances.violatedTheRulesOfOvertaking) {
            drawer.drawCross(provider.overtaking)
            count++
        }
        if (participant.accidentCircumstances.startedMovingAfterStoppingOrParking) {
            drawer.drawCross(provider.moveAfterStop)
            count++
        }
        if (participant.accidentCircumstances.didNotComplyWithPriorityMarkRequirement) {
            drawer.drawCross(provider.priorityMark)
            count++
        }
        if (participant.accidentCircumstances.DepartedFromSecondaryRoadAdjacentToTheTerritory) {
            drawer.drawCross(provider.secondaryRoad)
            count++
        }
        if (participant.accidentCircumstances.movedAroundTheTerritoryInThePresenceOfAnObstacleToTheRight) {
            drawer.drawCross(provider.aroundTerritory)
            count++
        }
        if (participant.accidentCircumstances.movedAroundTheRoundabout) {
            drawer.drawCross(provider.roundRoad)
            count++
        }
        if (participant.accidentCircumstances.collidedWithaStandingVehicle) {
            drawer.drawCross(provider.standVehicle)
            count++
        }
        if (participant.accidentCircumstances.stoppedOrForcedlyStoppedOrStood) {
            drawer.drawCross(provider.forceStop)
            count++
        }
        if (participant.accidentCircumstances.otherViolationNotSpecifiedInParagraph1to18) {
            drawer.drawCross(provider.anotherViolation)
            count++
        }
        drawer.drawText(provider.count, count.toString())

        provider.hitPlaces.forEach {
            drawer.drawCross(it)
        }


        //TODO add multiline text drawing
        //drawer.drawText(provider.notes, participant.myNotes)
    }

}