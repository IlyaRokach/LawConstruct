package by.europrotocol.data.repository.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class PolicyholderInformation {
    @PrimaryKey
    var id: Long = 0

    @ColumnInfo(name = "json")
    var json: String? = null

    @ColumnInfo(name = "user_holder")
    var isUser: Boolean = false
}