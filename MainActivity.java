package com.example.testme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;

import android.content.ContentProviderClient;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public EditText emailid,password;
    Button btnSignUp;
    Button btnSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth= FirebaseAuth.getinstence();
        emailid=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextTextPassword);
        btnSignUp=findViewById(R.id.button);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string email= emailid.getText().toString();
                string pwd= password.getText().toString();
                if (email.isEmpty()){
                    emailid.setError("please enter email id");
                    emailid.requestFocus()

                }
                else if (pwd.isEmpty()){
                    password.setError("plesde enter your password");
                    password.requestFocus()
                }
                else if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"fields are empty!",Toast.LENGTH_SHORT).show();
                    )
                }
                else if (!(email.isEmpty() && pwd.isEmpty())){ mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addonCompleteListener (MainActivity.this,new onCompleteListener())
                        @override
                    {
                        public void onComplete(@NonNull Task<Authresult>)task) {
                       if (!task,isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Signup unsuccessfull,Please Try Again",Toast.LENGTH_SHORT).show();

                        }
                       else{
                           startActivity(MainActivity.this,HomeActivity2.class);
                        }
                    }
                    }

                }
            }
        });

    else{
        Toast.makeText(MainActivity.this,"Error occured!",Toast.LENGTH_SHORT).show();

    }
}
