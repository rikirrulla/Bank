package com.example.bank;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.bank.Model.ApplicationDB;
import com.example.bank.Model.Profile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class LoginActivity extends Activity {

    SharedPreferences pref;
    EditText ETUsername,ETPassword;
    Button BTNLogin;
    ArrayList<Profile> profiles;
    String password = new String();
    String passwordHash= new String();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean finish = getIntent().getBooleanExtra("finish", false);
        if (finish) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_login);
        ETUsername = findViewById(R.id.idUsernameLogin);
        ETPassword = findViewById(R.id.idPasswordLogin);
        BTNLogin = findViewById(R.id.idSignInLogin);
        password = ETPassword.getText().toString();
        populateProfiles();


        BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAccount();
            }
        });
    }

    private void populateProfiles() {
        ApplicationDB applicationDB = new ApplicationDB(getApplicationContext());
        profiles = applicationDB.getAllProfiles();

    }

    private void hashPassword() throws NoSuchAlgorithmException {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(ETPassword.getText().toString().getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            passwordHash = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void validateAccount() {
        String welcome = null;
        boolean match = false;
        try {
            hashPassword();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
        if (profiles.size() > 0) {
            for (int i = 0; i < profiles.size(); i++) {
              //  Log.e("@",profiles.get(i).getUsername()+"-pw:-"+profiles.get(i).getPassword());
               // Log.e("#",ETUsername.getText().toString()+"-baba:-"+passwordHash);
                if (ETUsername.getText().toString().equals(profiles.get(i).getUsername()) && passwordHash.equals(profiles.get(i).getPassword())) {
                    match = true;
                     SharedPreferences sharedPreferences = PreferenceManager
                            .getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("id", Integer.toString(profiles.get(i).getProfileID()));
                    editor.putString("fullname", profiles.get(i).getFullname());
                    welcome = profiles.get(i).getFullname();
                    editor.putString("city", profiles.get(i).getCity());
                    editor.putString("address", profiles.get(i).getAddress());
                    editor.putString("telephone_number", profiles.get(i).getTelephone_number());
                    editor.putString("username", ETUsername.getText().toString());
                    editor.putString("password", passwordHash);
                    editor.apply();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
                if (match == true){
                    Toast.makeText(getApplicationContext(), "Miresevini "+welcome,Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplication(), "Perdoruesi ose fjalekalimi gabim!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
