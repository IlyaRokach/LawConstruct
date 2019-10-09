package by.europrotocol.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.europrotocol.R
import by.europrotocol.activity.registration.INextCallback
import by.europrotocol.activity.registration.RegistrationStep
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity(), INextCallback {

    override fun onNext(currentStep: RegistrationStep) {
        when (currentStep) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)
    }
}
