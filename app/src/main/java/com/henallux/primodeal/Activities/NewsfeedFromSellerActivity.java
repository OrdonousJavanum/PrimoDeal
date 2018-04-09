package com.henallux.primodeal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.henallux.primodeal.Adapters.PublicationAdapter;
import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.Model.PersonReturnModel;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bil on 28-03-18.
 */

public class NewsfeedFromSellerActivity extends AppCompatActivity {



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        List<Publication>  publications = new ArrayList<>();

        publications.addAll(PersonDao._user.getPublications());
        System.out.println(PersonDao._user.getPublications());


        PublicationAdapter publicationAdapter = new PublicationAdapter(this, publications);
        final ListView listView = (ListView)findViewById(R.id.gardenList);
        listView.setAdapter(publicationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Object listItem = listView.getItemAtPosition(position);
                PublicationDetailResponseActivity.setPublication(null);
                Publication publication = (Publication) listView.getItemAtPosition(position);
                System.out.println("listItem : "+publication.getTitle());
                startActivity(new Intent(NewsfeedFromSellerActivity.this, StatPublicationOfUserActivity.class).putExtra("publicationId", publication.getId()));
            }
        });

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
                startActivity(new Intent(NewsfeedFromSellerActivity.this, SellerMenuActivity.class));
                return true;
        }

        return true;
    }


}
