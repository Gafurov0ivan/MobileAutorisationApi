package com.gafur.mobile.api.service.impl;

import com.gafur.mobile.api.config.app.RandomKeyConfig;
import com.gafur.mobile.api.service.RandomService;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static org.bitbucket.dollar.Dollar.$;

/**
 * @author igafurov
 * @since 07.12.2017
 */
@Service
@Getter
@Accessors(fluent = true)
@Slf4j
public class RandomServiceImpl implements RandomService {

    @Autowired
    private RandomKeyConfig config;
    private String validCharacters;

    public String validCharacters() {
        if (isNull(validCharacters)) {
            validCharacters = $('0', '9').join() + (config.getWithLetters() ? $('A', 'Z').join() : "");
        }
        return validCharacters;
    }

    public String generateCode() {
        return $(validCharacters()).shuffle().slice(config.getSize()).toString();
    }

    public String customizeCode(String code) {
        return String.join(config.getDelimiter(),
                code.split("(?<=\\G.{" + config.getPartitionSize() + "})")
        );
    }

    public String generateAuthCode(String phone) {
        List<Character> list = $(validCharacters()).shuffle().concat($(phone.toCharArray())).slice(config.getSize()).toList();
        return list.stream().map(e -> e.toString()).collect(Collectors.joining(""));
    }
}
