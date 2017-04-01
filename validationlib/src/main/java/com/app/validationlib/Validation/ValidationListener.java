package com.app.validationlib.Validation;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public interface ValidationListener {
    void onValidationPass();
    void onValidationFail(String message);
}
