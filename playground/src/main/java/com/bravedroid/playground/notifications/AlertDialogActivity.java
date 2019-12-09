package com.bravedroid.playground.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.bravedroid.playground.R;
import com.bravedroid.ui.notifications.alert.AlertDialogManager;
import com.bravedroid.ui.notifications.alert.FacadeAlertDialogManager;

public class AlertDialogActivity extends AppCompatActivity {
    private FacadeAlertDialogManager facadeAlertDialogManager;
    private static final String TAG = "@@@@AlertDialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        facadeAlertDialogManager = new FacadeAlertDialogManager(this);
        View.OnClickListener onClickCallback = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonSuccess:
                        showSuccessDialog(new AlertDialogManager.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                Log.d(TAG, "Button Success dismissed");
                            }
                        });
                        break;
                    case R.id.buttonError:
                        showErrorDialog(new AlertDialogManager.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                Log.d(TAG, "Button Error dismissed");
                            }
                        });
                        break;
                    case R.id.buttonWarning:
                        showWarningDialog(new AlertDialogManager.OnWarningDismissListener() {
                            @Override
                            public void onDismissYesButton() {
                                Log.d(TAG, "Button Warning YES dismissed");
                            }

                            @Override
                            public void onDismissNoButton() {
                                Log.d(TAG, "Button Warning NO dismissed");
                            }
                        });
                        break;
                    default:
                        Log.e(TAG, "unknown id");
                        break;
                }
            }
        };
        findViewById(R.id.buttonSuccess).setOnClickListener(onClickCallback);
        findViewById(R.id.buttonWarning).setOnClickListener(onClickCallback);
        findViewById(R.id.buttonError).setOnClickListener(onClickCallback);
    }

    private void showSuccessDialog(final AlertDialogManager.OnDismissListener listener) {
        facadeAlertDialogManager.showSuccessDialog(listener);
    }

    private void showWarningDialog(final AlertDialogManager.OnWarningDismissListener listener) {
            facadeAlertDialogManager.showWarningDialog(listener);
    }

    private void showErrorDialog(final AlertDialogManager.OnDismissListener listener) {
        facadeAlertDialogManager.showErrorDialog(listener);
    }
}
