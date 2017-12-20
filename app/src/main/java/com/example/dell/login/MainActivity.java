package com.example.dell.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=5;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.edName);
        Password = (EditText) findViewById(R.id.edPassword);
        Info = (TextView) findViewById(R.id.edNumber);
        Login = (Button) findViewById(R.id.edButton);

        Info.setText("NO. of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                 validate(Name.getText().toString(), Password.getText().toString());
             }
        });
    }

    public void validate(String username, String password){
        if((username.equals("Aditi")) && (password.equals("12345"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("NO. of attempts remaining:" + String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }
        }

    }
}
