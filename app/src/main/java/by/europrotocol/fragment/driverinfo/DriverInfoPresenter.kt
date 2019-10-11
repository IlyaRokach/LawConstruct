package by.europrotocol.fragment.driverinfo

import by.europrotocol.R
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver
import com.google.gson.Gson

class DriverInfoPresenter(
    view: IDriverInfoView
): BaseRegistrationPresenter<IDriverInfoView>(view), IDriverInfoPresenter {

    protected val infoModel: DriverInfoModel = DriverInfoModel()

    override fun onCreateView() {
        var drivers = getView()!!.getApplication().getBase().userDao.getDriver(true).map {
            var gson = Gson()
            gson.fromJson(it.json, DriverInfo::class.java)
        }
        if (drivers.isNotEmpty()) {
            val driver = drivers.first()
            infoModel.fistName = driver.fistName
            infoModel.name = driver.name
            infoModel.patronymic = driver.patronymic
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