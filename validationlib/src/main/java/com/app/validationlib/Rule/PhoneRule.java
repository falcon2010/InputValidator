package com.app.validationlib.Rule;

import android.text.TextUtils;
import android.util.Patterns;

import com.app.validationlib.R;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class PhoneRule extends BaseRuleValidator {


    private PhoneRule(int resId) {
        super(resId);
    }

    private PhoneRule(String message) {
        super(message);
    }

    private PhoneRule() {
        super(R.string.vi_validation_phone);
    }

    public static PhoneRule Rule() {
        return new PhoneRule();
    }

    public static PhoneRule Rule(int message) {
        return new PhoneRule(message);
    }

    public static PhoneRule Rule(String message) {
        return new PhoneRule(message);
    }

    @Override
    public boolean validateValue(String value) {
        return !TextUtils.isEmpty(value) && value.trim().length() > 0 && TextUtils.isDigitsOnly(value) && Patterns.PHONE.matcher(value).matches();

    }

}
