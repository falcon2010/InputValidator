package com.app.validationlib.Rule;

import android.webkit.URLUtil;

import com.app.validationlib.R;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class UrlRule extends BaseRuleValidator {

    private UrlRule() {
        super(R.string.vi_validation_url);
    }


    private UrlRule(String message) {
        super(message);
    }

    private UrlRule(int resId) {
        super(resId);

    }

    public static UrlRule Rule(String message) {
        return new UrlRule(message);
    }

    public static UrlRule Rule(int message) {
        return new UrlRule(message);
    }

    @Override
    public boolean validateValue(String value) {
        return URLUtil.isValidUrl(value);
    }
}

