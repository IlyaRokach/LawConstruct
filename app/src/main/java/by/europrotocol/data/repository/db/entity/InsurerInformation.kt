package by.europrotocol.data.repository.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class InsurerInformation {
    @PrimaryKey
    var id: Long = 0

    @ColumnInfo(name = "json")
    var json: String? = null

    @ColumnInfo(name = "user_insurer")
    var isUser: Boolean = false
}