package com.gafur.mobile.api.rest.impl;

import com.gafur.mobile.api.rest.UserProfileRestService;
import com.gafur.mobile.api.rest.model.UserProfileDto;
import com.gafur.mobile.api.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@RestController
@Slf4j
public class UserProfileRestServiceImpl implements UserProfileRestService {

    @Autowired
    UserProfileService userProfileService;

    @Override
    public ResponseEntity<UserProfileDto> get(@RequestParam String phone) {
        return ResponseEntity.ok().body(userProfileService.getByPhone(phone));
    }

    @Override
    public ResponseEntity<UserProfileDto> create(@RequestBody @Valid UserProfileDto userProfile) {
        return ResponseEntity.ok().body(userProfileService.save(userProfile));
    }
}
