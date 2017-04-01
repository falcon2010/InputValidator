package com.app.validationlib.Validation;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public interface IValidatorRule {
    boolean validateValue(String value);
    boolean isResId();
    int getErrorMessageId();
    String getErrorMessage();

}
