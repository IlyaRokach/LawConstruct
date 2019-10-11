package by.europrotocol.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.europrotocol.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        initViews()
        initClickListeners()
    }

    private fun initViews() {
        iv_logo.setImageResource(R.drawable.ic_logo)
    }

    private fun initClickListeners() {
        btn_sign_in.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        btn_sign_up.setOnClickListener {
            startActivity(ProtocolActivity.newIntent(this))
        }
        tv_forgot.setOnClickListener {
            //TODO forgot password implementation
        }
    }
}
