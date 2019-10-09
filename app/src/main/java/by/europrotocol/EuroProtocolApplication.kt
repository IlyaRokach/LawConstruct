package by.europrotocol

import android.app.Application
import androidx.room.Room
import by.europrotocol.data.repository.db.AppDatabase


class EuroProtocolApplication: Application() {

    private lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build()
    }
}