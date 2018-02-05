package com.henallux.primodeal.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.R;

public class PersonRegisterActivity extends AppCompatActivity {

    private Button createPersonButton;
    private EditText email_path, password_path;
    private String role;
    private PersonDao personDao = new PersonDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_register);

        email_path = (EditText) findViewById(R.id.inputEmailRegister);
        password_path = (EditText) findViewById(R.id.inputPasswordRegister);

        createPersonButton = (Button) findViewById(R.id.buttonRegister);
        createPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new RecordPersonAsync().execute(email_path.getText().toString(), password_path.getText().toString());
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_costumer:
                if (checked)
                    role = "costumer";
                    break;
            case R.id.radio_seller:
                if (checked)
                    role="seller";
                    break;
        }
    }

    private class RecordPersonAsync extends AsyncTask<String, Void, Integer> {
        private Integer code;

        protected Integer doInBackground(String... strings) {

            try {
                System.out.println("ici ");
                code = personDao.inscription(strings[0],strings[1],role);
                if(code == 201)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Bienvenue", Toast.LENGTH_LONG);
                    toast.show();
                    /*
                    Intent intent = new Intent(PersonRegisterActivity.this, P.class);
                    startActivity(intent);*/
                }
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }

            return code;
        }
    }
}
