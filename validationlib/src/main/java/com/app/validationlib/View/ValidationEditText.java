package com.app.validationlib.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.widget.TextView;

import com.app.validationlib.R;
import com.app.validationlib.Rule.BaseRuleValidator;
import com.app.validationlib.Validation.FieldValidationDelegate;
import com.app.validationlib.Validation.ValidationListener;
import com.app.validationlib.Validation.ViewValidation;

/**
 * Created by mohamed.ibrahim on 3/27/2017.
 */


public class ValidationEditText extends AppCompatEditText implements ViewValidation {


    private final FieldValidationDelegate delegate;

    public ValidationEditText(Context context) {
        super(context);
        delegate = new FieldValidationDelegate(this, null);
    }

    public ValidationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs == null) {
            delegate = new FieldValidationDelegate(this, null);
        } else {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ValidationInput);
            delegate = new FieldValidationDelegate(this, a);
            a.recycle();
        }

    }

    public ValidationEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public TextView getControl() {
        return this;
    }

    @Override
    public String getTextValue() {
        return getText().toString();
    }
}
