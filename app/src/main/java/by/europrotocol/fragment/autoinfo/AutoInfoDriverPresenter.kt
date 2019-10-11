package by.europrotocol.fragment.autoinfo

import by.europrotocol.R
import by.europrotocol.data.model.AutoInfo
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.data.model.TrailerInfo
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.physicaluser.IAutoInfoDriverView
import by.europrotocol.fragment.physicaluser.IAutoInfoPresenter
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.functions.Consumer

class AutoInfoDriverPresenter(view: IAutoInfoDriverView): BaseRegistrationPresenter<IAutoInfoDriverView>(view), IAutoInfoPresenter {

    protected val autoInfoModel: AutoInfoModel = AutoInfoModel()

    override fun onChangeCarModel(changedText: String) {
        autoInfoModel.carModel = changedText
    }

    override fun onChangeRegistrationNumber(changedText: String) {
        autoInfoModel.registrationNumber = changedText
    }

    override fun onChangeCountryRegistration(changedText: String) {
        autoInfoModel.countryRegistration = changedText
    }

    override fun onChangeRegistrationNumberTrailer(changedText: String) {
        if (autoInfoModel.trailerInfo != null) {
            autoInfoModel.trailerInfo?.registrationNumber = changedText
        }
    }

    override fun onChangeCountryRegistrationTrailer(changedText: String) {
        if (autoInfoModel.trailerInfo != null) {
            autoInfoModel.trailerInfo?.countryRegistration = changedText
        }
    }

    override fun onChangeChecedAvailableTrailer(isAvailable: Boolean) {
        if (isAvailable) {
            getView()!!.showTrailerInfo()
        } else {
            getView()!!.showTrailerInfo()
        }
    }

    override fun onNextRequest() {

        var isApprove = true

        if (autoInfoModel.carModel.isEmpty()){
            getView()!!.showCarModelRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }
        if (autoInfoModel.registrationNumber.isEmpty()) {
            getView()!!.showRegistrationNumberRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (autoInfoModel.countryRegistration.isEmpty()) {
            getView()!!.showCountryRegistrationRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (!isApprove) {
            getView()!!.approveNext(isApprove)
        }

        var trailerInfo: TrailerInfo? = null
        if (autoInfoModel.trailerInfo != null) {
            trailerInfo = TrailerInfo(
                autoInfoModel.trailerInfo!!.registrationNumber,
                autoInfoModel.trailerInfo!!.countryRegistration)
        }

        val driverInfo = AutoInfo(
            autoInfoModel.carModel,
            autoInfoModel.registrationNumber,
            autoInfoModel.countryRegistration,
            trailerInfo
        )

        when (getView()!!.getTypeDriver().type){
            TypeDriver.ONE -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverOne(
                driverInfo
            )
            TypeDriver.TWO -> getView()!!.getApplication().getEuroProtocolRepository().saveDriverTwo(
                driverInfo
            )
        }
        getView()!!.approveNext(true)
    }

}