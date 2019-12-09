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

public class SuccessAlertDialogManager extends AlertDialogManager {

    @Override
    public View inflateDialogView(Context context) {
        Resources resources = context.getResources();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_dialog_success, null);
        ((TextView) view.findViewById(R.id.textView_dialog_title)).setText(resources.getString(R.string.alert_dialog_success_title));
        ((TextView) view.findViewById(R.id.textView_dialog_textMessage)).setText(resources.getString(R.string.dummy_text_medium));
        ((Button) view.findViewById(R.id.button_dialog_buttonAction)).setText(resources.getString(R.string.all_okay));
        ((ImageView) view.findViewById(R.id.imageView_dialog_imageIcon)).setImageResource(R.drawable.icon_success);
        return view;
    }

    @NotNull
    @Override
    public AlertDialog createAlertDialog(Context context, View successDialogView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        builder.setView(successDialogView);
        builder.setCancelable(false);
        return builder.create();
    }

    @Override
    public void setAlertDialogBehaviorOnDismiss(final AlertDialog alertDialog,
                                                final View successDialogView,
                                                final OnDismissListener listener) {
        successDialogView.findViewById(R.id.button_dialog_buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                ((ViewGroup) successDialogView.getParent()).removeView(successDialogView);
                listener.onDismiss();
            }
        });
    }

    @Override
    public void setWarningAlertDialogBehaviorOnDismiss(AlertDialog alertDialog, View alertDialogView, OnWarningDismissListener listener) {

    }
}
