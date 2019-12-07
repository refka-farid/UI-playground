package com.bravedroid.ui.notifications.alert;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bravedroid.ui.notifications.R;

public class AlertDialogActivity extends AppCompatActivity {
    private FacadeAlertDialogManager facadeAlertDialogManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        facadeAlertDialogManager = new FacadeAlertDialogManager(this);
        View.OnClickListener onClickCallback = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.buttonSuccess) {
                    showSuccessDialog();
                } else if (v.getId() == R.id.buttonError) {
                    showErrorDialog();
                }
                if (v.getId() == R.id.buttonWarning) {
                    showWarningDialog();
                }
            }
        };
        findViewById(R.id.buttonSuccess).setOnClickListener(onClickCallback);
        findViewById(R.id.buttonWarning).setOnClickListener(onClickCallback);
        findViewById(R.id.buttonError).setOnClickListener(onClickCallback);
    }

    private void showSuccessDialog() {
        facadeAlertDialogManager.showSuccessDialog();
    }

    private void showWarningDialog() {
        facadeAlertDialogManager.showWarningDialog();
    }

    private void showErrorDialog() {
        facadeAlertDialogManager.showErrorDialog();
    }
}
