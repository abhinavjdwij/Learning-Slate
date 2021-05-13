package com.abhinavjdwij.learn.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.abhinavjdwij.learn.combinatorpattern.CustomerValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerValidationResult> {
    static CustomerRegistrationValidator emailValidation() {
        return customer -> (
                customer.getEmail() != null && customer.getEmail().contains("@")
        ) ? SUCCESS : EMAIL_INVALID;
    }

    static CustomerRegistrationValidator phoneNumberValidation() {
        return customer -> (
                customer.getPhoneNumber() != null && customer.getPhoneNumber().length() == 10
        ) ? SUCCESS : PHONE_NUMBER_INVALID;
    }

    static  CustomerRegistrationValidator isAdultValidation() {
        return customer -> (
                customer.getDob() != null
                        && Period.between(customer.getDob(), LocalDate.now()).getYears() > 18
        ) ? SUCCESS : NON_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            CustomerValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
}
