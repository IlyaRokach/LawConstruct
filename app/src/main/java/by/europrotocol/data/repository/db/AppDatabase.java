package by.europrotocol.data.repository.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import by.europrotocol.data.repository.db.dao.UserDataDao;
import by.europrotocol.data.repository.db.entity.AutoInfo;
import by.europrotocol.data.repository.db.entity.DriverInfo;
import by.europrotocol.data.repository.db.entity.InsurerInformation;
import by.europrotocol.data.repository.db.entity.PolicyholderInformation;
import by.europrotocol.data.repository.db.entity.UserInfo;

@Database(entities = {
        AutoInfo.class,
        InsurerInformation.class,
        DriverInfo.class,
        PolicyholderInformation.class,
        UserInfo.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDataDao getUserDao();
}
