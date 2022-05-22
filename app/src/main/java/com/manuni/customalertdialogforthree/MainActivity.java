package com.manuni.customalertdialogforthree;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSuccess();
            }
        });
        findViewById(R.id.btnError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogError();
            }
        });
        findViewById(R.id.btnWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogWarning();
            }
        });
    }
    private void showDialogSuccess(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_success_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer));
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Success Title Here");
        ((TextView)view.findViewById(R.id.textMessage)).setText("Your all messages will be here");
        ((Button) view.findViewById(R.id.btnSuccessBtn)).setText("Okay");
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_done);

        final AlertDialog dialog = builder.create();

        view.findViewById(R.id.btnSuccessBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Okay button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        if (dialog.getWindow() != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.show();
    }
    private void showDialogError(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_error_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer));
        builder.setView(view);
        ((TextView)view.findViewById(R.id.textTitle)).setText("Error Title");
        ((TextView)view.findViewById(R.id.textMessage)).setText("Error messages will be here");
        ((Button)view.findViewById(R.id.errorBtn)).setText("Okay");
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_error);

        AlertDialog dialog = builder.create();
        view.findViewById(R.id.errorBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (dialog.getWindow() != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        dialog.show();
    }
    private void showDialogWarning(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_warning_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer));
        builder.setView(view);

        ((TextView)view.findViewById(R.id.textTitle)).setText("Warning Title");
        ((TextView)view.findViewById(R.id.textMessage)).setText("Warning messagtes will be here");
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.ic_warning);
        ((Button)view.findViewById(R.id.btnNo)).setText("No");
        ((Button)view.findViewById(R.id.btnYes)).setText("Yes");

       final AlertDialog dialog = builder.create();

        view.findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.dismiss();
            }
        });
        view.findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (dialog.getWindow() != null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialog.show();
    }
}