package by.europrotocol.fragment.InsurerInformation

import by.europrotocol.R
import by.europrotocol.data.model.AutoInfo
import by.europrotocol.data.model.InsurerInformation
import by.europrotocol.data.model.TrailerInfo
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.functions.Consumer

class InsurerInformationPresenter(
    view: IInsurerInformationView
): BaseRegistrationPresenter<IInsurerInformationView>(view), IInsurerInformationPresenter {

    protected val infoModel: InsurerInformationModel = InsurerInformationModel()

    override fun onChangeNameCompany(changedText: String) {
        infoModel.nameCompany = changedText
    }

    override fun onChangeCertificate(changedText: String) {
        infoModel.certificate = changedText
    }

    override fun onChangeSeries(changedText: String) {
        infoModel.series = changedText
    }

    override fun onChangeNumber(changedText: String) {
        infoModel.number = changedText
    }

    override fun onChangeCountry(changedText: String) {
        infoModel.country = changedText
    }

    override fun onChangeStartDate(changedText: String) {
        infoModel.startDate = changedText
    }

    override fun onChangeFinishDate(changedText: String) {
        infoModel.finishDate = changedText
    }

    override fun onChangeCheckedVoluntary(isAvailable: Boolean) {
        infoModel.isvoluntary = isAvailable
    }

    override fun onNextRequest() {
        var isApprove = true

        if (infoModel.nameCompany.isEmpty()){
            getView()!!.showNameCompanyError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }
        if (infoModel.certificate.isEmpty()) {
            getView()!!.showCertificateError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (infoModel.series.isEmpty()) {
            getView()!!.showSeriesError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (infoModel.number.isEmpty()) {
            getView()!!.showNumberError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (infoModel.country.isEmpty()) {
            getView()!!.showCountryError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (infoModel.startDate.isEmpty()) {
            getView()!!.showStartDateError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (infoModel.finishDate.isEmpty()) {
            getView()!!.showFinishDateError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            isApprove = false
        }

        if (!isApprove) {
            getView()!!.approveNext(isApprove)
        }

        val driverInfo = InsurerInformation(
            infoModel.nameCompany,
            infoModel.isvoluntary,
            infoModel.certificate,
            infoModel.series,
            infoModel.number,
            infoModel.country,
            infoModel.startDate,
            infoModel.finishDate
        )

        addDisposable(
            Single.just(driverInfo)
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

        getView()!!.approveNext(false)
    }
}