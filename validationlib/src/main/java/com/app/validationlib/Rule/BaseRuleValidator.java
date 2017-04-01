package com.app.validationlib.Rule;

import com.app.validationlib.R;
import com.app.validationlib.Validation.IValidatorRule;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public abstract class BaseRuleValidator implements IValidatorRule {
    protected final String DEFAULT_MESSAGE = "invalid";
    protected final int DEFAULT_RES_ID = R.string.vi_all_validation_error;

    private final int resId;
    private final String message;
    private final boolean isFromResource;


    public BaseRuleValidator() {
        this.resId = 0;
        this.message = null;
        this.isFromResource = true;
    }

    public BaseRuleValidator(int resId) {
        this.resId = resId;
        this.message = null;
        this.isFromResource = true;
    }

    public BaseRuleValidator(String message) {
        this.resId = 0;
        this.message = message;
        this.isFromResource = false;
    }


    @Override
    public boolean isResId() {
        return isFromResource;
    }

    @Override
    public int getErrorMessageId() {
        return resId > 0 ? resId : DEFAULT_RES_ID;
    }

    @Override
    public String getErrorMessage() {
        return isEmpty(message) ? DEFAULT_MESSAGE : message;
    }

}
