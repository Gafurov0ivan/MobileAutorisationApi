package com.gafur.mobile.api.service;

import com.gafur.mobile.api.entity.account.embeddable.UserProfileEmbeddable;
import com.gafur.mobile.api.rest.model.UserProfileDto;

/**
 * Операции с профилем пользователя
 *
 * @author igafurov
 * @since 07.12.2017
 */
public interface UserProfileService {

    /**
     * Сохранение профиля
     *
     * @param userProfile профиль
     * @return профиль
     */
    UserProfileDto save(UserProfileDto userProfile);

    /**
     * Получение профиля по номеру телефона
     *
     * @param phone телефон
     * @return профиль
     */
    UserProfileDto getByPhone(String phone);

    /**
     * Маппинг из UserProfileEmbeddable в UserProfileDto
     *
     * @param embeddable
     * @return модель
     */
    UserProfileDto map(UserProfileEmbeddable embeddable);
}
