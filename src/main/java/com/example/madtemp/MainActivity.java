package com.example.madtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    User person = new User("John","description",1,false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        if(person.getFollowed() == false){
            btn.setText("FOLLOW");
        }
        else{
            btn.setText("UNFOLLOW");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(person.getFollowed() == false){
                    btn.setText("FOLLOW");
                    person.setFollowed(true);
                } else if (person.getFollowed() == true) {
                    btn.setText("UNFOLLOW");
                    person.setFollowed(false);
                }
            }
        });
    }
}