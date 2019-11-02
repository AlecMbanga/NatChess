package com.example.natchess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {


    private EditText editTextUsername;
    private EditText editTextPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mProgress = new ProgressDialog(this);



        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button btnLogin = findViewById(R.id.buttonLogin);
        Button btnPlay = findViewById(R.id.buttonPlay);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chess.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        String email = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        mProgress.setMessage("Logging In...");
        mProgress.show();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            mProgress.dismiss();
                            Intent intent = new Intent(getApplicationContext(), play.class);
                            startActivity(intent);


                        } else {
                            mProgress.dismiss();
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Login in failed, Enter valid credentials",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }

                });
    }
}
