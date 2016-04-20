package com.srin.android.mvvm;

import android.databinding.BaseObservable;
import android.text.TextUtils;

/**
 * Created by SRIN on 4/19/2016.
 */
public class BindableString extends BaseObservable {

    private String value;

    public String get(){
        return value != null ? value : "";
    }

    public void set(String value){
        if(!TextUtils.equals(this.value, value)){
            this.value = value;
            notifyChange();
        }
    }

    public boolean isEmpty(){
        return this.value == null || value.isEmpty();
    }

}
