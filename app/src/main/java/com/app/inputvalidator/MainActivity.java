package com.app.inputvalidator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.app.validationlib.Rule.InputLengthRule;
import com.app.validationlib.Rule.RequiredRule;
import com.app.validationlib.Rule.SameViewValueRule;
import com.app.validationlib.Validation.ViewValidation;

public class MainActivity extends ValidationActivity {

    ViewValidation requiredEditText;
    ViewValidation textInputEmail;
    ViewValidation textInputPassword;
    ViewValidation textInputConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        requiredEditText = (ViewValidation) findViewById(R.id.requiredEditText);
        textInputEmail = (ViewValidation) findViewById(R.id.textInputEmail);
        textInputPassword = (ViewValidation) findViewById(R.id.textInputPassword);
        textInputConfirmPassword = (ViewValidation) findViewById(R.id.textInputConfirmPassword);


        // add required validation
        addValidationView(requiredEditText).

                // add email validation
                        addViewValidation(textInputEmail).


                // add password validation
                        addViewValidation(
                        textInputPassword.
                                addRule(RequiredRule.Rule()).
                                addRule(InputLengthRule.Rule(5, 10, "Password must be between 5 and 10 characters"))).

                // add confirm password validation
                        addViewValidation(
                        textInputConfirmPassword.
                                addRule(RequiredRule.Rule()).
                                addRule(SameViewValueRule.Rule(textInputPassword, "Password not match")
                                ));


    }

    public void onValidationClicked(View view) {

        if (validate()) {
            Toast.makeText(this, "All Validation is passed", Toast.LENGTH_SHORT).show();

        } else {

        }


    }
}
