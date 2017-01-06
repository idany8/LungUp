package com.example.idan.lungup;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CareProviderLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_provider_login);

        findViewById(R.id.btn_gt_create_new_pat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CareProviderLoginActivity.this,CreateNewPatientActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, 1);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), "recieved: "+result , Toast.LENGTH_SHORT).show();

                AlertDialog alertDialog = new AlertDialog.Builder(CareProviderLoginActivity.this).create();
                alertDialog.setTitle("New Patient Created!");
                alertDialog.setMessage("New patient login code is:\n\n\n" +result+"\n\n\nPlease copy the code the patient device.\nEmail with instruction bla bla");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
                Toast.makeText(getApplicationContext(), "recieved nothing" , Toast.LENGTH_SHORT).show();
            }
        }
    }//onActivityResult
}
