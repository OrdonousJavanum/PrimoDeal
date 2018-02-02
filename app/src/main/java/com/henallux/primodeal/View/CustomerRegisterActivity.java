package com.henallux.primodeal.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.henallux.primodeal.Controller.Controller;
import com.henallux.primodeal.Exception.InscriptionException;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.R;

public class CustomerRegisterActivity extends AppCompatActivity {

    private Person person;
    private Controller controller = new Controller();
    private Button createPersonButton;
    private EditText first_namePath, last_namePath, emailPath, passwordPath, shop_namePath, shop_descriptionPath, cityPath, streetPath, box_numberPath, zipPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        first_namePath = (EditText) findViewById(R.id.inputFirstName);
        last_namePath = (EditText) findViewById(R.id.inputNameRegister);
        emailPath = (EditText) findViewById(R.id.inputEmail);
        passwordPath = (EditText) findViewById(R.id.inputPassword);

        createPersonButton = (Button) findViewById(R.id.buttonRegister);
        createPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(first_namePath.getText());

                try {
                    person = new Person(
                            first_namePath.getText().toString(),
                            last_namePath.getText().toString(),
                            emailPath.getText().toString(),
                            passwordPath.getText().toString()
                    );
                } catch (InscriptionException e) {
                    e.printStackTrace();
                }
                System.out.println(person.toString());

                try {
                   // controller.addPerson(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }


}
