package by.europrotocol.fragment.autoinfo

import by.europrotocol.R
import by.europrotocol.data.model.AutoInfo
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.data.model.TrailerInfo
import by.europrotocol.fragment.base.BaseRegistrationPresenter
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

    override fun onNextRequest() {
        if (autoInfoModel.carModel.isEmpty()){
            getView()!!.showCarModelRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }
        if (autoInfoModel.registrationNumber.isEmpty()) {
            getView()!!.showRegistrationNumberRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }

        if (autoInfoModel.countryRegistration.isEmpty()) {
            getView()!!.showCountryRegistrationRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }

        var trailerInfo: TrailerInfo? = null
        if (autoInfoModel.trailerInfo != null) {
            trailerInfo = TrailerInfo(
                autoInfoModel.trailerInfo!!.registrationNumber,
                autoInfoModel.trailerInfo!!.countryRegistration)
        }

        val driverInfo: AutoInfo = AutoInfo(
            autoInfoModel.carModel,
            autoInfoModel.registrationNumber,
            autoInfoModel.countryRegistration,
            trailerInfo
        )

        addDisposable(Single.just(driverInfo)
            .map {
                var gson = Gson()
                gson.toJson(it)
            }.map {
                val drover = by.europrotocol.data.repository.db.entity.DriverInfo()
                drover.json = it
                drover.isUser = true
                getView()!!.getApplication().getBase().userDao.insert(
                    drover
                )
                return@map true
            }.subscribe(Consumer {
                getView()!!.approveNext(true)
            } ))
    }

}