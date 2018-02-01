package com.ads.dbexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by 27489 on 1/24/2018.
 */
@Entity
public class UsersDataModel {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private int id;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "user_age")
    private int age;
    @ColumnInfo(name = "user_prof")
    private String profession;

    public UsersDataModel(int id, String userName, int age, String profession) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public String toString() {
        return "UsersDataModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
