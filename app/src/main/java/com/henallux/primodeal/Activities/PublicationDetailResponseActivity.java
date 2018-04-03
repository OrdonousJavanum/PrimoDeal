package com.henallux.primodeal.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
        Bundle bundle = this.getIntent().getExtras();
        Publication publication = (Publication) bundle.getSerializable("publication");
        System.out.println("idPublication : "+publication.getId());

        titleTextView = (TextView)findViewById(R.id.textViewTitlePublicationDetail);
        descriptionTextView = (TextView)findViewById(R.id.textViewDescriptionPublicationDetail);
        yesTextView = (TextView)findViewById(R.id.textViewYesPublicationDetail);
        noTextView = (TextView)findViewById(R.id.textViewNoPublicationDetail);
        indifferentTextView = (TextView)findViewById(R.id.textViewIndifferentPublicationDetail);

        // List<Response> responses = publication.getResponses();

        cptYes = cptNo = cptIndifferent = 0;

        for(int i = 0; i < publication.getResponses().size(); i++){

            if(publication.getResponses().get(i).getResponse().equals("yes"))
                cptYes++;
            if(publication.getResponses().get(i).getResponse().equals("no"))
                cptNo++;
            if(publication.getResponses().get(i).getResponse().equals("indifferent"))
                cptIndifferent++;
        }

        titleTextView.setText(publication.getTitle());
        descriptionTextView.setText(publication.getDescription());
        yesTextView.setText("yes : "+cptYes);
        noTextView.setText("no : "+cptNo);
        indifferentTextView.setText("indifferent : "+cptIndifferent);

    }

    public void onRadioButtonClicked(View view) {
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
            case R.id.radioButtonResIndifferent:
                if(checked)
                    response="Indifferent";
                break;
        }
    }

}
