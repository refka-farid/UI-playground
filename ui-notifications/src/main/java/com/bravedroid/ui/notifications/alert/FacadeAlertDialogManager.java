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

    public void showSuccessDialog(final AlertDialogManager.OnDismissListener listener) {
        showDialog(successAlertDialogManager, successDialogView, listener);
    }

    public void showWarningDialog(final AlertDialogManager.OnWarningDismissListener listener) {
        showWarningDialog(warningAlertDialogManager, warningDialogView, listener);
    }

    public void showErrorDialog(final AlertDialogManager.OnDismissListener listener) {
        showDialog(errorAlertDialogManager, errorDialogView, listener);
    }

    private void showDialog(AlertDialogManager alertDialogManager,
                            View dialogView,
                            final AlertDialogManager.OnDismissListener listener) {
        if (dialogView == null)
            dialogView = alertDialogManager.inflateDialogView(context);
        final AlertDialog alertDialog = alertDialogManager.createAlertDialog(context, dialogView);
        alertDialogManager.setAlertDialogBehaviorOnDismiss(alertDialog, dialogView, listener);
        alertDialogManager.setAlertDialogTransparent(alertDialog);
        alertDialog.show();
    }

    private void showWarningDialog(AlertDialogManager alertDialogManager,
                                   View dialogView,
                                   final AlertDialogManager.OnWarningDismissListener warningDismissListener) {
        if (dialogView == null)
            dialogView = alertDialogManager.inflateDialogView(context);
        final AlertDialog alertDialog = alertDialogManager.createAlertDialog(context, dialogView);
        alertDialogManager.setWarningAlertDialogBehaviorOnDismiss(alertDialog, dialogView, warningDismissListener);
        alertDialogManager.setAlertDialogTransparent(alertDialog);
        alertDialog.show();
    }
}
