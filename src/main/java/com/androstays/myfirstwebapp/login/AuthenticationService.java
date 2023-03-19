package com.androstays.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String name, String password) {
        return name.equals("in28minutes") && password.equals("dummy");
    }
}
