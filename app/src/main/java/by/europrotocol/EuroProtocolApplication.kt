package by.europrotocol

import android.app.Application
import androidx.room.Room
import by.europrotocol.data.repository.EuroProtocolRepository
import by.europrotocol.data.repository.RamEuroProtocol
import by.europrotocol.data.repository.db.AppDatabase


class EuroProtocolApplication: Application() {

    private lateinit var db: AppDatabase

    private val euroProtocolRepository: EuroProtocolRepository = RamEuroProtocol

    fun getBase(): AppDatabase  = db

    fun getEuroProtocolRepository(): EuroProtocolRepository = euroProtocolRepository

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}