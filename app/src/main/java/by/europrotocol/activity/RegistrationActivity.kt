package by.europrotocol.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.europrotocol.R
import by.europrotocol.activity.registration.INextCallback
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.fragment.InsurerInformation.InsurerInformationFragment
import by.europrotocol.fragment.autoinfo.AutoInfoFragment
import by.europrotocol.fragment.base.TypeDriver
import by.europrotocol.fragment.circumstancesoftheaccident.CircumstancesOfTheAccidentFragment
import by.europrotocol.fragment.claimresponsibleFfortheharm.ClaimToBeResponsibleForTheHarmFragment
import by.europrotocol.fragment.driverinfo.DriverInfoFragment
import by.europrotocol.fragment.physicaluser.PrivateInfoDriverFragment
import by.europrotocol.fragment.placeofaccident.PlaceOfAccidentFragment
import by.europrotocol.fragment.placeofimpact.PlaceOfImpactFragment
import by.europrotocol.fragment.policyholder.PolicyholderInformationFragment
import by.europrotocol.fragment.questionoftheaccident.QuestionOfTheAccidentFragment
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity(), INextCallback {

    val list = listOf(
        Pair(RegistrationStep.STEP_QUESTION_ACCIDENT, null),
        Pair(RegistrationStep.STEP_PLACE_OF_ACCIDENT, null),
        Pair(RegistrationStep.STEP_AUTO_INFO, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_DRIVER_INFO, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_INSURER_INFO, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_PLACE_HOLDER_DATA, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_PLACE_OF_IMPACT, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_MY_NOTES, TypeDriver(TypeDriver.ONE)),

        Pair(RegistrationStep.STEP_AUTO_INFO, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_DRIVER_INFO, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_INSURER_INFO, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_PLACE_HOLDER_DATA, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_PLACE_OF_IMPACT, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_MY_NOTES, TypeDriver(TypeDriver.TWO)),
        Pair(RegistrationStep.STEP_GENERATE_PDF, null)
    )

    companion object {
        fun newInstance(context: Context): Intent =
            Intent(context, RegistrationActivity::class.java).apply {

            }
    }

    override fun onNext(currentStep: RegistrationStep, typeDriver: TypeDriver?) {

        val value = getNextStep(currentStep, typeDriver)

        val fragment = when (value.first) {
            RegistrationStep.STEP_PERSONAL_DRIVER_INFO -> PrivateInfoDriverFragment.newInstance()
            RegistrationStep.STEP_INSURER_INFO -> InsurerInformationFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_DRIVER_INFO -> DriverInfoFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_PLACE_HOLDER_DATA -> PolicyholderInformationFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_AUTO_INFO -> AutoInfoFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_QUESTION_ACCIDENT -> QuestionOfTheAccidentFragment.newInstance()
            RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT -> CircumstancesOfTheAccidentFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_PLACE_OF_IMPACT -> PlaceOfImpactFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_PLACE_OF_ACCIDENT -> PlaceOfAccidentFragment.newInstance()
            RegistrationStep.STEP_MY_NOTES -> ClaimToBeResponsibleForTheHarmFragment.newInstance(typeDriver!!)
            RegistrationStep.STEP_GENERATE_PDF -> {
                startActivity(Intent(this, ProtocolActivity::class.java))
                null
            }
            else -> null
        }

        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.container_registration,
                fragment
            ).commitAllowingStateLoss()
        }
    }

    private fun getNextStep(currentStep: RegistrationStep, typeDriver: TypeDriver?): Pair<String, TypeDriver?> {
        var index = 0
        var next: Int = 0
        val max = list.size
        while (index < max) {
            var pair = list[index]
            if (pair.first == currentStep.step &&
                ( ( (typeDriver != null && pair.second != null) && typeDriver.type == pair.second!!.type))) {
                next = (index + 1)
            }
            index++
        }

        return list[next]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction().replace(
            R.id.container_registration,
            QuestionOfTheAccidentFragment.newInstance()
        ).commitAllowingStateLoss()

    }
}
