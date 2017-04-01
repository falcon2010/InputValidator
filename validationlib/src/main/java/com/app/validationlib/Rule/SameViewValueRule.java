package com.app.validationlib.Rule;

import android.text.TextUtils;

import com.app.validationlib.Validation.ViewValidation;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class SameViewValueRule extends BaseRuleValidator {

    private final ViewValidation otherField;


    private SameViewValueRule(ViewValidation otherField, int resId) {
        super(resId);
        this.otherField = otherField;

    }


    private SameViewValueRule(ViewValidation otherField, String message) {
        super(message);
        this.otherField = otherField;

    }

    public static SameViewValueRule Rule(ViewValidation otherField, int message) {
        return new SameViewValueRule(otherField, message);
    }

    public static SameViewValueRule Rule(ViewValidation otherField, String message) {
        return new SameViewValueRule(otherField, message);
    }

    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().length() > 0 && value.equals(getOtherFieldText());
    }

    private String getOtherFieldText() {
        if (otherField == null) return "";
        return otherField.getTextValue();
    }


}

