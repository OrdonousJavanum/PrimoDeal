package com.henallux.primodeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TypeUserRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_user_register);
    }
    public void goToCustomerRegisterActivity(View v)
    {
        Intent explicitIntent = new Intent(this, CustomerRegisterActivity.class);
        startActivityForResult(explicitIntent, 1);
    }

    public void goToSellerRegisterActivity(View v)
    {
        Intent explicitIntent = new Intent(this, SellerRegisterActivity.class);
        startActivityForResult(explicitIntent, 1);
    }



}
