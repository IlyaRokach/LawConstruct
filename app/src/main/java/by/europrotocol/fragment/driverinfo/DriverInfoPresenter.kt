package by.europrotocol.fragment.driverinfo

import by.europrotocol.BuildConfig
import by.europrotocol.R
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.data.model.PolicyholderInformation
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver
import com.google.gson.Gson
import java.lang.reflect.Type

class DriverInfoPresenter(
    view: IDriverInfoView
): BaseRegistrationPresenter<IDriverInfoView>(view), IDriverInfoPresenter {

    protected val infoModel: DriverInfoModel = DriverInfoModel()
    private var isInsuranceHolder: Boolean = false

    override fun onCreate() {
        super<BaseRegistrationPresenter>.onCreate()
        if (BuildConfig.DEBUG) {
            when (getView()!!.getTypeDriver().type){
                TypeDriver.ONE -> {
                    infoModel.fistName = "Иванов"
                    infoModel.name = "Иван"
                    infoModel.patronymic = "Иванович"
                    infoModel.dateBirthday = "20.09.1995"
                    infoModel.residenceAdress = "г.Минск Шарафанянская 12А 221-3"
                    infoModel.country = "РБ"
                    infoModel.zipCode = "123456"
                    infoModel.driverLicense.series = "MC"
                    infoModel.driverLicense.number = "123456"
                    infoModel.driverLicense.category = setOf("B")
                    infoModel.driverLicense.validFinishDate = "25.08.2026"
                }
                TypeDriver.TWO -> {
                    infoModel.fistName = "Петров"
                    infoModel.name = "Пётр"
                    infoModel.patronymic = "Петрович"
                    infoModel.dateBirthday = "25.12.1991"
                    infoModel.residenceAdress = "г.Гродно Кирилла Туровского 1А 112-1"
                    infoModel.country = "РБ"
                    infoModel.zipCode = "123444"
                    infoModel.driverLicense.series = "MC"
                    infoModel.driverLicense.number = "142424"
                    infoModel.driverLicense.category = setOf("B","A")
                    infoModel.driverLicense.validFinishDate = "25.08.2023"
                }
            }
            getView()!!.setInitData(infoModel)
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

    override fun onDateBirthday(changedText: String) {
        infoModel.dateBirthday = changedText
    }

    override fun onCountry(changedText: String) {
        infoModel.country = changedText
    }

    override fun onZipCode(changedText: String) {
        infoModel.zipCode = changedText
    }

    override fun onSeries(changedText: String) {
        infoModel.driverLicense.series = changedText
    }

    override fun onNumber(changedText: String) {
        infoModel.driverLicense.number = changedText
    }

    override fun onCategory(changedText: String) {

        val array = changedText.split(",").toTypedArray()

        infoModel.driverLicense.category = array.toHashSet()
    }

    override fun onValidFinishDate(changedText: String) {
        infoModel.driverLicense.validFinishDate = changedText
    }

    override fun onCheckBox(isChecked: Boolean) {
        isInsuranceHolder = isChecked
    }

    override fun onNextRequest() {
        if (infoModel.fistName.isEmpty()){
            getView()!!.showFirstNameRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }

        if (infoModel.name.isEmpty()) {
            getView()!!.showNameRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }

        val data = DriverInfo(
            infoModel.fistName,
            infoModel.name,
            infoModel.patronymic,
            infoModel.residenceAdress,
            infoModel.dateBirthday,
            infoModel.country,
            infoModel.mobilePhoneOrEmail,
            DriverInfo.DriverLicense(
                infoModel.driverLicense.series,
                infoModel.driverLicense.number,
                infoModel.driverLicense.category,
                infoModel.driverLicense.validFinishDate
            )
        )

        val insuranceHolder = PolicyholderInformation(
            infoModel.fistName,
            infoModel.name,
            infoModel.patronymic,
            infoModel.residenceAdress,
            infoModel.country,
            infoModel.zipCode,
            infoModel.mobilePhoneOrEmail
        )

        val typeDriver = getView()!!.getTypeDriver().type
        when (typeDriver){
            TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                data
            )
            TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                data
            )
        }

        if (isInsuranceHolder) {
            when (typeDriver){
                TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                insuranceHolder
                )
                TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                insuranceHolder
                )
            }
        }

        getView()!!.approveNext(true)
    }
}