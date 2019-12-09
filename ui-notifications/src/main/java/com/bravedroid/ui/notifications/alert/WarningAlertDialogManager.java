package com.bravedroid.ui.notifications.alert;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
                R.layout.layout_warning_dialog, null);
        ((TextView) view.findViewById(R.id.textTitle)).setText(resources.getString(R.string.warning_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(resources.getString(R.string.dymy_text));
        ((Button) view.findViewById(R.id.buttonYes)).setText(resources.getString(R.string.yes));
        ((Button) view.findViewById(R.id.buttonNo)).setText(resources.getString(R.string.no));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning);
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
        warningDialogView.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                ((ViewGroup) warningDialogView.getParent()).removeView(warningDialogView);
                listener.onDismissYesButton();
            }
        });

        warningDialogView.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
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
