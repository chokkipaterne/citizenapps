package com.ogd.citizenapps;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;


public class DialogView {

    static ProgressDialog mAlertDialog;

    public static Dialog customSpinProgress, customNoNetwork;

    public DialogView() {}

    public void showSpinProgress(Context context, String msg) {
        mAlertDialog = new ProgressDialog(context);
        mAlertDialog.setMessage(msg);
        mAlertDialog.setCancelable(true);
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mAlertDialog.show();

    }

    public void showCustomSpinProgress(Context context) {

        customSpinProgress = new Dialog(context);
        customSpinProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customSpinProgress.setContentView(R.layout.dialog_loading);
        customSpinProgress.setCanceledOnTouchOutside(false);
        customSpinProgress.setCancelable(true);
        customSpinProgress.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        WindowManager.LayoutParams wlmp = customSpinProgress.getWindow()
                .getAttributes();
        wlmp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlmp.height = WindowManager.LayoutParams.MATCH_PARENT;
        customSpinProgress.show();
    }

    public void dismissCustomSpinProgress() {
        if (customSpinProgress != null)
            customSpinProgress.dismiss();
    }

    public void showHorizontalProgress(Context context, String msg) {
        mAlertDialog = new ProgressDialog(context);
        mAlertDialog.setMessage(msg);
        mAlertDialog.setCancelable(true);
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.setIndeterminate(false);
        mAlertDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mAlertDialog.setProgress(0);
        mAlertDialog.setMax(100);
        mAlertDialog.show();
    }

    public void dismissProgress() {
        if (mAlertDialog.isShowing())
            mAlertDialog.dismiss();
    }


}
