package by.europrotocol.activity.registration

import by.europrotocol.fragment.base.TypeDriver

interface INextCallback {
    fun onNext(currentStep: RegistrationStep, typeDriver: TypeDriver? = null)
}