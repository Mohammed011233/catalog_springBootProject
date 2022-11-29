package com.catalog.services;

public interface CheckId <T> {

    default T checkIdIsExist(Long id) {
        return null;
    }
}
