package com.henallux.primodeal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.henallux.primodeal.R;

/**
 * Created by bil on 22-11-17.
 */

public class SellerMenuActivity extends AppCompatActivity {

    private Button myPublicationsButton, newPublicationButton, allPublicationNamur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_menu);

        myPublicationsButton = (Button) findViewById(R.id.buttonMyPublications);
        newPublicationButton = (Button) findViewById(R.id.buttonNewPublication);
        allPublicationNamur = (Button) findViewById(R.id.buttonAllPublication);

        myPublicationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerMenuActivity.this, NewsfeedFromSellerActivity.class);
                startActivity(intent);
            }
        });

        newPublicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerMenuActivity.this, NewPublicationSellerActivity.class);
                startActivity(intent);
            }
        });

        allPublicationNamur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerMenuActivity.this, NewsfeedActivity.class);
                startActivity(intent);
            }
        });
    }

}
