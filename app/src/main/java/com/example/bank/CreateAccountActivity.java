package com.example.bank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bank.Model.ApplicationDB;
import com.example.bank.Model.Connection;
import com.example.bank.Model.Profile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class CreateAccountActivity extends Activity {

    Button btnCreateAccount;
    EditText ETUsername, ETPassword, ETPasswordConfirm;
    ArrayList<Profile> profileArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account_1);

        ApplicationDB applicationDB = new ApplicationDB(getApplication());
        profileArrayList = applicationDB.getAllProfiles();

        ETUsername = findViewById(R.id.idUsernameC1);
        ETPassword = findViewById(R.id.idPasswordC2);
        ETPasswordConfirm = findViewById(R.id.idRePasswordC2);
        btnCreateAccount = findViewById(R.id.idCreateAccountRegister);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createProfile();
            }
        });
    }

    private void createProfile() {


        boolean usernameTaken = false;
        for (int i = 0; i < profileArrayList.size(); i++) {
            if (ETUsername.getText().toString().equalsIgnoreCase(profileArrayList.get(i).getUsername())) {
                usernameTaken = true;
            }
        }

        if (ETUsername.getText().toString().equals("") || ETPassword.getText().toString().equals("")) {

            Toast.makeText(CreateAccountActivity.this, "Emri i perdoruesit ose fjalkalimi i pavlefshm", Toast.LENGTH_LONG).show();

        } else if (!(ETPassword.getText().toString().equalsIgnoreCase(ETPasswordConfirm.getText().toString()))) {
            Toast.makeText(CreateAccountActivity.this, "Fjalekalimet nuk perputhen!", Toast.LENGTH_SHORT).show();
        } else if (usernameTaken) {
            Toast.makeText(CreateAccountActivity.this, "Ju lutem ndryshoni perdoruesin", Toast.LENGTH_SHORT).show();
        } else {
            String hashpass = null;
            try {
                hashpass = hashpass();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            //Toast.makeText(getApplication(),hashpass,Toast.LENGTH_LONG).show();

            Intent i = new Intent(CreateAccountActivity.this, CreateAccountActivity2.class)
                    .putExtra("username", ETUsername.getText().toString())
                    .putExtra("password", hashpass);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    private String hashpass() throws NoSuchAlgorithmException {
        String hashtext = null;
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
            hashtext = hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashtext;
    }
}
