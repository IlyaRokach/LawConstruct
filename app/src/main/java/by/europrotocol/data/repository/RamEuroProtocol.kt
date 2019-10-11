package by.europrotocol.data.repository

import by.europrotocol.data.model.*

object RamEuroProtocol : EuroProtocolRepository {

    var witnesses: EuroProtocolInternModel? = null
    //One
    var accidentCircumstancesOne: AccidentCircumstances? = null
    var driverInfoOne: DriverInfo? = null
    var autoInfoOne: AutoInfo? = null
    var insurerInformationOne: InsurerInformation? = null
    var placeOfImpactOne: Set<PlaceOfImpact> = setOf()
    var policyholderInformationOne: PolicyholderInformation? = null
    var notesDriverOne: NotesDriver? = null

    //Two
    var accidentCircumstancesTwo: AccidentCircumstances? = null
    var driverInfoTwo: DriverInfo? = null
    var autoInfoTwo: AutoInfo? = null
    var insurerInformationTwo: InsurerInformation? = null
    var placeOfImpactTwo: Set<PlaceOfImpact> = setOf()
    var policyholderInformationTwo: PolicyholderInformation? = null
    var notesDriverTwo: NotesDriver? = null

    override fun getPdfModel(): EuroProtocolModel = EuroProtocolModel(
        witnesses!!.dateAccident,
        witnesses!!.placeAccident,
        witnesses!!.isInjuredPersons,
        witnesses!!.isotherVehicles,
        witnesses!!.isOtherObject,
        witnesses!!.witnesses,
        EuroProtocolModel.RoadAccidentParticipant(
            policyholderInformationOne!!,
            insurerInformationOne!!,
            driverInfoOne!!,
            autoInfoOne!!,
            accidentCircumstancesOne!!,
            notesDriverOne!!.notes,
            notesDriverOne!!.iClaimToBeResponsibleForTheHarm,
            placeOfImpactOne, null),
        EuroProtocolModel.RoadAccidentParticipant(
            policyholderInformationTwo!!,
            insurerInformationTwo!!,
            driverInfoTwo!!,
            autoInfoTwo!!,
            accidentCircumstancesTwo!!,
            notesDriverTwo!!.notes,
            notesDriverTwo!!.iClaimToBeResponsibleForTheHarm,
            placeOfImpactTwo, null)
    )

    override fun saveDriverOne(info: AccidentCircumstances) {
        accidentCircumstancesOne = info
    }

    override fun saveDriverTwo(info: AccidentCircumstances) {
        accidentCircumstancesTwo = info
    }

    override fun saveDriverOne(info: DriverInfo) {
        driverInfoOne = info
    }

    override fun saveDriverTwo(info: DriverInfo) {
        driverInfoTwo = info
    }

    override fun saveDriverOne(info: AutoInfo) {
        autoInfoOne = info
    }

    override fun saveDriverTwo(info: AutoInfo) {
        autoInfoTwo = info
    }

    override fun saveDriverOne(info: InsurerInformation) {
        insurerInformationOne = info
    }

    override fun saveDriverTwo(info: InsurerInformation) {
        insurerInformationTwo = info
    }

    override fun saveDriverOne(info: Set<PlaceOfImpact>) {
        placeOfImpactOne = info
    }

    override fun saveDriverTwo(info: Set<PlaceOfImpact>) {
        placeOfImpactTwo = info
    }

    override fun saveDriverOne(info: PolicyholderInformation) {
        policyholderInformationOne = info
    }

    override fun saveDriverTwo(info: PolicyholderInformation) {
        policyholderInformationTwo = info
    }


    override fun saveDriverOne(info: NotesDriver) {
        notesDriverOne = info
    }

    override fun saveDriverTwo(info: NotesDriver) {
        notesDriverTwo = info
    }

    override fun saveEuroProtocolInternModel(witnesses: EuroProtocolInternModel) {
        this.witnesses = witnesses
    }
}