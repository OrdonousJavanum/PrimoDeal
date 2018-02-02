package com.henallux.primodeal.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henallux.primodeal.Controller.Controller;
import com.henallux.primodeal.Exception.InscriptionException;
import com.henallux.primodeal.Model.LoginForm;
import com.henallux.primodeal.R;

public class LoginActivity extends AppCompatActivity {

    private EditText email_path, password_path;
    private Button loginButton;
    private LoginForm loginForm;
    private Controller controller = new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_path = (EditText) findViewById(R.id.inputEmail);
        password_path = (EditText)findViewById(R.id.inputPassword);

        loginButton = (Button) findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginForm = new LoginForm(email_path.getText().toString(), password_path.getText().toString());



                try {
                    controller.login(loginForm);
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }


            }
        });
    }

    public void goToTypeUserRegisterActivity(View v)
    {
        Intent explicitIntent = new Intent(this, TypeUserRegisterActivity.class);
       // final Intent msg = explicitIntent.putExtra("msg", "Données trop classes");

        // test voila quoi !
        startActivityForResult(explicitIntent, 1);
    }
}
