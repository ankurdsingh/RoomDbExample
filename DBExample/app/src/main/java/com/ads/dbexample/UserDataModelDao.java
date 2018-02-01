package com.ads.dbexample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by 27489 on 1/24/2018.
 * <h2>UserDataModelDao</h2>
 * To perform all db db operation we need a Dao
 */
@Dao
public interface UserDataModelDao {
    /**
     * <h2>insert</h2>
     * <p>Insert user in db</p>
     * @param user object of user
     */
    @Insert
    void insert(UsersDataModel user);

    @Update
    void update(UsersDataModel user);

    @Delete
    void deleteUser(UsersDataModel user);

    @Delete
    void deleteAllUsers(List<UsersDataModel> usersList);

    /**
     * <h2>getAllUsers</h2>
     * <p>Db call to fetch all user</p>
     * @return list of user
     */
    @Query("SELECT * FROM UsersDataModel")
    List<UsersDataModel> getAllUsers();

    /**
     * <h2>getUser</h2>
     * <p>Db call to fetch all user</p>
     * @param name of the users
     * @return details of user
     */
    @Query("SELECT * FROM UsersDataModel WHERE " +
            " user_name LIKE :name")
    List<UsersDataModel> getUser(String name);

}
