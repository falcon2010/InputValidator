package com.app.validationlib.Rule;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class RegexRule extends BaseRuleValidator {


    private final String match;


    private RegexRule(String match, String msg) {
        super(msg);
        this.match = match;

    }

    private RegexRule(String match, int msg) {
        super(msg);
        this.match = match;

    }


    public static RegexRule Rule(String regex, int message) {
        return new RegexRule(regex, message);
    }

    public static RegexRule Rule(String regex, String message) {
        return new RegexRule(regex, message);
    }

    @Override
    public boolean validateValue(String value) {
        return !isEmpty(value) && match != null && value.matches(match);
    }

}
