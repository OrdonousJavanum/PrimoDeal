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
    ListView mGardenList;
    String[] gardens = new String[]{
            "La poterne des peupliers", "Rainbow garden", "Les roses de Martha",
            "Le poireau Agile", "Le Semi Urbain", "La Note Bleue"
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);

        mGardenList = (ListView) findViewById(R.id.gardenList);

        try {
            afficherListeTweets();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void afficherListeNoms(){
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewsfeedActivity.this, android.R.layout.simple_list_item_1, gardens);
        mGardenList.setAdapter(adapter);
    }

    private List<Publication> genererTweets() throws Exception {
        new PublicationList().execute();

        List<Publication> tweets = new ArrayList<Publication>();
       /* tweets.add(new Publication("Florent", "Mon premier tweet !"));
        tweets.add(new Publication("Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Publication("Logan", "Que c'est beau..."));
        tweets.add(new Publication("Mathieu", "Il est quelle heure ??"));
        tweets.add(new Publication("Willy", "On y est presque"));*/
      // tweets =
        return tweets;
    }

    private void afficherListeTweets() throws Exception {
        List<Publication> tweets = genererTweets();

        PublicationAdapter adapter = new PublicationAdapter(NewsfeedActivity.this, tweets);
        mGardenList.setAdapter(adapter);
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
            }
        }
    }

}
