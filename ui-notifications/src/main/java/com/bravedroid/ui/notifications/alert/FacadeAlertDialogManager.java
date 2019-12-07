package com.bravedroid.ui.notifications.alert;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class FacadeAlertDialogManager {
    private final Context context;

    private View successDialogView;
    private View errorDialogView;
    private View warningDialogView;

    private AlertDialogManager successAlertDialogManager;
    private AlertDialogManager errorAlertDialogManager;
    private AlertDialogManager warningAlertDialogManager;

    public FacadeAlertDialogManager(Context context) {
        this.context = context;
        successAlertDialogManager = new SuccessAlertDialogManager();
        errorAlertDialogManager = new ErrorAlertDialogManager();
        warningAlertDialogManager = new WarningAlertDialogManager(context);
    }

    public void showSuccessDialog() {
        showDialog(successAlertDialogManager, successDialogView);
    }

    public void showWarningDialog() {
        showDialog(warningAlertDialogManager, warningDialogView);
    }

    public void showErrorDialog() {
        showDialog(errorAlertDialogManager, errorDialogView);
    }

    private void showDialog(AlertDialogManager alertDialogManager, View dialogView) {
        if (dialogView == null)
            dialogView = alertDialogManager.inflateDialogView(context);
        final AlertDialog alertDialog = alertDialogManager.createAlertDialog(context, dialogView);
        alertDialogManager.setAlertDialogBehaviorOnDismiss(alertDialog, dialogView);
        alertDialogManager.setAlertDialogTransparent(alertDialog);
        alertDialog.show();
    }
}
