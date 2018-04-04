package com.henallux.primodeal.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.DataAccess.ResponseDao;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.Model.Response;
import com.henallux.primodeal.R;

import java.util.List;

/**
 * Created by bil on 03-04-18.
 */

public class PublicationDetailResponseActivity extends AppCompatActivity {

    private String response;
    private Integer cptYes, cptNo, cptIndifferent;
    private TextView titleTextView, descriptionTextView, yesTextView, noTextView, indifferentTextView;
    private Button sendResponseButton;
    private ResponseDao responseDao = new ResponseDao();
    private Publication publication;
    private Boolean isVoted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
        Bundle bundle = this.getIntent().getExtras();
        /*final Publication*/ publication = (Publication) bundle.getSerializable("publication");
        System.out.println("idPublication : " + publication.getId());

        titleTextView = (TextView) findViewById(R.id.textViewTitlePublicationDetail);
        descriptionTextView = (TextView) findViewById(R.id.textViewDescriptionPublicationDetail);
        yesTextView = (TextView) findViewById(R.id.textViewYesPublicationDetail);
        noTextView = (TextView) findViewById(R.id.textViewNoPublicationDetail);
        indifferentTextView = (TextView) findViewById(R.id.textViewIndifferentPublicationDetail);

        sendResponseButton = (Button) findViewById(R.id.buttonSendResponse);

        // List<Response> responses = publication.getResponses();

        cptYes = cptNo = cptIndifferent = 0;

        for (int i = 0; i < publication.getResponses().size(); i++) {

            if ("yes".equals(publication.getResponses().get(i).getResponse()))
                cptYes++;
            if ("no".equals(publication.getResponses().get(i).getResponse()))
                cptNo++;
            if ("indifferent".equals(publication.getResponses().get(i).getResponse()))
                cptIndifferent++;

            //voted ?
            if(publication.getResponses().get(i).getApplicationUserId().equals(PersonDao._user.id)){
                isVoted = true;
                View b = findViewById(R.id.buttonSendResponse);
                b.setVisibility(View.GONE);
            }
        }

        titleTextView.setText(publication.getTitle());
        descriptionTextView.setText(publication.getDescription());
        yesTextView.setText("yes : " + cptYes);
        noTextView.setText("no : " + cptNo);
        indifferentTextView.setText("indifferent : " + cptIndifferent);



        sendResponseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    System.out.println("reponse : "+response);
                    new SendResponseAsync().execute();


                } catch (Exception e) {
                    System.out.println("dans le catch");
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }

    public void onRadioButtonResponseClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonResYes:
                if (checked)
                    response = "yes";
                break;
            case R.id.radioButtonResNo:
                if (checked)
                    response="no";
                break;
            case R.id.radioButtonResIndifferent:
                if(checked)
                    response="indifferent";
                break;
        }
    }

    private class SendResponseAsync extends AsyncTask<Void, Void, Integer> {
        int code = 0;

        @Override
        protected Integer doInBackground(Void ...voids){

            try {
                code = responseDao.postResponse(response, publication.getId());
                if(code == 201){
                    startActivity(new Intent(PublicationDetailResponseActivity.this, NewsfeedActivity.class));
                }
            } catch (Exception e) {
                System.out.println("new post catch: "+e.getMessage());
            }

            return code;
        }


    }



}
