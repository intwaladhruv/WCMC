package com.example.wcmc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Prac11 extends AppCompatActivity {

    int RC_SIGN_IN = 0;
    SignInButton signInButton;
    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac11);

        // Set the dimensions of the sign-in button.
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {signIn();}});
    }

    private void signIn()
    {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    protected void handleSignInResult(Task<GoogleSignInAccount> completedTask)
    {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            startActivity(new Intent(Prac11.this, Glogin.class));
        }catch (ApiException e)
        {
            Log.w("Google Sign In Error" , "signInFailedCode = "+e.getStatusCode());
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(Prac11.this);
        if (account != null)
        {
            startActivity(new Intent(Prac11.this, Glogin.class));
        }
        super.onStart();
    }
}
