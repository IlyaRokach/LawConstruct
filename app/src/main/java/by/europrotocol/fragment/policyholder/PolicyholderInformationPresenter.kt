package by.europrotocol.fragment.policyholder

import by.europrotocol.BuildConfig
import by.europrotocol.R
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.data.model.PolicyholderInformation
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver

class PolicyholderInformationPresenter(
    placeOfImpactView: IPolicyholderInformationView
) : BaseRegistrationPresenter<IPolicyholderInformationView>(placeOfImpactView), IPolicyholderInformationPresenter  {

    private val infoModel: PolicyHolderModel = PolicyHolderModel()

    override fun onCreate() {
        super<BaseRegistrationPresenter>.onCreate()

        val insuranceData: PolicyholderInformation? = getView()!!.getApplication().getEuroProtocolRepository().readPolicyholderInformation(getView()!!.getTypeDriver())
        if (insuranceData != null) {
            infoModel.zipCode = insuranceData.postalCode
            infoModel.country = insuranceData.residenceCountry
            infoModel.mobilePhoneOrEmail = insuranceData.mobilePhoneOrEmail
            infoModel.fistName = insuranceData.fistName
            infoModel.name = insuranceData.name
            infoModel.patronymic = insuranceData.patronymic
            infoModel.residenceAdress = insuranceData.residenceAdress

            getView()!!.initValue(infoModel)
        } else if (BuildConfig.DEBUG) {
            when (getView()!!.getTypeDriver().type){
                TypeDriver.ONE -> {
                    infoModel.zipCode = "123456"
                    infoModel.country = "РБ"
                    infoModel.mobilePhoneOrEmail = "+375291233456"
                    infoModel.fistName = "Иванов"
                    infoModel.name = "Иван"
                    infoModel.patronymic = "Иванович"
                    infoModel.residenceAdress = "г.Минск ул.Шарафанянская 22 229-4"
                }
                TypeDriver.TWO -> {
                    infoModel.zipCode = "132426"
                    infoModel.country = "РБ"
                    infoModel.mobilePhoneOrEmail = "+375441233456"
                    infoModel.fistName = "Петров"
                    infoModel.name = "Пётр"
                    infoModel.patronymic = "Петрович"
                    infoModel.residenceAdress = "г.Минск ул.Уманская 22 112-4"
                }
            }
            getView()!!.initValue(infoModel)
        }
    }

    override fun onChangeFirstName(changedText: String) {
        infoModel.fistName = changedText
    }

    override fun onChangeName(changedText: String) {
        infoModel.name = changedText
    }

    override fun onChangePatronymic(changedText: String) {
        infoModel.patronymic
    }

    override fun onResidenceAdress(changedText: String) {
        infoModel.residenceAdress = changedText
    }

    override fun onCountry(changedText: String) {
        infoModel.country = changedText
    }

    override fun onZipCode(changedText: String) {
        infoModel.zipCode = changedText
    }

    override fun onMobilePhoneOrEmail(text: String) {
        infoModel.mobilePhoneOrEmail = text
    }

    override fun onNextRequest() {

        val data = PolicyholderInformation(
            infoModel.fistName,
            infoModel.name,
            infoModel.patronymic,
            infoModel.residenceAdress,
            infoModel.country,
            infoModel.zipCode,
            infoModel.mobilePhoneOrEmail
        )

        when (getView()!!.getTypeDriver().type){
            TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                data
            )
            TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                data
            )
        }

        getView()!!.approveNext(true)
    }
}