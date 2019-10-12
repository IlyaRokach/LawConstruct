package by.europrotocol.activity.registration

import android.os.Parcel
import android.os.Parcelable
import by.europrotocol.fragment.base.TypeDriver

class RegistrationStep(
    val step: String
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString().toString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = parcel.writeString(step)

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<TypeDriver> {
        override fun createFromParcel(parcel: Parcel): TypeDriver = TypeDriver(parcel)

        override fun newArray(size: Int): Array<TypeDriver?> = arrayOfNulls(size)

        val STEP_FIRMA_INFO = "STEP_FIRMA_INFO"
        val STEP_PERSONAL_DRIVER_INFO = "STEP_PERSONAL_DRIVER_INFO"
        val STEP_VEHICLE_DATA = "STEP_VEHICLE_DATA"
        val STEP_INSURER_INFO = "STEP_INSURER_INFO"
        val STEP_DRIVER_INFO = "STEP_DRIVER_INFO"
        val STEP_PLACE_HOLDER_DATA = "STEP_PLACE_HOLDER_DATA"
        val STEP_AUTO_INFO = "STEP_AUTO_INFO"
        val STEP_QUESTION_ACCIDENT = "STEP_QUESTION_ACCIDENT"
        val STEP_CIRCUMSTANCES_OF_AN_ACCIDENT = "STEP_CIRCUMSTANCES_OF_AN_ACCIDENT"
        val STEP_PLACE_OF_IMPACT = "STEP_PLACE_OF_IMPACT"
        val STEP_PLACE_OF_ACCIDENT = "STEP_PLACE_OF_ACCIDENT"
        val STEP_MY_NOTES = "STEP_MY_NOTES"
        val STEP_GENERATE_PDF = "STEP_GENERATE_PDF"
    }

}