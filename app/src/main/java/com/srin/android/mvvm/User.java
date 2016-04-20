package com.srin.android.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.srin.android.mvvm.BR;

/**
 * Created by SRIN on 4/18/2016.
 */
public class User extends BaseObservable{

    private String firstName;
    private String lastName;

    public User (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setUser(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        notifyPropertyChanged(BR.firstName);
        notifyPropertyChanged(BR.lastName);
        //notifyPropertyChanged(BR._all);
    }

}
