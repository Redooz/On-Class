package com.redoz.onclass.domain.exception;

public class TechnologyAlreadyExistsException extends RuntimeException {
    public TechnologyAlreadyExistsException(String technologyName) {
        super(technologyName);
    }
}
