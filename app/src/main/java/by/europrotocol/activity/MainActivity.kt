package by.europrotocol.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import by.europrotocol.R

class MainActivity : AppCompatActivity() {

    @BindView(R.id.tv_new_incident)
    protected lateinit var tvNewIncident: TextView

    @BindView(R.id.tv_history)
    protected lateinit var tvHistory: TextView

    @BindView(R.id.tv_help_info)
    protected lateinit var tvHelpInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        tvNewIncident.setOnClickListener {
            startActivity(RegistrationActivity.newInstance(this))
        }
    }
}
