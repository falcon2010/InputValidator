package com.app.validationlib.Validation;

import java.util.ArrayList;

/**
 * Created by mohamed ibrahim on 4/1/2017.
 */

public class ValidationGroup {
    private final ArrayList<ViewValidation> mValidations;
    private final boolean mValidateAll;


    public ValidationGroup(boolean mValidateAll) {
        this(new ArrayList<ViewValidation>(), mValidateAll);
    }


    public ValidationGroup() {
        this(new ArrayList<ViewValidation>(), true);
    }


    public ValidationGroup(ArrayList<ViewValidation> mValidations) {
        this(mValidations, true);
    }


    public ValidationGroup(ArrayList<ViewValidation> mValidations, boolean mValidateAll) {
        this.mValidations = mValidations;
        this.mValidateAll = mValidateAll;
    }


    public ValidationGroup addViewValidation(ViewValidation viewValidation) {
        this.mValidations.add(viewValidation);
        return this;
    }


    public boolean validate() {

        if (mValidateAll) {
            boolean validationPass = true;
            for (ViewValidation mValidation : mValidations) {
                if (!mValidation.validate()) validationPass = false;
            }

            return validationPass;

        } else {

            for (ViewValidation mValidation : mValidations) {
                if (!mValidation.validate()) return false;
            }

        }


        return true;
    }


}
