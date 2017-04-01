package com.app.validationlib.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;
import android.widget.TextView;

import com.app.validationlib.R;
import com.app.validationlib.Rule.BaseRuleValidator;
import com.app.validationlib.Validation.FieldValidationDelegate;
import com.app.validationlib.Validation.ValidationListener;
import com.app.validationlib.Validation.ViewValidation;

/**
 * Created by mohamed.ibrahim on 3/29/2017.
 */

public class ValidationTextInputEditText extends TextInputEditText implements ViewValidation {

    private final FieldValidationDelegate delegate;

    public ValidationTextInputEditText(Context context) {
        super(context);
        delegate = new FieldValidationDelegate(this, null);
    }

    public ValidationTextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs == null) {
            delegate = new FieldValidationDelegate(this, null);
        } else {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ValidationInput);
            delegate = new FieldValidationDelegate(this, a);
            a.recycle();
        }
    }

    public ValidationTextInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (attrs == null) {
            delegate = new FieldValidationDelegate(this, null);
        } else {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ValidationInput);
            delegate = new FieldValidationDelegate(this, a);
            a.recycle();
        }
    }

    public ViewValidation addRule(BaseRuleValidator baseRuleValidator) {
        delegate.addRule(baseRuleValidator);
        return this;
    }


    /**
     * validation method will use @setError method for @EditText or @InputTextLayout
     */
    public boolean validate() {
        return delegate.validate();
    }


    /**
     * validate method will return the message back to client to handle it
     *
     * @param callback
     */
    public boolean validate(ValidationListener callback) {
        return delegate.validate(callback);
    }


    @Override
    public String getTextValue() {
        return getText().toString();
    }

    @Override
    public TextView getControl() {
        return this;
    }
}
