package com.bravedroid.ui.notifications.alert;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bravedroid.ui.notifications.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        findViewById(R.id.buttonSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog();
            }
        });
        findViewById(R.id.buttonWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWarningDialog();
            }
        });
        findViewById(R.id.buttonError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showErrorDialog();
            }
        });
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertDialogActivity.this).inflate(
                R.layout.layout_success_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView)view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.success_title));
        ((TextView)view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dymy_text));
        ((Button)view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_success);

        final AlertDialog alertDialog=builder.create();
        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    
    private void showWarningDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertDialogActivity.this).inflate(
                R.layout.layout_warning_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView)view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.warning_title));
        ((TextView)view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dymy_text));
        ((Button)view.findViewById(R.id.buttonYes)).setText(getResources().getString(R.string.yes));
        ((Button)view.findViewById(R.id.buttonNo)).setText(getResources().getString(R.string.no));
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning);

        final AlertDialog alertDialog=builder.create();
        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(AlertDialogActivity.this,"Yes",Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Toast.makeText(AlertDialogActivity.this,"Yes",Toast.LENGTH_SHORT).show();
            }
        });
        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(AlertDialogActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(AlertDialogActivity.this).inflate(
                R.layout.layout_error_dialog,
                (ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView)view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.error_title));
        ((TextView)view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.dymy_text));
        ((Button)view.findViewById(R.id.buttonAction)).setText(getResources().getString(R.string.okay));
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);

        final AlertDialog alertDialog=builder.create();
        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        if(alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}
