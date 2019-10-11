package by.europrotocol.fragment.placeofimpact

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.OnClick
import by.europrotocol.R
import by.europrotocol.activity.registration.RegistrationStep
import by.europrotocol.data.model.PlaceOfImpact
import by.europrotocol.fragment.base.BaseRegistrationFragment
import by.europrotocol.fragment.base.TypeDriver

class PlaceOfImpactFragment : BaseRegistrationFragment<IPlaceOfImpactPresenter>(),
    IPlaceOfImpactView {

    companion object {
        @JvmStatic
        fun newInstance(type: TypeDriver) =
            PlaceOfImpactFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TypeDriver.NAME_ARG, type)
                }
            }
    }

    @BindView(R.id.title_driver)
    protected lateinit var titleDriver: TextView

    @BindView(R.id.cb_place_of_impact_front_bumper)
    protected lateinit var cbPlaceOfImpactFrontBumper: CheckBox

    @BindView(R.id.cb_place_of_impact_back_bumper)
    protected lateinit var cbPlaceOfImpactBackBumper: CheckBox

    @BindView(R.id.cb_place_of_impact_front_left_wing)
    protected lateinit var cbPlaceOfImpactFrontLeftWing: CheckBox

    @BindView(R.id.cb_place_of_impact_back_left_wing)
    protected lateinit var cbPlaceOfImpactBackLeftWing: CheckBox

    @BindView(R.id.cb_place_of_impact_front_right_wing)
    protected lateinit var cbPlaceOfImpactFrontRightWing: CheckBox

    @BindView(R.id.cb_place_of_impact_back_right_wing)
    protected lateinit var cbPlaceOfImpactBackRightWing: CheckBox

    @BindView(R.id.cb_place_of_impact_left_door)
    protected lateinit var cbPlaceOfImpactLeftDoor: CheckBox

    @BindView(R.id.cb_place_of_impact_right_door)
    protected lateinit var cbPlaceOfImpactRightDoor: CheckBox

    override fun onInflateViewFragment(): Int = R.layout.fragment_place_of_impact

    override fun onCreateViewFragment(view: View): View {
        initPresenter()
        initListener()
        return view
    }

    @OnClick(R.id.next_button)
    override fun onNextClick() {
        getController().onNextRequest()
    }

    private fun initListener() {
        cbPlaceOfImpactFrontBumper.setOnCheckedChangeListener { buttonView, isChecked ->
            run {
                val item = PlaceOfImpact.FRONT_BUMPER
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }
        }
        cbPlaceOfImpactBackBumper.setOnCheckedChangeListener { buttonView, isChecked ->  run {
            val item = PlaceOfImpact.BACK_BUMPER
            if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                item
            )
        }}
        cbPlaceOfImpactFrontLeftWing.setOnCheckedChangeListener { buttonView, isChecked ->  run {
            val item = PlaceOfImpact.FRONT_LEFT_WING
            if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                item
            )
        }}
        cbPlaceOfImpactBackLeftWing.setOnCheckedChangeListener { buttonView, isChecked ->  run {
                val item = PlaceOfImpact.BACK_LEFT_WING
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }}
        cbPlaceOfImpactFrontRightWing.setOnCheckedChangeListener { buttonView, isChecked ->  run {
                val item = PlaceOfImpact.FRONT_RIGHT_WING
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }}
        cbPlaceOfImpactBackRightWing.setOnCheckedChangeListener { buttonView, isChecked ->  run {
                val item = PlaceOfImpact.BACK_RIGHT_WING
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }}
        cbPlaceOfImpactLeftDoor.setOnCheckedChangeListener { buttonView, isChecked ->  run {
                val item = PlaceOfImpact.LEFT_DOOR
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }}
        cbPlaceOfImpactRightDoor.setOnCheckedChangeListener { buttonView, isChecked ->  run {
                val item = PlaceOfImpact.RIGHT_DOOT
                if (isChecked) getController().onAddPlaceOfImpact(item) else getController().onRemovePlaceOfImpact(
                    item
                )
            }}
    }

    private fun initPresenter() {
        presenter = PlaceOfImpactPresenter(this)
    }

    override fun approveNext(isApprove: Boolean) {
        if (isApprove) {
            nextCallback?.onNext(RegistrationStep.STEP_PLACE_OF_IMPACT, getTypeDriver())
        } else {
            Toast.makeText(activity, "Есть незаполненные обязательные поля!!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun getTypeDriver(): TypeDriver = arguments!!.get(TypeDriver.NAME_ARG) as TypeDriver
}