package com.app.inputvalidator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.app.validationlib.Validation.ValidationGroup;
import com.app.validationlib.Validation.ViewValidation;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class ValidationActivity extends AppCompatActivity {

    private static final boolean VALIDATE_ALL_VIEWS_ONCE = true;
    protected ValidationGroup validationGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validationGroup = new ValidationGroup(VALIDATE_ALL_VIEWS_ONCE);
    }

    protected final ValidationGroup addValidationView(ViewValidation viewValidation) {
        return validationGroup.addViewValidation(viewValidation);
    }

    protected final boolean validate() {
        return  validationGroup.validate();
    }

}
