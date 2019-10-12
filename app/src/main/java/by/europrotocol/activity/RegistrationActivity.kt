package by.europrotocol.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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

    private var doubleBackToExitPressedOnce = false

    val list = listOf(
        Pair(RegistrationStep.STEP_QUESTION_ACCIDENT, null),
        Pair(RegistrationStep.STEP_PLACE_OF_ACCIDENT, null),
        Pair(RegistrationStep.STEP_AUTO_INFO, TypeDriver(TypeDriver.ONE)), //create pre-data debug version
        Pair(RegistrationStep.STEP_DRIVER_INFO, TypeDriver(TypeDriver.ONE)), //create pre-data debug version
        Pair(RegistrationStep.STEP_INSURER_INFO, TypeDriver(TypeDriver.ONE)), //create pre-data debug version
        Pair(RegistrationStep.STEP_PLACE_HOLDER_DATA, TypeDriver(TypeDriver.ONE)), //create pre-data debug version
        Pair(RegistrationStep.STEP_PLACE_OF_IMPACT, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT, TypeDriver(TypeDriver.ONE)),
        Pair(RegistrationStep.STEP_MY_NOTES, TypeDriver(TypeDriver.ONE)),

        Pair(RegistrationStep.STEP_AUTO_INFO, TypeDriver(TypeDriver.TWO)), //create pre-data debug version
        Pair(RegistrationStep.STEP_DRIVER_INFO, TypeDriver(TypeDriver.TWO)), //create pre-data debug version
        Pair(RegistrationStep.STEP_INSURER_INFO, TypeDriver(TypeDriver.TWO)), //create pre-data debug version
        Pair(RegistrationStep.STEP_PLACE_HOLDER_DATA, TypeDriver(TypeDriver.TWO)), //create pre-data debug version
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
            RegistrationStep.STEP_PERSONAL_DRIVER_INFO -> {
                PrivateInfoDriverFragment.newInstance()}
            RegistrationStep.STEP_INSURER_INFO -> {
                InsurerInformationFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_DRIVER_INFO -> {
                DriverInfoFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_PLACE_HOLDER_DATA -> {
                PolicyholderInformationFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_AUTO_INFO -> {
                AutoInfoFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_QUESTION_ACCIDENT -> {
                QuestionOfTheAccidentFragment.newInstance()
            }
            RegistrationStep.STEP_CIRCUMSTANCES_OF_AN_ACCIDENT -> {
                CircumstancesOfTheAccidentFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_PLACE_OF_IMPACT -> {
                PlaceOfImpactFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_PLACE_OF_ACCIDENT -> {
                PlaceOfAccidentFragment.newInstance()
            }
            RegistrationStep.STEP_MY_NOTES -> {
                ClaimToBeResponsibleForTheHarmFragment.newInstance(value.second!!)
            }
            RegistrationStep.STEP_GENERATE_PDF -> {
                startActivity(ProtocolActivity.newIntent(this, false))
                null
            }
            else -> null
        }

        if (fragment != null) {

            addFragment(R.id.container_registration, fragment)
        }
    }

    private fun getNextStep(currentStep: RegistrationStep, typeDriver: TypeDriver?): Pair<String, TypeDriver?> {
        var index = 0
        var next: Int = 0
        val max = list.size
        while (index < max) {
            var pair = list[index]
            if (pair.first == currentStep.step &&
                ( ( (typeDriver != null && pair.second != null) && typeDriver.type == pair.second!!.type) || typeDriver == null && pair.second == null) ) {
                next = (index + 1)
                break
            }
            index++
        }

        return list[next]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)

        addFragment(R.id.container_registration, QuestionOfTheAccidentFragment.newInstance())
    }

    fun <T : Fragment> addFragment(@IdRes containerId: Int, fragment: T) {
        val currentFragment = supportFragmentManager.findFragmentById(containerId)
        val ft = this.supportFragmentManager.beginTransaction()
        this.addAnimations(ft)
        ft.add(containerId, fragment).addToBackStack("root_fragment")
        if (currentFragment != null) {
            ft.hide(currentFragment)
        }

        ft.commitAllowingStateLoss()
    }

    protected fun addAnimations(ft: FragmentTransaction) {
        ft.setCustomAnimations(
            R.anim.enter_from_left,
            R.anim.exit_to_right,
            R.anim.enter_from_right,
            R.anim.exit_to_left
        )
    }

    override fun onBackPressed() {
        makeBack()
    }

    private fun checkDoubleBackToExitPressedOnce() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
        } else {
            setDoubleBackToExitPressedOnce(true)
            Toast.makeText(this, "Нажмите 2 раза для выхода с приложения", Toast.LENGTH_SHORT).show()
            Handler().postDelayed(
                { setDoubleBackToExitPressedOnce(false) },
                1000
            )
        }
    }

    protected fun makeBack() {
        if (!this.isLastFragmentInStack()) {
            this.removeFragmentFromBackStack()
        } else {
            checkDoubleBackToExitPressedOnce()
        }
    }

    private fun removeFragmentFromBackStack() {
        this.supportFragmentManager.popBackStackImmediate()
    }

    private fun setDoubleBackToExitPressedOnce(doubleBackToExitPressedOnce: Boolean) {
        this.doubleBackToExitPressedOnce = doubleBackToExitPressedOnce
    }

    fun isLastFragmentInStack(): Boolean {
        return this.supportFragmentManager.backStackEntryCount === 1
    }
}
