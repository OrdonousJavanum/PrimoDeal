package com.henallux.primodeal.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.henallux.primodeal.Controller.Controller;
import com.henallux.primodeal.Exception.InscriptionException;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.R;

public class SellerRegisterActivity extends AppCompatActivity {

    private Person person;
    private Controller controller = new Controller();
    private Button createPersonButton;
    private EditText first_namePath, last_namePath, emailPath, passwordPath, shop_namePath, shop_descriptionPath, cityPath, streetPath, box_numberPath, zipPath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_register);

        first_namePath = (EditText) findViewById(R.id.inputFirstName);
        last_namePath = (EditText) findViewById(R.id.inputNameRegister);
        emailPath = (EditText) findViewById(R.id.inputEmailRegister);
        passwordPath = (EditText) findViewById(R.id.inputPasswordRegister);
        shop_namePath = (EditText) findViewById(R.id.inputShopName);
        shop_descriptionPath = (EditText) findViewById(R.id.inputDescription);
        cityPath = (EditText) findViewById(R.id.inputTown);
        streetPath = (EditText) findViewById(R.id.inputStreet);
        zipPath = (EditText) findViewById(R.id.inputCodePostal);



        createPersonButton = (Button) findViewById(R.id.buttonRegister);
        createPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(first_namePath.getText());
                System.out.println(emailPath.getText());
                try {
                    person = new Person(
                            first_namePath.getText().toString(),
                            last_namePath.getText().toString(),
                            emailPath.getText().toString(),
                            passwordPath.getText().toString(),
                            shop_namePath.getText().toString(),
                            shop_descriptionPath.getText().toString(),
                            cityPath.getText().toString(),
                            streetPath.getText().toString(),
                            Integer.parseInt(zipPath.getText().toString())
                    );
                    controller.addPerson(person);
                } catch (InscriptionException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
