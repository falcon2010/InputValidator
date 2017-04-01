package com.app.validationlib.Validation;

import android.widget.TextView;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public interface FieldValidator {
    IValidatorRule validate();
    TextView getControl();
    FieldValidator addValidator(IValidatorRule iValidatorRule);

}
