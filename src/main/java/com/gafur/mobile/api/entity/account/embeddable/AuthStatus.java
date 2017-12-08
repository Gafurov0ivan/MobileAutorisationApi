package com.gafur.mobile.api.entity.account.embeddable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static java.util.Objects.nonNull;

/**
 * Статус доставки смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Getter
@RequiredArgsConstructor
public enum AuthStatus {
    Wait(0), Confirmed(1), SmsNotDelivered(2);

    @NonNull
    private int id;

    public static AuthStatus valueOf(Integer ID) {
        if (nonNull(ID)) {
            try {
                return Arrays.stream(values()).filter(x -> x.id == ID).findFirst().get();
            } catch (NoSuchElementException e) {
                return Wait;
            }
        }
        return null;
    }
}
