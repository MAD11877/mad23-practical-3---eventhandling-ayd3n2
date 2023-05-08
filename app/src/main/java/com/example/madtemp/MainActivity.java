package com.example.madtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    User person = new User("John","description",1739039545,false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(person.getName() + " " + person.getId());
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
                if(btn.getText() == "UNFOLLOW"){
                    btn.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                    person.setFollowed(true);
                } else if (btn.getText() == "FOLLOW") {
                    btn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                    person.setFollowed(false);
                }
            }
        });
    }
}