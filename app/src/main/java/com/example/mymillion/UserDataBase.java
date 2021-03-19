package com.example.mymillion;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mymillion.Model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDao userDao();

    private static UserDataBase INSTANCE;

    public static UserDataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (UserDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDataBase.class, "myDATA")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
