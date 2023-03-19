package com.androstays.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginPage(ModelMap model) {
        model.put("name", "in28minutes");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        String value;
        model.put("name", name);
        value = authenticationService.authenticate(name, password) ? "welcome" : "login";
        if(!authenticationService.authenticate(name, password)){
            model.put("error_msg", "please enter valid credentials");
        }
        return value;
    }
}
