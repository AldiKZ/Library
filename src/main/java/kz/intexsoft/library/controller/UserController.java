package kz.intexsoft.library.controller;

import kz.intexsoft.library.securingweb.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


}
