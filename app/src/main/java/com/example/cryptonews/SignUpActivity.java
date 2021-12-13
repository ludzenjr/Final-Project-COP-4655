package com.example.cryptonews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextEmail;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

    }

    public void signupButtonClicked(View view){


        //Strings to get the user input
        String txtUserName= editTextUserName.getText().toString().trim();
        String txtPassword= editTextPassword.getText().toString().trim();
        String txtEmail= editTextEmail.getText().toString().trim();

        //error messages
        if(txtUserName.isEmpty()){
            editTextUserName.setError("Please enter User Name");
            editTextUserName.requestFocus();
        }
        if(txtPassword.isEmpty() || txtPassword.length() < 6){
            editTextPassword.setError("Please enter Password containing six characters");
            editTextPassword.requestFocus();
        }

        if(txtEmail.isEmpty()){
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            User user = new User(txtUserName, txtPassword, txtEmail);
                            //save user in database
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(SignUpActivity.this,"Registration Completed",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                        startActivity(new Intent(SignUpActivity.this, DashboardActivity.class));

                                    }
                                    else{
                                        Toast.makeText(SignUpActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }
                        else{
                            Toast.makeText(SignUpActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}