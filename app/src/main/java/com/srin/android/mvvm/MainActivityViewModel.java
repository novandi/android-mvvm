package com.srin.android.mvvm;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SRIN on 4/18/2016.
 */
public class MainActivityViewModel {

    public User mUser;
    //public ObservableField firstNameEt = new ObservableField();
    //public ObservableField lastNameEt = new ObservableField();

    private BindableString firstNameEt = new BindableString();

    public BindableString getFirstNameEt() {
        return firstNameEt;
    }

    public void setFirstNameEt(BindableString firstNameEt) {
        this.firstNameEt = firstNameEt;
    }

    public BindableString getLastNameEt() {
        return lastNameEt;
    }

    public void setLastNameEt(BindableString lastNameEt) {
        this.lastNameEt = lastNameEt;
    }

    private BindableString lastNameEt = new BindableString();

    @BindingAdapter("binding")
    public static void bindEditText(EditText view, final BindableString bindableString){
        if(view.getTag() == null){
            view.setTag(true);
            view.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindableString.set(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
        String newValue = bindableString.get();
        if(!view.getText().toString().equals(newValue))
            view.setText(newValue);
    }

    /*public TextWatcher mFirstNameEtTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.equals(mUser.getFirstName(), s.toString())) {
                firstNameEt.set(s.toString());
            }
        }
    };

    public TextWatcher mLastNameEtTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.equals(mUser.getLastName(), s.toString())) {
                lastNameEt.set(s.toString());
            }
        }
    };*/

    public MainActivityViewModel(){
        mUser = new User("", "");
    }

    public void onClick(View view){
//        View root = view.getRootView();
//        EditText firsName = (EditText)root.findViewById(R.id.firstNameEt);
//        EditText lastName = (EditText)root.findViewById(R.id.lastNameEt);
//        mUser.setUser(new User(firsName.getText().toString().equals("")?"NULL":firsName.getText().toString(), lastName.getText().toString().equals("")?"NULL":lastName.getText().toString()));
        mUser.setUser(new User(firstNameEt.get().toString(), lastNameEt.get().toString()));
    }

    @BindingConversion
    public static String convertBindableToString(BindableString bindableString) {
        return bindableString.get();
    }

}
