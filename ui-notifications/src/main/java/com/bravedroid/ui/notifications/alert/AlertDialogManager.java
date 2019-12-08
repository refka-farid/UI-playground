package com.bravedroid.ui.notifications.alert;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public abstract class AlertDialogManager {

    public abstract View inflateDialogView(Context context);

    public void setAlertDialogTransparent(AlertDialog alertDialog) {
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        alertDialog.show();
    }

    public abstract AlertDialog createAlertDialog(Context context, View dialogView);

    public abstract void setAlertDialogBehaviorOnDismiss(final AlertDialog alertDialog,
                                                         final View alertDialogView,
                                                         final OnDismissListener listener);

    public abstract void setWarningAlertDialogBehaviorOnDismiss(final AlertDialog alertDialog,
                                                         final View alertDialogView,
                                                         final OnWarningDismissListener listener);

    public interface OnDismissListener {
        void onDismiss();
    }

    public interface OnWarningDismissListener {
        void onDismissYesButton();
        void onDismissNoButton();
    }
}
