package com.henallux.primodeal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.henallux.primodeal.Model.PersonReturnModel;
import com.henallux.primodeal.R;

/**
 * Created by bil on 05-04-18.
 */

public class StoreCardActivity  extends AppCompatActivity {

    private PersonReturnModel shop;
    private TextView nameShopTextView, addressShopTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_card);
        Bundle bundle = this.getIntent().getExtras();
        /*final Publication*/ shop = (PersonReturnModel) bundle.getSerializable("shop");
        System.out.println("Name shop : " + shop.getNameShop());

        nameShopTextView = (TextView) findViewById(R.id.textViewNameShopCard);
        addressShopTextView = (TextView) findViewById(R.id.textViewAddressShopCard);

        nameShopTextView.setText(shop.getNameShop());
        addressShopTextView.setText(shop.getAddressShop());

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newsfeed, menu);
        menu.findItem(R.id.action_deconnection).setVisible(false);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_deconnection:
                return true;

            case R.id.action_back:
                startActivity(new Intent(StoreCardActivity.this, PublicationDetailResponseActivity.class));
                return true;
        }

        return true;
    }


}
