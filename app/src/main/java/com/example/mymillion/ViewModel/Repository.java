package com.example.mymillion.ViewModel;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mymillion.Model.User;
import com.example.mymillion.UserDao;
import com.example.mymillion.UserDataBase;

import java.util.List;

public class Repository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public Repository(Application application){
        UserDataBase db = UserDataBase.getDatabase(application.getApplicationContext());
        this.userDao = db.userDao();
        this.allUsers = userDao.getAll();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insert(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    public void deleteAll(){
        new deleteAsyncTask(userDao).execute();
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void>{

        private UserDao mAsyncDao;
        insertAsyncTask(UserDao userDao){
            mAsyncDao = userDao;
        }


        @Override
        protected Void doInBackground(final User... params) {
            mAsyncDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Void, Void, Void>{

        private UserDao mAsyncDao;
        deleteAsyncTask(UserDao userDao){
            mAsyncDao = userDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncDao.deleteAll();
            return null;
        }
    }
}
