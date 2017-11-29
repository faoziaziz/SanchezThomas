package org.labseni.sanchezthomas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
/*
	import org.labseni.sanchez.R; ini aku hapus
*/

public class login extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth= FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            //profile activity
            finish();
            startActivity(new Intent(getApplicationContext(), profile.class));

        }

        editTextEmail =(EditText) findViewById(R.id.editTextEmail);
        editTextPassword =(EditText) findViewById(R.id.editTextPassword);
        buttonSignIn =(Button) findViewById(R.id.buttonSignin);
        textViewSignUp =(TextView) findViewById(R.id.textViewSignup);

        progressDialog= new ProgressDialog(this);

        buttonSignIn.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);

    }

    private void userLogin()
    {
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            //email is emty
            Toast.makeText(this, "Silfupley, email", Toast.LENGTH_SHORT).show();
            //stop function
            return;
        }
        if(TextUtils.isEmpty(password))
        {
            //password is empty
            Toast.makeText(this, "Silfupley, password", Toast.LENGTH_SHORT).show();
            //stopping execution furher
            return;
        }
        //if valid
        progressDialog.setMessage("Lagi login bro...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progressDialog.dismiss();
                if(task.isSuccessful()){
                    //start the profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), profile.class));
                }
            }


        });
    }
    @Override
    public void onClick(View view)
    {
        if(view==buttonSignIn){
            userLogin();
        }
        if (view==textViewSignUp)
        {
            finish();
            startActivity(new Intent(this, daftar.class));
        }
    }
}
