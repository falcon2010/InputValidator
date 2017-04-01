package com.app.validationlib.Validation;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class Field implements FieldValidator  {
    private final TextView control;
    private final List<IValidatorRule> validatorList = new ArrayList<>();

    public Field(TextView control) {
        this.control = control;
    }


    @Override
    public IValidatorRule validate() {
        final String value = getValue();
        final int size = validatorList.size();
        for (int i = 0; i < size; i++) {
            IValidatorRule iValidator = validatorList.get(i);
            if (!iValidator.validateValue(value)) {
                return iValidator;
            }
        }


        return null;
    }

    @Override
    public TextView getControl() {
        return control;
    }


    protected String getValue() {
        return getControl().getText().toString();
    }

    @Override
    public FieldValidator addValidator(IValidatorRule iValidator) {
        validatorList.add(iValidator);
        return this;
    }

}
