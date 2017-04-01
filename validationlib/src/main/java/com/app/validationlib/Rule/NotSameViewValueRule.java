package com.app.validationlib.Rule;

import android.widget.TextView;

import com.app.validationlib.R;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class NotSameViewValueRule extends BaseRuleValidator {
    private final TextView oldValue;

    private NotSameViewValueRule(TextView oldValue) {
        super(R.string.vi_validation_not_same);
        this.oldValue = oldValue;
    }

    private NotSameViewValueRule(TextView oldValue, String message) {
        super(message);
        this.oldValue = oldValue;
    }

    private NotSameViewValueRule(TextView oldValue, int resId) {
        super(resId);
        this.oldValue = oldValue;
    }

    public static NotSameViewValueRule Rule(TextView oldValue, int resId) {
        return new NotSameViewValueRule(oldValue, resId);
    }

    public static NotSameViewValueRule Rule(TextView oldValue, String message) {
        return new NotSameViewValueRule(oldValue, message);
    }

    public static NotSameViewValueRule Rule(TextView oldValue) {
        return new NotSameViewValueRule(oldValue);
    }

    @Override
    public boolean validateValue(String value) {
        return !isEmpty(value) && oldValue != null && !isEmpty(oldValue.getText()) && !value.equals(oldValue.getText().toString());

    }

}
