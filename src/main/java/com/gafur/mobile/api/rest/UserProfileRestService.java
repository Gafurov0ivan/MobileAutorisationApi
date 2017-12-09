package com.gafur.mobile.api.rest;

import com.gafur.mobile.api.rest.model.UserProfileDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Рест сервис для операций с профилем пользователя
 *
 * @author igafurov
 * @since 07.12.2017
 */
@RequestMapping("/v1/profile")
public interface UserProfileRestService {

    /**
     * Возвращает профиль пользователя по номеру телефона
     *
     * @param phone номер телефона
     * @return профиль пользователя
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    ResponseEntity<UserProfileDto> get(@ApiParam(value = "Phone number", example = "14053264519", required = true)
                                               String phone);

    /**
     * Создает профиль пользователя
     *
     * @param userProfile профиль пользователя
     * @return профиль пользователя
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<UserProfileDto> create(@ApiParam(value = "User profile", required = true)
                                                  UserProfileDto userProfile);
}
