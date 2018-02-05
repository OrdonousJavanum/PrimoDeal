package com.henallux.primodeal.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.Model.LoginForm;
import com.henallux.primodeal.Model.PersonReturnModel;
import com.henallux.primodeal.R;

public class LoginActivity extends AppCompatActivity {

    private EditText email_path, password_path;
    private Button loginButton, inscriptionButton;
    private LoginForm loginForm;
    private PersonDao personDao = new PersonDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_path = (EditText) findViewById(R.id.inputEmail);
        password_path = (EditText)findViewById(R.id.inputPassword);

        loginButton = (Button) findViewById(R.id.buttonLogin);
        inscriptionButton = (Button) findViewById(R.id.buttonRegister);

        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if(!isConnected){
            Toast.makeText(this,"pas de reseau", Toast.LENGTH_LONG).show();
            //Todo mieux gérer la non connection au réseaux
            return;
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new LoginAsync().execute(email_path.getText().toString(), password_path.getText().toString());
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        inscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, PersonRegisterActivity.class);
                startActivity(intent);
            }

        });
    }


    private class LoginAsync extends AsyncTask<String, Void, Integer> {
        private Integer code;

        protected Integer doInBackground(String... strings) {

            try {
                System.out.println("ici ");
                code = personDao.login(strings[0],strings[1]);
            } catch (Exception e) {
                Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }

            return code;
        }
    }


}


