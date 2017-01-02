package com.example.idan.lungup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn_pat_login_screen = (Button) findViewById(R.id.pat_btn);
        final Button btn_cp_login_screen = (Button) findViewById(R.id.cp_btn);


        findViewById(R.id.pat_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PatientLoginActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.cp_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CareProviderLoginActivity.class);
                startActivity(intent);
            }
        });



//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference();

       // myRef.setValue("Hello, Worldsss11!");
//        User usr = new User("idan","idan@gmail.com");
//        myRef.child("users").setValue(usr);

//        Map<User> post1 = new Map<User>();
//        post1.put("author", "gracehop");
//        post1.put("title", "Announcing COBOL, a New Programming Language");
//        myRef.push().setValue(post1);
//        Map<String, String> post2 = new HashMap<String, String>();
//        post2.put("author", "alanisawesome");
//        post2.put("title", "The Turing Machine");
//        myRef.push().setValue(post2);

       // User usr = new User("idan","idan@gmail.com");
    }
}
