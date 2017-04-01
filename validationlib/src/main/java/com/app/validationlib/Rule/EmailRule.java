package com.app.validationlib.Rule;

import android.text.TextUtils;

import com.app.validationlib.R;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class EmailRule extends BaseRuleValidator  {
    public  static EmailRule Rule(String message) {
        return  new EmailRule(message);
    }


    public  static EmailRule Rule(int message) {
        return  new EmailRule(message);
    }

    private EmailRule() {
        super(R.string.vi_validation_email);
    }

    private EmailRule(String message) {
        super(message);
    }


    private EmailRule(int ResId) {
        super(ResId);
    }


    @Override
    public boolean validateValue(String target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
