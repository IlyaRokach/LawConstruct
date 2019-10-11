package by.europrotocol.data.repository

import by.europrotocol.data.model.*
import by.europrotocol.fragment.base.TypeDriver

interface EuroProtocolRepository: RepositoryEuroProtocolConvertPdf {
    fun saveDriverOne(info: AccidentCircumstances)
    fun saveDriverTwo(info: AccidentCircumstances)

    fun saveDriverOne(info: DriverInfo)
    fun saveDriverTwo(info: DriverInfo)

    fun saveDriverOne(info: AutoInfo)
    fun saveDriverTwo(info: AutoInfo)

    fun saveDriverOne(info: InsurerInformation)
    fun saveDriverTwo(info: InsurerInformation)

    fun saveDriverOne(info: Set<PlaceOfImpact>)
    fun saveDriverTwo(info: Set<PlaceOfImpact>)

    fun saveDriverOne(info: PolicyholderInformation)
    fun saveDriverTwo(info: PolicyholderInformation)

    fun saveDriverOne(info: NotesDriver)
    fun saveDriverTwo(info: NotesDriver)

    fun readPolicyholderInformation(typeDriver: TypeDriver): PolicyholderInformation?

    fun saveEuroProtocolInternModel(witnesses: EuroProtocolInternModel)
}