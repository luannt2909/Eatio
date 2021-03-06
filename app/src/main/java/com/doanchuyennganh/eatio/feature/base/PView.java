package com.doanchuyennganh.eatio.feature.base;

/**
 * Created by Nguyen Tan Luan on 3/26/2017.
 */

public interface PView {
    void showDialog(String title, String message, ViewDialogAction leftAction, ViewDialogAction rightAction);
    void showDialog(String title, String message);
    void showToast(String message);
    void showToast(String message, int duration);
    void cancelToast();
    void hideKeyboard();
    void showWaitingDialog();
    void dismissWaitingDialog();

    interface ViewDialogAction {
        String getTitle();
        void onClick();
    }
}
