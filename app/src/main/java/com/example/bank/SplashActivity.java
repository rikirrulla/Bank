package com.example.bank;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static org.bitbucket.dollar.Dollar.$;

public class SplashActivity extends Activity {

    ImageView bgapps,logo;
    Animation bganim;
    LinearLayout logincreate;
    Button btnSignUp,btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bganim = AnimationUtils.loadAnimation(this, R.anim.frombuttom);

        bgapps = findViewById(R.id.idBackgroundApps);
        logo = findViewById(R.id.idLogoBankSplash);
        logincreate = findViewById(R.id.idButtonMenu);
        btnSignIn = findViewById(R.id.idLoginSplash);
        btnSignUp = findViewById(R.id.idSignInLogin);
        //test();
        animate();

       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(SplashActivity.this, "BABA: -"+preferences.getString("username", "defaultValue"), Toast.LENGTH_SHORT).show();
        */
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SplashActivity.this, CreateAccountActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


    }

    private void animate() {
        bgapps.animate().translationY(-700).setDuration(800).setStartDelay(1000);
        logo.animate().translationY(-400).setDuration(800).setStartDelay(1000);
        logincreate.startAnimation(bganim);
        logincreate.animate().setStartDelay(1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String u = preferences.getString("username", "defaultValue");
        if(!u.equals("defaultValue")){
            Intent i = new Intent(SplashActivity.this, DashboardActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String u = preferences.getString("username", "defaultValue");
        if(!u.equals("defaultValue")){
            Intent i = new Intent(SplashActivity.this, DashboardActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    private void test(){
        String validCharacters = $('0', '9').join() + $('A', 'Z').join();
        String randomString =  $(validCharacters).shuffle().slice(6).toString();
        Log.e("TEXT : ",randomString);
        Toast.makeText(getApplicationContext(), randomString, Toast.LENGTH_LONG).show();
    }
}
