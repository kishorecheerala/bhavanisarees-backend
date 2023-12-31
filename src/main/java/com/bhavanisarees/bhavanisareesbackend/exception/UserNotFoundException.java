package com.bhavanisarees.bhavanisareesbackend.exception;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String customerID) {
    super("Could not found the user with the ID: "+customerID);
    }
}
