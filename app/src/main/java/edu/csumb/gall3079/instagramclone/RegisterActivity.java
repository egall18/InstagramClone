package edu.csumb.gall3079.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";
    EditText newUsername;
    EditText newPassword;
    Button registerUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUsername = findViewById(R.id.etNewUsername);
        newPassword = findViewById(R.id.etNewPassword);
        registerUser = findViewById(R.id.btnRegisterUser);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick signup button");
                //TODO register the user
                ParseUser new_user = new ParseUser();
                new_user.setUsername(newUsername.getText().toString());
                new_user.setPassword(newPassword.getText().toString());
                new_user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null)
                        {
                            Toast.makeText(RegisterActivity.this, "New User Created. Signing you in", Toast.LENGTH_SHORT).show();
                            goToMain();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }

    private void goToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}