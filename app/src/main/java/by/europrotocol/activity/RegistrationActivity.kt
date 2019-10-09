package by.europrotocol.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.europrotocol.R
import by.europrotocol.activity.registration.INextCallback
import by.europrotocol.activity.registration.RegistrationStep
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity(), INextCallback {

   companion object {
       fun newInstance(context: Context): Intent = Intent(context, RegistrationActivity::class.java).apply {

       }
   }

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
