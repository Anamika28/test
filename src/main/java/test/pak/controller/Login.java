package test.pak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.pak.dao.User;
import test.pak.service.LoginService;

import java.io.Serializable;

@RestController
public class Login implements Serializable{

    private String email_id;
    private String password;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/get_credentials", method = RequestMethod.POST)
    public User retreivereq(@PathVariable String email_id, @PathVariable String password) {

      return loginService.userAuth(email_id, password);
    }

    /*User public retreive()
    {

    }*/
}
