package com.app.validationlib.Rule;

import com.app.validationlib.R;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class RequiredRule extends BaseRuleValidator {

    private RequiredRule() {
        super(R.string.vi_required);
    }

    private RequiredRule(String message) {
        super(message);
    }


    private RequiredRule(int resId) {
        super(resId);

    }

    public static RequiredRule Rule() {
        return new RequiredRule();
    }

    public static RequiredRule Rule(String message) {

        return new RequiredRule(message);
    }

    public static RequiredRule Rule(int message) {

        return new RequiredRule(message);
    }

    @Override
    public boolean validateValue(String value) {
        return !isEmpty(value) && value.trim().length() > 0;
    }


}
