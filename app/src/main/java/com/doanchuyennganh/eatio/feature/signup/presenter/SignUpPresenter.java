package com.doanchuyennganh.eatio.feature.signup.presenter;

import com.doanchuyennganh.eatio.feature.base.Presenter;
import com.doanchuyennganh.eatio.feature.signup.view.SignUpNavigator;
import com.doanchuyennganh.eatio.feature.signup.view.SignUpView;

/**
 * Created by Nguyen Tan Luan on 4/6/2017.
 */

public interface SignUpPresenter extends Presenter<SignUpView,SignUpNavigator> {
    void excuteSignUp(String username, String email, String password);
    //boolean canLogin(String username,String email, String password);
}
