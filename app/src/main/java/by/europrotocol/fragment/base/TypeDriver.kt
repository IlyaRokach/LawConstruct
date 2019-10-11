package by.europrotocol.fragment.base

import android.os.Parcel
import android.os.Parcelable

class TypeDriver(
    val type: String
): Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString().toString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = parcel.writeString(type)

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<TypeDriver> {
        override fun createFromParcel(parcel: Parcel): TypeDriver = TypeDriver(parcel)

        override fun newArray(size: Int): Array<TypeDriver?> = arrayOfNulls(size)

        const val ONE: String = "ONE"
        const val TWO: String = "TWO"

        const val NAME_ARG = "TYPE_DRIVER"
    }
}