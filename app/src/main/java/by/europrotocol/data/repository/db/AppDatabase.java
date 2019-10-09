package by.europrotocol.data.repository.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import by.europrotocol.data.repository.db.dao.UserDataDao;
import by.europrotocol.data.repository.db.entity.AutoInfo;
import by.europrotocol.data.repository.db.entity.InsurerInformation;

@Database(entities = {AutoInfo.class, InsurerInformation.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDataDao getUserDao();
}
