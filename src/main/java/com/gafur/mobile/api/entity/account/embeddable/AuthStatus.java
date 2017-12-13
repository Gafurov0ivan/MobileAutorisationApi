package com.gafur.mobile.api.entity.account.embeddable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Статус доставки смс
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Getter
@RequiredArgsConstructor
public enum AuthStatus {
    WAIT(0), CONFIRMED(1), SMS_NOT_DELIVERED(2);

    @NonNull
    private int id;

    public static AuthStatus valueOf(Integer inputId) {
        Optional<Integer> id = Optional.of(inputId);
            try {
                return Arrays.stream(values()).filter(x -> x.id == id.get()).findFirst().get();
            } catch (NoSuchElementException e) {
                return WAIT;
            }
    }
}
