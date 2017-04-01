package com.app.validationlib.Rule;

import android.text.TextUtils;

import com.app.validationlib.R;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class InputLengthRule extends  BaseRuleValidator
{
    private final int min;
    private final int max;


    public static InputLengthRule Rule(int min, int max, String message) {
        return new InputLengthRule(min, max, message);
    }


    public static InputLengthRule Rule(int min, int max, int message) {
        return new InputLengthRule(min, max, message);
    }


    public  static InputLengthRule Rule(int min , int max){
        return new InputLengthRule(min , max);
    }

    private InputLengthRule(int min   , int max) {
        super(R.string.vi_validation_length);
        this.min = min ;
        this.max = max ;


    }


    private InputLengthRule(int min, int max, int resId) {
        super(resId);
        this.min = min;
        this.max = max;

    }


    private InputLengthRule(int min, int max, String message) {
        super(message);
        this.min = min;
        this.max = max;

    }


    @Override
    public boolean validateValue(String value) {
        if (TextUtils.isEmpty(value)) return false;
        final int length = value.trim().length();
        return length != 0 && !(length < min || length > max);
    }


}
