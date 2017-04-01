package com.app.validationlib.Rule;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class SameValueRule extends BaseRuleValidator {


    private final String oldValue;

    private SameValueRule(String oldValue, int resId) {
        super(resId);
        this.oldValue = oldValue;
    }


    private SameValueRule(String oldValue, String message) {
        super(message);
        this.oldValue = oldValue;
    }

    public static SameValueRule Rule(String oldValue, String message) {
        return new SameValueRule(oldValue, message);
    }

    public static SameValueRule Rule(String oldValue, int message) {
        return new SameValueRule(oldValue, message);
    }

    @Override
    public boolean validateValue(String value) {
        return !isEmpty(value) && !isEmpty(oldValue) && !value.equals(oldValue);

    }
}
