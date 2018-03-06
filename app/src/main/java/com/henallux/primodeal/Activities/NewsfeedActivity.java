package com.henallux.primodeal.Activities;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.henallux.primodeal.Adapters.PublicationAdapter;
import com.henallux.primodeal.DataAccess.PublicationDao;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bil on 26-02-18.
 */

public class NewsfeedActivity extends AppCompatActivity {
    private List<Publication> publicationList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        new PublicationList().execute();

    }

    private void publicationView()
    {
        List<Publication>  publications = new ArrayList<>();

        publications.addAll(publicationList);



        PublicationAdapter publicationAdapter = new PublicationAdapter(this, publications);
        ListView listView = (ListView)findViewById(R.id.gardenList);
        listView.setAdapter(publicationAdapter);
    }




    private class PublicationList extends AsyncTask<Void,Void,List<Publication>>
    {
        private String errorMsg;
        @Override
        protected List<Publication> doInBackground(Void... strings) {
            List<Publication> list = new ArrayList<>();
            PublicationDao publicationDao = new PublicationDao();
            try {
                list = publicationDao.Get();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(list);
            return list;
        }

        protected void onPostExecute(List<Publication> list) {
            if(this.errorMsg != null){
                Toast.makeText(NewsfeedActivity.this, errorMsg, Toast.LENGTH_LONG).show();
            } else {
                publicationList = list;
                publicationView();
            }
        }
    }

}
