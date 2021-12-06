package com.example.cryptonews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    EditText editTextUserName,editTextPassword;
    TextView textViewForgotPassword, textViewRegister;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserName = (EditText) findViewById(R.id.editTextSignInUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextSignInPassword);
        textViewForgotPassword = (TextView) findViewById(R.id.txtSignInForgotPassword);
        textViewRegister = (TextView) findViewById(R.id.txtSignInRegister);

        progressBar = (ProgressBar) findViewById(R.id.progressBarSignIn);
        mAuth = FirebaseAuth.getInstance();
    }

    public void txtSignInForgotPasswordClicked(View v){

    }

    public void txtSignInRegisterClicked(View v){

    }

    public void buttonSignInScrSignInClicked(View v){

        String userName = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            editTextUserName.setError("Please Enter a valid Email");
            editTextUserName.requestFocus();
        }
        if (editTextPassword.length() <6){
            editTextPassword.setError("Please enter password containing at least 6 characters");
            editTextPassword.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(userName,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(SignInActivity.this,"User Has Been Signed In",Toast.LENGTH_LONG).show();
                }
                else{
                    progressBar.setVisibility(View.GONE);

                    Toast.makeText(SignInActivity.this,"User Has Failed to Sign In",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}