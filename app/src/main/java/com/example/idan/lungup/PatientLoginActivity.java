package com.example.idan.lungup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PatientLoginActivity extends AppCompatActivity {
EditText inputCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        inputCode   = (EditText)findViewById(R.id.et_patient_code);

        findViewById(R.id.btn_ok_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientLoginActivity.this,PatientMainActivity.class);
                //need to add validation func for the inputCode
                intent.putExtra("key",inputCode.getText().toString());
                startActivity(intent);

            }
        });

    }
}
