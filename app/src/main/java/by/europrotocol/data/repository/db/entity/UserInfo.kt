package by.europrotocol.data.repository.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserInfo {

    @PrimaryKey
    var id: Long = 0

    @ColumnInfo(name = "json")
     var json: String? = null
}
