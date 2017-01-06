package com.example.idan.lungup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNewPatientActivity extends AppCompatActivity {
    EditText nameInput,mailInput;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    static String createdKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_patient);
        nameInput   = (EditText)findViewById(R.id.et_name);
        mailInput   = (EditText)findViewById(R.id.et_mail);

        findViewById(R.id.btn_create_new_pat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid(nameInput,mailInput)) {
                    Toast.makeText(getApplicationContext(), "send details", Toast.LENGTH_SHORT).show();
                    Log.d("createdKey:", createdKey);

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",createdKey);
                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();

//                    *** if i dont want to return data -->
//                    Intent returnIntent = new Intent();
//                    setResult(Activity.RESULT_CANCELED, returnIntent);
//                    finish();
                }

            }
        });
    }

    public boolean isValid(EditText name, EditText mail) {
        if ((name.getText().toString() != "") && (mail.getText().toString().matches((emailPattern)))) {
            createdKey = createNewPatient(name.getText().toString(),mail.getText().toString());
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
            return false;

        }
    }
    public String createNewPatient(String name, String email)
    {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference().child("Users").push();
                User usr = new User(name,email);
                myRef.setValue(usr);
                return myRef.getKey();


    }

}

