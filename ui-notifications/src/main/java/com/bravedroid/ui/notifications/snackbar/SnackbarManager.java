package com.bravedroid.ui.notifications.snackbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.bravedroid.ui.notifications.R;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

public class SnackbarManager {

    public Snackbar makeSuccessSnackbar(Context context, ViewGroup rootLayout, String text, OnDismissSnackBar onDismissSnackBar) {
        final Snackbar snackBar = createSnackbar(rootLayout, text);
        View snackView = inflateSnackView(context);
        prepareSnackbarLayout(snackBar, snackView, text, R.color.colorSuccess, context);
        setSnackbarBehaviorOnDismiss(snackBar, snackView, onDismissSnackBar);
        return snackBar;
    }

    public Snackbar makeWarningSnackbar(Context context, ViewGroup rootLayout, String text, OnDismissSnackBar onDismissSnackBar) {
        final Snackbar snackBar = createSnackbar(rootLayout, text);
        View snackView = inflateSnackView(context);
        prepareSnackbarLayout(snackBar, snackView, text, R.color.colorWarning, context);
        setSnackbarBehaviorOnDismiss(snackBar, snackView, onDismissSnackBar);
        return snackBar;
    }

    public Snackbar makeErrorSnackbar(Context context, ViewGroup rootLayout, String text, OnDismissSnackBar onDismissSnackBar) {
        final Snackbar snackBar = createSnackbar(rootLayout, text);
        View snackView = inflateSnackView(context);
        prepareSnackbarLayout(snackBar, snackView, text, R.color.colorError, context);
        setSnackbarBehaviorOnDismiss(snackBar, snackView, onDismissSnackBar);
        return snackBar;
    }

    @NotNull
    private Snackbar createSnackbar(ViewGroup rootLayout, String text) {
        return Snackbar.make(rootLayout, text, Snackbar.LENGTH_LONG);
    }

    private View inflateSnackView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.layout_snackbar, null);
    }

    private void prepareSnackbarLayout(Snackbar snackBar, View snackView, String text, int color, Context context) {
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackBar.getView();
        snackbarLayout.setPadding(0, 0, 0, 0);
        TextView snackbarText = snackbarLayout.findViewById(R.id.snackbar_text);
        LinearLayout snackbarLayoutContainer = snackView.findViewById(R.id.linearLayout_snackbar_layout);
        snackbarLayoutContainer.setBackgroundColor(ContextCompat.getColor(context, color));
        snackbarText.setVisibility(View.INVISIBLE);
        TextView textView = snackView.findViewById(R.id.textView_snackbar_textBody);
        textView.setText(text);
        snackbarLayout.addView(snackView, 0);
    }

    private void setSnackbarBehaviorOnDismiss(Snackbar snackBar, View snackView, OnDismissSnackBar onDismissSnackBar) {
        ImageView cancelIcon = snackView.findViewById(R.id.imageView_snackbar_iconCancel);
        cancelIcon.setOnClickListener(v1 -> {
            onDismissSnackBar.onDismissSnack();
            snackBar.dismiss();
        });
    }

    public interface OnDismissSnackBar {
        void onDismissSnack();
    }
}
