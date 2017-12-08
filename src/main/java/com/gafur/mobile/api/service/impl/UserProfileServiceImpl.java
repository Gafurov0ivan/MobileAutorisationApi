package com.gafur.mobile.api.service.impl;

import com.gafur.mobile.api.entity.account.UserProfileEntity;
import com.gafur.mobile.api.entity.account.embeddable.UserProfileEmbeddable;
import com.gafur.mobile.api.repository.UserProfileRepository;
import com.gafur.mobile.api.rest.model.UserProfileDto;
import com.gafur.mobile.api.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDto save(UserProfileDto userProfile) {
        UserProfileEntity userProfileEntityEntity = userProfileRepository.save(map(userProfile));
        return map(userProfileEntityEntity);
    }

    @Override
    public UserProfileDto getByPhone(String phone) {
        return map(userProfileRepository.findByAccountPhone(phone));
    }

    private UserProfileEntity map(UserProfileDto source) {
        UserProfileEntity target = new UserProfileEntity();
        if (source == null) return target;
        if (source.getId() != null) target.setId(source.getId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPatronymic(source.getPatronymic());
        target.setAvatarLink(source.getAvatarLink());
        target.setEmail(source.getEmailAddress());
        return target;
    }

    public UserProfileDto map(UserProfileEntity source) {
        UserProfileDto target = new UserProfileDto();
        if (source == null) return target;
        if(source.getId() != null) target.setId(source.getId());
        target.setLastName(source.getLastName());
        target.setFirstName(source.getFirstName());
        target.setPatronymic(source.getPatronymic());
        target.setAvatarLink(source.getAvatarLink());
        target.setEmailAddress(source.getEmail());
        return target;
    }

    public UserProfileDto map(UserProfileEmbeddable source) {
        UserProfileDto target = new UserProfileDto();
        if (source == null) return target;
        target.setLastName(source.getLastName());
        target.setFirstName(source.getFirstName());
        target.setPatronymic(source.getPatronymic());
        target.setAvatarLink(source.getAvatarLink());
        target.setEmailAddress(source.getEmailAddress());
        return target;
    }

}
