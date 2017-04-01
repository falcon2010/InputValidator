package com.app.validationlib.Rule;

import com.app.validationlib.R;

import static android.text.TextUtils.isDigitsOnly;
import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class NumberOnlyRule extends BaseRuleValidator {

    private NumberOnlyRule() {
        super(R.string.vi_validation_number_only);
    }

    private NumberOnlyRule(int message) {
        super(message);
    }


    private NumberOnlyRule(String message) {
        super(message);
    }


    public static NumberOnlyRule Rule() {
        return new NumberOnlyRule();
    }

    public static NumberOnlyRule Rule(int message) {
        return new NumberOnlyRule(message);
    }

    public static NumberOnlyRule Rule(String message) {
        return new NumberOnlyRule(message);

    }

    @Override
    public boolean validateValue(String value) {
        return !isEmpty(value) && isDigitsOnly(value);
    }
}
