package com.example.idan.lungup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PatientMainActivity extends AppCompatActivity {
User usr = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main);

        Bundle b = getIntent().getExtras();
        String userKey = ""; // or other values
        if(b != null)
            userKey = b.getString("key");

        Log.d("userKey in patient:", userKey);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Users");

        myRef.child("-K_pfZqAd1dpvHaB9Kku").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                usr.setEmail(snapshot.child("email").getValue().toString());
                usr.setName(snapshot.child("name").getValue().toString());

                Log.d("aa1", usr.toString() );
               // usr = (User) snapshot.getValue();
               // Log.d("aa1", usr.getName());

              //  System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}
