package by.europrotocol.fragment.physicaluser

import by.europrotocol.R
import by.europrotocol.data.model.DriverInfo
import by.europrotocol.fragment.base.BaseRegistrationPresenter
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Consumer

class PrivateInfoDriverPresenter(view: IPrivateInfoDriverView): BaseRegistrationPresenter<IPrivateInfoDriverView>(view), IPrivateInfoDriverPresenter {

    protected val privateInfoDriverModel: PrivateInfoDriverModel = PrivateInfoDriverModel()

    override fun onChangeFirstName(changedText: String) {
        privateInfoDriverModel.firstName = changedText
    }

    override fun onChangeName(changedText: String) {
        privateInfoDriverModel.name = changedText
    }

    override fun onChangePatronymic(changedText: String) {
        privateInfoDriverModel.patronymic
    }

    override fun onNextRequest() {
        if (privateInfoDriverModel.firstName.isEmpty()){
            getView()!!.showFirstNameRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }
        if (privateInfoDriverModel.name.isEmpty()) {
            getView()!!.showNameRequiredError(getView()!!.getActivity()!!.getString(R.string.error_required_field))
            return
        }

        val driverInfo: DriverInfo = DriverInfo(
            privateInfoDriverModel.firstName,
            privateInfoDriverModel.name,
            privateInfoDriverModel.patronymic ?: ""
        )

        addDisposable(Single.just(driverInfo)
            .map {
                var gson: Gson = Gson()
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