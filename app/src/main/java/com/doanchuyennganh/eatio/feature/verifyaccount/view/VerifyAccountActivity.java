package com.doanchuyennganh.eatio.feature.verifyaccount.view;

import android.widget.EditText;
import android.widget.ProgressBar;

import com.doanchuyennganh.eatio.R;
import com.doanchuyennganh.eatio.feature.base.impl.MainActivity;
import com.doanchuyennganh.eatio.feature.home.view.HomeActivity_;
import com.doanchuyennganh.eatio.feature.verifyaccount.presenter.VerifyAccountPresenter;
import com.doanchuyennganh.eatio.feature.verifyaccount.presenter.VerifyAccountPresenterImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Nguyen Tan Luan on 3/26/2017.
 */
@EActivity(R.layout.activity_verify_code)
public class VerifyAccountActivity extends MainActivity<VerifyAccountPresenter> implements VerifyAccountView,VerifyAccountNavigator {

    @ViewById(R.id.verify_code)
    EditText mEdtVerifyCode;

    @ViewById(R.id.progressBar)
    ProgressBar mProgressBar;
    @Bean
    void setBean(VerifyAccountPresenterImpl presenter){
        this.mPresenter=presenter;
    }

    @AfterViews
    void initView(){
        mPresenter.setView(this);
    }

    @Click(R.id.btn_active_code)
    void excuteVerifyAccount(){
        String code=mEdtVerifyCode.getText().toString();
        mPresenter.verifyAccount(code);
    }

    @Click(R.id.btn_back)
    void goBack(){
        this.finish();
    }

    @Override
    public void goToHome() {
        HomeActivity_.intent(this).start();
        this.finish();
    }

    @Override
    public void showWaitingDialog() {
        super.showWaitingDialog();
       // mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissWaitingDialog() {
        super.dismissWaitingDialog();
        //mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDialog(String title, String message) {
        super.showDialog(title, message);
    }
}
