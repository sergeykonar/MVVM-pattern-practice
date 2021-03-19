package com.example.mymillion.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mymillion.Model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Repository mRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        allUsers = mRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insert(User user){
        mRepository.insert(user);
    }
    public void deleteAll(){
        mRepository.deleteAll();
    }
}
