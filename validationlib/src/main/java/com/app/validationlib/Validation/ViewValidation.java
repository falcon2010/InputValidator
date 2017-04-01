package com.app.validationlib.Validation;

import android.widget.TextView;

import com.app.validationlib.Rule.BaseRuleValidator;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public interface ViewValidation {
    ViewValidation addRule(BaseRuleValidator baseRuleValidator);

    boolean validate();

    boolean validate(ValidationListener callback);

    String getTextValue();

    TextView getControl();

}
