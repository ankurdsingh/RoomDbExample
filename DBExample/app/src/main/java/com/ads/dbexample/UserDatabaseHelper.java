package com.ads.dbexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by 27489 on 1/24/2018.
 *
 */
@Database(entities = {UsersDataModel.class},version = 1, exportSchema = false)
public abstract class UserDatabaseHelper extends RoomDatabase{
    public abstract UserDataModelDao getUserDataModelDao();
}
