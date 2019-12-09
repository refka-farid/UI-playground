package com.bravedroid.playground.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bravedroid.playground.R;
import com.bravedroid.playground.databinding.ActivitySnackbarBinding;
import com.bravedroid.ui.notifications.snackbar.SnackbarManager;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarActivity extends AppCompatActivity {
    private ActivitySnackbarBinding binding;
    private static final String TAG = "@@@@SnackbarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_snackbar);
        SnackbarManager snackbarManager = new SnackbarManager();

        Button showErrorSnackbarButton = binding.buttonSnackbarActivityShowErrorSnackbar;
        Button showSuccessSnackbarButton = binding.buttonSnackbarActivityShowSuccessSnackbar;
        Button showWarningSnackbarButton = binding.buttonSnackbarActivityShowWarningSnackbar;
        ViewGroup rootLayout = binding.constraintLayoutSnackbarActivityRoot;

        View.OnClickListener callback = v -> {
            switch (v.getId()) {
                case R.id.button_snackbarActivity_showSuccessSnackbar:
                    Snackbar successSnackbar = snackbarManager.makeSuccessSnackbar(SnackbarActivity.this, rootLayout, "SAMPLE TEXT", () -> {
                        Log.d(TAG, "snackbar CANCELED");
                    });
                    successSnackbar.show();
                    break;

                case R.id.button_snackbarActivity_showErrorSnackbar:
                    Snackbar errorSnackbar = snackbarManager.makeErrorSnackbar(SnackbarActivity.this, rootLayout, "SAMPLE TEXT", () -> {
                        Log.d(TAG, "snackbar CANCELED");
                    });
                    errorSnackbar.show();
                    break;

                case R.id.button_snackbarActivity_showWarningSnackbar:
                    Snackbar warningSnackbar = snackbarManager.makeWarningSnackbar(SnackbarActivity.this, rootLayout, "SAMPLE TEXT", () -> {
                        Log.d(TAG, "snackbar CANCELED");
                    });
                    warningSnackbar.show();
                    break;
            }
        };
        showErrorSnackbarButton.setOnClickListener(callback);
        showSuccessSnackbarButton.setOnClickListener(callback);
        showWarningSnackbarButton.setOnClickListener(callback);
    }
}
