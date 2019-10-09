package by.europrotocol.data.repository.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import by.europrotocol.data.repository.db.entity.AutoInfo;
import by.europrotocol.data.repository.db.entity.DriverInfo;
import by.europrotocol.data.repository.db.entity.InsurerInformation;
import by.europrotocol.data.repository.db.entity.PolicyholderInformation;

@Dao
public interface UserDataDao {

    @Query("SELECT * FROM autoinfo")
    List<AutoInfo> getAllAuto();

    @Query("SELECT * FROM autoinfo where user_auto = :isUser")
    List<AutoInfo> getAuto(boolean isUser);

    @Insert
    void insert(AutoInfo car);

    @Delete
    void delete(AutoInfo car);

    @Query("SELECT * FROM insurerinformation")
    List<InsurerInformation> getAllInsurer();

    @Query("SELECT * FROM insurerinformation where user_insurer = :isUser")
    List<InsurerInformation> getInsurer(boolean isUser);

    @Insert
    void insert(InsurerInformation car);

    @Delete
    void delete(InsurerInformation car);

    @Query("SELECT * FROM policyholderinformation")
    List<PolicyholderInformation> getAllHolder();

    @Query("SELECT * FROM policyholderinformation where user_holder = :isUser")
    List<InsurerInformation> getHolder(boolean isUser);

    @Insert
    void insert(PolicyholderInformation car);

    @Delete
    void delete(PolicyholderInformation car);

    @Query("SELECT * FROM driverinfo")
    List<DriverInfo> getAllDriver();

    @Query("SELECT * FROM driverinfo where user = :isUser")
    List<DriverInfo> getDriver(boolean isUser);

    @Insert
    void insert(DriverInfo car);

    @Delete
    void delete(DriverInfo car);
}
