package com.bravedroid.ui.notifications.alert;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.bravedroid.ui.notifications.R;

import org.jetbrains.annotations.NotNull;

public class ErrorAlertDialogManager extends AlertDialogManager {

    @NotNull
    @Override
    public View inflateDialogView(Context context) {
        Resources resources = context.getResources();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_error_dialog, null);
        ((TextView) view.findViewById(R.id.textTitle)).setText(resources.getString(R.string.error_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(resources.getString(R.string.dymy_text));
        ((Button) view.findViewById(R.id.buttonAction)).setText(resources.getString(R.string.okay));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);
        return view;
    }

    @NotNull
    @Override
    public AlertDialog createAlertDialog(Context context, View errorDialogView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        builder.setView(errorDialogView);
        builder.setCancelable(false);
        return builder.create();
    }

    @Override
    public void setAlertDialogBehaviorOnDismiss(final AlertDialog alertDialog,
                                                final View errorDialogView,
                                                final OnDismissListener listener) {
        errorDialogView.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                ((ViewGroup) errorDialogView.getParent()).removeView(errorDialogView);
                listener.onDismiss();
            }
        });
    }

    @Override
    public void setWarningAlertDialogBehaviorOnDismiss(AlertDialog alertDialog, View alertDialogView, OnWarningDismissListener listener) {

    }


}
