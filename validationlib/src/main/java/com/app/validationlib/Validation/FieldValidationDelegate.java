package com.app.validationlib.Validation;

import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

import com.app.validationlib.Rule.BaseRuleValidator;
import com.app.validationlib.Rule.EmailRule;
import com.app.validationlib.Rule.InputLengthRule;
import com.app.validationlib.Rule.RegexRule;
import com.app.validationlib.Rule.RequiredRule;
import com.app.validationlib.Rule.UrlRule;

import static com.app.validationlib.R.styleable.ValidationInput_vi_email;
import static com.app.validationlib.R.styleable.ValidationInput_vi_email_message;
import static com.app.validationlib.R.styleable.ValidationInput_vi_input_length;
import static com.app.validationlib.R.styleable.ValidationInput_vi_input_length_max;
import static com.app.validationlib.R.styleable.ValidationInput_vi_input_length_message;
import static com.app.validationlib.R.styleable.ValidationInput_vi_input_length_min;
import static com.app.validationlib.R.styleable.ValidationInput_vi_phone;
import static com.app.validationlib.R.styleable.ValidationInput_vi_phone_code;
import static com.app.validationlib.R.styleable.ValidationInput_vi_phone_message;
import static com.app.validationlib.R.styleable.ValidationInput_vi_regex;
import static com.app.validationlib.R.styleable.ValidationInput_vi_regex_match;
import static com.app.validationlib.R.styleable.ValidationInput_vi_regex_message;
import static com.app.validationlib.R.styleable.ValidationInput_vi_required;
import static com.app.validationlib.R.styleable.ValidationInput_vi_required_message;
import static com.app.validationlib.R.styleable.ValidationInput_vi_url;
import static com.app.validationlib.R.styleable.ValidationInput_vi_url_message;


/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class FieldValidationDelegate {
    private final TextView textView;
    private final Field field;

    // required rule
    private boolean viRequired;
    private String viRequiredMessage;

    // email rule
    private boolean viEmail;
    private String viEmailMessage;

    // input length
    private boolean viInputLength;
    private String viInputLengthMessage;
    private int viInputLengthMin;
    private int viInputLengthMax;

    // phone
    private boolean viPhone;
    private String viPhoneMessage;
    private int viPhoneCode;


    // regex
    private boolean viRegex;
    private String viRegexMessage;
    private String viRegexMatch;

    //  url
    private boolean viUrl;
    private String viUrlMessage;


    public FieldValidationDelegate(TextView textView, TypedArray a) {
        this.textView = textView;
        field = new Field(textView);
        init(a);
        setValidationRules();


    }

    private void init(TypedArray a) {

        if (a == null) return;

        viRequired = a.getBoolean(ValidationInput_vi_required, false);
        viRequiredMessage = a.getString(ValidationInput_vi_required_message);

        // email

        viEmail = a.getBoolean(ValidationInput_vi_email, false);
        viEmailMessage = a.getString(ValidationInput_vi_email_message);

        //  input length

        viInputLength = a.getBoolean(ValidationInput_vi_input_length, false);
        viInputLengthMessage = a.getString(ValidationInput_vi_input_length_message);
        viInputLengthMin = a.getInt(ValidationInput_vi_input_length_min, 0);
        viInputLengthMax = a.getInt(ValidationInput_vi_input_length_max, 0);


        // Phone

        viPhone = a.getBoolean(ValidationInput_vi_phone, false);
        viPhoneMessage = a.getString(ValidationInput_vi_phone_message);
        viPhoneCode = a.getInt(ValidationInput_vi_phone_code, 0);


        // url
        viUrl = a.getBoolean(ValidationInput_vi_url, false);
        viUrlMessage = a.getString(ValidationInput_vi_url_message);


        //  regex
        viRegex = a.getBoolean(ValidationInput_vi_regex, false);
        viRegexMessage = a.getString(ValidationInput_vi_regex_message);
        viRegexMatch = a.getString(ValidationInput_vi_regex_match);
    }


    private void setValidationRules() {

        if (viRequired) {
            field.addValidator(RequiredRule.Rule(viRequiredMessage));
        }

        if (viEmail) {
            field.addValidator(EmailRule.Rule(viEmailMessage));
        }

        if (viInputLength) {
            if (viInputLengthMin <= 0 || viInputLengthMax <= 0) {
                throw new IllegalStateException("You must enter valid min and max");
            }
            field.addValidator(InputLengthRule.Rule(viInputLengthMin, viInputLengthMax, viInputLengthMessage));
        }

        if (viRegex) {
            field.addValidator(RegexRule.Rule(viRegexMatch, viRegexMessage));

        }

        if (viUrl) {
            field.addValidator(UrlRule.Rule(viUrlMessage));
        }


    }


    public void addRule(BaseRuleValidator baseRuleValidator) {
          field.addValidator(baseRuleValidator);
    }


    public boolean validate() {
        return validate(null);
    }

    public boolean validate(ValidationListener callback) {
        IValidatorRule validate = field.validate();

        if (validate != null) {
            final String message = getMessage(validate);
            if (callback == null) {
                setErrorMessage(message);
            } else {
                callback.onValidationFail(message);
            }

            return false;
        }


        if (callback == null) setErrorMessage(null);
        else callback.onValidationPass();

        return true;
    }

    /**
     * set @errorMessage for TextInputLayout or for  the EditText or remove it in case Empty value
     */
    private void setErrorMessage(String errorMessage) {

        final boolean isHasError = errorMessage != null && errorMessage.length() > 0;

        TextInputLayout textInputLayout = getTextInputEditText();
        if (textInputLayout != null) {
            textInputLayout.setErrorEnabled(isHasError);
            textInputLayout.setError(errorMessage);
        } else {
            textView.setError(errorMessage);
        }


    }


    /**
     * code snippet from @{@link TextInputEditText}.onCreateInputConnection}
     *
     * @return
     */
    private TextInputLayout getTextInputEditText() {
        ViewParent parent = textView.getParent();
        while (parent instanceof View) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;

            }
            parent = parent.getParent();
        }

        return null;
    }


    private String getMessage(IValidatorRule iValidator) {
        if (iValidator.isResId())
            return textView.getResources().getString(iValidator.getErrorMessageId());

        return iValidator.getErrorMessage();

    }

}
