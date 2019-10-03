package by.europrotocol.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.europrotocol.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)
    }
}
