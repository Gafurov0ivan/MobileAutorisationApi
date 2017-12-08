package com.gafur.mobile.api.service.validation;

import com.gafur.mobile.api.entity.account.PhoneRegistrationLogEntity;
import com.gafur.mobile.api.entity.account.embeddable.AuthStatus;
import com.gafur.mobile.api.rest.model.AccountConfirmDto;
import com.gafur.mobile.api.rest.model.AccountLoginDto;
import com.gafur.mobile.api.rest.model.AccountRegistrationDto;
import com.gafur.mobile.api.service.exception.ConflictException;
import com.gafur.mobile.api.service.exception.NotValidFormException;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Component
public class UserAccountValidatorImpl implements UserAccountValidator {

    @Override
    public void isValidRegistrationForm(AccountRegistrationDto account) throws NotValidFormException {
        if (account.getPhone() == null) {
            throw new NotValidFormException("Phone number is required");
        }
        if (!account.getPhone().matches("\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{5})")) {
            throw new NotValidFormException("Not valid phone number");
        }
    }

    public void isValidLoginForm(AccountLoginDto account) {
        if (account.getPhone() == null) {
            throw new NotValidFormException("Phone number is required");
        }
        if (account.getPassword() == null) {
            throw new NotValidFormException("Password is required");
        }
        if (!account.getPhone().matches("\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{5})")) {
            throw new NotValidFormException("Not valid phone number");
        }
    }

    @Override
    public void isValidConfirmForm(AccountConfirmDto external, PhoneRegistrationLogEntity existed) {
        if (isNull(existed)) {
            throw new NotValidFormException("Not valid phone number " + external.getPhone() + " for confirmation");
        }
        if (existed.getAuthStatus().equals(AuthStatus.Confirmed)) {
            throw new ConflictException("The number" + external.getPhone() + " is already confirm registration");
        }
        //stub, code always valid
        if (!existed.getCode().contentEquals(external.clearConfirmationCode())) {
            // throw new NotValidFormException("Not valid confirmation code");
        }
    }

}
