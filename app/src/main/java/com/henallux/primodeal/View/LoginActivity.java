package com.henallux.primodeal.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.henallux.primodeal.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToTypeUserRegisterActivity(View v)
    {
        Intent explicitIntent = new Intent(this, TypeUserRegisterActivity.class);
       // final Intent msg = explicitIntent.putExtra("msg", "Données trop classes");

        // test voila quoi !
        startActivityForResult(explicitIntent, 1);
    }
}
