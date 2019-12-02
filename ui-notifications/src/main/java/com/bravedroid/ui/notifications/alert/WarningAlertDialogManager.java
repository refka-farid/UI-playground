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

public class WarningAlertDialogManager extends AlertDialogManager {

    private final Context context;

    public WarningAlertDialogManager(Context context) {
        this.context = context;
    }

    @NotNull
    public View inflateDialogView(Context context) {
        Resources resources = context.getResources();
        View view = LayoutInflater.from(context).inflate(
                R.layout.layout_dialog_warning, null);
        ((TextView) view.findViewById(R.id.textView_dialog_title)).setText(resources.getString(R.string.alert_dialog_warning_title));
        ((TextView) view.findViewById(R.id.textView_dialog_textMessage)).setText(resources.getString(R.string.dummy_text_medium));
        ((Button) view.findViewById(R.id.button_dialog_button_yes)).setText(resources.getString(R.string.all_yes));
        ((Button) view.findViewById(R.id.button_dialog_button_no)).setText(resources.getString(R.string.all_no));
        ((ImageView) view.findViewById(R.id.imageView_dialog_imageIcon)).setImageResource(R.drawable.icon_warning);
        return view;
    }

    @NotNull
    @Override
    public AlertDialog createAlertDialog(Context context, View warningDialogView) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogTheme);
        builder.setView(warningDialogView);
        builder.setCancelable(false);
        return builder.create();
    }

    @Override
    public void setWarningAlertDialogBehaviorOnDismiss(final AlertDialog alertDialog,
                                                       final View warningDialogView,
                                                       final OnWarningDismissListener listener) {
        warningDialogView.findViewById(R.id.button_dialog_button_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                ((ViewGroup) warningDialogView.getParent()).removeView(warningDialogView);
                listener.onDismissYesButton();
            }
        });

        warningDialogView.findViewById(R.id.button_dialog_button_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                ((ViewGroup) warningDialogView.getParent()).removeView(warningDialogView);
                listener.onDismissNoButton();
            }
        });
    }

    @Override
    public void setAlertDialogBehaviorOnDismiss(AlertDialog alertDialog, View alertDialogView, OnDismissListener listener) {

    }
}
