package com.example.validate_user.formatter;

import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        try {
            return Integer.parseInt(source);
        } catch (Exception exception) {
            throw new RuntimeException("Input value must be a number");
        }
    }
}
