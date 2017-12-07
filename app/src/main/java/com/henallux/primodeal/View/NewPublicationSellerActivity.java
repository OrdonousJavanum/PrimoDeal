package com.henallux.primodeal.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henallux.primodeal.Controller.Controller;
import com.henallux.primodeal.Exception.PublicationException;
import com.henallux.primodeal.Model.Answer;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.Model.Question;
import com.henallux.primodeal.R;

/**
 * Created by bil on 22-11-17.
 */

public class NewPublicationSellerActivity extends AppCompatActivity {

    private Publication publication;
    private Question question;
    private Answer answer;
    private Controller controller = new Controller();
    private Button postButton, cancelButton, addQuestionButton, addAnswerButton;
    private EditText titlePublication_path, descriptionPublication_path, question_path, answer_path;
    private FragmentTransaction mFragmentTransaction;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_seller_new_publication);
        //QuestionFragment question = (QuestionFragment)findViewById(R.id.fragmentQuestion);

        titlePublication_path = (EditText) findViewById(R.id.input_titlePublication);
        descriptionPublication_path = (EditText) findViewById(R.id.input_descriptionPublication);


        postButton = (Button) findViewById(R.id.buttonPostPublication);
        cancelButton = (Button) findViewById(R.id.buttonCancelPublication);



        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    answer = new Answer(question_path.getText().toString());
                } catch (PublicationException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }

                try {
                    question = new Question(question_path.getText().toString(), answer);
                } catch (PublicationException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }

                try {
                    publication = new Publication(
                            titlePublication_path.getText().toString(),
                            descriptionPublication_path.getText().toString(),
                            question
                    );
                    controller.addPublication(publication);
                } catch (PublicationException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });



        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPublicationSellerActivity.this, SellerMenuActivity.class);
                startActivity(intent);
            }
        });


    }
}
